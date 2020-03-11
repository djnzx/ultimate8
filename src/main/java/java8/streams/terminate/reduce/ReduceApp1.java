package java8.streams.terminate.reduce;

import core.iterable.Months;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceApp1 {
  public static void main(String[] args) {
    Stream<String> stream = new Months().stream();

    BinaryOperator<String> combiner = (s1, s2) -> String.format("%s : %s", s1, s2);

    // the easiest way to collect the data
    // it returns Optional because stream can be empty
    Optional<String> reduced1 = stream.reduce(combiner);
    System.out.println(reduced1); // Optional[Jan : Feb : Mar : Apr : May : Jun : Jul : Aug : Sep : Oct : Nov : Dec]

    // it returns Optional of one element if it contains from one element
    Optional<String> reduced2 = Stream.of("January").reduce(combiner);
    System.out.println(reduced2); // Optional[January]

    // it returns Optional.empty because stream can be empty
    Stream<String> empty = Stream.empty();
    Optional<String> reduced3 = empty.reduce(combiner);
    System.out.println(reduced3); // Optional.empty
  }
}
