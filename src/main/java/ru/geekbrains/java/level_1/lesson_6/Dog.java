package ru.geekbrains.java.level_1.lesson_6;

public class Dog extends Aquatic {

    public Dog(String name) {
        setName(name);

        setRunLimit(5, 600);
        setSwimLimit(0, 10);
        setJumpLimit(0, 1);
    }

}
