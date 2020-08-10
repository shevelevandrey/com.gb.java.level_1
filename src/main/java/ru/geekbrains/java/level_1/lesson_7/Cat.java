package ru.geekbrains.java.level_1.lesson_7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name) {
        this.name = name;
        this.appetite = getAppetiteAtBirth(1, 10);
        this.fullness = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (!fullness) {
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);
                fullness = !fullness;

                System.out.println(this.getClass().getSimpleName() + "[" + this.getName() + "] покушал.");
            } else {
                System.out.println("В тарелке не достаточно еды для " +
                        this.getClass().getSimpleName() + "[" +
                        this.getName() + "]. Кол-во еды в тарелке: " + p.getFood() + "; Аппетит котенка: " + appetite + ".");
            }
        } else {
            System.out.println(this.getClass().getSimpleName() + "[" + this.getName() + "] не голоден.");
        }
    }

    public void info() {
        if (fullness) {
            System.out.println(this.getClass().getSimpleName() + "[" + this.getName() + "]. не голоден.");
        } else {
            System.out.println(this.getClass().getSimpleName() + "[" + this.getName() + "]. голоден; Аппетит котенка: " + appetite + ".");
        }
    }

    private int getAppetiteAtBirth(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

}

