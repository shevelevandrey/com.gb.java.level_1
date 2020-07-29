package ru.geekbrains.java.level_1.lesson_5;

public class Employee {

    /**
     *
     * * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
     * * Конструктор класса должен заполнять эти поля при создании объекта;
     * * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
     * * Создать массив из 5 сотрудников
     * Пример:
     * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
     * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
     * persArray[1] = new Person(...);
     * ...
     * persArray[4] = new Person(...);
     *
     * * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
     *
     * */

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int years;

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public int getYears() {
        return years;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Employee(String fullName, String position, String email, String phone, double salary, int years) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.years = years;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", years=" + years +
                '}';
    }

}
