// Coded by: Victor H. Gonzales
// Date: September 13, 2022
package InputOutput;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of student:");
        String name = input.nextLine();

        System.out.println("Enter number of units enrolled:");
        int enroll = input.nextInt();

        System.out.println("Enter price per unit:");
        double payment = input.nextDouble();

        input.close();

        double total = (payment * enroll);

        double tenPercent = total * 0.1;
        double fivePercent = total * 0.05;

        System.out.println("Computed Tuition fee: " + df.format(total));
        System.out.println(name + ", you could avail the following payment mode:\n\n");
        System.out.println("Payment Mode:\n");
        System.out.println("cash Payment: " + df.format(total - tenPercent) + " dollars");
        System.out.println("cash Payment: " + df.format(total + fivePercent) + " dollars");
        System.out.println("cash Payment: " + df.format(total + tenPercent) + " dollars");
    }
}