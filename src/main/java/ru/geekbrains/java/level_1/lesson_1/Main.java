package ru.geekbrains.java.level_1.lesson_1;

public class Main {

    /**
     * 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
     */
    public static void main(String[] args) {

        /**
         * 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
         */
        byte byte_val = 127;
        short short_val = 32767;
        int int_val = 2147483647;
        long long_val = 9223372036854775807L;
        float float_val = 100000.10f;
        double double_val = 1000000000000.20d;
        char char_val = '*';
        boolean boolean_val = true;


        System.out.println(calculate(5, 10, 3, 8));
        System.out.println(isBetween10and20(5, -20));
        printIsPositiveOrNegative(5);
        System.out.println(isNegative(1));
        printGreetings("Андрей");
        printIsLeapYear(2000);
    }

    /**
     * 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
     */
    public static double calculate(int a, int b, int c, int d) throws ArithmeticException {
        double division = (d != 0) ? (double) c / d : c / d;
        return a * (b + division);
    }

    /**
     * 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     * если да – вернуть true, в противном случае – false;
     */
    public static boolean isBetween10and20(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    /**
     * 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали,
     * или отрицательное;
     * Замечание: ноль считаем положительным числом.
     */
    public static void printIsPositiveOrNegative(int a) {
        System.out.printf("Число " + a + " - является %s.%n", (a >= 0) ? "положительным" : "отрицательным");
    }

    /**
     * 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
     */
    public static boolean isNegative(int a) {
        return (a < 0);
    }

    /**
     * 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    public static void printGreetings(String name) {
        System.out.printf("Привет, \"%s\"!%n", name);
    }

    /**
     * 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static void printIsLeapYear(int year) {
        System.out.printf(year + " год - %s високосным.", ( year % 4 == 0 && ( year % 100 != 0 || year % 400 == 0 ) ) ? "является" : "не является" );
    }

}
