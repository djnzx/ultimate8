package streams.terminate.reduce;

import streams.initiation.StreamFromIterable;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Reduce {
    public static void main(String[] args) {
        StreamFromIterable si = new StreamFromIterable();

        Optional<String> reduced1 = si.stream().reduce(
                new BinaryOperator<String>() {
                    @Override
                    public String apply(String s, String s2) {
                        return s + " / " + s2;
                    }
                });

        Optional<String> reduced2 = si.stream().reduce((s1, s2) -> s1 + " / " + s2);

        System.out.println(reduced1.get());
        System.out.println(reduced2.get());

        String reduced3 = si.stream().reduce(": ", (s1, s2) -> s1 + " / " + s2);
        System.out.println(reduced3);

        String reduced4 = si.stream().reduce(
                // initial
                "_:",
                // merge function
                (s1, s2) -> s1 + "." + s2,
                new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + "!!" + s2;
            }
        });

        System.out.println(reduced4);

        int length = Arrays.asList("str1", "str2").parallelStream()
                .reduce(
                        0,
                        (accumulated, string ) -> accumulated + string.length(),
                        (accumulatedInt1, accumulatedInt2) -> accumulatedInt1 + accumulatedInt2
                );

        System.out.println(length);
        /**
         * combiner is used to finalize the result of parallel stream
         *
         * the great explanation could be seen here
         * https://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8
         */
    }
}
