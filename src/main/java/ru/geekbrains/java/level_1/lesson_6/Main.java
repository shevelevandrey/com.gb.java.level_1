package ru.geekbrains.java.level_1.lesson_6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[] {
                new Dog("Шарик"),
                new Cat("Барсик"),
                new Dog("Тузик"),
                new Cat("Мурзик"),
                new Cat("Рыжик"),
                new Dog("Дружок")
        };

        for (Animal animal : animals) {
            System.out.println();

            if (animal instanceof Mammal) {
                ( (Mammal) animal).run( getLimit(1, 600) );
                ( (Mammal) animal).jump( getLimit(1, 3) );
            } else {
                System.out.println(animal.getClass().getSimpleName() + "[" + animal.getName() + "] не умеет бегать или прыгать :(");
            }

            if (animal instanceof Aquatic) {
                ( (Aquatic) animal).swim( getLimit(1, 10) );
            } else {
                System.out.println(animal.getClass().getSimpleName() + "[" + animal.getName() + "] не умеет плавать :(");
            }

        }

    }

    private static float getLimit(int min, int max) {
        return new Random().nextFloat() * (max - min) + min;
    }

}
