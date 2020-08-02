package ru.geekbrains.java.level_1.lesson_6;

public class Dog extends Animal {

    private float swimLimit;

    public Dog(String name) {
        setName(name);

        setRunLimit(5, 600);
        setSwimLimit(0, 10);
        setJumpLimit(0, 1);
    }

    public float getSwimLimit() {
        return swimLimit;
    }

    public void setSwimLimit(int min, int max) {
        swimLimit = getLimit(min, max);
    }

    public boolean toSwim(float value) {
        boolean isSwim = value <= swimLimit;
        System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] " +
                (isSwim ? "сможет" : "не сможет") + " проплыть " +
                String.format("%.2f", value) + "м. Пердел составляет " +
                String.format("%.2f", swimLimit) + "м."
        );
        return isSwim;
    }

}
