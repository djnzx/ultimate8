package java8.streams.terminate.collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualCollect1Basic {
  public static void main(String[] args) {
    List<Integer> collected2 = IntStream.range(0, 10).boxed()
        .collect(Collectors.toList());
    System.out.println(collected2);
  }
}
