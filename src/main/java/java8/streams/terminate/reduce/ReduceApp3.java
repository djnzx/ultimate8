package java8.streams.terminate.reduce;

import core.iterable.Months;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceApp3 {
  public static void main(String[] args) {
    Stream<String> stream = new Months().stream();

    String reduced4 = stream.reduce(
        // initial
        "_:",
        // merge function
        (s1, s2) -> s1 + "." + s2,
        // merge for
        (s, s2) -> s + "!!" + s2
    );
    System.out.println(reduced4);
    /**
     * combiner is used to finalize the result of parallel stream
     *
     * the great explanation could be seen here
     * https://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8
     */
  }
}
