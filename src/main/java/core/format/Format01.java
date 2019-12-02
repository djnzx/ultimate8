package core.format;

public class Format01 {
  public static void main(String[] args) {
    // natural way of parameters
    System.out.printf("Hello word %s %s %s\n", "ONE", "TWO", "THREE");
    // reordering parameters
    System.out.printf("Hello word %2$s %1$s %3$s\n", "ONE", "TWO", "THREE");
  }
}
