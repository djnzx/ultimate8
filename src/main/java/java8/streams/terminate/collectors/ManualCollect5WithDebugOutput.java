package java8.streams.terminate.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ManualCollect5WithDebugOutput {
  public static void main(String[] args) {
    List<Integer> collected =
        IntStream.range(0, 10).boxed()
            .parallel()
            .collect(
                new Supplier<ArrayList<Integer>>() {
                  @Override
                  public ArrayList<Integer> get() {
                    System.out.println("Final ArrayList is creating:");
                    return new ArrayList<>();
                  }
                },
                new BiConsumer<ArrayList<Integer>, Integer>() {
                  @Override
                  public void accept(ArrayList<Integer> list, Integer item) {
                    System.out.println("Accumulator:");
                    System.out.printf("List BEFORE:%s:%s\n", list, item);
                    list.add(item);
                    System.out.printf("List AFTER: %s\n", list);
                  }
                },
                new BiConsumer<ArrayList<Integer>, ArrayList<Integer>>() {
                  @Override
                  public void accept(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                    System.out.println("Combiner:");
                    System.out.printf("List1:%s\n", list1);
                    System.out.printf("List2:%s\n", list2);
                    list1.addAll(list2);
                  }
                }
            );
    System.out.printf("Final result: %s\n", collected);
  }
}
