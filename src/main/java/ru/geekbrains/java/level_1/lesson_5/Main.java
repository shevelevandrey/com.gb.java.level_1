package ru.geekbrains.java.level_1.lesson_5;

public class Main {

    public static void main(String[] args) {

        int older = 90;
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(
                "Бродский Иосиф Александрович",
                "Middle developer",
                "i.brodsky@geekbrains.com",
                "5111",
                1500,
                80);

        employees[1] = new Employee(
                "Есенин Сергей Александрович",
                "Senior developer",
                "s.esenin@geekbrains.com",
                "5888",
                3000,
                125);

        employees[2] = new Employee(
                "Достоевский Фёдор Михайлович",
                "Business analyst",
                "f.dostoevsky@geekbrains.com",
                "5333",
                2500,
                199);

        employees[3] = new Employee(
                "Толстой Лев Николаевич",
                "Product manager",
                "l.tolstoy@geekbrains.com",
                "5555",
                4000,
                192);

        employees[4] = new Employee(
                "Пушкин Александр Сергеевич",
                "Product owner",
                "a.pushkin@geekbrains.com",
                "5777",
                5000,
                221);

        System.out.printf("list of employees over %s years old:%n%n", older);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getYears() > older) {
                System.out.println(employees[i].toString());
            }

        }

    }

}
