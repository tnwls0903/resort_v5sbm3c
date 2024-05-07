package oop;

import java.util.Random;

public class ArrayTest {

  public static void main(String[] args) {
    // 1차원 배열
//    String[] dev1 = new String[3]; // 0 ~ 2, 3개의 값만 저장 가능
//    dev1[0] = "Web";
//    dev1[1] = "Analysis";
//    dev1[2] = "AI";
//    
//    System.out.println(dev1[0]);
//    System.out.println(dev1[1]);
//    System.out.println(dev1[2]);
//    
    // dev1[3] = "IOT"; // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    // dev1[2] = 2024; // Type mismatch: cannot convert from int to String

    // 1 ~ 100까지의 정수형 난수 5개를 생성하여 배열에 저장하는 코드 제작
//    int[] nos = new int[5]; // 0 ~ 4
//    int index = 0;  // array index
//    int no = 0;
//    
//    Random random = new Random();
//    while(true) {
//      no = random.nextInt(100) + 1;  // 1 ~ 100
//      nos[index] = no;  // 난수를 배열에 저장
//      System.out.println(no);
//      
//      index = index + 1;
//      
//      if (index == 5) {
//        break;
//      }
//    }
//    System.out.println(nos); // 해시코드
//    
//    index=0;
//    
//    while(true) {
//      System.out.println(nos[index]);
//      index = index + 1;
//      
//      if (index == 5) {
//        break;
//      }
//    }
    
    // 2 차원 배열
    // Web 개발 → DBMS + Web → SQL + Spring Boot
    // 데이터 분석 → 머신러닝 → Scikit-learn
    // 인공지능 → 인공신경망 → Tensorflow, Pytorch
  
//    String[][] devs = new String[3][3]; // 3행 3열
//    devs[0][0] = "Web 개발";   devs[0][1] = "DBMS + Web";  devs[0][2] = "SQL + Spring Boot";
//    devs[1][0] = "데이터 분석"; devs[1][1] = "머신러닝";  devs[1][2] = "Scikit-learn";
//    devs[2][0] = "인공지능";     devs[2][1] = "인공신경망";  devs[2][2] = "Tensorflow, Pytorch";
//  
//    int row = 0;
//    while (true) {
//      System.out.println(devs[row][0] + ": " + devs[row][1] + ", " + devs[row][2]);     
//      if (row == 2) {
//        break; // while문 탈출
//      }
//      row = row + 1;
//    }

 // 3차원: 데이터 타입이 다름으로 독립적인 배열 개발
    String[] names = new String[3];
    names[0] = "왕눈이";
    names[1] = "아로미";
    names[2] = "홍길동";

    int[][][] score = new int[3][2][4]; // 3면 2행 4열: 2행 4열로 구성된 3개의 면
    // 왕눈이 입사 성적
    score[0][0][0] = 90; //[면][행][열], 1차 평가
    score[0][0][1] = 85;
    score[0][0][2] = 100;
    score[0][0][3] = 95; 
    score[0][1][0] = 80; // 2차 평가
    score[0][1][1] = 75;
    score[0][1][2] = 90;
    score[0][1][3] = 85;

    System.out.println("개발직 사원 평가 점수\n");
    System.out.println("1. " + names[0]);
    System.out.println("▷ 1차 평가");
    System.out.println("JAVA: " + score[0][0][0]);
    System.out.println("Python: " + score[0][0][1]);
    System.out.println("JSP: " + score[0][0][2]);
    System.out.println("GPT: " + score[0][0][3] + "\n");

    System.out.println("▷ 2차 평가");
    System.out.println("JAVA: " + score[0][1][0]);
    System.out.println("Python: " + score[0][1][1]);
    System.out.println("JSP: " + score[0][1][2]);
    System.out.println("GPT: " + score[0][1][3] + "\n");

    // 아로미 성적
    score[1][0][0] = 80;
    score[1][0][1] = 80;
    score[1][0][2] = 75;
    score[1][0][3] = 100;
    score[1][1][0] = 80;
    score[1][1][1] = 80;
    score[1][1][2] = 75;
    score[1][1][3] = 100;

    System.out.println("2. " + names[1]);
    System.out.println("▷ 1차 평가");
    System.out.println("JAVA: " + score[1][0][0]);
    System.out.println("Python: " + score[1][0][1]);
    System.out.println("JSP: " + score[1][0][2]);
    System.out.println("GPT: " + score[1][0][3] + "\n");

    System.out.println("▷ 2차 평가");
    System.out.println("JAVA: " + score[1][1][0]);
    System.out.println("Python: " + score[1][1][1]);
    System.out.println("JSP: " + score[1][1][2]);
    System.out.println("GPT: " + score[1][1][3] + "\n");

    // 홍길동 성적
    score[2][0][0] = 100;
    score[2][0][1] = 95;
    score[2][0][2] = 65;
    score[2][0][3] = 80;
    score[2][1][0] = 100;
    score[2][1][1] = 95;
    score[2][1][2] = 65;
    score[2][1][3] = 80;

    System.out.println("3. " + names[2]);
    System.out.println("▷ 1차 평가");
    System.out.println("JAVA: " + score[2][0][0]);
    System.out.println("Python: " + score[2][0][1]);
    System.out.println("JSP: " + score[2][0][2]);
    System.out.println("GPT: " + score[2][0][3] + "\n");

    System.out.println("▷ 2차 평가");
    System.out.println("JAVA: " + score[2][1][0]);
    System.out.println("Python: " + score[2][1][1]);
    System.out.println("JSP: " + score[2][1][2]);
    System.out.println("GPT: " + score[2][1][3] + "\n");
    
  } // END main
} // END class









