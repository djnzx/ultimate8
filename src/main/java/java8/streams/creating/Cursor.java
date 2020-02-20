package java8.streams.creating;

public class Cursor {
  int offset = 0;

  void inc(int by) {
    offset += by;
  }
}
