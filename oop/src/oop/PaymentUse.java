package oop;
 
public class PaymentUse {
  // 상속을 사용한 경우  
  public static void main(String[] args) {
    // 객체를 만들고 변수 값을 출력하고 메소드를 호출하세요.
    Cash cash = new Cash();
    cash.order("한우", 65000, 3);
    cash.calc();
    cash.cash();
    
    Card card = new Card();
    card.order("쏘가리 메운탕", 80000, 2);
    card.calc();
    card.card();
    
    Mobile mobile = new Mobile();
    mobile.order("두부전골", 15000, 5);
    mobile.calc();
    mobile.mobile();
   
    Point point = new Point();
    point.order("도시락 컵라면", 1100, 3);
    point.calc();
    point.point();
    
    System.out.println(point.hashCode());    
  }
 
}





 