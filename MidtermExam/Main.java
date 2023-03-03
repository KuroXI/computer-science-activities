// Coded by: Victor H. Gonzales
// Date: October 4, 2022
package MidtermExam;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("$###,###.00");

        System.out.println("Sales Input\n");

        System.out.println("Enter Product 1:");
        String product1 = input.nextLine();
        System.out.println("Enter Price:");
        double price1 = input.nextDouble();

        input.nextLine();

        System.out.println("\nEnter Product 2:");
        String product2 = input.nextLine();
        System.out.println("Enter Price:");
        double price2 = input.nextDouble();

        input.nextLine();
        
        String product3 = input.nextLine();
        System.out.println("\nEnter Product 3:");
        double price3 = input.nextDouble();
        System.out.println("Enter Price:");

        System.out.println("\nInput Mode of Payment Terms\n");

        System.out.println("Cash Discount:");
        int discount1 = input.nextInt();
        System.out.println("\tYou input " + discount1 + "% Discount for Cash");

        System.out.println("3 Months Installment:");
        int discount2 = input.nextInt();
        System.out.println("\tYou input " + discount2 + "% Interest for 3 Months Installment");

        System.out.println("6 Months Installment:");
        int discount3 = input.nextInt();
        System.out.println("\tYou input " + discount3 + "% Interest for 6 Months Installment");

        System.out.println("12 Months Installment:");
        int discount4 = input.nextInt();
        System.out.println("\tYou input " + discount4 + "% Interest for 12 Months Installment\n");

        System.out.println("Main Menu\n");

        System.out.println("Press I/i:" + product1 + "\t\t\t\t" + df.format(price1));
        System.out.println("Press S/s:" + product2 + "\t\t" + df.format(price2));
        System.out.println("Press X/x:" + product3 + "\t" + df.format(price3));

        System.out.println("\nEnter Item:");
        char item = input.next().toLowerCase().charAt(0);

        String selectModePayment = "", selectItem = "";
        double selectPrice = 0, selectDiscount = 0, total = 0, monthly = 0;

        int mode = input.nextInt();

        switch(item) {
            case 'i':
                selectItem = product1;
                System.out.println("\tYour Item is " + product1);
                System.out.println("\nSelect mode of Payment\n");

                System.out.println("Press 1:Cash\t\t\t\t\t" + discount1 + "% Discount");
                System.out.println("Press 2:3 Months Installment\t" + discount2 + "% Interest");
                System.out.println("Press 3:6 Months Installment\t" + discount3 + "% Interest");
                System.out.println("Press 4:12 Months Installment\t" + discount4 + "% Interest");

                System.out.println("\nEnter Mode of Payment:");

                switch(mode) {
                    case 1:
                        selectModePayment = "Cash";
                        selectPrice = price1;
                        selectDiscount = price1 * ((double) discount1 / 100);
                        total = selectPrice - selectDiscount;
                        monthly = 0;
                        break;
                    case 2:
                        selectModePayment = "3 Months Installment";
                        selectPrice = price1;
                        selectDiscount = price1 * ((double) discount2 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 3;
                        break;
                    case 3:
                        selectModePayment = "6 Months Installment";
                        selectPrice = price1;
                        selectDiscount = price1 * ((double) discount3 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 6;
                        break;
                    case 4:
                        selectModePayment = "12 Months Installment";
                        selectPrice = price1;
                        selectDiscount = price1 * ((double) discount4 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 12;
                        break;
                    default:
                        selectModePayment = "Cash";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount1 / 100);
                        total = selectPrice - selectDiscount;
                        monthly = 0;
                        break;
                }
                break;
            case 's':
                selectItem = product2;
                System.out.println("\tYour Item is " + product2);
                System.out.println("\nSelect mode of Payment\n");

                System.out.println("Press 1:Cash\t\t\t\t\t" + discount1 + "% Discount");
                System.out.println("Press 2:3 Months Installment\t" + discount2 + "% Interest");
                System.out.println("Press 3:6 Months Installment\t" + discount3 + "% Interest");
                System.out.println("Press 4:12 Months Installment\t" + discount4 + "% Interest");

                System.out.println("\nEnter Mode of Payment:");

                switch(mode) {
                    case 1:
                        selectModePayment = "Cash";
                        selectPrice = price2;
                        selectDiscount = price2 * ((double) discount1 / 100);
                        total = selectPrice - selectDiscount;
                        monthly = 0;
                        break;
                    case 2:
                        selectModePayment = "3 Months Installment";
                        selectPrice = price2;
                        selectDiscount = price2 * ((double) discount2 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 3;
                        break;
                    case 3:
                        selectModePayment = "6 Months Installment";
                        selectPrice = price2;
                        selectDiscount = price2 * ((double) discount3 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 6;
                        break;
                    case 4:
                        selectModePayment = "12 Months Installment";
                        selectPrice = price2;
                        selectDiscount = price2 * ((double) discount4 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 12;
                        break;
                    default:
                        selectModePayment = "Cash";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount1 / 100);
                        total = selectPrice - selectDiscount;
                        monthly = 0;
                        break;
                }
                break;
            case 'x':
                selectItem = product3;
                System.out.println("\tYour Item is " + product3);
                System.out.println("\nSelect mode of Payment\n");

                System.out.println("Press 1:Cash\t\t\t\t\t" + discount1 + "% Discount");
                System.out.println("Press 2:3 Months Installment\t" + discount2 + "% Interest");
                System.out.println("Press 3:6 Months Installment\t" + discount3 + "% Interest");
                System.out.println("Press 4:12 Months Installment\t" + discount4 + "% Interest");

                System.out.println("\nEnter Mode of Payment:");

                switch(mode) {
                    case 1:
                        selectModePayment = "Cash";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount1 / 100);
                        total = selectPrice - selectDiscount;
                        monthly = 0;
                        break;
                    case 2:
                        selectModePayment = "3 Months Installment";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount2 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 3;
                        break;
                    case 3:
                        selectModePayment = "6 Months Installment";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount3 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 6;
                        break;
                    case 4:
                        selectModePayment = "12 Months Installment";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount4 / 100);
                        total = selectPrice + selectDiscount;
                        monthly = total / 12;
                        break;
                    default:
                        selectModePayment = "Cash";
                        selectPrice = price3;
                        selectDiscount = price3 * ((double) discount1 / 100);
                        total = selectPrice - selectDiscount;
                        monthly = 0;
                        break;
                }
                break;
            default:
                System.out.println("\tYour Item is NO ITEM\n\t");
                selectItem = "N/A";
                selectModePayment = "N/A";
                selectPrice = 0;
                selectDiscount = 0;
                total = 0;
                monthly = 0;
                break;
        }

        input.close();

        System.out.println("Mode of Payment:\t\t\t\t" + selectModePayment);
        System.out.println("Item:\t\t\t\t\t\t\t" + selectItem);
        System.out.println("Price:\t\t\t\t\t\t\t" + df.format(selectPrice));
        System.out.println("Discount/Interest:\t\t\t\t" + df.format(selectDiscount));
        System.out.println("Total Amount:\t\t\t\t\t" + df.format(total));
        System.out.println("Monthly Amortization:\t\t\t" + df.format(monthly));
    }
}