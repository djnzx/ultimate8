package java8.streams.initiation;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFromArray {
    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final int[] flat = {1,2,3,4,5};
    private static final int[][] nested = {{1,2,3}, {4,5}};
    private static final int[][][] triple = {{{1,2,3}, {4,5}},{{11,12,13}, {44,55}}};
    private static final String[][][] tripleString = {{{"1","2","3"}, {"4","5"}},{{"11","12","13"}, {"44","55"}}};

    public static void main(String[] args) {
        // stream from array
        Stream<String> stream1 = Arrays.stream(months);
        IntStream stream2 = Arrays.stream(flat);

        // nested
        Stream<int[]> stream3 = Arrays.stream(nested);
        // nested
        Stream<int[][]> stream4 = Arrays.stream(triple);

        // opening more than one level of nesting
        Stream<Integer> stream5 = Arrays.stream(nested)
                .flatMap((Function<int[], Stream<Integer>>) ints -> Arrays.stream(ints).boxed());

        // opening more than one level of nesting
        Stream<int[]> stream6 = Arrays.stream(triple)
                .flatMap(new Function<int[][], Stream<int[]>>() {
                    @Override
                    public Stream<int[]> apply(int[][] ints) {
                        return Arrays.stream(ints);
                    }
                });

        // opening double nesting integers with anonymous classes
        Stream<Integer> stream7 = Arrays.stream(triple)
                .flatMap(new Function<int[][], Stream<int[]>>() {
                    @Override
                    public Stream<int[]> apply(int[][] ints) {
                        return Arrays.stream(ints);
                    }
                })
                .flatMap(new Function<int[], Stream<Integer>>() {
                    @Override
                    public Stream<Integer> apply(int[] ints) {
                        return Arrays.stream(ints).boxed();
                    }
                });

        // opening double nesting integers with lambdas
        Stream<Integer> stream8 = Arrays.stream(triple)
                .flatMap((Function<int[][], Stream<int[]>>) ints -> Arrays.stream(ints))
                .flatMap((Function<int[], Stream<Integer>>) ints -> Arrays.stream(ints).boxed());

        // opening double nesting integers with method references
        Stream<Integer> stream9 = Arrays.stream(triple)
                .flatMap((Function<int[][], Stream<int[]>>) Arrays::stream)
                .flatMap((Function<int[], Stream<Integer>>) ints -> Arrays.stream(ints).boxed());

        // opening double nesting Strings with anonymous classes
        Stream<String> stream10 = Arrays.stream(tripleString)
                .flatMap(new Function<String[][], Stream<String[]>>() {
                    @Override
                    public Stream<String[]> apply(String[][] strings) {
                        return Arrays.stream(strings);
                    }
                })
                .flatMap(new Function<String[], Stream<String>>() {
                    @Override
                    public Stream<String> apply(String[] strings) {
                        return Arrays.stream(strings);
                    }
                });

        // opening double nesting Strings with lambdas
        Stream<String> stream11 = Arrays.stream(tripleString)
                .flatMap((Function<String[][], Stream<String[]>>) strings -> Arrays.stream(strings))
                .flatMap((Function<String[], Stream<String>>) strings -> Arrays.stream(strings));

        // opening double nesting Strings with method references
        Stream<String> stream12 = Arrays.stream(tripleString)
                .flatMap((Function<String[][], Stream<String[]>>) Arrays::stream)
                .flatMap((Function<String[], Stream<String>>) Arrays::stream);
    }
}
