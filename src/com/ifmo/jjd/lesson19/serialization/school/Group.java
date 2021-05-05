package com.ifmo.jjd.lesson19.serialization.school;

import java.io.Serializable;

public class Group implements Serializable {
    private String title;

    public Group(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Group{" +
                "title='" + title + '\'' +
                '}';
    }
}