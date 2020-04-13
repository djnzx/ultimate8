package java8.streams.terminate.count;

import java8.streams.initiation.StreamFromIterable;

import java.util.stream.Stream;

public class CountApp {
    public static void main(String[] args) {
        StreamFromIterable si = new StreamFromIterable();
        Stream<String> stream = si.stream();
        long count = stream.count();
        System.out.println(count);
    }
}
