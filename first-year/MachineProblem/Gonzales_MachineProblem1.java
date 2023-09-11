package MachineProblem;

import java.util.Arrays;
import java.util.Scanner;

public class Gonzales_MachineProblem1 {
    public static void main(String[] args) {
        boolean isStop = false;

        Scanner scanner = new Scanner(System.in);

        while(!isStop) {
            System.out.print("INPUT INTEGER VALUE: ");
            int input = scanner.nextInt();

            switch(input) {
                case 1:
                    System.out.print("Enter the first number: ");
                    int addNumber1 = scanner.nextInt();
                    System.out.print("Enter the second number: ");
                    int addNumber2 = scanner.nextInt();
                    System.out.printf("%s + %s = %s\n\n", addNumber1, addNumber2, addNumber1 + addNumber2);
                    break;
                case 2:
                    System.out.print("Enter a number to reverse: ");
                    int reverseNumber = scanner.nextInt();
                    System.out.printf("Reverse number: %s\n\n", reverse(reverseNumber));
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    int sieveNumber = scanner.nextInt();
                    System.out.printf("Prime number from 2 to %s are: ", sieveNumber);
                    sieveEratosthenes(sieveNumber);
                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    int palindromeNumber = scanner.nextInt();

                    if (palindromeNumber == reverse(palindromeNumber)) {
                        System.out.printf("%s is Palindrome\n\n", palindromeNumber);
                    } else {
                        System.out.printf("%s is not Palindrome\n\n", palindromeNumber);
                    }

                    break;
                case 5:
                    System.out.print("Enter a number: ");
                    int oddOrEvenNumber = scanner.nextInt();

                    if (oddOrEvenNumber % 2 == 0) {
                        System.out.printf("%s is Even number\n\n", oddOrEvenNumber);
                    } else {
                        System.out.printf("%s is Odd number\n\n", oddOrEvenNumber);
                    }

                    break;
                case 6:
                    System.out.println("Terminate the program - John Victor H. Gonzales.");
                    isStop = true;
                    break;
                default:
                    System.out.println("Invalid Option\n\n1 - Sum\n2 - Reverse Number\n3 - Prime Number\n4 - Palindrome Checking\n5 - Odd or Even\n6 - Exit\n");
                    break;
            }
        }

        scanner.close();
    }

    static int reverse(int number) {
        int reverse = 0;

        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        return reverse;
    }

    static void sieveEratosthenes(int number) {
        boolean[] prime = new boolean[number + 1];
        Arrays.fill(prime, true);

        for (int i = 2; i * i <= number; i++) {
            if (prime[i])
                for (int j = i * i; j <= number; j += i) prime[j] = false;
        }

        for (int i = 2; i <= number; i++) {
            if (prime[i]) System.out.print(i + " ");
        }

        System.out.println("\n");
    }
}
