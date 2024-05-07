package oop;

public class MethodUse {

  public static void main(String[] args) {
    Method method = new Method();
    System.out.println(method.add(100, 200));
    System.out.println(method.sub(100, 200));
    
    int result = method.mul(10, 20);
    System.out.println(result);
    
    result = method.div(10, 3);
    System.out.println(result);

    result = method.nam(10, 3);
    System.out.println(result);
  }

}
