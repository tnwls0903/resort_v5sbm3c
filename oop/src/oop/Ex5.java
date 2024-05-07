package oop;
 
public class Ex5 {
  public void test1() {
    String str = null;
    System.out.println("str: " + str);
    System.out.println("str.length(): " + str.length());
  }
  
  public void test2() {
    try {
      String str = null;
      System.out.println("str: " + str);
      System.out.println("str.length(): " + str.length());
    } catch (Exception e) {
      System.out.println("예외 발생 기록: " + e.toString());
    }
    
    System.out.println("시스템 정상 실행중...");
  }
  
  public void test3() {
    try {
      String str = null;
      System.out.println("str: " + str);
      System.out.println("str.length():" + str.length() );
    } catch (Exception e) {
      // 예외 무시
    }
    
    System.out.println("시스템 정상 실행중....");
    
  }
}

