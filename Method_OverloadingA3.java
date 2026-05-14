import java.util.Scanner;

class Calculator {

    // ---- Overloaded power() methods ----
    public static double power(int base, int exp) {
        return Math.pow(base, exp);
    }
    public static double power(double base, double exp) {
        return Math.pow(base, exp);
    }
    public static double power(float base, int exp) {
        return Math.pow(base, exp);
    }

    // ---- Overloaded absolute() methods ----
    public static int absolute(int num) {
        return Math.abs(num);
    }
    public static double absolute(double num) {
        return Math.abs(num);
    }
    public static long absolute(long num) {
        return Math.abs(num);
    }
}

public class Method_OverloadingA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== POWER CALCULATION ===");
        System.out.print("Enter integer base: ");    int iBase = sc.nextInt();
        System.out.print("Enter integer exponent: "); int iExp = sc.nextInt();
        System.out.println("Result: " + Calculator.power(iBase, iExp));

        System.out.print("\nEnter double base: ");    double dBase = sc.nextDouble();
        System.out.print("Enter double exponent: ");  double dExp  = sc.nextDouble();
        System.out.println("Result: " + Calculator.power(dBase, dExp));

        System.out.println("\n=== ABSOLUTE VALUE ===");
        System.out.print("Enter integer: ");  int inum = sc.nextInt();
        System.out.println("Absolute: " + Calculator.absolute(inum));

        System.out.print("Enter double: ");   double dnum = sc.nextDouble();
        System.out.println("Absolute: " + Calculator.absolute(dnum));

        System.out.print("Enter long: ");     long lnum = sc.nextLong();
        System.out.println("Absolute: " + Calculator.absolute(lnum));

        sc.close();
    }
}