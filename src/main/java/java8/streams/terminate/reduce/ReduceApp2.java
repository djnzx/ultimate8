package java8.streams.terminate.reduce;

import core.iterable.Months;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceApp2 {
  public static void main(String[] args) {
    Stream<String> stream = new Months().stream();

    BinaryOperator<String> combiner = (s1, s2) -> String.format("%s -> %s", s1, s2);

    /**
     * if I provide identity,
     * my reduce will start from identity
     *
     * I can get rid of Optional
     * and get string as a result, not Optional
     */
    String reduced1 = stream.reduce("START:", combiner);
    System.out.println(reduced1); // START: -> Jan -> Feb -> Mar -> Apr -> May -> Jun -> Jul -> Aug -> Sep -> Oct -> Nov -> Dec

    /**
     * it returns empty string (identity element)
     * because that stream is empty
     */
    Stream<String> empty = Stream.empty();
    String reduced2 = empty.reduce("START:", combiner);
    System.out.println(reduced2); // START:
  }
}
