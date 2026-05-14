// Parent class (Superclass)
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Child class — inherits from Animal
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);    // calls Animal(name, age) constructor
        this.breed = breed;
    }

    // New method — only exists in Dog
    public void bark() {
        System.out.println(name + " is barking! Woof!");
    }

    // Override — Dog's own version replaces Animal's eat()
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food.");
    }

    public void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("Breed: " + breed);
    }
}

public class Single_InheritanceB1 {
    public static void main(String[] args) {
        Dog d1 = new Dog("Tommy", 3, "Labrador");

        d1.displayDetails();
        System.out.println();

        d1.eat();    // Dog's overridden version
        d1.sleep();  // inherited from Animal
        d1.bark();   // Dog-only method
    }
}