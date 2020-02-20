package java8.streams.terminate.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ManualCollect3LambdaSyntax {
  public static void main(String[] args) {
    List<Integer> collected2 =
        IntStream.range(0, 10).boxed()
            .collect(
                () -> new ArrayList<>(),            // this function is responsible for structure creation
                (list, item) -> list.add(item),     // this MUTABLE method for adding ONE element
                (left, right) -> left.addAll(right) // this MUTABLE method for joining TWO lists
            );
    System.out.println(collected2);
  }
}
