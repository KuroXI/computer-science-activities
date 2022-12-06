// Coded by: Victor H. Gonzales.
// Date: November 15, 2022

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements of the first array: ");
        int firstArraySize = input.nextInt();
        int firstArray[] = new int[firstArraySize];
        
        int i = 0, j = 0, k = 0;

        while(i < firstArraySize) {
            firstArray[i] = input.nextInt();
            i++;
        }

        System.out.print("Enter the number of elements of the second array: ");
        int secondArraySize = input.nextInt();
        int secondArray[] = new int[secondArraySize];

        while(j < secondArraySize) {
            secondArray[j] = input.nextInt();
            j++;
        };
        input.close();
        
        int array[] = new int[firstArraySize + secondArraySize];

        for (int value:firstArray) {
            array[k] = value;
            k++;
        };
        for (int value:secondArray) {
            array[k] = value;
            k++;
        };
        
        Arrays.sort(array);

        System.out.print("New array: ");
        for(int value:array) System.out.print(value + " ");
    }
}