// Coded by: Victor H. Gonzales.
// Date: December 6, 2022

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Number of Rows: ");
        int rows = input.nextInt();

        System.out.print("Enter Number of Columns: ");
        int cols = input.nextInt();

        System.out.println();

        int[][] array = new int[rows][cols];

        int elementNum = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element" + elementNum + " : ");
                array[i][j] = input.nextInt();
                elementNum++;
            }
        }

        input.close();

        System.out.println();

        System.out.println("Matrix Input:");
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < cols; k++) {
                System.out.print(array[j][k] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Transposed Matrix:");

        for (int l = 0; l < cols; l++) {
            for (int m = 0; m < rows; m++) {
                System.out.print(array[m][l] + " ");
            }
            System.out.println();
        }
    }
}