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
    }
}
