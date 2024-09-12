
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
