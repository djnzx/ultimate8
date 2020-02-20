package java8.streams.creating;

import java.util.List;

/**
 * it can be SQL, test file, whatever
  */
public interface AnotherBigDataset<A> {
  List<A> fetch(int offset, int limit);
}

