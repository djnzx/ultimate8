package core.comparator;

import source.Source;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PyramidComparator {

  public static boolean isOdd(int val) {
    return val % 2 != 0;
  }

  public static boolean isEven(int val) {
    return ! isOdd(val);
  }

  public static void main(String[] args) {
    List<Integer> origin = Source.random_int_from_range(0,100,30);
    ArrayList<Integer> sorted = new ArrayList<>(origin);

    Comparator<Integer> super_comparator = (i1, i2) -> {
      if (isEven(i1) && isOdd(i2)) return 1;
      else if (isEven(i1) && isEven(i2)) return i2-i1;
      else if (isOdd(i1) && isOdd(i2)) return i1-i2;
      else return -1;
    };

//    Collections.sort(sorted, super_comparator);
    // or
    sorted.sort(super_comparator);

    System.out.println(origin);
    System.out.println(sorted);
  }
}
