// Coded by: John Victor H. Gonzales.
// Date: September 20, 2022
// First Year

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount: ");
        double amount = input.nextDouble();
        input.close();

        int
            bill1000 = 0,
            bill500 = 0,
            bill200 = 0,
            bill100 = 0,
            bill50 = 0,
            bill20 = 0,
            coin10 = 0,
            coin5 = 0,
            coin1 = 0,
            cent25 = 0,
            cent1 = 0;


        // ! Bad statement => if ((amount / 1000) >= 1)
        // * Good statement => if (amount > 1000)

        if ((amount / 1000) >= 1) {
            bill1000 = (int) amount / 1000;
            amount -= bill1000 * 1000;
        };

        if ((amount / 500) >= 1) {
            bill500 = (int) amount / 500;
            amount -= bill500 * 500;
        };

        if ((amount / 200) >= 1) {
            bill200 = (int) amount / 200;
            amount -= bill200 * 200;
        };

        if ((amount / 100) >= 1) {
            bill100 = (int) amount / 100;
            amount -= bill100 * 100;
        };

        if ((amount / 50) >= 1) {
            bill50 = (int) amount / 50;
            amount -= bill50 * 50;
        };

        if ((amount / 20) >= 1) {
            bill20 = (int) amount / 20;
            amount -= bill20 * 20;
        };

        if ((amount / 10) >= 1) {
            coin10 = (int) amount / 10;
            amount -= coin10 * 10;
        };

        if ((amount / 5) >= 1) {
            coin5 = (int) amount / 5;
            amount -= coin5 * 5;
        };

        if ((amount / 1) >= 1) {
            coin1 = (int) amount / 1;
            amount -= coin1 * 1;
        };

        if ((amount / 0.25) >= 1) {
            cent25 = (int) Math.floor(amount / 0.25);
            amount -= cent25 * 0.25;
        };

        if ((amount / 0.01) >= 1) {
            cent1 = (int) Math.round(amount / 0.01);
            amount -= cent1 * 0.01;
        };

        System.out.println("P1000 bills: " + bill1000);
        System.out.println("P500 bills: " + bill500);
        System.out.println("P200 bills: " + bill200);
        System.out.println("P100 bills: " + bill100);
        System.out.println("P50 bills: " + bill50);
        System.out.println("P20 bills: " + bill20);
        System.out.println("P10 coins: " + coin10);
        System.out.println("P5 coins: " + coin5);
        System.out.println("P1 coins: " + coin1);
        System.out.println("P25 cents: " + cent25);
        System.out.println("P1 cents: " + cent1);
    }
}