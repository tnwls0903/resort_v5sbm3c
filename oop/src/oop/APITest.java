package oop;

import java.util.Date;

public class APITest {

  public static void main(String[] args) {
    String country="Korea"; 
    
    System.out.println(country.toUpperCase());  // 대문자로 바꾸어서 출력
    System.out.println(country.toLowerCase());  // 소문자로 바꾸어서 출력
    
    String fname = "spring.jpg";
    boolean result = fname.endsWith("jpg");
    System.out.println(result);
    System.out.println(fname.endsWith("Jpg"));
    System.out.println("--------------");
    System.out.println(fname.toLowerCase().endsWith("jpg")); // ★
    System.out.println(fname.equalsIgnoreCase("SPRING.JPG"));
    
    String msg = String.format("숙소 경비: %,d",  300000);
    System.out.println(msg);

    int pay=500000;
    System.out.println(String.format("숙소 경비: %,d",  pay));
    
    Date date = new Date();
    System.out.println(date.toLocaleString()); 
    // The method toLocaleString() from the type Date is deprecated. 권장하지 않음.

  }

}


