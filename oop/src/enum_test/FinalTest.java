package enum_test;

import java.util.Date;

public class FinalTest {
  public static void main(String[] args) {
    Final obj = new Final();
    
    // System.out.println("제목: " + obj.normal); // ERROR, private 변수임으로 바로 접근 불가능
    
    System.out.println("1) 제목: " + obj.getNormal());   // 가을 단풍 여행 접수
    
    obj.setNormal("서산 튜울립 축제");  // private 변수에 값 저장
    System.out.println("2) 제목: " + obj.getNormal());   // private 변수 값 읽기
    
    Final.COUNT++; // static 변수
    System.out.println("3) 현재 인원: " + Final.COUNT);  // 1
    
    // obj.com = "(주)투어"; // final 변수, 최초 할당된 값 변경 불가능
    System.out.println("4) 여행사: " + obj.com);  // (주)행복 여행사
    
    // Final.TEL = "123"; // final static 선언이면 값 변경 불가능
    System.out.println("5) 연락처: " + Final.TEL); // ☎ 02-1111-1111
    
    // Final.HOBBY = "오버랜딩";  // X
    // Final.HOBBY = new String("오버랜딩"); // X
    // Final.START = new Date();  // X
    
  }
 
}



