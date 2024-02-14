public class DAASeatwork2 {
  public static void main(String[] args) {
    int number = 15;
    fibonacciRecursive(number, 0, 1);
    System.out.println();
    fibonacciNonRecursive(number);
    System.out.println();
  }

  private static void fibonacciRecursive(int equal, int first, int second) {
    if (equal < 1) return;

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