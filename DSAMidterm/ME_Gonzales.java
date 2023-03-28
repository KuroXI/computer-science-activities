package DSAMidterm;

import java.util.Scanner;

public class ME_Gonzales {
    public static void main(String[] args) {
        boolean isStop = false;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        System.out.println("1 - Reverse Word");
        System.out.println("2 - Balancing the parenthesis");
        System.out.println("3 - Exit");
        System.out.println();

        while(!isStop) {
            System.out.print("Select an option [1..3]: ");
            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    System.out.print("Input the word you want to reverse: ");
                    String word = scanner.next();
                    reverseWord(word);
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Input the parenthesis you want to check: ");
                    String parenthesis = scanner.next();
                    String prompt = (checkBalanceParenthesis(parenthesis))
                            ? "Balance\n" : "Not Balance\n";
                    System.out.println(prompt);
                    break;
                case 3:
                    System.out.println("John Victor H. Gonzales");
                    isStop = true;
                    break;
                default:
                    System.out.println("1 - Reverse Word");
                    System.out.println("2 - Balancing the parenthesis");
                    System.out.println("3 - Exit");
                    System.out.println();
                    break;
            }
        }

        scanner.close();
    }

    static void reverseWord(String word) {
        if (word.length() == 1) {
            System.out.print(word);
        } else {
            System.out.print(word.charAt(word.length() - 1));
            reverseWord(word.substring(0, word.length() - 1));
        }
    }

    static boolean checkBalanceParenthesis(String parenthesis) {
        int count = 0;

        for (char character : parenthesis.toCharArray()) {
            if (character == '(') {
                count++;
            } else if (character == ')') {
                count--;
            }
        }

        return count == 0;
    }
}
