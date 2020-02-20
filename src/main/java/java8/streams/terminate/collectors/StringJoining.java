package java8.streams.terminate.collectors;

import java8.streams.initiation.StreamFromIterable;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJoining {

  public static String joining1(Stream<String> stream) {
    return stream.collect(Collectors.joining());
  }

  public static String joining2(Stream<String> stream) {
    return stream.collect(Collectors.joining(" "));
  }

  public static String joining3(Stream<String> stream) {
    return stream.collect(Collectors.joining(", ", "[", "]"));
  }

  public static void main(String[] args) {
    StreamFromIterable si = new StreamFromIterable();

    System.out.println("joining approach 1: (no parameters)");
    System.out.println( joining1(si.stream()) );

    System.out.println("joining approach 2: (w/1 parameter)");
    System.out.println( joining2(si.stream()) );

    System.out.println("joining approach 3: (w/3 parameters)");
    System.out.println( joining3(si.stream()) );
  }
}
