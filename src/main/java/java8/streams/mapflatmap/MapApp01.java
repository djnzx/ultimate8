package java8.streams.mapflatmap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapApp01 {
  public static void main(String[] args) {
    List<Integer> collected = Stream.of(1, 2, 3)
        .map(x -> x + 1)
        .collect(Collectors.toList());
    System.out.println(collected); // 2 3 4
  }
}
