package oop;

import java.util.Random;

public class ForTest {

  public static void main(String[] args) {
//    for (int i = 1; i <= 5; i++) { // 5 이하
//      System.out.print(i + " ");
//    }
//
//    System.out.println();
//
//    for (int i = 1; i < 5; i++) { // 5 미만
//      System.out.print(i + " ");
//    }
//
//    System.out.println();
//
//    for (int i = 1; i <= 5; i = i + 1) { // 5 미만
//      System.out.print(i + " ");
//    }
//
//    System.out.println();
//
//    for (int i = 1; i <= 10; i = i + 2) { // 5 미만
//      System.out.print(i + " ");
//    }
//
//    System.out.println();
//
//    for (int i = 5; i >= 1; i--) { // 5 미만
//      System.out.print(i + " ");
//    }

    // 1 ~ 1000까지의 수 중에서 2 and 3 and 4 and 5의 배수를 출력하시오.
    // hint: for, if
    // 60 120 180 240 300 360 420 480 540 600 660 720 780 840 900 960
//    System.out.println();
//    
//    for (int i = 1; i <= 1000; i++) {
//      if (i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0) {
//        System.out.print(i + " ");
//      }
//    }

    // 1 ~ 1000까지의 수 중에서 2 and 3 and 4 and 5의 배수와 갯수를 출력하시오.
    // hint: for, if
    // 60 120 180 240 300 360 420 480 540 600 660 720 780 840 900 960
    // cnt: 16
//    System.out.println();
//    int cnt = 0;
//    for (int i = 1; i <= 1000; i++) {
//      if (i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0) {
//        cnt = cnt + 1;
//      }
//    }
//
//    System.out.println("cnt: " + cnt);

    // 1 ~ 100까지의 수 중에서 30개의 난수를 생성하고 배열에 저장한후 짝수와 홀수의 갯수를 출력하시오.
    
    // 난수: 3 6 8 12 56 87 98 23 55 65...
    // 짝수의 갯수: 13
    // 홀수의 갯수: 17
    
//    System.out.println();
//    int cnt = 0;
//    for (int i = 1; i <= 1000; i++) {
//      if (i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0) {
//        cnt = cnt + 1;
//      }
//    }
//
//    System.out.println("cnt: " + cnt);
//    

    // 1 ~ 100까지의 수 중에서 30개의 난수를 생성하고 배열에 저장한 후 짝수와 홀수의 개수를 출력하시오.
    // 난수: 3 6 8 9 7 21....
    // 짝수의 개수: 13
    // 홀수의 개수: 17
//    Random random = new Random();
//    int even = 0;
//    int odd = 0;
//
//    System.out.print("난수: ");
//    for (int i = 0; i < 30; i++) {
//      int no = random.nextInt(100) + 1;
//      System.out.print(no + " ");
//      
//      if (no % 2 == 0) {
//        even = even + 1;
//      } else {
//        odd = odd + 1;
//      }
//
//    }
//    System.out.println();
//    System.out.println("짝수의 갯수: " + even);
//    System.out.println("홀수의 갯수: " + odd);
   
    // 구구단 3단 출력
    // 3 x 1 = 3
    // 3 x 2 = 6
    // 3 x 3 = 9
    // 3 x 4 = 12
    // ...
    // 3 x 9 = 27
//    for (int i=1; i<=9; i++) {
//      System.out.println("3 × " + i + "=" + (3 * i));
//    }
    
//    for (int i=1; i<=9; i++) {
//      System.out.printf("%d × %d = %d\n", 3, i, (3 * i));
//    }
//    
//    System.out.println();
//    
//    for (int i=1; i<=9; i++) {
//      System.out.printf("%d × %d = %d\n", 4, i, (4 * i));
//    }
//    
//    System.out.println();
//    
//    for (int i=1; i<=9; i++) {
//      System.out.printf("%d × %d = %d\n", 5, i, (5 * i));
//    }

//    System.out.println();
//    
//    for (int i=1; i<=18; i++) {
//      System.out.println(i + " 단");
//      for(int j=1; j<=9; j++) {
//        System.out.printf("%d × %d = %d\n", i, j, (i * j));
//      }
//      System.out.println();
//    }

    int[] years = new int[5];  // 0으로 초기화
    System.out.println(years[0]);
    
    for (int no: years) {
      System.out.println(years[0]);
    }
    
    String[] week = {"월", "화","수"};
    for (String item: week) {
      System.out.println(item);
    }
    
    // week[3] = "목"; // java.lang.ArrayIndexOutOfBoundsException
    
    for (int i=1; i<=10; i++) {
      if (i % 2 != 0) { // 홀수라면
        continue;
      }
      System.out.print(i + " ");
    }
    
    System.out.println();
    
    for (int i=1; i<=10; i++) {
      if (i % 2 == 0 && i % 3 == 0) { // 홀수라면
        System.out.print("-> " + i + " ");
        break;
      }
    }
  }
}





