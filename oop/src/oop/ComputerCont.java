package oop;

// 콤포넌트
public class ComputerCont {
  // 전역 변수, 필드, 클래스 전체에서 접근 가능
  String name; // null
  int price;       // 0 
  double screen; // 0.0
  String cpu;    // null
  int baesong;  // 0
  
  // 생성자, 클래스명과 일치해야함.
  public ComputerCont() {
    System.out.println("-> 객체 생성됨");
  }
  
  // 지역 변수: 메소드(생성자, 함수)안에서만 접근 가능
  public ComputerCont(String name, int price, double screen, String cpu) {
    // System.out.println("-> 인수 있는 생성자 호출, 객체 생성됨");
    this.name = name; // 전역 변수 <- 지역 변수
    this.price = price;
    this.screen = screen;
    this.cpu  =cpu;
  }
  
  public void print() {
    if (this.price >= 1700000) {
      this.baesong = 0;
    } else {
      this.baesong = 5000;
    }

    int tot = this.price + this.baesong; // 지역변수의 사용
    int point = (int)(this.price * 0.025); // 2.5 %
    
    System.out.println("제품명: " + this.name);
    System.out.println("가격: " + this.price);
    System.out.println("화면: " + this.screen);
    System.out.println("CPU: " + this.cpu);
    System.out.println("배송비: " + this.baesong + " 원");
    System.out.println("결재 금액: " + tot + " 원");
    System.out.println("포인트: " + point + " 원");
    System.out.println("----------------------------");

  }
}



