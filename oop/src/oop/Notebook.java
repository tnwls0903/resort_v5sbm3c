package oop;

public class Notebook {
  public static void main(String[] args) {
    String name = "LG i5";
    int price = 1670000;
    double screen = 17.3;
    String cpu = "Core i5 12세대";
    int baesong = 0;
    
    if (price >= 1700000) {
      baesong = 0;
    } else {
      baesong = 5000;
    }

    int tot = price + baesong;
    int point = (int)(price * 0.025); // 2.5 %
    
    System.out.println("제품명: " + name);
    System.out.println("가격: " + price);
    System.out.println("화면: " + screen);
    System.out.println("CPU: " + cpu);
    System.out.println("배송비: " + baesong + " 원");
    System.out.println("결재 금액: " + tot + " 원");
    System.out.println("포인트: " + point + " 원");
    System.out.println("----------------------------");
    
    String name2 = "HP i7";
    int price2 = 1745000;
    double screen2 = 17.3;
    String cpu2 = "Core i7-12700H";
    int baesong2 = 0;

    if (price2 >= 1700000) {
      baesong2 = 0;
    } else {
      baesong2 = 5000;
    }

    int tot2 = price + baesong2;
    int point2 = (int)(price2 * 0.025);
    
    System.out.println("제품명: " + name2);
    System.out.println("가격: " + price2);
    System.out.println("화면: " + screen2);
    System.out.println("CPU: " + cpu2);
    System.out.println("배송비: " + baesong2 + " 원");
    System.out.println("결재 금액: " + tot2 + " 원");    
    System.out.println("포인트: " + point2 + " 원");
    System.out.println("----------------------------");
    
    String name3 = "Dell i9";
    int price3 = 1990000;
    double screen3 = 17.3;
    String cpu3 = "Core i9-12900H";
    int baesong3 = 0;
    
    if (price3 >= 1700000) {
      baesong3 = 0;
    } else {
      baesong3 = 5000;
    }

    int tot3 = price3 + baesong3;
    int point3 = (int)(price3 * 0.025);
    
    System.out.println("제품명: " + name3);
    System.out.println("가격: " + price3);
    System.out.println("화면: " + screen3);
    System.out.println("CPU: " + cpu3);
    System.out.println("배송비: " + baesong3 + " 원");
    System.out.println("결재 금액: " + tot3 + " 원");        
    System.out.println("포인트: " + point3 + " 원");
   
  }

}
