package streams.examples6;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Streams {
    public static void main(String[] args) {
        List<Integer> collect = Stream
                .generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .collect(toList());
        collect.forEach(item -> System.out.println(item));
    }
}
