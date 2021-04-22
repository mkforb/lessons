package com.ifmo.jjd.lesson14;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapApp {
    public static void main(String[] args) {
        User qwe = new User("qwe", "qwe123", User.Role.USER);
        User asd = new User("asd", "asd123", User.Role.ADMIN);
        User zxc = new User("zxc", "zxc123", User.Role.ADMIN);
        User cvb = new User("cvb", "cvb123", User.Role.USER);

        //HashMap - класс, которых хранит данные в паре, самый быстрый,
        // хранит их в порядке в зависимости от хешкода ключа
        //позволяет использовать в качестве ключа null, но один раз
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(qwe.getLogin(), qwe);
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(zxc.getLogin(), zxc);
        userHashMap.put(cvb.getLogin(), cvb);

        System.out.println(userHashMap.containsKey("cvb")); // проверяет содержится ли в мапе ключ или нет, true-false
        System.out.println(userHashMap.containsValue(zxc)); //проверка значения, требует переопределение equals hashcode

        userHashMap.replace("jnsrj", zxc); //замена по ключу
        //если в мапу добавляем ключ который существует, то будет перезапись
        userHashMap.replace("zxc", zxc, null); //false - по ключу и значению

        // получаем значение по ключу
        System.out.println(userHashMap.get("zxc")); // User
        System.out.println(userHashMap.get("jnsrj")); // null

        // получение значения
        System.out.println(userHashMap.getOrDefault("jnsrj", new User("default", "default", User.Role.USER)));
        //если метод не найдет значение по ключу, то вернет дефолтный, который сам прописываешь, но в мапу его не добавит

        // удаление - удаляет пару по ключу
        User removed = userHashMap.remove("zxc"); // вернет удаленное значение из пары
        System.out.println(removed);

        System.out.println(userHashMap.remove("zxc", zxc)); // удаляет по ключу и значению, true false - удалили или нет
        // перебор мапы
        for (Map.Entry<String, User> entry : userHashMap.entrySet()) { // обратились к типу Ентри который внутри мапы, он дженерик <>
            // на каждое добавление в мапу создается Entry("qwe", qwe) с двумя свойствами - ключ и значение
            // EntrySet возвращает Set из объектов типа Entry на каждое этирации
            System.out.println(entry.getKey()); //возвращает ключ
            System.out.println(entry.getValue()); // возвращает значение
        }

        // HashMap<String, ArrayList<Integer>>
        // HashMap<код сообщенияб количество сообщений>

        //enumMap в качесте ключей использует перечисление
        //перечисления одного типа
        EnumMap<User.Role, ArrayList<User>> enumMap = new EnumMap<User.Role, ArrayList<User>>(User.Role.class);
        //в конструктор ВСЕГДА передаем на класс перечисления
        //внутри мапы создается массив на количество перечислений, и харнит только знаения
        enumMap.put(User.Role.USER, new ArrayList<>(Arrays.asList(qwe, cvb)));
        //сначала создаем список объектов, потмо в эррэйлист и его сохраняем под ключом АДМИН
        enumMap.put(User.Role.ADMIN, new ArrayList<>(Arrays.asList(asd, zxc)));
        System.out.println(enumMap.get(User.Role.USER)); // ArrayList<User>

        User newUser = new User("new", "new123", User.Role.ADMIN);
        enumMap.get(newUser.getRole()).add(newUser); //возвращаем список по ключу - get(newUser.getRole())
        // , добавляем нвоого юзера - .add(newUser)

        TreeMap<String, User> treeMap = new TreeMap<>(userHashMap);
        // пары хранит в отсортированном порядке по ключам
        //необходимо передавать компаратор если бы были User на первом месте, а не String
        System.out.println(treeMap);

        // вывести логины пользователей с ролью ADMIN
        for (Map.Entry<String, User> entry : treeMap.entrySet()) {
            if (entry.getValue().getRole() == User.Role.ADMIN) {
                System.out.println(entry.getValue().getLogin());
            }
        }
        System.out.println(treeMap.entrySet()); // пары Set
        System.out.println(treeMap.keySet()); // только ключи Set
        System.out.println(treeMap.values()); // только значения Collection

        // LinkedHashMap - работает медленнее чем hash, но хранит в порядке добавления

        User strong = new User("strong", "strong123", User.Role.ADMIN); //пока есть сильная ссылка сборщик его не удаляет
        // strong = null; //а теперь он null  его удалит
        WeakReference<User> weak = new WeakReference<>(strong); // слабая ссылка на объект, сборщик удалит если ссылка будет нехватка памяти

        WeakHashMap<String,User> weakHashMap = new WeakHashMap<>();
        //содержимое будет польностью ощичено, если на ключи не осталось сильных ссылок, а в остальном hashMap
        // используют в качестве временного кэша

        // HashMap
        //"qwe", qwe
        // "asd". asd
        // [Entry ("qwe", qwe)+keyHashCode, Entry ("asd",asd"+keyHashCode]
        // Entry хранит hashcode ключа, и он может быть одинаковый
        //если hashcode одинаковый, то новый элемент добавляется не в массив, а
        // сохраняется в связный список к "собрату"

    }
}
