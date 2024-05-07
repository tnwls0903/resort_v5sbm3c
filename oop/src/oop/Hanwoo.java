package oop;

/**
 * 한우 데이터 처리
 * @author 왕눈이
 * 횡성한우 처리 시스템
 */
public class Hanwoo {
  /*
  꽃등심    ← 상품명
  횡성       ← 원산지
  200 g      ← 무게  
  20,000 원  ← (무게/100) X 10,000
  18,000 원  ← 가격의 10% 할인된 가격
  */
  
  /** 제품명 */
  String name;
  
  /** 생산자 */
  String productor;
  
  /** 무게(단위:g) */
  int weight;
  
  /** 가격 */
  int price;
  
  /** 할인 가격 */
  int dc;
  
  public Hanwoo() {
    
  }
  
  public Hanwoo(String name, String productor, int weight) {
    this.name = name;
    this.productor = productor;
    this.weight = weight;    
  }
  
  public void print() {
    this.price = (this.weight/100) * 10000;
    this.dc = (int)(this.price - (this.price * 0.1));
    
    System.out.println(this.name);
    System.out.println(this.productor);
    System.out.println(this.weight + " g");
    System.out.println(String.format("%,d", this.price) + " 원");
    System.out.println(String.format("%,d", this.dc) + " 원");
    System.out.println();
  }
  
  
}
