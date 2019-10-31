package java8.streams.examples5;

import java.util.function.Supplier;

public class PersonSimple implements Person, Supplier<Person> {
    private final int id;
    private final String name;
    private final int salary;
    private final int beginYear;

    public PersonSimple(int id, String name, int salary, int beginYear) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.beginYear = beginYear;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int salary() {
        return this.salary;
    }

    @Override
    public int beginYear() {
        return this.beginYear;
    }

    @Override
    public String toString() {
        return String.format("%d %-18s %d %d",this.id, this.name, this.salary, this.beginYear);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name());
    }

    @Override
    public void printIt() {
        System.out.println(this);
    }

    @Override
    public Person get() {
        return this;
    }
}
