package java8.optional;

import source.Source;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExamples {

  // different way of initialization
  public void example1() {
    System.out.println("Example #1");
    // data
    String s1 = "Definitely not null value";
    String s2 = "Possibly nullable";
    String s3 = null;
    // wrappers
    Optional<String> opt1 = Optional.of(s1);
    Optional<String> opt2 = Optional.empty();
    Optional<String> opt3 = Optional.ofNullable(s2);  // Optional.empty()
    Optional<String> opt4 = Optional.ofNullable(s3);  // Optional.of
    System.out.println("----------");
  }

  // the problem
  public void example2() {
    System.out.println("Example #2");
    List<String> data = Source.list_with_nulls();
    for (String s: data) {
      if (s != null) {
        System.out.println(s);
      }
    }
    System.out.println("----------");
  }

  // the solution
  public void example3() {
    System.out.println("Example #3");
    List<String> data = Source.list_with_nulls();
    data.stream()
        .map(s -> Optional.ofNullable(s))
        .map(o -> o.map(s -> String.format("<<%s>>", s)))
        .filter(o -> o.isPresent())
        .map(o -> o.get())
        .forEach(System.out::println);
    System.out.println("----------");
  }

  String eager() {
    System.out.println("call: eager()");
    return "I'm Eager";
  }

  String lazy() {
    System.out.println("call: lazy()");
    return "I'm Lazy";
  }

  // different extractor with eager approach (used for EASY-to-calculate values)
  public void example4() {
    System.out.println("Example #4");
    List<String> data = Source.list_with_nulls();
    data.stream()
        .map(s -> Optional.ofNullable(s))
        .map(o -> o.map(s -> String.format("<<%s>>", s)))
        .map(o -> o.orElse(eager()))
        .forEach(System.out::println);
    System.out.println("----------");
  }
  // different extractor with eager approach (used for HARD-to-calculate values)
  public void example5() {
    System.out.println("Example #5");
    List<String> data = Source.list_with_nulls();
    data.stream()
        .map(s -> Optional.ofNullable(s))
        .map(o -> o.map(s -> String.format("<<%s>>", s)))
        .map(o -> o.orElseGet(() -> lazy()))
        .forEach(System.out::println);
    System.out.println("----------");
  }
  // different extractor with eager approach (used for problems)
  public void example6() {
    System.out.println("Example #6");
    List<String> data = Source.list_with_nulls();
    data.stream()
        .map(s -> Optional.ofNullable(s))
        .map(o -> o.map(s -> String.format("<<%s>>", s)))
        .map(o -> o.orElseThrow(() -> new IllegalArgumentException("NULL was given!")))
        .forEach(System.out::println);
    System.out.println("----------");
  }
  // manual way
  public void example7() {
    System.out.println("Example #7");
    Optional<String> opt1 = Optional.of("yes");
    Optional<String> opt2 = Optional.empty();

    opt1.ifPresent(s -> System.out.println(s)); // yes
    opt1.ifPresent(System.out::println);        // yes
    opt2.ifPresent(s -> System.out.println(s));
    opt2.ifPresent(System.out::println);

    if (opt1.isPresent()) {
      System.out.println(opt1.get());        // yes
    }
    if (opt2.isPresent()) {
      System.out.println(opt1.get());
    }
    System.out.println("----------");
  }

  public void example8() {
    System.out.println("Example #8");
    List<String> data = Source.list_with_nulls();
    Stream<String> stream = data.stream();
    stream                                  // Stream<String>
        .map(s -> Optional.ofNullable(s))   // Stream<Optional<String>> : 9
        .filter(o -> o.isPresent())          // Stream<Optional<String>> : 3
        .map(o -> o.get())                  // Stream<String> : 3
        .map(s -> String.format("* %s", s)) // Stream<String> : 3
        .forEach(s -> System.out.println(s));
    System.out.println("----------");
  }

  // no need to use any if
  private String process(String origin) {
    return Optional.ofNullable(origin)
        .map(String::toUpperCase)
        .map(s -> String.format("<< %s >>", s))
        .orElse(">> null was given <<");
  }

  public void example9() {
    System.out.println("Example #9");
    System.out.println(process("Hello"));
    System.out.println(process(null));
    System.out.println("----------");
  }

  public static void main(String[] args) {
    OptionalExamples ox = new OptionalExamples();
//    ox.example1();
//    ox.example2();
//    ox.example3();
//    ox.example4();
//    ox.example5();
//    ox.example6();
//    ox.example7();
//    ox.example8();
    ox.example9();
  }
}
