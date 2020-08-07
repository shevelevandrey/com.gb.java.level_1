package ru.geekbrains.java.level_1.lesson_7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFullness;

    public Cat(String name) {
        this.name = name;
        this.appetite = getAppetiteAtBirth(1, 10);
        this.isFullness = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFullness = false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return isFullness;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (!isFullness) {
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);
                isFullness = !isFullness;

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
        if (isFullness) {
            System.out.println(this.getClass().getSimpleName() + "[" + this.getName() + "]. не голоден.");
        } else {
            System.out.println(this.getClass().getSimpleName() + "[" + this.getName() + "]. голоден; Аппетит котенка: " + appetite + ".");
        }
    }

    private int getAppetiteAtBirth(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

}

