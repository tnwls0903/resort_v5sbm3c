package oop;

public class Interstate {
  int highway;
  String title;
  int population;
  int mile;
  String etc;
  
  public Interstate(int highway, String title, int population, int mile, String etc) {
    this.highway = highway;
    this.title = title;
    this.population = population;
    this.mile = mile;
    this.etc = etc;
  }

  public Interstate() { // 기본 생성자 자동 생성 안됨
    
  }
  
  public void print() {
    System.out.println("고속도로 번호: " + this.highway);
    System.out.println("도시명(마을이름): " + this.title);
    System.out.println("인구: " + String.format("%,d", this.population));
    System.out.println("Seattle 기준 거리: " + String.format("%,d", this.mile) + " mile" + " ("+ String.format("%,d", mileToKM()) + " km)");
    System.out.println("기타: " + this.etc);
    System.out.println("----------------------------------------------");    
  }
  
  public void setData(String title, int population, int mile, String etc) {
    this.title = title;
    this.population = population;
    this.mile = mile;
    this.etc = etc;
  }
  
  public int mileToKM() {
    return (int)(this.mile * 1.609);
  }
  
  public int oil_price(int mile) {
    return (int)(((mile * 1.609) / 10.5)*1500); // mile -> km -> 10.5km per 1 liter -> 휘발류기준
  }
}

  
  
  
  