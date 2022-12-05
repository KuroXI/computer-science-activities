import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size: ");
        int size = input.nextInt();

        System.out.print("Enter the values: ");

        int i = 0,
            j = 0,
            k = (size - 1) - 2,
            father = 0,
            son = 0;
        int values[] = new int[size];

        while (i < size) {
            values[i] = input.nextInt();
            i++;
        }

        input.close();

        Arrays.sort(values);

        while(j < 3) {
            son += values[j];
            j++;
        };
        while(k <= (size - 1)) {
            father += values[k];
            k++;
        }

        System.out.println("Father = " + father + ", Son = " + son);
    }
}