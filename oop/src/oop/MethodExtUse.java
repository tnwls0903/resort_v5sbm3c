package oop;

import java.util.Random;

public class MethodExtUse {

  public static void main(String[] args) {
    // 객체 생성 -> 등급 산출 메소드 호출 -> 결과 리턴받아 출력
    MethodExt methodext = new MethodExt();
    int score = 90;
    String grade = methodext.grade(score);
    
    System.out.println("점수 : "+ score);
    System.out.println("등급 : " + grade);
    
    // 계절 산출 메소드 호출 -> 결과 리턴받아 출력
    int mon = 3;
    String result = methodext.season(mon);
    System.out.println("월: " + mon);
    System.out.println("계절: " + result);
    System.out.println("----------------------------");
    int use = 300;
    System.out.println("사용량(kwh) : " + use);
    double price = methodext.price(use);
    System.out.println("단가(원) : " + price);
    int basic = methodext.basic(use);
    System.out.println(String.format("기본요금(원) : %,d", basic ));
    int last = methodext.last(use,price,basic);
    System.out.println(String.format("금액(원) : %,d", last));

    System.out.println("----------------------------");
    Random random = new Random();
    
    int[] datas = new int[30];
    
    String datas_print = ""; 
    
    for (int i = 0; i < datas.length; i++) {
      datas[i] = random.nextInt(100) + 1;
      datas_print  = datas_print + datas[i] + " "; // 출력용
    }
    
    int evenCnt = methodext.evenCount(datas);
    int oddCnt = methodext.oddCount(datas);
    
    System.out.println("난수: "+datas_print);
    System.out.println("짝수의 갯수: "+ evenCnt);
    System.out.println("홀수의 갯수: "+ oddCnt);
  }

}


