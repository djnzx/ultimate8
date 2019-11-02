package core.equals;

public class EqualsApp {

  public static void main(String[] args) {
    Cake cake1 = new Cake(44);
    TastyCake cake2 = new TastyCake(44, 567);
    boolean equals1 = cake1.equals(cake2);
    boolean equals2 = cake2.equals(cake1);
    System.out.println(equals1);
  }

}
