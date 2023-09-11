package Activity2Part2;

import java.util.Scanner;

public class SubArray {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Sub-array size: ");
        int subIndex = scanner.nextInt();

        scanner.close();

        int total = 0;
        for (int i = 0; i < subIndex; i++) {
            total += num[i];
        }

        System.out.printf("Sub-array from 0 to %s and sum is: %s", subIndex - 1, total);
    }
}
