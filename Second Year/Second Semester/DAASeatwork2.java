import java.util.Scanner;

public class DAASeatwork2 {
  public static void main(String[] args) {
    boolean hasStopped = false;

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter value: ");
    int number = scanner.nextInt();

    do {
      System.out.println("\na. Recursive");
      System.out.println("b. Non-Recursive");
      System.out.println("c. Exit");
      System.out.print("Choose method: ");
      String method = scanner.next();

      switch (method.toLowerCase()) {
        case "a":
          fibonacciRecursive(number, 0, 1);
          System.out.println();
          break;
        case "b":
          fibonacciNonRecursive(number);
          System.out.println();
          break;
        case "c":
          hasStopped = true;
          System.out.println("John Victor H. Gonzales.");
          break;
        default:
          System.out.println("Invalid method");
      }
    } while (!hasStopped);

    scanner.close();
  }

  private static void fibonacciRecursive(int equal, int first, int second) {
    if (equal < 1)
      return;

    System.out.print(first + " ");
    fibonacciRecursive(equal - 1, second, first + second);
  }

  private static void fibonacciNonRecursive(int number) {
    int first = 0, second = 1;
    for (int i = 0; i < number; i++) {
      System.out.print(first + " ");
      int next = first + second;
      first = second;
      second = next;
    }
  }
}