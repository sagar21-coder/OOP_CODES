// Interface — defines WHAT to do, not HOW
interface Shape {
    void draw();
    double calculateArea();
}

// Class 1 — implements Shape
class Circle implements Shape {
    private double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override
    public void draw() {
        System.out.println("Drawing Circle  (radius = " + radius + ")");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;   // pi * r²
    }
}

// Class 2 — implements Shape
class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length; this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle (" + length + " x " + width + ")");
    }

    @Override
    public double calculateArea() {
        return length * width;   // l × w
    }
}

public class Interface_PolymorphismB2 {
    public static void main(String[] args) {

        // Interface reference — polymorphism!
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        s1.draw();
        System.out.printf("  Area: %.2f%n%n", s1.calculateArea());

        s2.draw();
        System.out.printf("  Area: %.2f%n", s2.calculateArea());

        // Array of shapes — polymorphic loop
        System.out.println("\n--- Polymorphic Loop ---");
        Shape[] shapes = { new Circle(3), new Rectangle(5, 2), new Circle(7) };
        for (Shape s : shapes) {
            s.draw();
            System.out.printf("  Area: %.2f%n", s.calculateArea());
        }
    }
}