package streams.initiation;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGenerete {
    public static void main(String[] args) {
        IntStream intstream3 = IntStream
                .generate(() -> (int) (Math.random() * 100))
                .limit(10);// 10 random integers from 0-100 range

        Stream<String> generate = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                return IntStream
                        .generate(() -> (int) (65 + Math.random() * 26))
                        .limit(10).mapToObj(value -> (char) value + "")
                        .collect(Collectors.joining());
            }
        })
                .limit(10);
    }
}
