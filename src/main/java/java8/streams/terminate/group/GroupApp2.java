package java8.streams.terminate.group;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupApp2 {
  public static void main(String[] args) {
    Map<String, Map<String, List<Integer>>> collected = new Random()
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
        }, Collectors.groupingBy(new Function<Integer, String>() {
          @Override
          public String apply(Integer a) {
            if (a % 2 == 0) return "EVEN";
            return "ODD";
          }
        })));
    System.out.println(collected);
  }
}
