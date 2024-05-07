package oop;

public class Condition_if {

  public static void main(String[] args) {
//    int score = 70;
//    
//    // 3 항 연산자
//    String msg = (score >= 60) ? "합격":"불합격"; // (조건)?참:거짓
//    System.out.println(msg);
//    
//    int year = 2024;
//    if (year % 2 == 0) {
//      System.out.println("짝수");
//    }
//    
//    year = 2025;
//    if (year % 2 == 0) {
//      System.out.println("짝수");
//    } else {
//      System.out.println("홀수");
//    }
//
//    // 권장하지 않는 패턴
//    if (year % 2 == 0) 
//    System.out.println("짝수");
//    else
//    System.out.println("홀수");
//    
//    int java = 80;
//    int python = 75;
//    int dbms = 100;
//    
//    int total = java + python + dbms;
//    int avg = total / 3;
//    
//    if (avg >= 60) {
//      System.out.println("통과");
//    } else {
//      System.out.println("다음에 응시해주세요.");
//    }
//    
//    System.out.println("취득 점수: " + avg);
//    
//    score=-90;
//    String grade = "";
//    if (score >= 90) {
//      grade = "A";
//    } else if (score >= 80) {
//      grade = "B";
//    } else if (score >= 70) {
//      grade = "C";
//    } else if (score >= 60) {
//      grade = "D";
//    } else if (score >= 0) {
//      grade = "F";
//    } else {
//      grade = "없음";
//      System.out.println("음수는 처리하지 않음");
//    }
//    
//    System.out.println("등급: " + grade);
//    
//    // &&: and, ||: or
//    int mon=2;
//    String season="";
//    
//    if (mon >= 3 && mon <= 5) {
//      season = "Spring";
//    } else if (mon >= 6 && mon <= 8) {
//      season = "Summer";
//    } else if (mon >= 9 && mon <= 11) {
//      season = "Fall";
//    // }  else if (mon >= 12 && mon <= 2) {  // 논리적 에러, 특정 상황에서 발생하며 Exception이 발생하지 않음.
//    }  else if (mon == 12 || mon == 1 || mon == 2) {
//      season = "Winter";
//    } else {
//      season = "계절을 알 수 없습니다.";
//    }
//    
//    System.out.println("season: " + season);
//    
//    grade = "A";
//    if (grade == "A") {
//      System.out.println(30000 - (int)(30000 * 0.20));
//    }

    //  1. 교보문고의 회원 등급을 확인하여 결재 금액을 출력하는 프로그램을 제작하시오.
    //  - 입력: 회원 등급, 도서 정가
    //  - 처리: 결재 금액 할인: P: 7% 할인, G: 6% 할인, S: 5% 할인, F: 2% 할인
    //    해당하는 등급이 없으면 'N'로 처리, 대소문자 구분됨
    //  - 출력: 회원 등급, 도서 정가, 결재 금액
    //
    //  회원 등급: P
    //  도서 정가: 30,000
    //  결재 금액: 27,900
    //
    //  회원 등급: N
    //  도서 정가: 30,000
    //  결재 금액: 30,000
//    String grade="P";
//    int price = 30000;
//    int pay = 0;
//    
//    if (grade == "P" || grade == "p") {
//      pay = (int)(price - (price * 0.07));
//    } else if (grade == "G" || grade == "g") {
//      pay = (int)(price - (price * 0.06));
//    } else if (grade == "S" || grade == "s") {
//      pay = (int)(price - (price * 0.05));
//    } else if (grade == "F" || grade == "f") {
//      pay = (int)(price - (price * 0.02));
//    } else {
//      grade = "N";
//      pay = price; // 할인 없음
//    }
//
//    System.out.println("----------------------------");
//    System.out.println("회원 등급: " + grade);
//    System.out.println("도서 정가: " + price);
//    System.out.println("결재 금액: " + pay);    
    
//  전기 요금 계산기
//  사용량 kwh   200이하    201~400    400초과
//  단가(원)        99.3        187.9         280.6
//  기본요금(원)  910         1600          7300
//
//  전기 사용량을 입력받아 전기 요금을 계산하는 프로그램 제작
//  금액 = (사용량 * 단가) + 기본요금
//
//  전기 사용량을 입력: 300
//  사용량(kwh): 300
//  단가(원): 187.9
//  기본요금(원): 1,600
//  금액(원): 57,970

  int use = 300;

  double price=0; // 단가(원)
  int basic=0;       // 기본요금(원)
  if (use <= 200) {
      price = 99.3;
      basic = 910;
  } else if (use >= 201 && use <= 400) {
      price = 187.9;
      basic = 1600;
  } else { // elif use > 400:
      price = 280.6;
      basic = 7300;
  }
  
  int tot = (int)((use * price) + basic);
  // int 4 byte <- (int)double;
  // int 4 byte <- (int)float;
  
  // String.format("%,.2f", number)
  System.out.println("사용량(kwh): " + String.format("%,d", use)); // JDK 1.8+
  System.out.println("단가(원): " + price);
  System.out.println("기본요금(원): " + basic);
  System.out.println("금액(원): " +String.format("%,d", tot));    
  }

}









