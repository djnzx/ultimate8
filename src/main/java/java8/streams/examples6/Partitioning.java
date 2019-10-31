package java8.streams.examples6;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Partitioning {
    Stream<Integer> data() {
        return IntStream.range(0, 100).boxed();
    }

    public static void main(String[] args) {
        Partitioning p = new Partitioning();
        p.data().collect(
                        groupingBy(
                                mappingRule2()
                        )
                )
        .forEach((i, ii) -> System.out.printf("key:%d, values:%s\n",i,ii));
    }

    private static Function<Integer, Integer> mappingRule() {
        return val -> val / 10;
    }

    private static Function<Integer, Integer> mappingRule2() {
        return val -> val % 10;
    }
}
