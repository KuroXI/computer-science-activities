package Fibonacci;

import java.util.Scanner;

public class Main {
    public static void fibonacci(int equal, int first, int second) {
        if (equal < 1) return;

        System.out.print(first + " ");
        fibonacci(equal - 1, second, first + second);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value: ");
        int number = scanner.nextInt();
        scanner.close();

        fibonacci(number, 0, 1);
    }
}