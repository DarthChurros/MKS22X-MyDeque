public class Calculator {
  public static double eval(String s) {
    MyDeque<Double> stack = new MyDeque<Double>();
    String arg = "";
    double temp;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        arg += s.charAt(i);
      } else {
        System.out.println("arg="+arg);
        switch (arg) {
          case "+":
            stack.addLast(stack.removeLast() + stack.removeLast());
            break;
          case "-":
            temp = stack.removeLast();
            stack.addLast(stack.removeLast() - temp);
            break;
          case "*":
            stack.addLast(stack.removeLast() - stack.removeLast());
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
        arg = "";
      }
    }
    return stack.getLast();
  }

  public static void main(String[] args) {
    System.out.println(eval(args[0]));
  }
}
