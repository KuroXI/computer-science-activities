import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the values:");
        int rows = 3;
        int columns = 3;
        int array[][] = new int[columns][rows];
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < columns; b++) {
                array[a][b] = input.nextInt();
            }
        }

        input.close();

        int determinant = 0;

        for (int c = 0; c < rows; c++) {
            int deter1 = 1, deter2 = 1;
            for (int d = 0; d < columns; d++) {
                deter1 *= array[(c + d) % columns][d];
                deter2 *= array[(c + d) % columns][rows - 1 - d];
            }

            determinant += deter1 - deter2;
        }

        System.out.print("Determinant = " + determinant);
    }
}