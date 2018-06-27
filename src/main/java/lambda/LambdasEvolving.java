package lambda;

import comparable.CompByAge;
import comparable.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdasEvolving {
    public static void main(String[] args) {
        List<Person> l = new ArrayList<>();
        l.add(new Person(21, 10000, "Masha"));
        l.add(new Person(25, 12000, "Sergey"));
        l.add(new Person(30, 25000, "Roma"));
        l.add(new Person(23, 20000, "Alina"));
        l.add(new Person(55, 55000, "Anne"));

        // The same comparing by different approaches
        // non-anonymous class
        Collections.sort(l, new CompByAge());
        // anonymous class
        Collections.sort(l, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age()-o2.age();
            }
        });
        // lambda full code
        Collections.sort(l, (Person o1, Person o2) -> {
            return  o1.age()-o2.age();
        });
        // lambda v2
        Collections.sort(l, (o1, o2) -> {
            return  o1.age()-o2.age();
        });
        // lambda v3
        Collections.sort(l, (o1, o2) ->
                o1.age()-o2.age()
        );
        // lambda v4
        Collections.sort(l, (o1, o2) -> o1.age()-o2.age());
        // lambda v5 by applying embedded comparator
        Collections.sort(l, Comparator.comparingInt(Person::age));
    }
}
