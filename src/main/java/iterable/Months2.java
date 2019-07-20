package iterable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Months2 implements Iterable<String> {
    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    public Iterator<String> iterator() {
        List<String> strings = Arrays.asList(months);
        return strings.iterator();
    }
}
