package com.ifmo.jjd.lesson6;

import java.util.UUID;

public class Application {
    public static void main(String[] args) {
        Climber climber1 = new Climber();
        // Обращение к свойствам объекта
        // Свойства private, прямое обращение невозможно
        /*climber1.fullName = "Иван Григорьев";
        climber1.email = "ivan@gmail.com";
        climber1.age = 34;
        climber1.uuid = UUID.randomUUID();*/
        climber1.setFullName("Иван Григорьев");
        climber1.setAge(34);
        climber1.setEmail("ivan@gmail.com");
        climber1.setUuid();

        Climber climber2 = new Climber();
        /*climber2.fullName = "Елена Михайлова";
        climber2.email = "helena@yahoo.com";
        climber2.age = 20;
        climber2.uuid = UUID.randomUUID();*/
        climber2.setFullName("Елена Михайлова");
        climber2.setAge(20);
        climber2.setEmail("helena@yahoo.com");
        climber2.setUuid();

        int helenaAge = climber2.getAge();
        // ToDo: Ссылочные типы возвращаются по ссылке?

        System.out.println(helenaAge);
        System.out.println(climber1);
        System.out.println(climber2);

        Mountain everest = new Mountain("Эверест", 8000);
        Mountain elbrus = new Mountain("Эльбрус", 6000);

        System.out.println(everest);
        System.out.println(elbrus);

        // сравнить и клонировать группы
        Climber cl1 = new Climber();
        Mountain m1 = new Mountain("Гора", 1000);
        ClimbingGroup gr1 = new ClimbingGroup(m1, 0);
        gr1.addClimber(cl1);

        Climber cl2 = new Climber();
        Mountain m2 = new Mountain("Гора", 1000);
        ClimbingGroup gr2 = new ClimbingGroup(m2, 0);
        gr2.addClimber(cl2);

        System.out.println(gr1);
        System.out.println(gr2);
        System.out.println(gr1.equals(gr2));

        Climber cl3 = new Climber();
        Mountain m3 = new Mountain("Гора", 1000);
        ClimbingGroup gr3 = new ClimbingGroup(m3, 1);
        gr3.addClimber(cl3);

        ClimbingGroup gr4 = gr3.clone();

        cl3.setFullName("Tata");
        cl3.setAge(20);

        System.out.println(gr3);
        System.out.println(gr4);
    }
}
