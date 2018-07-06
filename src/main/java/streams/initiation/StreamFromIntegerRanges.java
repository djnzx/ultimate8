package streams.initiation;

import java.util.stream.IntStream;

public class StreamFromIntegerRanges {
    public static void main(String[] args) {
        IntStream intstream1 = IntStream.range(0, 10); // 0..9,    10 excluded
        IntStream intstream2 = IntStream.rangeClosed(0, 10); // 0..10    10 included
    }
}
