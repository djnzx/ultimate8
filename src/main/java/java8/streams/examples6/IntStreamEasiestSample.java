package java8.streams.examples6;

import java.util.stream.IntStream;

public class IntStreamEasiestSample {
  public static void main(String[] args) {
    IntStream.
        range(0,10).
        forEach(value -> System.out.println(value));
  }
}
