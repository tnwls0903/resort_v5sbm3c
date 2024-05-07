package enum_test;

public class StaticSeasonUse {

  public static void main(String[] args) {
    String season = StaticSeason.SPRING;
    System.out.println("1. " + season);
    System.out.println("2. " + StaticSeason.SPRING);

//    if (season == SPRING) {  // X  
//      System.out.println("3. 봄입니다.");
//    }
//
    if (season == "SPRING") {  // X
      System.out.println("4. 봄입니다.");
    }
//
//    if (season == 0) { // X
//      System.out.println("5. 봄입니다.");
//    }
    
    // 열거형 값 비교는 열거형 타입을 항상 먼저 명시해야함.
    if (season == StaticSeason.SPRING) {  
      System.out.println("6. 봄입니다.");
    }

    // StaticSeason season2 = StaticSeason.FALL;  // X
    // System.out.println("좋아하는 계절: " + season2);

//    for (StaticSeason sea : StaticSeason.values()) {  // X
//      System.out.print(sea + " ");
//    }
    
    StaticSeason.SPRING = "봄 응봉산 야경";
    System.out.println("7. " + StaticSeason.SPRING);  // 값 변경 가능

  }
}




