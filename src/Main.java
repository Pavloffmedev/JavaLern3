import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
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


/**
 * Задание 11: Реализуйте класс Product с полями name, price, и quantity.
 * Создайте класс Store, который содержит список продуктов и методы для добавления, удаления и поиска товаров по имени
 */
class Product {
    private String name;
    private double price;
    private int quantity;

    // Конструктор
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "name='" + name + "', price=" + price + ", quantity=" + quantity;
    }
}

class Store {
    private ArrayList<Product> products;


    public Store() {
        this.products = new ArrayList<>();
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProductByName(String name) {
        return products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}


/**
 * Задачи 12: Создайте интерфейс PaymentSystem с методами pay() и refund().
 * Реализуйте классы CreditCard и PayPal, которые реализуют этот интерфейс
 */
interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
}

class CreditCard implements PaymentSystem {
    private String cardNumber;
    private String cardHolderName;


    public CreditCard(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("оплачено " + amount + " кредиткой [" + cardNumber + "]");
    }

    @Override
    public void refund(double amount) {
        System.out.println("возврат " + amount + " на кредитку [" + cardNumber + "]");
    }
}

class PayPal implements PaymentSystem {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("оплачено " + amount + " PayPal [" + email + "]");
    }

    @Override
    public void refund(double amount) {
        System.out.println("возврат " + amount + " PayPal [" + email + "]");
    }
}


/**
 * Задание 13: Создайте класс UniqueID, который генерирует уникальные идентификаторы для объектов каждого созданного класса.
 * Реализуйте этот функционал через статическое поле и метод
 */
class UniqueID {
    private static int lastID = 0;

    public static int generateID() {
        return ++lastID;
    }
}


/**
 * Задание 14: Создайте класс Point с координатами x и y.
 * Реализуйте класс Rectangle, который содержит две точки (левая верхняя и правая нижняя).
 * Реализуйте метод для вычисления площади прямоугольника
 */
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Rectangle2 {
    private final Point topLeft;
    private final Point bottomRight;

    public Rectangle2(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public int calculateArea() {
        int width = Math.abs(bottomRight.getX() - topLeft.getX());
        int height = Math.abs(topLeft.getY() - bottomRight.getY());
        return width * height;
    }
}


/**
 * Задание 15: Создайте класс ComplexNumber с полями для действительной и мнимой частей. Реализуйте методы для сложения, вычитания, умножения и деления комплексных чисел
 */
class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}


/**
 * Задание 16: Создайте класс Matrix, представляющий двумерную матрицу.
 * Реализуйте методы для сложения и умножения матриц. Продемонстрируйте перегрузку методов
 */
class Matrix {
    private final int[][] data; // Двумерный массив для хранения элементов матрицы
    private final int rows;     // Количество строк
    private final int cols;     // Количество столбцов

    public Matrix(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Невозможно сложить матрицы");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix add(int scalar) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + scalar;
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Невозможно перемножить матрицы");
        }

        int[][] result = new int[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(int scalar) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] * scalar;
            }
        }

        return new Matrix(result);
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/**
 * Задание 17: Реализуйте классы для небольшой текстовой игры, такие как Player, Enemy, Weapon, с полями и методами, описывающими их поведение
 */
class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void display() {
        System.out.println("Оружие: " + name + ", урон: " + damage);
    }
}

class Player {
    private final String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(name + " оружие " + weapon.getName());
    }

    public void attack(Enemy enemy) {
        if (weapon == null) {
            System.out.println(name + " нет оружия для аттаки");
            return;
        }

        System.out.println(name + " атакует " + enemy.getName() + " с " + weapon.getName());
        enemy.takeDamage(weapon.getDamage());
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " получил " + damage + " урон. ХП " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void displayStatus() {
        System.out.println("Игрок: " + name + ", ХП: " + health);
        if (weapon != null) {
            weapon.display();
        }
    }
}

class Enemy {
    private final String name;
    private int health;
    private final int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Player player) {
        System.out.println(name + " атакует " + player.getName());
        player.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " получает " + damage + " урон. ХП " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public void displayStatus() {
        System.out.println("Враг: " + name + ", ХП: " + health);
    }
}


/**
 * Задание 18: Создайте классы Order, Customer, и Product.
 * Реализуйте систему, где можно добавлять заказы, отображать общую стоимость заказа и просматривать историю заказов
 */
class Product2 {
    private String name;
    private double price;

    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println("Продукт: " + name + ", Цена: " + price);
    }
}

class Order {
    private ArrayList<Product2> products = new ArrayList<>();;
    private double totalCost = 0.0;


    public void addProduct(Product2 product) {
        products.add(product);
        totalCost += product.getPrice();
        System.out.println(product.getName() + " добавлено в заказ");
    }

    public double calculateTotalCost() {
        return totalCost;
    }

    public void displayOrder() {
        System.out.println("Детали заказа:");
        for (Product2 product : products) {
            product.display();
        }
        System.out.println("Итого: " + totalCost);
    }
}


/**
 * Задание 19: Создайте класс Device с полем brand и методами turnOn() и turnOff().
 * Реализуйте классы Smartphone и Laptop, которые наследуют от Device и добавляют уникальные методы, например, takePhoto() для смартфона
 */
class Device {
    private final String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println(brand + " включен");
    }

    public void turnOff() {
        System.out.println(brand + " выключен");
    }

    public String getBrand() {
        return brand;
    }
}

class Smartphone extends Device {

    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println(getBrand() + " смартфон сделал фото");
    }
}

class Laptop extends Device {

    public Laptop(String brand) {
        super(brand);
    }

    public void connectToNetwork() {
        System.out.println(getBrand() + " ноутбук подключается к интернету");
    }
}


/**
 * Задание 20: Разработайте классы для игры "Крестики-нолики".
 * Создайте класс Game, который управляет логикой игры, и классы Player, описывающие поведение игроков
 */
class Player2 {
    private final String name;
    private final char symbol;

    public Player2(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Game {
    private final char[][] board;
    private final Player2 playerX;
    private final Player2 playerO;
    private Player2 currentPlayer;

    // Конструктор
    public Game(Player2 playerX, Player2 playerO) {
        this.board = new char[3][3];
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Невозможно так походить");
            return false;
        }

        board[row][col] = currentPlayer.getSymbol();
        return true;
    }

    private boolean checkWin() {
        char symbol = currentPlayer.getSymbol();

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayBoard();
            System.out.println(currentPlayer.getName() + ", Ваша очередь. Введите столбец и колонку (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (makeMove(row, col)) {
                if (checkWin()) {
                    displayBoard();
                    System.out.println(currentPlayer.getName() + " победил!");
                    break;
                }

                if (checkDraw()) {
                    displayBoard();
                    System.out.println("Ничья!");
                    break;
                }

                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            }
        }

        scanner.close();
    }
}