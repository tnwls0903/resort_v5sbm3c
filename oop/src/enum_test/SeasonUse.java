package enum_test;

public class SeasonUse {

  public static void main(String[] args) {
    // Season: enum 열거형 타입, 데이터 타입의 한 종류
    // 열거형으로 지정하지 않으면 봄을 각자 표현하게됨: Spring, spring, 봄...
    // 열거형은 코드화하여 특정 값을 통일시킴.
    Season season = Season.SPRING;
    System.out.println("1. " + season);
    System.out.println("2. " + Season.SPRING);

//    if (season == SPRING) {  // X  
//      System.out.println("3. 봄입니다.");
//    }
//
//    if (season == "SPRING") {  // X
//      System.out.println("4. 봄입니다.");
//    }
//
//    if (season == 0) { // X
//      System.out.println("5. 봄입니다.");
//    }
    
    // 열거형 값 비교는 열거형 타입을 항상 먼저 명시해야함.
    if (season == Season.SPRING) {  
      System.out.println("6. 봄입니다.");
    }

    Season season2 = Season.FALL;
    System.out.println("좋아하는 계절: " + season2);

    for (Season sea : Season.values()) {
      System.out.print(sea + " ");
    }

  }
}



