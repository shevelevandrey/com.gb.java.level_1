package ru.geekbrains.java.level_1.lesson_6;

import java.util.Random;

public abstract class Animal {

    private String name;

    private float runLimit;
    private float swimLimit;
    private float jumpLimit;

    public String getName() {
        return name;
    }

    public float getRunLimit() {
        return runLimit;
    }

    public float getSwimLimit() {
        return swimLimit;
    }

    public float getJumpLimit() {
        return jumpLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRunLimit(int min, int max) {
        runLimit = getLimit(min, max);
    }

    public void setSwimLimit(int min, int max) {
        swimLimit = getLimit(min, max);
    }

    public void setJumpLimit(int min, int max) {
        jumpLimit = getLimit(min, max);
    }

    public boolean toRun (float value) {
        boolean isRun = value <= runLimit;
        System.out.println(this.getClass().getSimpleName() + "[" +
                           name + "] " +
                           (isRun ? "сможет" : "не сможет") + " пробежать " +
                           value + "м. Пердел составляет " +
                String.format("%.2f", runLimit) + "м."
        );
        return isRun;
    }

    public boolean toSwim (float value) {
        boolean isSwim = value <= swimLimit;
        System.out.println(this.getClass().getSimpleName() + "[" +
                name + "] " +
                (isSwim ? "сможет" : "не сможет") + " проплыть " +
                value + "м. Пердел составляет " +
                String.format("%.2f", swimLimit) + "м."
        );
        return isSwim;
    }

    public boolean toJump (float value) {
        boolean isJump = value <= jumpLimit;
        System.out.println(this.getClass().getSimpleName() + "[" +
                name + "] " +
                (isJump ? "сможет" : "не сможет") + " подпрыгнуть на " +
                value + "м. Пердел составляет " +
                String.format("%.2f", jumpLimit) + "м."
        );
        return isJump;
    }

    private float getLimit(int min, int max) {
        return new Random().nextFloat() * (max - min) + min;
    }

}
