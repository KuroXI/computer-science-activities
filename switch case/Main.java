// Coded by: John Victor H. Gonzales.
// Date: September 27, 2022
// First Year

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00 pesos");
        Scanner input = new Scanner(System.in);

        int ordinaryPass = input.nextInt();
        System.out.println("Enter Discount for Ordinary Passenger:");
        int ordinaryFare = input.nextInt();
        System.out.println("Business class additional Fare for Ordinary Passenger:");

        int studentPass = input.nextInt();
        System.out.println("\nEnter Discount for Student Passenger:");
        int studentFare = input.nextInt();
        System.out.println("Business class additional Fare for Student Passenger:");

        int seniorPass = input.nextInt();
        System.out.println("\nEnter Discount for Senior Citizen Passenger:");
        int seniorFare = input.nextInt();
        System.out.println("Business class additional Fare for Senior Citizen Passenger:");

        int fare = input.nextInt();
        System.out.println("\nEnter fare:");
        char type = input.next().toLowerCase().charAt(0);
        System.out.println("Passenger type [O,S,C]:");
        char travellingWithBC = input.next().toLowerCase().charAt(0);
        System.out.println("Travelling in business class [Y/N]:");

        input.close();

        switch (type) {
            case 'o':
                int ordinaryBusinessCharge = (travellingWithBC == 'y') ? ordinaryFare : 0;
                double ordinaryDiscountPercentage = (double) ordinaryPass / 100;
                double ordinaryDiscount = ordinaryDiscountPercentage * fare;
                
                System.out.println("\nDiscount: " + df.format(ordinaryDiscount));
                System.out.println("Business class charge: " + df.format(ordinaryBusinessCharge));
                System.out.println("\nNew fare: " + df.format(fare + ordinaryBusinessCharge - ordinaryDiscount));
                
                break;
            case 's':
                int studentBusinessCharge = (travellingWithBC == 'y') ? studentFare : 0;
                double studentDiscountPercentage = (double) studentPass / 100;
                double studentDiscount = studentDiscountPercentage * fare;
                
                System.out.println("\nDiscount: " + df.format(studentDiscount));
                System.out.println("Business class charge: " + df.format(studentBusinessCharge));
                System.out.println("\nNew fare: " + df.format(fare + studentBusinessCharge - studentDiscount));
                
                break;
            case 'c':
                int seniorBusinessCharge = (travellingWithBC == 'y') ? seniorFare : 0;
                double seniorDiscountPercentage = (double) seniorPass / 100;
                double seniorDiscount = seniorDiscountPercentage * fare;
                
                System.out.println("\nDiscount: " + df.format(seniorDiscount));
                System.out.println("Business class charge: " + df.format(seniorBusinessCharge));
                System.out.println("\nNew fare: " + df.format(fare + seniorBusinessCharge - seniorDiscount));
                
                break;
            default:
                System.out.println("\nDiscount: " + df.format(0));
                System.out.println("Business class charge: " + df.format(0));
                System.out.println("\nNew fare: " + df.format(0));
                
                break;
        }
    }
}