package ru.geekbrains.java.level_1.lesson_6;

public class Cat extends Animal {

    public Cat(String name) {
        setName(name);

        setRunLimit(5, 500);
        setSwimLimit(0, 0);
        setJumpLimit(0, 2);
    }

}
