import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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

