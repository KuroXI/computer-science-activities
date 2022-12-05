import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        
        System.out.print("Enter the number of columns: ");
        int columns = input.nextInt();

        int array[][] = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = input.nextInt();
            }
        }

        input.close();

        int combineArray[] = new int[rows * columns];
        int m = 0;
        for (int[] row:array) {
            for (int value:row) {
                combineArray[m] = value;
                m++;
            }
        }
        
        Arrays.sort(combineArray);
 
        int mostFrequent = 1;
        int count = 1;
        for (int o = 0; o < combineArray.length; o++) {
            int value = combineArray[o];
            int temporaryCount = 0;
            for (int p = 0; p < combineArray.length; p++) {
                if (combineArray[p] == value) temporaryCount++;
                
                if (temporaryCount >= count) {
                    mostFrequent = value;
                    count = temporaryCount;
                }
            }
        }

        System.out.print("Most severe crime = " + mostFrequent);
    }
}