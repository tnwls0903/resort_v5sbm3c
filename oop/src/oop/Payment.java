package oop;
 
public class Payment {
// public class Payment extends Object { // Object 자동 상속
  private String name = ""; // 상품명
  private int price = 0;       // 가격
  private int count = 0;      // 갯수
  private int total = 0;       // 결재 금액
  
  public void order(String name, int price, int count) {
    this.name = name;
    this.price = price;
    this.count = count;
  }
  
  public void calc() {
    this.total = this.price * this.count;

    System.out.println();    
    System.out.println("상품명: " + name);
    System.out.println("가격: " + price);
    System.out.println("수량: " + count);
    System.out.println("결재 금액: " + this.total);
    System.out.println("---------------------------");
  }
}