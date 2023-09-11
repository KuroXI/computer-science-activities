package ObjectOrientedProgram;

import java.text.DecimalFormat;

public class Account {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBalance() {
        DecimalFormat df = new DecimalFormat("$###.00");
        return df.format(balance);
    }

    public void debit(double withdraw) {
        if (withdraw > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= withdraw;
        }
    }
}
