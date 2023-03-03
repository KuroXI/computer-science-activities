package ArrayOperation;

public class Search {
    public static void main(String[] args) {
        int[] LA = {1, 3, 5, 7, 8};
        int searchElement = 5;

        System.out.println("The original array elements are:");
        for (int i = 0; i < LA.length; i++) {
            System.out.printf("LA[%s] = %s \n", i, LA[i]);
        }

        for (int i = 0; i < LA.length; i++) {
            if (LA[i] != searchElement) continue;

            System.out.printf("Found element %s at position %s\n", searchElement, i + 1);
            break;
        }
    }
}
