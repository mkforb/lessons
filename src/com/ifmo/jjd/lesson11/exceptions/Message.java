package com.ifmo.jjd.lesson11.exceptions;

public class Message {
    private String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws AppException {
        if (title.trim().length() < 3) {
            throw new AppException("title < 3");
        }
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws AppException {
        if (text.trim().length() < 7) {
            throw new AppException("text < 3");
        }
        this.text = text;
    }
}
