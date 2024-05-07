package oop;

/**
 * 메소드 사용법 실습
 * @author 왕눈이
 *
 */
public class MethodExt {
  
  public MethodExt() {  // 기본 생성자
    System.out.println("객체 생성됨");
  }
  
  // Condition_if.java를 참고하여 취득 점수별 등급을 산출하여 출력하는 메소드(함수)를 제작하세요.
  // 점수: 90
  // 등급: A
  
  // 점수: 85
  // 등급: B
  
  /**
   * 등급 산출
   * @param score 점수
   * @return 등급
   */
  public String grade(int score) {
    String grade = "";
    if (score >= 90) {
      grade = "A";
    } else if (score >= 80) {
      grade = "B";
    } else if (score >= 70) {
      grade = "C";
    } else if (score >= 60) {
      grade = "D";
    } else {
      grade = "없음";
      System.out.println("음수는 처리하지 않음");
      
    }
    return grade;
    
  }
  
  // 월을 전달받아 계절을 리턴하는 함수 제작
  // 월: 3
  // 계절: Spring
  
  /**
   * 계절 변환
   * @param mon 월
   * @return 계절명
   */
  public String season(int mon) {
    String season="";
    
    if (mon >= 3 && mon <= 5) {
      season = "Spring";
    } else if (mon >= 6 && mon <= 8) {
      season = "Summer";
    } else if (mon >= 9 && mon <= 11) {
      season = "Fall";
    // }  else if (mon >= 12 && mon <= 2) {  // 논리적 에러, 특정 상황에서 발생하며 Exception이 발생하지 않음.
    }  else if (mon == 12 || mon == 1 || mon == 2) {
      season = "Winter";
    } else {
      season = "계절을 알 수 없습니다.";
    }
    
    return season;
  }
  
  // 교보문고의 회원 등급을 확인하여 결재 금액을 출력하는 프로그램을 제작하시오.
  // 메소드 입력: 회원 등급, 금액
  //           리턴: 결재 금액
  
  //  회원 등급: P
  //  도서 정가: 30,000
  //  결재 금액: 27,900

  //  회원 등급: N
  //  도서 정가: 30,000
  //  결재 금액: 30,000
  
  // 전기 요금 계산기
  // 메소드1 입력: 사용량,  리턴: 단가(원)
  // 메소드2 입력: 사용량,  리턴: 기본 요금
  // 메소드3 입력: 사용량, 단가, 기본요금  리턴: 결재 금액(원)
  
  // 사용량(kwh): 300
  // 단가(원): 187.9
  // 기본요금(원): 1,600
  // 금액(원): 57,970
  
  public double price(int use) {
    double price = 0;
    if (use <= 200) {
      price = 99.3;
    } else if(use >200 || use <=400) {
      price = 187.9;
    } else {
      price = 280.6;
    }
    
    return price;
  }
  
  public int basic(int use) {
    int basic= 0;
    if (use <= 200) {
      basic = 910;
    } else if(use >200 || use <=400) {
      basic = 1600;
    } else {
      basic = 7300;
    }
    
    return basic;
  }
  
  public int last(int use,double price,int basic) {
   double last =0;
   
   last = (use * price) +basic;
    
    return (int)last;
  }
  
  // 1 ~ 1000까지의 수 중에서 하나의 정수를 메소드로 전달하여
  // 1부터 전달된 수까지의 2 and 3 and 4 and 5의 배수의 갯수를 리턴하는 함수 제작
  // 메소드 입력: 정수 1개,  리턴: 갯수
  
  // 데이터: 200
  // cnt: 3
  
  // 데이터: 300
  // cnt: 5
  
  // 1 ~ 100까지의 수 중에서 30개의 난수를 생성하고 배열에 저장한 후 짝수와 홀수의 개수를 출력하시오.
  // 난수: 3 6 8 9 7 21....
  // 짝수의 개수: 13
  // 홀수의 개수: 17
  
  // 메소드를 호출하기전에 1 ~ 100까지의 수 중에서 30개의 난수를 생성해야함.
  // 배열도 메소드로 전달 될 수 있음.
  // public int even_cnt(int[] datas]) {...
  // public int odd_cnt(int[] datas]) {...
  // 메소드가 배열을 전달받아 처리하는 형태로 구현할 것.
  /**
   * @param datas(랜덤수 배열)
   * @return even(짝수카운트)
   */
  public int evenCount(int[] datas) {
    int even = 0;
    
    for (int num : datas) {
      if (num % 2 == 0) {
        even++;
      }
    }
    return even;
  }

  /**
   * @param datas(랜덤수 배열)
   * @return odd(홀수카운트)
   */
  public int oddCount(int[] datas) {
    int odd = 0;
    
    for (int num : datas) {
      if (num % 2 == 1) {
        odd++;
      }
    }
    return odd;
  }
}





