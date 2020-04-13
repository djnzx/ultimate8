package java8.streams.mapflatmap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapApp04 {
  public static void main(String[] args) {
    List<Integer> collect = IntStream.rangeClosed(1, 4).boxed()
        .flatMap(x -> IntStream.rangeClosed(1, x).map(zz -> x).boxed())
        .collect(Collectors.toList());
    System.out.println(collect);
  }
}
