package java8.streams.mapflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapApp02 {
  public static void main(String[] args) {
    List<List<Integer>> collected = Stream.of(1, 2, 3)
        .map(x -> Arrays.asList(x + 10, x + 100))
        .collect(Collectors.toList());
    System.out.println(collected);
    List<Integer> collected2 = Stream.of(1, 2, 3)
        .flatMap(x -> Stream.of(x + 10, x + 100))
        .collect(Collectors.toList());
    System.out.println(collected2);
  }
}
