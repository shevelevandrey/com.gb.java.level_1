package ru.geekbrains.java.level_1.lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Task 1
        System.out.println("Task 1: ");
        replacingArray( new int[]{ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 } );
        System.out.println();
        System.out.println();

        // Task 2
        System.out.print("Task 2: ");
        fillArray( new int[]{ 0, 3, 6, 9, 12, 15, 18, 21 } );
        System.out.println();
        System.out.println();

        // Task 3
        System.out.println("Task 3: ");
        calcArray( new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 } );
        System.out.println();
        System.out.println();

        // Task 4
        System.out.println("Task 4: ");
        matrixModification(10, 10);
        System.out.println();

        // Task 5
        System.out.println("Task 5: ");
        System.out.printf( "5.1. Max element is: %s;%n", getMax( new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 } ) );
        System.out.printf( "5.2. Min element is: %s;%n", getMin( new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 } ) );
        System.out.println();

        // Task 6
        System.out.println("Task 6: ");
        System.out.printf(" -> result: %s", checkBalance( new int[]{ 2, 2, 2, 1, 2, 2, 10, 1 } ) );
        System.out.println();

        System.out.printf(" -> result: %s", checkBalance( new int[]{ 2, 1, 1, 2, 1 } ) );
        System.out.println();

        System.out.printf(" -> result: %s", checkBalance( new int[]{ 1, 1, 1, 2, 1 } ) );
        System.out.println();

        System.out.printf(" -> result: %s", checkBalance( new int[]{ 8, 4, 1, 1, 2 } ) );
        System.out.println();
        System.out.println();

        // Task 7
        System.out.println("Task 7: ");
        arrayTransformation( new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 3 );
        System.out.println();
        System.out.println();
        arrayTransformation( new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 }, -3 );
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * */
    public static void replacingArray(int[] array) {
        System.out.print("input array:  ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );
        System.out.println();

        for (int i = 0; i < array.length; i++)
            array[i] = (array[i] == 0) ? 1 : 0;

        System.out.print("output array: ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     * */
    public static void fillArray(int[] inArray) {
        int[] newArray = new int[inArray.length];

        for (int i = 0; i < newArray.length; i++)
            newArray[i] = inArray[i];

        Arrays.stream( newArray ).forEach( i -> System.out.printf("%s ", i) );
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     * */
    public static void calcArray(int[] array) {
        System.out.print("input array:  ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );
        System.out.println();

        for (int i = 0; i < array.length; i++)
            array[i] = (array[i] < 6) ? array[i]*2 : array[i];

        System.out.print("output array: ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     * */
    public static void matrixModification(int x, int y) {
        int[][] array = new int[y][x];
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (j == counter) ? 1 : 0;
                System.out.printf("%s ", array[i][j]);
            }
            System.out.println();
            counter++;
        }
    }

    /**
     * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     * */
    public static int getMax(int[] array) {
        int result = array[0];

        for (int i = 0; i < array.length; i++)
            result = (array[i] > result) ? array[i] : result;

        return result;
    }

    public static int getMin(int[] array) {
        int result = array[0];

        for (int i = 0; i < array.length; i++)
            result = (array[i] < result) ? array[i] : result;

        return result;
    }

    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     * */
    public static boolean checkBalance(int[] array) {
        System.out.print("input array: ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );

        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < array.length; i++)
            sum += array[i];

        if (sum % 2 != 0)  return false;

        for (int i = 0; i < array.length; i++) {
            if ( leftSum < sum/2  )
                leftSum += array[i];
            else
                rightSum += array[i];
        }

        return leftSum == rightSum;
    }


    /**
     * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементымассива на n позиций.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * */
    public static void arrayTransformation(int[] array, int offset) {
        int buffer;

        System.out.printf("offset: %s%n", offset);
        System.out.print("input array:  ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );

        while (offset > 0) {
            for (int i = 0; i < array.length; i++) {
                buffer = array[array.length-1];
                array[array.length-1] = array[i];
                array[i] = buffer;
            }
            offset--;
        }

        while (offset < 0) {
            for (int i = array.length-1; i >= 0; i--) {
                buffer = array[array.length-1];
                array[array.length-1] = array[i];
                array[i] = buffer;
            }
            offset++;
        }

        System.out.println();
        System.out.print("output array: ");
        Arrays.stream( array ).forEach( i -> System.out.printf("%s ", i) );
    }

}
