package oop;

public class BookUse {

  public static void main(String[] args) {
    Book book = new Book("SQL 개발자", "영진출판사", 18000, 10.0);
    book.print();
    
    book = new Book("코딩 자율학습 HTML + CSS + 자바스크립트", "길벗", 27000, 10.0);
    book.print();
  }

}