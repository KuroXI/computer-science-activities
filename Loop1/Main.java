// Coded by: Victor H. Gonzales.
// Date: October 25, 2022
package Loop1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Number: ");
        int number = input.nextInt();
        input.close();

        int i = 1;
        String order = "";
        String orderReverse = "";

        while(number != i && i < number) {
            order += number + " " + i + " ";
            number--;
            i++;

            if (i == number) order += number + " ";
        }

        String[] splitted = order.split(" ");
        int j = splitted.length - 1;
        while (j >= 0) {
            orderReverse += splitted[j] + " ";
            j--;
        }
        
        System.out.println(order + orderReverse);
    }
}