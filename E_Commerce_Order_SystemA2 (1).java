import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    // Constructor 1: name + price only
    public Product(String name, double price) {
        this.name = name; this.price = price;
        this.quantity = 1; this.category = "General";
    }

    // Constructor 2: name + price + quantity
    public Product(String name, double price, int quantity) {
        this.name = name; this.price = price;
        this.quantity = quantity; this.category = "General";
    }

    // Constructor 3: all four fields
    public Product(String name, double price, int quantity, String category) {
        this.name = name; this.price = price;
        this.quantity = quantity; this.category = category;
    }

    public double getTotalPrice() { return price * quantity; }

    public String toString() {
        return String.format("%-14s %8.2f  %3d  %9.2f",
                name, price, quantity, getTotalPrice());
    }
}

class Order {
    private ArrayList<Product> list = new ArrayList<>();

    public void addProduct(Product p) { list.add(p); }

    public double calculateTotal() {
        double total = 0;
        for (Product p : list) total += p.getTotalPrice();
        return total;
    }

    public double applyDiscount(double total) {
        if (total > 5000) return total * 0.15;   // 15% off
        if (total > 3000) return total * 0.10;   // 10% off
        if (total > 1000) return total * 0.05;   // 5% off
        return 0;
    }

    public void generateInvoice() {
        double total    = calculateTotal();
        double discount = applyDiscount(total);

        System.out.println("\n========== INVOICE ==========");
        System.out.printf("%-14s %8s  %3s  %9s%n",
                "Product","Price","Qty","Total");
        System.out.println("------------------------------");
        for (Product p : list) System.out.println(p);
        System.out.println("------------------------------");
        System.out.printf("Total Amount : Rs %.2f%n", total);
        System.out.printf("Discount     : Rs %.2f%n", discount);
        System.out.printf("Final Payable: Rs %.2f%n", total - discount);
        System.out.println("==============================");
    }
}

public class E_Commerce_Order_SystemA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        // Using different constructors
        order.addProduct(new Product("Laptop", 45000));
        order.addProduct(new Product("Mouse", 500, 2));
        order.addProduct(new Product("Headphones", 1500, 1, "Electronics"));

        System.out.print("How many more products to add? ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");     String name = sc.nextLine();
            System.out.print("Price: ");    double price = sc.nextDouble();
            System.out.print("Qty: ");      int qty = sc.nextInt(); sc.nextLine();
            System.out.print("Category: "); String cat = sc.nextLine();
            order.addProduct(new Product(name, price, qty, cat));
        }

        order.generateInvoice();
        sc.close();
    }
}
