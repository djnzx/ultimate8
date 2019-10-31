package java8.streams.initiation;

import java.util.stream.Stream;

public class StreamIterate {
    public static void main(String[] args) {
        Stream.iterate(20, x -> x+10)
                .limit(10)
                .forEach(obj -> System.out.print(obj +" "));

    }
}
