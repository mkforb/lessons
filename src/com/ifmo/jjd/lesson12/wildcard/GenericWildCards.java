package com.ifmo.jjd.lesson12.wildcard;

import com.ifmo.jjd.lesson12.type.PairContainer;
import com.ifmo.jjd.lesson12.types.parameters.Bus;
import com.ifmo.jjd.lesson12.types.parameters.Train;
import com.ifmo.jjd.lesson12.types.parameters.Transport;

public class GenericWildCards {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Animal> animalBox = new PairContainer<>(1, animal);
        PairContainer<Integer, Cat> catBox = new PairContainer<>(1, cat);
        PairContainer<Integer, Dog> dogBox = new PairContainer<>(1, dog);

        GenericWildCards.<Animal>copyValue(catBox, animalBox);
        GenericWildCards.<Animal>copyValue(animalBox, animalBox);
        GenericWildCards.<Animal>copyValue(dogBox, animalBox);

        copyValue(animalBox, animalBox);
        copyValue(catBox, animalBox);

        // Пример с другой иерархией классов

        Transport transport = new Train("Спб", "Москва", "23-Ф", 12); // new Bus("Спб", "Тверь", "234", false);
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        //Train train = new Train("Спб", "Москва", "23-Ф", 12);

        PairContainer<Integer, Transport> transportBox = new PairContainer<>(1, transport);
        PairContainer<Integer, Bus> busBox = new PairContainer<>(1, bus);
        copyValue(busBox, transportBox);
    }


    // ? extends T указывает на то что передаваемый тип должен быть тип T или его потомки
    // ? super T указывает на то что передаваемый тип должен быть тип T или его предки
    public static <T> void copyValue(
            PairContainer<Integer, ? extends T> from,
            PairContainer<Integer, ? super T> to) {
        to.setValue(from.getValue());
    }
}
