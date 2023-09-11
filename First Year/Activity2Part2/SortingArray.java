package Activity2Part2;

import java.util.Arrays;

public class SortingArray {
    public static void main(String[] args) {
        int[] num1 = {3, 5, 6, 9, 8, 7};
        int[] num2 = {5, 0, 1, 2, 3, 4, -2};

        System.out.printf("After sorting new array becomes: %s", Arrays.toString(sort(num1)));
        System.out.printf("After sorting new array becomes: %s", Arrays.toString(sort(num2)));
    }

    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];

            int j = i - 1;
            while(j > -1 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }

        return array;
    }
}
