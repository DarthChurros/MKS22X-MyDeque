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
      out += data[(start + i) % data.length] + " ";
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
    if (size() >= data.length - 1) resize();
    start = mod(start-1,data.length);
    data[start] = value;
  }

  private void resize() {
    @SuppressWarnings("unchecked")
    E[] temp = (E[])new Object[data.length * 2 + 1];
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[(start+i) % data.length];
    }
    end = size();
    start = 0;
    data = temp;
  }

  private int mod(int x, int y) {
    int result = x % y;
    if (result < 0) result += y;
    return result;
  }

  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<Integer>();
    System.out.println(test);
    test.printData();
    for (int i = 0; i < 12; i++) {
      test.addFirst(Integer.valueOf(i));
      System.out.println(test);
    }
    test.printData();
  }
}
