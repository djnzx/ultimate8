package java8.streams.initiation;

import core.iterable.Months1;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamFromIterable {
    public Stream<String> stream() {
        return StreamSupport.stream(new Months1().spliterator(), false);
    }

    public static void main(String[] args) {
        Stream<String> stream11 = new StreamFromIterable().stream();
    }
}
