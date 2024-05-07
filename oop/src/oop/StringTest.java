package oop;

public class StringTest {

  public static void main(String[] args) {
    String str1 = "Spring";  // 상수 할당, 객체 생성
    String str2 = new String("Spring"); // 객체 생성
    
    if (str1 == "Spring") {
      System.out.println("1) 같음");
    }
    
    if (str2 == "Spring") { // 객체가 같은지 비교, 자바 문법상 문자열은 제외됨.
      System.out.println("2) 같음");
    } else {
      System.out.println("2) 같지않음");
    }
    
    System.out.println("Spring".hashCode()); // 해시코드 -> 실제 메모리와 연결됨.
    System.out.println(str1.hashCode());
    System.out.println(str2.hashCode());
    
    // 자바는 new를 이용하여 객체 생성과 문자열 상수를 할당하여 객체 생성한 것을 다르게 처리
    // 객체에서 "==" 값 비교가 해시코드 비교로 처리됨, new를 이용하면 값이 같아도 다른 객체로 처리됨.
    
    // 권장 값비교
    if (str1.equals("Spring") && str2.equals("Spring")) { // ★★★★★
      System.out.println("벗꽃 여행");
    }
  }

}




