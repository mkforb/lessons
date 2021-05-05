package com.ifmo.jjd.lesson20.nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        // запускаем один поток для обработки всех соединений
        new Thread(new NioThread()).start();
    }

    private static class NioThread extends Worker {
        private static final int BUF_SIZE = 1024;

        private ByteBuffer byteBuffer;
        private ServerSocketChannel serverChannel;
        private Selector selector;

        @Override
        protected void init() throws IOException {
            // создаем буфер
            byteBuffer = ByteBuffer.allocate(BUF_SIZE);

            // создаем селектор
            selector = Selector.open();

            // открываем канал сервера
            serverChannel = ServerSocketChannel.open(); // ServerSocketChannel ожидает входящие подключения на указанном порту
            // слушаем определенный порт (8090)
            serverChannel.bind(new InetSocketAddress(8090));
            // перевод в неблокирующий режим
            serverChannel.configureBlocking(false); // Неблокирующий режим нужен, чтобы можно было работать с несколькими клиентами, не разрывая подключений
            // регистрируем канал в селекторе на все допустимые события (для serverSocket - OP_ACCEPT)
            serverChannel.register(selector, serverChannel.validOps()); // Селектор следит за событиями в канале. Селектор подписывается на события // validOps() возвращает доступные события на канале. У serverSocket может быть только одно событие - новое соединение OP_ACCEPT
        }

        @Override
        protected void loop() throws IOException {
            // ожидание новых событий
            selector.select();

            // получаем ключи, на которые пришли события
            Set<SelectionKey> keys = selector.selectedKeys(); // Получаем информацию о всех произошедших событиях в виде Set

            Iterator<SelectionKey> iterator = keys.iterator();

            // обрабатываем все ключи
            while (iterator.hasNext()){
                SelectionKey key = iterator.next(); // Получаем событие

                // флаг isAcceptable означает, что пришло входящее подключение
                // можно получать новый канал для этого соединения
                if (key.isAcceptable()){
                    // получение канала
                    SocketChannel channel = serverChannel.accept(); // Создаем новый канал - соединение с клиентом
                    // переводим в неблокирующий режим
                    channel.configureBlocking(false); // Перевод в неблокир. режим, чтобы можно было отдавать данные в канал и получать
                    // регистрируем в селекторе
                    channel.register(selector, SelectionKey.OP_READ); // Селектор будет следить за событием получения данных
                    System.out.println("Client connected " + channel.getRemoteAddress());
                }
                // флаг означает, что пришли данные для чтения
                else if (key.isReadable()) {
                    // читаем входящие данные
                    System.out.println("читаем входящие данные...");
                    readData((SocketChannel)key.channel());
                }
                // isValid проверяет, что соединение открыто
                // isWritable канал готов к отправке данных
                else if (key.isValid() && key.isWritable()){
                    // записываем данные в канал
                    System.out.println("запись данных в канал...");
                    writeData((SocketChannel)key.channel(), key);
                }
                // удаляем обработанный ключ
                iterator.remove();
            }

        }

        @Override
        protected void stop() throws IOException {
            serverChannel.close();
            selector.close();
        }

        private void readData(SocketChannel channel){
            // готовим буфер для чтения данных
            byteBuffer.clear();

            try {
                int read = channel.read(byteBuffer); // Чтение данных из канала в буфер
                if(read != -1) {
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), StandardCharsets.UTF_8));
                } else {
                    System.out.println("client disconnected " + channel.getRemoteAddress());
                    channel.close();
                }

                // готовим буфер для чтения, чтобы потом прочитанные данные записать в канал
                byteBuffer.flip();

                Set<SelectionKey> keys = selector.keys();
                for (SelectionKey key: keys){
                    if ((key.channel().validOps() & SelectionKey.OP_WRITE) > 0){
                        key.interestOps(key.interestOps() | SelectionKey.OP_WRITE); //
                    }
                }

            } catch (IOException e) {
                System.out.println("client disconnected ");
                byteBuffer.clear();
                try {
                    channel.close();
                } catch (IOException e1) {
//                    e1.printStackTrace();
                }
            }
        }

        private void writeData(SocketChannel channel, SelectionKey key) throws IOException {
            //  записываем данные из буфера
            channel.write(byteBuffer); // Данные из буфера отправляются в канал
            // готовим для следующей записи
            byteBuffer.rewind();
            key.interestOps(key.interestOps() &~ SelectionKey.OP_WRITE);
        }
    }
}