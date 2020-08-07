package ru.geekbrains.java.level_1.lesson_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void setFood(int food) {
        this.food = this.food + food;
        System.out.println("Добавили еду в тарелку в размере:  " + food);
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        food = ((food - n) >= 0) ? food -= n : 0;
    }

    public void info() {
        System.out.println("Кол-во еды в тарелке:  " + food);
    }
}
