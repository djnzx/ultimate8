package core.equals;

public class Apple {

  private final int color;

  public Apple(int color) {
    this.color = color;
  }

  @Override
  public boolean equals(Object that_) {
    if (that_ == null) return false;
    if (that_ == this) return true;
    if (getClass() != that_.getClass()) return false;
    Apple that = (Apple) that_;
    return color == that.color;
  }

}
