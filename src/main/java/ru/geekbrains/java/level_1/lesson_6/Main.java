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
            animal.toRun(200);
            animal.toSwim(3);
            animal.toJump(1);
            System.out.println();
        }
    }

}
