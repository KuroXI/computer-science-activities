package ArrayOperation;

public class Update {
    public static void main(String[] args) {
        int[] LA = {1, 3, 5, 7, 8};
        int updateIndex = 3;
        int updateElement = 10;

        System.out.println("The original array elements are:");
        for (int i = 0; i < LA.length; i++) {
            System.out.printf("LA[%s] = %s \n", i, LA[i]);
        }

        LA[updateIndex - 1] = updateElement;

        System.out.println("The array elements after updation:");
        for (int i = 0; i < LA.length; i++) {
            System.out.printf("LA[%s] = %s \n", i, LA[i]);
        }
    }
}
