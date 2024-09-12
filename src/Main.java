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

