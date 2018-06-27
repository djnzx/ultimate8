package streams.examples5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PersonTest {

    public static void m2(Supplier s) {
        s.get();

    }

    public static void main(String[] args) {
        List<Person> people = new Database(25).get();
        //people.sort((o1, o2) -> o1.name().compareTo(o2.name()));
        //Collections.sort(people);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.salary()-o2.salary();
            }
        });
        people.forEach(System.out::println);

        // #1
        Consumer<Person> con = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        };
        people.forEach(con);

        // #2
        people.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });

        // #3
        people.forEach((Person person) -> System.out.println(person));

        // #4
        people.forEach(person -> System.out.println(person));

        // #5
        people.forEach(System.out::println);

        // #2
        people.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                person.printIt();
            }
        });

        // #5
        people.forEach(Person::printIt);

        m2(new PersonSimple(1,"",3,4));
        m2(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 777;
            }
        });
    }
}
