package oop;
 
public class Ex4 {
 
  public static void main(String[] args) {
    int cnt = 0;
    int avg = 0;
 
    try {
      cnt = Integer.parseInt(args[0]);
      avg = 260 / cnt;
      
      String str = null;  // 메모리를 할당 받지 못한 상태, str 변수만 있음.
      System.out.println(str.toLowerCase());
      
    } catch (NumberFormatException e) {
      System.out.println("정수를 입력하세요. 예) 1 ~ ");
    } catch (ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다.");
    } catch (NullPointerException e) {
      System.out.println("객체가 생성되지 않았습니다.");
    } catch (Exception e) {
      System.out.println("알수 없는 예외가 발생했습니다.");
    }

    System.out.println("평균: " + avg);
    System.out.println("과목수: " + cnt);
 
  }
 
}