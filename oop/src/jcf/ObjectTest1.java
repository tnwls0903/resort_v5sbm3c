package jcf;

import java.util.Date;

// 부모 클래스는 자식 클래스의 객체를 할당 받을 수 있다. ★★★★★
public class ObjectTest1 {

  public static void main(String[] args) {
    // 다형성
    Object obj1 = "Computer Vision"; // 부모 클래스 <- 자식 클래스 객체
    
    System.out.println(obj1.getClass().getName()); // java.lang.String
    System.out.println(obj1 instanceof Object);      // true
    System.out.println(obj1 instanceof String);       // true
    System.out.println(obj1 instanceof Integer);     // false
    
    System.out.println("--------------------------");
    
    Object obj2 = 2024; // int -> Integer -> Object
    
    System.out.println(obj2.getClass().getName()); // java.lang.Integer
    System.out.println(obj2 instanceof Object);      // true
    System.out.println(obj2 instanceof String);       // false
    System.out.println(obj2 instanceof Integer);     // true
    
    System.out.println("--------------------------");
    // obj1을 대문자로 출력
    // obj1.  // 부모클래스의 메소드만 호출됨, Object class의 메소드만 호출 가능.
    String obj1_str = (String)obj1; // 객체 형변환 -> 자식 클래스 메소드 호출 가능
    System.out.println(obj1_str.toUpperCase());
    
    System.out.println("--------------------------");
    // Object는 다양한 객체를 저장 할 수 있는 저장소 역활을 함.
    Object object1 = "Spring";
    Object object2 = 2023;
    Object object3 = true;
    Object object4 = 10.5;
    Object object5 = new Date();
    System.out.println(((Date)object5).toLocaleString());
  }

}





