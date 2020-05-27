package b.code_unsorted.equals;

public class Person {
  // package private
  protected String name;
  // private
  private static int counter = 0;
  protected boolean isMember;
  // public
  public int age;

  public Person() {
    this.isMember = false;
    counter++;
  }

  public Person(String name_) {
    this(name_, false);
//    this.name = name_;
//    this.isMember = false;
//    counter++;
  }

  public Person(String name_, boolean isMember) {
    this.name = name_;
    this.isMember = isMember;
    counter++;
  }

  public static int getCounter() {
    return Person.counter;
  }

  public static void setCounter(int newVal) {
    Person.counter = newVal;
  }
}
