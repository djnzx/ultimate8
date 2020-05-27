package b.code_unsorted.equals;

public class Pizza implements Comparable<Pizza> {
  public int size;
  String name;

  public Pizza(int size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    if (!(that instanceof Pizza)) return false;
    Pizza thatPizza = (Pizza) that;
    if (this.size == thatPizza.size) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
//    return size*31 + name.hashCode();
    return size;
  }

  @Override
  public String toString() {
    return String.format("Pizza: %d", size);
  }

  @Override
  public int compareTo(Pizza that) {
    return that.size - this.size;
//    if (that.size > this.size) {
//      return -1;
//    } else if (that.size < this.size) {
//      return 1;
//    }
//    return  0;
  }
}
