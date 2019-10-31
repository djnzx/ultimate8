package source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Source {

  public static List<Person> persons() {
    List<Person> list = new ArrayList<>();
    list.add(new Person(21, 10000, "Masha"));
    list.add(new Person(25, 12000, "Sergey"));
    list.add(new Person(30, 25000, "Roma"));
    list.add(new Person(23, 20000, "Alina"));
    list.add(new Person(55, 55000, "Anne"));
    return list;
  }

  public static double random() {
    return Math.random();
  }

  public static int random_from_range(int min, int max) {
    int range = max - min + 1;
    return (int)(Math.random() * range + 1);
  }

  public static List<Integer> random_int_from_range(int min, int max, int length) {
    return Stream.generate(() -> Source.random_from_range(min, max))
        .limit(length)
        .collect(Collectors.toList());
  }

  public static char random_letter() {
    return random_letter_uc();
  }

  public static char random_letter_uc() {
    return (char) random_from_range('A', 'Z');
  }

  public static char random_letter_lc() {
    return (char) random_from_range('a', 'z');
  }

  public static String random_string(int length) {
    return Stream.generate(Source::random_letter_uc)
        .limit(length)
        .map(String::valueOf)
        .reduce(String::concat)
        .orElse("");
  }

  public static String random_length(int min, int max) {
    return random_string(random_from_range(min, max));
  }

  public static Iterable<String> iterables() {
      return Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");
  }

}
