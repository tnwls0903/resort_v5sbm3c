package oop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class MovieProc {

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#,###,##0 원");
    
    // File movie = new File("C:\\kd\\ws_java\\oop\\src\\oop\\movie.csv");  // O
    // File movie = new File("C:\kd\ws_java\oop\src\oop\movie.csv");  // X
    // 파일 읽기 관련
    File movie = null;    // 읽을 파일
    FileReader fr = null; // 파일 읽기
    BufferedReader br = null; // 읽은 파일 내용을 메모리에 저장
    
    // 파일 쓰기 관련
    File movie_proc = null; // 기록할 파일
    FileWriter fw = null;     // 파일 쓰기
    PrintWriter pw = null;  // 메모리에 기록
    
    try {
      // -----------------------------------------------------------------------------------------------------
      movie = new File("C:/kd/ws_java/oop/src/oop/movie.csv"); // 절대 경로
      
      fr = new FileReader(movie); // movie는 객체이며 타입은? File, 가지고 있는 값은?
      
      br = new BufferedReader(fr);
      // -> movie: 1642356498(Reference value) -> 실제 메모리로 연결됨.
      // Reference value: 실제 메모리로 연결되는 고유한 정수(코드), 객체마다 고유함.
      // 메소드로 숫자나 문자열을 전달하지만 클래스의 객체도 메소드로 전달 가능,
      // 이때 전달되는 값은 정수 형태의 HashCode 임, 이 HashCode는 메모리에 접근 할 수 있기 때문에
      // HashCode를 전달받은 메소드와 전달해준 쪽은 같은 메모리의 데이터를 공유하게됨.
      // Call By Reference: 참조값에의한 호출, HashCode 전달 -> 메모리 공유 
      // System.out.println("-> movie: " + movie.hashCode());
      // System.out.println("-> fr: " + fr.hashCode());
      // -----------------------------------------------------------------------------------------------------
      
      // -----------------------------------------------------------------------------------------------------
      movie_proc = new File("C:/kd/ws_java/oop/src/oop/movie_proc.csv"); 
      fw = new FileWriter(movie_proc);
      pw = new PrintWriter(fw);
      // -----------------------------------------------------------------------------------------------------
      
      String line = br.readLine(); // 컬럼의 이름 읽기
      System.out.println(line);
      
      while(true) {
        line = br.readLine();
        
        if (line == null) {
          break;
        }
        // System.out.println(line);
        
        String[] items = line.split(",");
        String name = items[0];           // 영화명
        String seat = items[1].trim();    // 좌석
        int sungin_cnt = Integer.parseInt(items[2].trim());  // 성인수
        int stu_cnt = Integer.parseInt(items[3].trim());       // 학생수
        int sungin_price = 0; // 성인 금액: 단가 * 성인수
        int stu_price = 0;      // 학생 금액: 단가 * 학생수
        int price = 0;           // 결재 금액: 성인 금액 + 학생 금액
        int point = 0;          // 포인트: 결재 금액의 5% 계산
        
        if (seat.equals("A") == true) {
          sungin_price = 11000 * sungin_cnt;
          stu_price = (int)(11000*0.8) * stu_cnt;
          
        } else if (seat.equals("B") == true) {
          sungin_price = 10000 * sungin_cnt;
          stu_price = (int)(10000*0.8) * stu_cnt;
          
        } else if (seat.equals("C") == true) {
          sungin_price = 9000 * sungin_cnt;
          stu_price = (int)(9000*0.8) * stu_cnt;
        } 
 
        price = sungin_price + stu_price;
        point = (int)(price * 0.05);
        
        System.out.println("영화명: " + name);
        System.out.println("좌석: " + seat);
        System.out.println("성인수: " + sungin_cnt);
        System.out.println("학생수: " + stu_cnt);
        System.out.println("성인 금액: " + df.format(sungin_price));
        System.out.println("학생 금액: " + df.format(stu_price));
        System.out.println("결재 금액: " + df.format(price));
        System.out.println("포인트(5%): " + df.format(point));
        System.out.println("-------------------------------------");
        pw.println("영화명: " + name);  // 파일 기록
        pw.println("좌석: " + seat);
        pw.println("성인수: " + sungin_cnt + "명"); 
        pw.println("학생수: " + stu_cnt + "명");
        pw.println("성인 금액: " + df.format(sungin_price));
        pw.println("학생 금액: " + df.format(stu_price));
        pw.println("결재 금액: " + df.format(price));
        pw.println("포인트(5%): " + df.format(point));
        pw.println("-------------------------------");
  
        System.out.println(" → complete.");
        
      }
    
    } catch(FileNotFoundException e) {
      System.out.println("파일이 존재하지 않습니다.");
    } catch(IOException e) {
      System.out.println("파일을 읽거나 쓸수 없습니다.");
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      // 객체가 생성된 역순으로 메모리 해제, 파일쓰기가 실제로 이루어짐.
      // 틀린 패턴
//      try {
//        pw.close();
//        fw.close();
//        br.close();
//        fr.close();        
//      } catch(Exception e) { 
//        
//      }
     
      // 정상 처리
      try { pw.close(); } catch(Exception e) { }
      try { fw.close(); } catch(Exception e) { }
      try { br.close(); } catch(Exception e) { }
      try { fr.close(); } catch(Exception e) { }
    }
  }

}





