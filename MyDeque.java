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
    for (int i = 0; i < size(); i++) {
      out += data[start + i] + " ";
    }
    out += "}";
    return out;
  }

  public void printData() {
    String out = "[";
    for (int i = 0; i < data.length; i++) {
      out += data[i] + ", ";
    }
    out += "]";
    System.out.println(out);
    System.out.println("Start = "+start+", End = "+end);
  }

  public int size() {
    return mod((end - start), data.length);
  }

  public void addFirst(E value) {
    start = mod(start-1,data.length);
    data[start] = value;
  }

  private int mod(int x, int y) {
    int result = x % y;
    if (result < 0) result += y;
    return result;
  }

  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<Integer>();
    test.addFirst(Integer.valueOf(4));
    test.addFirst(Integer.valueOf(5));
    System.out.println(test);
    test.printData();
  }
}
