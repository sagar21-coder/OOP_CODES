// Abstract class — partial blueprint, cannot be instantiated
abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name   = name;
        this.salary = salary;
    }

    // Concrete method — ALL subclasses inherit this unchanged
    public void displayDetails() {
        System.out.println("Name   : " + name);
        System.out.println("Salary : Rs " + salary);
    }

    // Abstract method — subclass MUST implement this (no body here)
    public abstract double calculateBonus();
}

// Subclass 1 — Developer gets 10% bonus
class Developer extends Employee {

    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;   // 10%
    }
}

// Subclass 2 — Manager gets 20% bonus
class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20;   // 20%
    }
}

public class AbstractB3 {
    public static void main(String[] args) {

        Employee e1 = new Developer("Rahul", 50000);
        Employee e2 = new Manager("Priya", 80000);

        e1.displayDetails();
        System.out.println("Bonus  : Rs " + e1.calculateBonus());

        System.out.println();

        e2.displayDetails();
        System.out.println("Bonus  : Rs " + e2.calculateBonus());
    }
}