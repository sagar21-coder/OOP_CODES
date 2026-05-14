import java.util.Scanner;

public class Array_OperationsA4{

    public static void display(int[] arr) {
        System.out.print("Elements: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
    }

    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    // Linear search — check element by element
    public static int searchElement(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;  // found at index i
        return -1;                         // not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int choice;
        do {
            System.out.println("\n===== ARRAY MENU =====");
            System.out.println("1.Display  2.Maximum  3.Minimum");
            System.out.println("4.Sum & Avg  5.Search  6.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: display(arr); break;
                case 2: System.out.println("Maximum: " + findMax(arr)); break;
                case 3: System.out.println("Minimum: " + findMin(arr)); break;
                case 4:
                    int sum = calculateSum(arr);
                    System.out.println("Sum: " + sum);
                    System.out.println("Average: " + (double)sum / arr.length);
                    break;
                case 5:
                    System.out.print("Search for: ");
                    int key = sc.nextInt();
                    int idx = searchElement(arr, key);
                    System.out.println(idx != -1
                            ? "Found at index: " + idx : "Not found.");
                    break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }
}