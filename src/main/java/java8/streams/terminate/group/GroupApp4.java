package java8.streams.terminate.group;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupApp4 {
  public static void main(String[] args) {
    Map<String, List<String>> collected = new Random()
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
        }, Collectors.mapping(new Function<Integer, String>() {
          @Override
          public String apply(Integer a) {
            return String.format("<%d>", a);
          }
        }, Collectors.toList())));
    System.out.println(collected);
    // {GT0=[<1>, <9>, <9>, <7>, <8>, <2>, <1>, <1>], LT0=[<-10>, <-2>, <-2>, <-9>, <-2>, <-8>, <-5>, <-6>, <-2>, <-7>, <-8>, <-3>]}
  }
}
