package oop;

public class Book {
//  SQL 개발자              ←  도서명
//  교학사                     ← 출판사
//  20,000 원                  ← 가격
//  10.0 %                     ← 할인율
//  18,000 원                  ← 판매가
  String name;  // 필드
  String publisher;
  int price;
  double dc;
  int sale;
  
  public Book() {
    
  }
  
  public Book(String name, String publisher, int price, double dc) {
    this.name = name;
    this.publisher = publisher;
    this.price = price;
    this.dc = dc;
    
  }
  
  public void print() {
    this.sale = (int)(this.price - (this.price * (this.dc/100)));
    
    System.out.println(this.name);
    System.out.println(publisher); // 같은 이름의 지역 변수가 없음으로 this 생략가능
    System.out.println(String.format("%,d", price) + " 원");
    System.out.println(dc + " %");
    System.out.println(String.format("%,d", sale) + " 원");
    System.out.println();
    
  }

}

