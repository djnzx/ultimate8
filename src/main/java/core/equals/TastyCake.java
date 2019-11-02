package core.equals;

public class TastyCake extends Cake {
  private final int extra;

  public TastyCake(int size, int extra) {
    super(size);
    this.extra = extra;
  }


  @Override
  public int hashCode() {
    return extra;
  }
}
