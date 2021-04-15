package com.ifmo.jjd.lesson12.type;

public class User<T> { // <T> говорит, что дженерик-тип можно использовать в классе
    // Поскольку T не уточнен, то у T можно вызывать только методы класса Object
    // private String id;
    // private int id;
    // private UUID id;
    private T id;
    private String login;
    private String password;

    public User() { }

    public User(T id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
