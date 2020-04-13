package java8.streams.creating;

import java.util.List;
import java.util.stream.Stream;

public class Service<A> {
  private final AnotherBigDataset<A> svc;

  public Service(AnotherBigDataset<A> svc) {
    this.svc = svc;
  }

  public Stream<A> stream(int size, int batchSize) {
    Cursor cursor = new Cursor();
    return Stream
        .generate(() -> next(cursor, size, batchSize))
        // we need JAVA9 for this feature
//        .takeWhile(as -> !as.isEmpty())
        .flatMap(List::stream);
  }

  private List<A> next(Cursor cursor, int size, int batchSize) {
    int fetchSize = Math.min(size - cursor.offset, batchSize);
    List<A> result = svc.fetch(cursor.offset, fetchSize);
    cursor.inc(result.size());
    return result;
  }
}
