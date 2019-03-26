import java.util.*;

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
      out += data[mod(start + i)] + " ";
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
    return mod(end - start);
  }

  public void addFirst(E value) {
    if (value == null) throw new NullPointerException();
    if (size() >= data.length - 1) resize();
    start = mod(start-1);
    data[start] = value;
  }

  public void addLast(E value) {
    if (value == null) throw new NullPointerException();
    if (size() >= data.length - 1) resize();
    data[end] = value;
    end = mod(end + 1);
  }

  public E removeFirst() {
    if (size() == 0) throw new NoSuchElementException();
    start = mod(start + 1);
    return data[mod(start-1)];
  }

  public E removeLast() {
    if (size() == 0) throw new NoSuchElementException();
    end = mod(end - 1);
    return data[end];
  }

  public E getFirst() {
    if (size() == 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (size() == 0) throw new NoSuchElementException();
    return data[mod(end-1)];
  }

  private void resize() {
    @SuppressWarnings("unchecked")
    E[] temp = (E[])new Object[data.length * 2 + 1];
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[mod(start+i)];
    }
    end = size();
    start = 0;
    data = temp;
  }

  private int mod(int x) {
    int result = x % data.length;
    if (result < 0) result += data.length;
    return result;
  }

  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<Integer>();
    System.out.println(test);
    test.printData();
    /*
    for (int i = 1; i < 10; i++) {
      test.addFirst(Integer.valueOf(i*-1));
      System.out.println(test);
      test.addLast(Integer.valueOf(i));
      System.out.println(test);
    }
    */
    //test.addFirst(0);
    //test.printData();
    for (int i = 0; i < 10; i++) {
      test.addFirst(i);
      test.printData();
    }
  }
}
