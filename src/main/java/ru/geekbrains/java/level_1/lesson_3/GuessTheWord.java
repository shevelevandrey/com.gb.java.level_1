package ru.geekbrains.java.level_1.lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    /**
     *
     * 2 * Создать массив из слов String[] words = { "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato" };
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно, можно пользоваться:
     * String str = "apple";
     * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово
     * Используем только маленькие буквы
     *
     * */

    private static final String gameTitle = "Guess the word";

    public static void main(String[] args) {

        String[] words = { "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                           "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                           "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato" };

        runGame(words);
    }

    private static void printArray(String[] array) {
        Arrays.stream(array).forEach( elem -> System.out.printf("%s ", elem) );
        System.out.println();
        System.out.println();
    }

    private static String getRandomWord(String[] array) {
        return array[ new Random().nextInt(array.length) ];
    }

    public static String getUserWord(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }

    public static boolean isWordsEqual(String secretWord, String answerWord) {
        if (answerWord.equals(secretWord)) {
            System.out.println("\nYou won!");
            return true;
        }

        char[] maskArray = "###############".toCharArray();

        for (int i = 0; i < secretWord.length() && i < answerWord.length(); i++)
            maskArray[i] = ( secretWord.charAt(i) == answerWord.charAt(i) ) ? secretWord.charAt(i) : maskArray[i];

        System.out.printf("Sorry, but you didn't guess the word: %s%n", new String(maskArray));

        return false;
    }

    public static void runGame(String[] words) {
        System.out.printf("Good day! We offer you to play the game \"%s\".\n" +
                "You need to guess one of these words:%n", gameTitle);

        printArray(words);
        String secretWord = getRandomWord(words);

        int tryCount = 1;
        boolean toRepeat = true;

        while (toRepeat) {
            String message = (tryCount == 1) ? "Please, entering your word: " : "Attempt #" + tryCount + ". Try entering the word again: ";

            String userWord = getUserWord(message);
            toRepeat = !isWordsEqual(secretWord, userWord);

            tryCount++;
        }

        System.out.println("Goodbye! ;)");
    }

}
