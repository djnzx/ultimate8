package java8.streams.terminate.findfirst;

import java8.streams.initiation.StreamFromIterable;

import java.util.Optional;

public class FindFirst {
    public static void main(String[] args) {
        StreamFromIterable si = new StreamFromIterable();
        Optional<String> first = si.stream().findFirst();
        System.out.println(first.get());
    }
}
