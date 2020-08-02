package ru.geekbrains.java.level_1.lesson_6;

import java.lang.reflect.Method;
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

            animal.toRun( getLimit(1, 600) );
            animal.toJump( getLimit(1, 3) );

            try {
                Method m = animal.getClass().getMethod("toSwim", new Class[]{float.class});
                m.invoke(animal, getLimit(1, 10));
            } catch (Exception e) {
                System.out.println(animal.getClass().getSimpleName() + "[" + animal.getName() + "] не умеет плавать :(");
            }
        }
    }

    private static float getLimit(int min, int max) {
        return new Random().nextFloat() * (max - min) + min;
    }

}
