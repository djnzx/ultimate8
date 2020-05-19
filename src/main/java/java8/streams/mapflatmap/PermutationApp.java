package java8.streams.mapflatmap;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PermutationApp {

  static class Pair<A, B> {
    final A a;
    final B b;

    Pair(A a, B b) {
      this.a = a;
      this.b = b;
    }
  }

  private static Stream<Integer> range(int a, int b) {
    return IntStream.rangeClosed(a, b).boxed();
  }

  public static void main(String[] args) {
    range(1, 6).flatMap(v1 ->
        range(1, 6).flatMap(v2 ->
            Stream.of(new Pair<>(v1, v2))))
        .filter(xp -> !Objects.equals(xp.a, xp.b))
        .forEach(System.out::println);
  }
}
