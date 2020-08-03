package ru.geekbrains.java.level_1.lesson_6;

import java.util.Random;

public abstract class Mammal extends Animal {

    protected float runLimit;
    protected float jumpLimit;

    public float getRunLimit() {
        return runLimit;
    }

    public float getJumpLimit() {
        return jumpLimit;
    }

    public void setRunLimit(int min, int max) {
        runLimit = getLimit(min, max);
    }

    public void setJumpLimit(int min, int max) {
        jumpLimit = getLimit(min, max);
    }

    public boolean run (float value) {
        boolean isRun = value <= runLimit;
        System.out.println(
                this.getClass().getSimpleName() + "[" + name + "] " +
                        (isRun ? "сможет" : "не сможет") + " пробежать " +
                        String.format("%.2f", value) + "м. Пердел составляет " +
                        String.format("%.2f", runLimit) + "м."
        );
        return isRun;
    }

    public boolean jump (float value) {
        boolean isJump = value <= jumpLimit;
        System.out.println(this.getClass().getSimpleName() + "[" + name + "] " +
                (isJump ? "сможет" : "не сможет") + " подпрыгнуть на " +
                String.format("%.2f", value) + "м. Пердел составляет " +
                String.format("%.2f", jumpLimit) + "м."
        );
        return isJump;
    }

    protected float getLimit(int min, int max) {
        return new Random().nextFloat() * (max - min) + min;
    }

}
