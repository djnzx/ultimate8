package java8.streams.initiation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ZipStreams {
  static class Person {
    public final String name;
    public final int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return String.format("Person[name='%s', age=%d]", name, age);
    }
  }

  public static void main(String[] args) {
    /**
     * initial data
     * we can join any sizes, but the shortest wins
     */
    List<Integer> ages = Arrays.asList(33, 44, 55);
    List<String> names = Arrays.asList("Jim", "John", "Jackson", "Jeremy");
    /**
     * create Streams from Lists
     */
    Stream<Integer> streamAges = ages.stream();
    Stream<String> streamNames = names.stream();
    /**
     * create Spliterator from Streams
     */
    Spliterator<Integer> splAges = streamAges.spliterator();
    Spliterator<String> splNames = streamNames.spliterator();
    /**
     * create Iterators from Spliterators
     */
    Iterator<Integer> itAges = Spliterators.iterator(splAges);
    Iterator<String> itNames = Spliterators.iterator(splNames);
    /**
     * implement our logic in the new Iterator
     */
    Iterator<Person> itPerson = new Iterator<Person>() {
      @Override
      public boolean hasNext() {
        return itAges.hasNext() && itNames.hasNext();
      }

      @Override
      public Person next() {
        return new Person(itNames.next(), itAges.next());
      }
    };
    /**
     * new stream properties
     * whatever it was
     * -SIZED -SORTED -DISTINCT
     */
    int prop = splAges.characteristics() & ~(Spliterator.SIZED | Spliterator.SORTED | Spliterator.DISTINCT);
    /**
     * create new Spliterator from Iterator
     */
    Spliterator<Person> splPerson = Spliterators.spliterator(itPerson, -1, prop);
    /**
     * create new Stream from Spliterator
     */
    Stream<Person> streamPerson = StreamSupport.stream(splPerson, false);
    /**
     * use it
     */
    List<Person> people = streamPerson
        .collect(Collectors.toList());
    /**
     * look for output
     */
    System.out.println(people);
  }
}
