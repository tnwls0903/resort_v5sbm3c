package oop;
 
public class Ex3 {
 
  public static void main(String[] args) {
    int avg = 0; // 메소드 전체에서 사용 가능
    
    try {
      int tot = Integer.parseInt(args[0]); // try문에서만 사용 가능
      int cnt = Integer.parseInt(args[1]);
     
      avg = tot / cnt;
      
      System.out.println("총점: " + tot);
      System.out.println("과목수: " + cnt);
      System.out.println("평균: " + avg);
      
    } catch(Exception e) {
      System.out.println("0으로 나눌 수 없습니다.");
      // System.exit(0);
      
    } finally {
      System.out.println("진행을 계속합니다.");
      avg =avg + 10;
      System.out.println("평균 추가 점수 부여: " + avg);
      
    }
  }
 
}

