package streams.examples5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {
    private final String[] names = {"Alex", "Masha", "Dima", "Igor", "Sasha", "Lena"};
    private final String[] surNames = {"Petrenko", "Sydorenko", "Vinnichenko", "Shevchenko", "Moskalenko", "Savchenko"};
    private final int arraySize = names.length;
    private final int quantity;
    private final int salaryMin = 10000;
    private final int salaryMax = 100000;
    private final int yearMin = 2000;
    private final int yearMax = 2016;
    private final int rangeMin = 100000;
    private final int rangeMax = 999999;

    public Database(int quantity) {
        this.quantity = quantity;
    }

    int generateValueFromRange(int min, int max) {
        Random r = new Random();
        int val = r.nextInt(max - min);
        return min + val;
    }

    public List<Person> get() {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            people.add(generateNewPerson());
        }
        return people;
    }

    private Person generateNewPerson() {
        int id = generateValueFromRange(rangeMin, rangeMax);
        String name = names[generateValueFromRange(0,arraySize)];
        //+ " " + surNames[generateValueFromRange(0,arraySize)];
        int salary = generateValueFromRange(salaryMin, salaryMax);
        int beginYear = generateValueFromRange(yearMin, yearMax);
        return new PersonSimple(id, name, salary, beginYear);
    }
}
