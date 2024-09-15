import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person a = new Person("", 11, Gender.FEMAIL);
    }


}

enum Gender {
    MALE,
    FEMAIL,
    OTHER
}

/**
 * Задание 1: Создайте класс Person с полями name, age, gender.
 * Реализуйте методы для вывода информации о человеке и увеличения его возраста. Добавьте метод для изменения имени
 */
class Person {
    private String name;
    private int age;
    private final Gender gender;

    Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void printInfo() {
        System.out.println("ИНФОРИАЦИЯ О " + name);
        System.out.println("возраст: " + age);
        System.out.println("пол: " + gender.toString());
    }

    void changeName(String newName) {
        name = newName;
    }

    void plusYearToAge() {
        age ++;
    }

}


/**
 * Задание 2: Создайте класс Worker, который наследуется от класса Person, и добавьте поле salary.
 * Создайте класс Manager, который наследует от Worker и добавляет поле для подчиненных сотрудников.
 */
class Worker extends Person {

    private int salary;

    Worker(String name, int age, Gender gender, int salary) {
        super(name, age, gender);
        this.salary = salary;
    }
}

class Manager extends Worker {

    private ArrayList<Worker> workersInSubordination;
    private
    Manager(String name, int age, Gender gender, int salary, ArrayList<Worker> workers) {
        super(name, age, gender, salary);
        workersInSubordination = workers;
    }
}


/**
 * Задание 3: Создайте интерфейс Animal с методом makeSound().
 * Реализуйте классы Dog, Cat, и Cow, которые реализуют этот интерфейс.
 * Продемонстрируйте полиморфизм на примере массива животных.
 */
interface Animal {
    void makeSound();
}

class Dog implements  Animal{
    private String name;

    Dog(String name) {
        this.name = name;
    }


    @Override
    public void makeSound() {
        System.out.println(name + " сказала гав");
    }
}

class Cat implements  Animal{
    private String name;

    Cat(String name) {
        this.name = name;
    }


    @Override
    public void makeSound() {
        System.out.println(name + " сказала мяу");
    }
}

class Cow implements  Animal{
    private String name;

    Cow(String name) {
        this.name = name;
    }


    @Override
    public void makeSound() {
        System.out.println(name + " сказала му");
    }
}


/**
 * Задание 4: Создайте абстрактный класс Transport с абстрактным методом move().
 * Реализуйте классы Car и Bike, которые наследуются от Transport и реализуют метод move()
 */
abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    @Override
    void move() {
        System.out.println("Машина едет");
    }
}

class Bike extends Transport {
    @Override
    void move() {
        System.out.println("Байк едет");
    }
}


/**
 * Задание 5: Создайте класс Book с полями title, author, и year.
 * Создайте класс Library, который содержит коллекцию книг и методы для добавления книг, поиска по автору и году публикации
 */
class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    void printInfo() {
        System.out.println("ИНФОРИАЦИЯ О " + title);
        System.out.println("год: " + year);
        System.out.println("автор: " + author);
    }
}

class Library {

    private ArrayList<Book> books;

    Library(ArrayList<Book> books) {
        this.books = books;
    }

    void addBooks(ArrayList<Book> books) {
        this.books.addAll(books);
    }

    ArrayList<Book> findByAuthor(String author) {
         return (ArrayList<Book>) books.stream().filter(book -> book.author.equals(author)).collect(Collectors.toList());
    }

    ArrayList<Book> findByYear(int year) {
        return (ArrayList<Book>) books.stream().filter(book -> book.year == year).collect(Collectors.toList());
    }

}


/**
 * Задание 6: Создайте класс BankAccount с полями accountNumber, balance, и методами для пополнения и снятия средств.
 * Обеспечьте инкапсуляцию для безопасности данных счета.
 */
class BankAccount {

    private String accountNumber;
    private double balance = 0;

    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    double getBalance() {
        return balance;
    }

    void cashIn(double cash) {
        balance += cash;
    }

    void cashOut(double cash) {
        if (cash <= balance) {
            balance -= cash;
        }
    }
}


/**
 * Задание 7: Создайте класс Counter, который хранит количество созданных объектов данного класса.
 * Реализуйте статическое поле для учета количества объектов и метод для его увеличения при каждом создании объекта.
 */
class Counter {
    static int countOfObjects = 0;

    Counter() {
        countOfObjects ++;
    }
}


/**
 * Задание 8: Создайте абстрактный класс Shape с абстрактным методом getArea().
 * Реализуйте классы Circle и Rectangle, которые наследуют от Shape и вычисляют площадь круга и прямоугольника соответственно.
 */
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {

    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle extends Shape {

    private final double a;
    private final double b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }


    @Override
    double getArea() {
        return a * b;
    }
}


/**
 * Задание 9: Создайте класс Animal с методом move().
 * Реализуйте классы Fish, Bird и Dog, которые наследуют Animal и переопределяют метод move() (рыба плавает, птица летает, собака бегает)
 */
class Animal2 {
    void move() {
        System.out.println("Животное двигается");
    }
}

class Fish extends Animal2 {
    @Override
    void move() {
        System.out.println("плавает рыба");
    }
}

class Bird extends Animal2 {
    @Override
    void move() {
        System.out.println("летает птица");
    }
}

class Dog2 extends Animal2 {
    @Override
    void move() {
        System.out.println("бегает собака");
    }
}


/**
 * Задание 10: Создайте класс Student с полями name, group, grade.
 * Создайте класс University, который содержит список студентов и методы для добавления студентов, сортировки по имени и фильтрации по успеваемости
 */
class Student {
    private String name;
    private String group;
    private int grade;

    Student(String name, String group, int grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    String getName() {
        return name;
    }

    String getGroup() {
        return group;
    }

    int getGrade() {
        return grade;
    }
}

class University {

    private final ArrayList<Student> students;

    University(ArrayList<Student> students) {
        this.students = students;
    }


    void add(ArrayList<Student> students) {
        this.students.addAll(students);
    }

    void add(Student student) {
        this.students.add(student);
    }

    ArrayList<Student> sortByName() {
        this.students.sort(Comparator.comparing(Student::getName));
        return students;
    }

    ArrayList<Student> sortByGrade() {
        this.students.sort(Comparator.comparingInt(Student::getGrade));
        return students;
    }

}


