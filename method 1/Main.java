// Coded by: Victor H. Gonzales.
// Date: November 22, 2022

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter First integer: ");
        int first = input.nextInt();

        System.out.print("Enter Second integer: ");
        int second = input.nextInt();

        input.close();
        System.out.println();

        if (isMultiple(first, second)) {
            System.out.println(second + " is multiple of " + first);
        } else {
            System.out.println(second + " is not multiple of " + first);
        }
    }

    static boolean isMultiple(int a, int b) {
        return (b % a == 0) ? true : false;
    }
}