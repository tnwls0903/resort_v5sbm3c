package test;

public class NullTest {

  public static void main(String[] args) {
    String url = null;
    System.out.println(url);
    // System.out.println(url.toLowerCase()); // 메모리를 할당 받지 못하여 String class의 메소드 호출이 불가능함.
    //  java.lang.NullPointerException

    if (url == null) {
      System.out.println("url은 메모리를 할당받지 못함");
    }
    
    url = "";  // 아무런 데이터가 없는 문자열이 할당됨.
    if (url.length() == 0 || url.equals("")) {
      System.out.println("값이 없음: " + url);
    }
    System.out.println(url.toLowerCase());
    System.out.println("-> url.hashCode(): " + url.hashCode());    // 할당된 메모리 확인, hashCode -> 실제 주소로 연결됨.
    
    url = "주소가 같은가?";
    System.out.println("-> url.hashCode(): " + url.hashCode());    // 할당된 메모리 확인

  }

}