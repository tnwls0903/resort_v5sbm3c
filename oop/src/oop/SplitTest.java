package oop;

public class SplitTest {

  public static void main(String[] args) {
    String season="봄,여름,가을,겨울";
    String[] list = season.split(",");
    
    System.out.println(list.length); // 4
    
    for (String item : list) {
      System.out.println(item);
    }

    System.out.println("-----------------");
    
    season="봄, 여름, 가을, 겨울";
    list = season.split(", ");
    
    System.out.println(list.length);
    
    for (String item : list) {
      System.out.println(item);
    }
    
    System.out.println("-----------------");
    
    season="봄,,가을,겨울";
    list = season.split(",");
    
    System.out.println(list.length);
    
    for (String item : list) {
      System.out.println(item);
    }
    System.out.println("-----------------");
    for (String item : list) {
      if (item.equals("") == true) {
        // System.out.println("데이터 누락 발견");
      } else {
        System.out.println(item);
      }
    }
    
  }

}

