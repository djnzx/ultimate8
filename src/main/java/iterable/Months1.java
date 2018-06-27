package iterable;

import java.util.Iterator;

public class Months1 implements Iterable<String> {
    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return position<months.length;
            }

            @Override
            public String next() {
                return months[position++];
            }
        };
    }
}
