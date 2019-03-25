public class Calculator {
  public static double eval(String s) {
    MyDeque<Double> stack = new MyDeque<Double>();
    String arg = "";
    double temp;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        switch (arg) {
          case "+":
            stack.addLast(stack.getLast() + stack.getLast());
            break;
          case "-":
            temp = stack.getLast();
            stack.addLast(stack.getLast() - temp);
            break;
          case "*":
            stack.addLast(stack.getLast() - stack.getLast());
            break;
          case "/":
            temp = stack.getLast();
            stack.addLast(stack.getLast() / temp);
            break;
          case "%":
            temp = stack.getLast();
            stack.addLast(stack.getLast() % temp);
            break;
          default:
            stack.addLast(Double.parseDouble(arg));
        }
      } else {
        arg = "";
      }
    }
    return stack.getLast();
  }
}
