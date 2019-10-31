package java8.streams.initiation;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class StreamFromIntegerRanges {
    public static void main1(String[] args) {
        IntStream intstream1 = IntStream.range(0, 10); // 0..9,    10 excluded
        IntStream intstream2 = IntStream.rangeClosed(0, 10); // 0..10    10 included
    }

    public static void main2(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    static void printer1(int val) {
        System.out.println(val);
    }

    static void printer2(int val, int val2) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        // 1
        IntStream.range(0,10)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });

        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };

        IntConsumer intConsumer2 = value -> System.out.println(value);

        IntStream.range(0,10)
                .forEach((int x) -> System.out.println(x));

        IntStream.range(0,10)
                .forEach(x -> printer1(x));

        IntStream.range(0,10)
                .forEach(intConsumer);

        IntStream.range(0,10)
                .forEach(StreamFromIntegerRanges::printer1);

        IntStream.range(0,10)
                .forEach(System.out::println);
    }

}
