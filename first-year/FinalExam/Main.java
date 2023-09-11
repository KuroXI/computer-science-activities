// Coded by: Victor H. Gonzales.
// Date: September 20, 2022
package FinalExam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size: ");
        int size = input.nextInt();

        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = input.nextInt();
                array[i][j] = num;
            }
        }

        input.close();

        int row = row(array, size);
        int col = col(array, size);
        int diagonal = diagonal(array, size);

        if (row == col && row == diagonal && col == diagonal) {
            System.out.println("MAGIC!");
        } else {
            System.out.println("Just a square");
        }
    }

    public static int diagonal(int[][] array, int size) {
        int total = 0;
        for (int i = 0; i < size; i++) total += array[i][i];
        return total;
    }

    public static int row(int[][] array, int size) {
        int total = 0;
        for (int i = 0; i < size; i++) total += array[0][i];
        return total;
    }

    public static int col(int[][] array, int size) {
        int total = 0;
        for (int i = 0; i < size; i++) total += array[i][0];
        return total;
    }
}