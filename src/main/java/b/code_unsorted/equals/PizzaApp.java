package b.code_unsorted.equals;

public class PizzaApp {
  public static void main(String[] args) {
    Pizza p1 = new Pizza(30);
    Pizza p2 = new Pizza(30);
//    Pizza p3 = p2;
    Person alex = new Person("Alex");

    if (p1.equals(alex)) {}

    if (p1.equals(p2)) {
      System.out.println("identical");
    } else {
      System.out.println("non identical");
    }
  }
}
