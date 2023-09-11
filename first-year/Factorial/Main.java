package Factorial;

import java.math.BigDecimal;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int factorial = 50;
        double total = 1;
        int length = 150;

        for (int i = 1; i <= factorial; i++) {
            total *= i;

            String factorialNumber = "";
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    factorialNumber += j;
                    break;
                }
                
                factorialNumber += j + "x";
            }

            String whitespace = String.join("", Collections.nCopies(length - factorialNumber.length(), " "));
            System.out.println(factorialNumber + whitespace + new BigDecimal(total));
        }
    }
}