package oop;

import java.util.Random;  // 난수

public class Condition_cycle {

  public static void main(String[] args) {
//    // switch ~ case ~
//    int month = 1;
//    
//    switch(month) {
//    case 1:
//      System.out.println("1월 January");
//      break;
//    case 2:
//      System.out.println("2월 February");
//      break;
//    case 3:
//      System.out.println("3월 March");
//      break;
//    default:
//      System.out.println("1/4 분기만 가능합니다.");
//    }
//    
//    System.out.println("switch문 실행 종료");
    
    // while
    //1 ~100 사이의 난수 중에서 30이 나오면 while문을 종료하는 프로그램 제작 

    Random random = new Random();
//    int cnt = 1;
    
//    while (cnt <= 5) {
//      int no = random.nextInt(100)+1; // 0 ~ 99 -> 1 ~ 100
//      System.out.println(no);
//      cnt = cnt + 1;
//      
//      if (no == 30) {
//        break;
//      }
//    }

//    while (true) {
//      int no = random.nextInt(100)+1; // 0 ~ 99 -> 1 ~ 100
//      System.out.println(no);
//     
//      if (no == 30) {
//        break;
//      }
//    }

//    int no = 0;
//    while (no != 30) { // no가 30이 아닐동안 실행함으로 30이 나오면 종료
//      no = random.nextInt(100)+1; // 0 ~ 99 -> 1 ~ 100
//      System.out.println(no);
//     
//    }

    // do ~ while
    int avg = -60;
    
    do { // -60은 처리되면 안되지만 무조건 실행
      System.out.println("평균: " + avg);
    } while(avg >= 0); // avg가 0보다 크거나 같을때만 실행
    
  }

}







