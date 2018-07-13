package streams.initiation;

import iterable.Months1;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamFromIterable {
    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public Stream<String> stream() {
        return StreamSupport.stream(new Months1().spliterator(), false);
    }

    public static void main(String[] args) {
        Stream<String> stream11 = new StreamFromIterable().stream();
    }
}
