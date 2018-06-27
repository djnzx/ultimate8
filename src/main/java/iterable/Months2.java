package iterable;

import java.util.Arrays;
import java.util.Iterator;

public class Months2 implements Iterable<String> {
    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(months).iterator();
    }
}
