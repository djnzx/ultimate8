package java8.streams.examples5;

import java.util.OptionalInt;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class StreamSample2 {
  public static void m0() {
    IntStream.rangeClosed(1, 100)
        .forEach(System.out::println);
  }

  public static void m1() {
    IntStream.rangeClosed(1, 100)
        .map(i -> 100-i)
        .forEach(System.out::println);
  }

  public static void m3() {
    IntStream.rangeClosed(1, 100)
        .filter(i->i%2==0)
        .forEach(System.out::println);
  }

  public static void m4() {
    PrimitiveIterator.OfInt it = IntStream.rangeClosed(1, 100)
        .limit(5)
        .iterator();
    while (it.hasNext()) {
      it.next();
    }
  }

  public static void m5() {
    OptionalInt max = IntStream.rangeClosed(1, 100)
        .filter(i -> i % 2 == 0)
        .max();
    System.out.println(max.getAsInt());
    //.forEach(System.out::println);
  }

  public static void main(String[] args) {
    OptionalInt max = IntStream.rangeClosed(1, 100)
        .filter(i -> i>50)
        .filter(i -> i<50)
        .max();
    max.ifPresent(System.out::println);
  }
}
