package java8.streams.examples5;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSample3 {
  public static Comparator<Person> comparator() {
    return new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        if (o1.name().equals(o2.name())) {
          return o1.salary()-o2.salary();
        }
        else {
          return o1.name().compareTo(o2.name());
        }
      }
    };
  }

  public static void m1() {
    new Database(25).get().stream()
        .filter(p->p.salary()>50000)
        .sorted(comparator())
        .skip(5)
        .limit(5)
        .forEach(Person::printIt);
  }

  public static void main(String[] args) {
    Map<String, Long> collect = new Database(25).get().stream()
        .collect(
            Collectors.groupingBy(
                Person::name,
                Collectors.counting()
            )
        );
    System.out.println(collect);
  }
}
