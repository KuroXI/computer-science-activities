package ArrayOperation;

public class Deletion {
    public static void main(String[] args) {
        int LA[] = {1, 3, 5, 7, 8};
        int deleteIndex = 3;

        System.out.println("The original array elements are:");
        for (int i = 0; i < LA.length; i++) {
            System.out.printf("LA[%s] = %s\n", i, LA[i]);
        }

        int newArr[] = new int[LA.length - 1];
        for (int i = 0, j = 0; i < LA.length; i++) {
            if (i == deleteIndex) continue;
            newArr[j++] = LA[i];
        }
        LA = newArr.clone();

        System.out.println("The array elements after deletion:");
        for (int i = 0; i < LA.length; i++) {
            System.out.printf("LA[%s] = %s\n", i, LA[i]);
        }
    }
}
