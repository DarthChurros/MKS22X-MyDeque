public class MyDeque<E>{
  private E[] data;
  private int start, end;

  public MyDeque() {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  private int size() {
    return mod((end - start), data.length);
  }

  private int mod(int x, int y) {
    int result = x % y;
    if (result < 0) result += y;
    return result;
  }
}
