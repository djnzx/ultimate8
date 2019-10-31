package core.comparable;

import source.Person;
import source.Source;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableApp {
    public static void main(String[] args) {
        List<Person> l = Source.persons();

        System.out.println("Unsorted:");
        l.forEach(person -> person.printMe());

        System.out.println("Sorted by Comparable(age):");
        // sort w.o. parameters is possible only because Person implements Comparable<Person>
        Collections.sort(l);
        l.forEach(Person::printMe);

        // Different sorting methods by applying different comparators by
        System.out.println("Sorted by Comparator(name):");
        Collections.sort(l, new CompByName());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator(rate):");
        Collections.sort(l, new CompByRate());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator(age):");
        Collections.sort(l, new CompByAge());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator(rate(java8.lambda)):");
        Collections.sort(l, (o1, o2) -> o1.rate()-o2.rate());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator.comparingInt(rate):");
        Collections.sort(l, Comparator.comparingInt(Person::rate));
        l.forEach(Person::printMe);

        System.out.println("Sorted by Compator.comparing(name):");
        Collections.sort(l, Comparator.comparing(o -> o.name().toString()));
        l.forEach(Person::printMe);
    }
}
