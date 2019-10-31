package java8.streams.initiation;

import java.util.stream.IntStream;

public class StreamFromString {
    public static void main(String[] args) {
        String s = "Hello_Привет";
        IntStream chars = s.chars();

        System.out.println(s);
        s.chars().forEach(c-> System.out.print(c+" "));
        System.out.println();
        s.chars().mapToObj(c->(char)c).forEach(c-> System.out.print(c+" "));
        System.out.println();

        s.codePoints().forEach(c-> System.out.print(c+" "));
        System.out.println();
        s.codePoints().mapToObj(c->(char)c).forEach(c-> System.out.print(c+" "));

        // chars() deals with characters which fit into 2 bytes
        // codePoints() deals with characters which don't fit into 2 bytes
    }
}
