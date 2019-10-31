package core.equals;

public class Cake {

  private final int size;

  public Cake(int size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object that_) {
    if (this == that_) return true;
    if (!(that_ instanceof Cake)) return false;
    Cake that = (Cake) that_;
    return size == that.size;
  }

}
