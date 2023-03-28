package ObjectOrientedProgram;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AccountRun {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.00");
        Scanner scanner = new Scanner(System.in);

        Account account1 = new Account();
        Account account2 = new Account();

        account1.setBalance(150);
        account2.setBalance(500.53);

        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());

        System.out.print("\nEnter withdrawal amount for account1: ");
        double withdraw1 = scanner.nextDouble();

        System.out.println("\nsubtracting " + df.format(withdraw1) + " from account1 balance");
        account1.debit(withdraw1);
        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());

        System.out.print("\nEnter withdrawal amount for account2: ");
        double withdraw2 = scanner.nextDouble();

        System.out.println("\nsubtracting " + df.format(withdraw2) + " from account2 balance");
        account2.debit(withdraw2);
        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());
    }
}