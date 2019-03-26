public class Calculator {
  public static double eval(String s) {
    MyDeque<Double> stack = new MyDeque<Double>();
    String arg = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        arg += s.charAt(i);
      } else {
        operate(stack, arg);
        arg = "";
      }
    }
    operate(stack, arg);
    return stack.getLast();
  }

  private static void operate(MyDeque<Double> stack, String arg) {
    double temp;
    switch (arg) {
      case "+":
        stack.addLast(stack.removeLast() + stack.removeLast());
        break;
      case "-":
        temp = stack.removeLast();
        stack.addLast(stack.removeLast() - temp);
        break;
      case "*":
        stack.addLast(stack.removeLast() * stack.removeLast());
        break;
      case "/":
        temp = stack.removeLast();
        stack.addLast(stack.removeLast() / temp);
        break;
      case "%":
        temp = stack.removeLast();
        stack.addLast(stack.removeLast() % temp);
        break;
      default:
        stack.addLast(Double.parseDouble(arg));
    }
  }

  public static void main(String[] args) {
    System.out.println(eval(args[0]));
  }
}
