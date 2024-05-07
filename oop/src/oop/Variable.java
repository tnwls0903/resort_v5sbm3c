package oop;

public class Variable {

  public static void main(String[] args) {
    System.out.println("2024 K-Digital");
//    System.out.println('2024 K-Digital'); // X
    
    char grade = 'A'; // 하나의 문자
    System.out.println("grade: " + grade);
    
    int year = 2024;
    System.out.println(year);
    
    String msg = "자바 개발자";
    System.out.println(msg);
    
    // float score = 10.5; // X
    double score = 10.5; // 8 byte
    System.out.println(score);
    System.out.println((int)score);

    boolean bol = true;
    System.out.println(bol);
    
    // int current = "2024";
    int current = Integer.parseInt("2024"); // 형변환
    System.out.println(current + 10);
    System.out.println(current + " 년");
    // System.out.println("-" * 30); // X
    System.out.println("-------------------------");
    
    int su1 = 10;
    int su2 = 3;
    System.out.println(su1 + su2);
    System.out.println(su1 - su2);
    System.out.println(su1 * su2);
    System.out.println(su1 / su2);  // 3.3333 X,  정수 / 정수 = 정수, 소수점 짤림 
    System.out.println(su1 % su2);
    // System.out.println(su1 %% su2);  // X
    
//    int sales = 5000000000;  # The literal 5000000000 of type int is out of range 
    long sales = 5000000000L;
    
    int cnt = 0;
    cnt = cnt + 1;
    System.out.println("1) " + cnt);    
    
    cnt += 1;
    System.out.println("2) " + cnt);    
    
    cnt++;
    System.out.println("3) " + cnt);
    
    --cnt;
    System.out.println("4) " + cnt);
    
    cnt--;
    System.out.println("5) " + cnt);

    // 권장하지 않는 패턴
    int total = cnt--;  // cnt 변수의 값을 total에 할당 후 cnt 변수의 값을 1 감소
    System.out.println("total: " + total + " cnt: " + cnt);
    
    total = --cnt;  // cnt 변수의 값을 먼저 1 감소 시키고 total에 할당
    System.out.println("total: " + total + " cnt: " + cnt);
    
    // 연산자의 위치에따라 연산의 우선순위가 결정됨.

  }

}




