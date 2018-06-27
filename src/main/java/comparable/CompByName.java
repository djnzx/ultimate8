package comparable;

import java.util.Comparator;

public class CompByName implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name().toString().compareTo(
            o2.name().toString()
        );
    }
}
