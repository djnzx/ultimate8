package core.iterable;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Months implements Iterable<String> {
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

  public Stream<String> stream() {
    return StreamSupport.stream(spliterator(), false);
  }
}
