package ru.geekbrains.java.level_1.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    /**
     *
     * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
     * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     *
     * */

    public static final String gameTitle = "Guess the number";

    public static void main(String[] args) {
        runGame(0, 10,3);
    }

    private static int getRandomNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getUserNum(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextInt();
    }

    public static boolean isNumberEqual(int secretNum, int answerNum) {
        if (secretNum == answerNum) return true;

        if (secretNum > answerNum)
            System.out.println("Your number is less (<) than guessed.");
        else
            System.out.println("Your number is greater (>) than guessed.");

        return false;
    }

    public static boolean isContinuePlaying() {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;

        while (true) {
            System.out.print("Do you want to continue playing? 1 - yes, 0 - no: ");
            answer = scanner.nextInt();
            System.out.println();
            if (answer == 0 || answer == 1) break;
        }

        return (answer == 1);
    }

    public static void runGame(int minRange, int maxRange, int tryCount) {
        boolean continuePlaying = true;

        System.out.printf("Good day! We offer you to play the game \"%s\".\n" +
                "You need to guess a number in the range from %s to %s. " +
                "You have %s attempts.%n%n", gameTitle, minRange, maxRange, tryCount);

        while (continuePlaying) {
            int secretNum = getRandomNumber(minRange, maxRange);

            for (int i = 1; i <= tryCount; i++) {
                String message = (i == 1) ? "Please, entering your number: " : "Attempt #" + i + ". Try entering the number again: ";

                int userNum = getUserNum(message);
                if ( isNumberEqual(secretNum, userNum) ) {
                    System.out.println("You won!");
                    break;
                } else {
                    if ( i == tryCount ) System.out.printf("You loose! The hidden number was: %s.%n", secretNum);
                }
            }

            continuePlaying = isContinuePlaying();
        }

        System.out.println("Goodbye! ;)");
    }

}
