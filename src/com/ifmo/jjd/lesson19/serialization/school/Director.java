package com.ifmo.jjd.lesson19.serialization.school;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Director extends Human implements Externalizable {
    // Если имплементируется Externalizable, то
    // по умолчанию ни одно свойство не входит в сериализацию,
    // обязательно должен быть конструктор без параметров,
    // нужно переопределить два метода, в которых пишем какие свойства надо сериализовать и какие десериализовать
    private int rating;

    public Director() { }

    public Director(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Director{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(rating);
        out.writeInt(age);
        // Если нужно сериализвать свойство типа String, то это writeUTF(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // В какой последовательности прописали write в writeExternal, в такой же здесь читаем
        rating = in.readInt();
        age = in.readInt();
    }
}