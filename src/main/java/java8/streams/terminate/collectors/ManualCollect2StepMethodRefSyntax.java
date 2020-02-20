package java8.streams.terminate.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ManualCollect2StepMethodRefSyntax {
  public static void main(String[] args) {
    List<Integer> collected2 =
        IntStream.range(0, 10).boxed()
            .collect(
                ArrayList::new,   // this function is responsible for structure creation
                ArrayList::add,   // this MUTABLE method for adding ONE element
                ArrayList::addAll // this MUTABLE method for joining TWO lists
            );
    System.out.println(collected2);
  }
}
