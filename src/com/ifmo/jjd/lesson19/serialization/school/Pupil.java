package com.ifmo.jjd.lesson19.serialization.school;

import java.time.LocalDate;

public class Pupil extends Human implements LearnAble {
    // Если у Pupil поставить Serializable, то сериализоваться будут только свойства Pupil
    // Все свойства класса должны реализовывать Serializable
    private Group group;
    private int level;
    private LocalDate lastLesson;
    transient private final String info = "Ученик"; // transient -- чтобы исключить свойство из сериализации
    private static final long serialVersionUID = 1L; // Версия класса.
    // Если не прописать serialVersionUID и набор свойств изменится, то версия будет другой. Тогда при десериализации при различии версий будет ошибка.
    // Если прописали serialVersionUID, то версия всегда фиксирована.
    // Если предполагается изменение перечня свойств, то нужно прописать serialVersionUID.

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void learn(int knowledgeCount) {
        lastLesson = LocalDate.now();
        level += knowledgeCount;
    }


    @Override
    public String toString() {
        return "Pupil{" +
                "group=" + group +
                ", level=" + level +
                ", lastLesson=" + lastLesson +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}