package java8.streams.mapflatmap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapApp03 {
  public static void main(String[] args) {
    List<Integer> evens1 = IntStream.range(1, 10).boxed()
        .filter(x -> x%2==0)
        .collect(Collectors.toList());
    System.out.println(evens1); // [2, 4, 6, 8]

    List<Integer> evens2 = IntStream.range(1, 10).boxed()
        .flatMap(x -> (x%2==0) ? Stream.of(x) : Stream.empty())
        .collect(Collectors.toList());
    System.out.println(evens2); // [2, 4, 6, 8]
  }
}
