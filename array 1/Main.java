import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of the 1st array: ");
        int firstSize = input.nextInt();
        int[] firstArray = new int[firstSize];

        System.out.print("Enter size of the 2nd array: ");
        int secondSize = input.nextInt();
        int[] secondArray = new int[secondSize];

        System.out.print("Enter size of the 3rd array: ");
        int thirdSize = input.nextInt();
        int[] thirdArray = new int[thirdSize];

        System.out.println();

        System.out.print("Enter value of the 1st array: ");
        for (int i = 0; i < firstSize; i++) {
            firstArray[i] = input.nextInt();
        }

        System.out.print("Enter value of the 2nd array: ");
        for (int j = 0; j < secondSize; j++) {
            secondArray[j] = input.nextInt();
        }

        System.out.print("Enter value of the 3rd array: ");
        for (int k = 0; k < thirdSize; k++) {
            thirdArray[k] = input.nextInt();
        }

        input.close();

        System.out.println();

        System.out.print("Value of array 3:");
        for (int value : thirdArray) {
            System.out.print(" " + value);
        }

        System.out.println();
        System.out.print("Value of array 2:");
        for (int value : secondArray) {
            System.out.print(" " + value);
        }

        System.out.println();
        System.out.print("Value of array 1:");
        for (int value : firstArray) {
            System.out.print(" " + value);
        }

        System.out.println();
        System.out.print("Common Elements:");

        String commons = "";

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        Arrays.sort(thirdArray);

        for (int num1 : firstArray) for (int num2 : secondArray) {
            if (num1 == num2) for (int num3 : thirdArray) if (num2 == num3) {
                commons += " " + num3;
            }
        }

        if (commons.length() > 0) {
            System.out.print(commons);
        } else {
            System.out.print(" No Common Elements");
        }
    }
}