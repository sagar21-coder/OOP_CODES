import java.util.*;

public class EngineeringCalculatorA1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Engineering Calculator ===");

        while (true) {
            try {
                System.out.print("\nEnter expression (or 'exit'): ");
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Calculator closed.");
                    break;
                }

                double result = evaluateExpression(input);
                System.out.println("Result = " + result);

            } catch (ArithmeticException ae) {
                System.out.println("Math Error: " + ae.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Expression. Try again.");
            }
        }
        sc.close();
    }

    public static double evaluateExpression(String expr) {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isWhitespace(ch)) continue;

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expr.length() &&
                        (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.'))
                    sb.append(expr.charAt(i++));
                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (isOp(ch)) {
                while (!ops.empty() && prec(ch) <= prec(ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(ch);
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    static int prec(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
    static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero!");
                return a / b;
        }
        return 0;
    }
}