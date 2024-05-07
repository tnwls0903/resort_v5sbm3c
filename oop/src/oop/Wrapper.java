package oop;

public class Wrapper {

  public static void main(String[] args) {
    int year=2024;                    // primitive type, 원시 타입
    Integer year_object = 2024; // wrapper class, 객체 지향 타입
    
    // System.out.println(year.);  // X
    System.out.println(year_object.doubleValue());
    
    System.out.println(year_object.toBinaryString(3)); // 10 진수 -> 2진수
    // The static method toBinaryString(int) from the type Integer should be accessed in a static way
    
    System.out.println(Integer.parseInt("2024")); // static method
    System.out.println(Integer.toBinaryString(15));
    
  }

}
