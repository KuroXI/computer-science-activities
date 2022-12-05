import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = input.nextInt();
        input.close();

        String odd = "";
        int total = 0;
        int i = 1;

        do {
            odd += i + " ";
            total += i;
            i += 2;
        } while(i <= number * 2);

        System.out.println("Odd numbers are " + odd);
        System.out.println("The sum of odd numbers up to " + number + " term is " + total);
    }
}