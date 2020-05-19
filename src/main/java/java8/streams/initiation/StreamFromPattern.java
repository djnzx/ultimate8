package java8.streams.initiation;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * stream of values fit
 * to regular expression
 */
public class StreamFromPattern {
  public static void main(String[] args) {
    Pattern compiled = Pattern.compile("[(!),(?),(.)]");
    Stream<String> stream = compiled.splitAsStream("Hello! World? Maaybe.");
    stream
        .map(s -> String.format("_%s_",s))
        .forEach(System.out::println);
  }
}
