package core.equals;

public class EqualsApp {

  public static void main(String[] args) {
    Cake cake1 = new Cake(44);
    TastyCake cake2 = new TastyCake(44);
    boolean equals1 = cake1.equals(cake2);
    System.out.println(equals1);

    Apple apple1 = new Apple(3);
    TastyApple apple2 = new TastyApple(3);
    boolean equals2 = apple1.equals(apple2);
    System.out.println(equals2);
  }

}
