package java8.streams.terminate.group;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupApp3 {
  public static void main(String[] args) {
    Map<String, List<Integer>> collected = new Random()
        .ints(-10, 10)
        .limit(20)
        .boxed() // Stream<Integer>
        .collect(Collectors.groupingBy(new Function<Integer, String>() {
          @Override
          public String apply(Integer a) {
            if (a < 0) return "LT0";
            if (a > 0) return "GT0";
            return "ZE";
          }
        }, Collectors.mapping(new Function<Integer, Integer>() {
          @Override
          public Integer apply(Integer integer) {
            return integer + 1000;
          }
        }, Collectors.toList())));
    System.out.println(collected);
  }
}
