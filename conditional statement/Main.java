// Coded by: John Victor H. Gonzales.
// Date: September 20, 2022
// First Year

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("$###,###.00");
        Scanner input = new Scanner(System.in);

        String router = input.nextLine();
        System.out.println("Enter Product:");
        double price = input.nextDouble();
        System.out.println("Enter Price:");

        input.close();

        double discount = 0, netPrice = 0;

        if (price >= 0 && price <= 10000) {
            discount = 0;
            netPrice = price;
        } else if (price > 10000 && price <= 20000) {
            discount = price * 0.05;
            netPrice = price - discount;
        } else if (price > 20000 && price <= 50000) {
            discount = price * 0.10;
            netPrice = price - discount;
        } else if (price > 50000 && price <= 100000) {
            discount = price * 0.15;
            netPrice = price - discount;
        } else if (price > 100000) {
            discount = price * 0.20;
            netPrice = price - discount;
        }

        System.out.println("\nPrice of the " + router + " is " + df.format(price));
        System.out.println("Discount is " + df.format(discount));
        System.out.println("Net Price is " + df.format(netPrice));
    }
}
