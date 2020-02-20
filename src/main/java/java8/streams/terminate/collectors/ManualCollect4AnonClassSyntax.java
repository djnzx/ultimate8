package java8.streams.terminate.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ManualCollect4AnonClassSyntax {
  public static void main(String[] args) {
    List<Integer> collected2 =
        IntStream.range(0, 10).boxed()
            .collect(
                new Supplier<ArrayList<Integer>>() {
                  @Override
                  public ArrayList<Integer> get() {
                    return new ArrayList<>();
                  }
                },
                new BiConsumer<ArrayList<Integer>, Integer>() {
                  @Override
                  public void accept(ArrayList<Integer> list, Integer item) {
                    list.add(item);
                  }
                },
                new BiConsumer<ArrayList<Integer>, ArrayList<Integer>>() {
                  @Override
                  public void accept(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                    list1.addAll(list2);
                  }
                }
            );
    System.out.println(collected2);
  }
}
