public class MyDeque<E>{
  private E[] data;
  private int start, end;

  public MyDeque() {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  public String toString() {
    String out = "{";
    for (int i = start; i%data.length < end; i++) {
      out += data[i] + " ";
    }
    out += "}";
    return out;
  }

  public int size() {
    return mod((end - start), data.length);
  }

  private int mod(int x, int y) {
    int result = x % y;
    if (result < 0) result += y;
    return result;
  }
}
