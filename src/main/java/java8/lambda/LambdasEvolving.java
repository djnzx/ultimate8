package java8.lambda;

import core.comparable.CompByAge;
import source.Person;
import source.Source;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdasEvolving {
    public static void main(String[] args) {
        List<Person> list = Source.persons();

        // The same comparing by different approaches
        // non-anonymous class
        list.sort(new CompByAge());
        // anonymous class
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age()-o2.age();
            }
        });
        // java8.lambda full code
        Collections.sort(list, (Person o1, Person o2) -> {
            return  o1.age()-o2.age();
        });
        // java8.lambda v2
        Collections.sort(list, (o1, o2) -> {
            return  o1.age()-o2.age();
        });
        // java8.lambda v3
        Collections.sort(list, (o1, o2) ->
                o1.age()-o2.age()
        );
        // java8.lambda v4
        Collections.sort(list, (o1, o2) -> o1.age()-o2.age());
        // java8.lambda v5 by applying embedded comparator
        Collections.sort(list, Comparator.comparingInt(Person::age));
    }
}
