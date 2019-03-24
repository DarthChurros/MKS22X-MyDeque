import java.util.NoSuchElementException;

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
    if (value == null) throw new NullPointerException();
    if (size() >= data.length - 1) resize();
    start = mod(start-1,data.length);
    data[start] = value;
  }

  public void addLast(E value) {
    if (value == null) throw new NullPointerException();
    if (size() >= data.length - 1) resize();
    data[end] = value;
    end = (end + 1) % data.length;
  }

  public E removeFirst() {
    start = (start + 1) % data.length;
    return data[mod(start-1,data.length)];
  }

  public E removeLast() {
    end = mod(end - 1, data.length);
    return data[(end+1)%data.length];
  }

  public E getFirst() {
    if (size() == 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (size() == 0) throw new NoSuchElementException();
    return data[end-1];
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
    for (int i = 1; i < 10; i++) {
      test.addFirst(Integer.valueOf(i*-1));
      System.out.println(test);
      test.addLast(Integer.valueOf(i));
      System.out.println(test);
    }
    test.printData();
  }
}
