package oop;

public class InterstateUse {

  public static void main(String[] args) {
    Interstate interstate = new Interstate(90, "seattle", 737015, 0, "해안 항구 도시");
    interstate.print();
    
//    Interstate interstate2 = new Interstate();
//    interstate2.print();
    
    interstate.setData("Moses Lake", 20366, 280, "모지스 호가 있음");
    interstate.print();
    System.out.println("비용: "+ String.format("%,d", interstate.oil_price(interstate.mile)) + " 원");
  }

}
