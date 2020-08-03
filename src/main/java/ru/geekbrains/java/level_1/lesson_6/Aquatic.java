package ru.geekbrains.java.level_1.lesson_6;

public abstract class Aquatic extends Mammal {

    protected float swimLimit;

    public float getSwimLimit() {
        return swimLimit;
    }

    public void setSwimLimit(int min, int max) {
        swimLimit = getLimit(min, max);
    }

    public boolean swim(float value) {
        boolean isSwim = value <= swimLimit;
        System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] " +
                (isSwim ? "сможет" : "не сможет") + " проплыть " +
                String.format("%.2f", value) + "м. Пердел составляет " +
                String.format("%.2f", swimLimit) + "м."
        );
        return isSwim;
    }

}
