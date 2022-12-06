// Coded by: Victor H. Gonzales.
// Date: November 22, 2022

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of eggs: ");
        int eggs = input.nextInt();
        input.close();

        System.out.println();

        System.out.println("Number of dozen: " + determineDozen(eggs));
        System.out.println("Eggs less than a dozen: " + showLessDozen(eggs));
    }

    static int determineDozen(int number) {
        return number / 12;
    }

    static int showLessDozen(int number) {
        return number % 12;
    }
}