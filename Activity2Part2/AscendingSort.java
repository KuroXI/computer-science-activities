package Activity2Part2;

import java.util.Arrays;
import java.util.Scanner;

public class AscendingSort {
    public static void main(String[] args) {
        int arrayLength = 10;
        
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[arrayLength];

        System.out.printf("Enter %s value: ", arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            num[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println(Arrays.toString(sort(num)));
    }

    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];

            int j = i - 1;
            while(j > -1 && current > array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }

        return array;
    }
}
