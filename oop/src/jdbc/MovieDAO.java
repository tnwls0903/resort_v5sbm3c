package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {
  private Connection con = null;               // DBMS 연결
  private PreparedStatement pstmt = null; // SQL 실행
  private ResultSet rs = null;                     // SELECT 결과를 저장
  private StringBuffer sql = null;                // SQL 문장
  private int count = 0;                             // 처리된 레코드 갯수

//  private String className = "com.mysql.jdbc.Driver"; // MySQL 연결 Drvier, JDK 11
  private String className = "com.mysql.cj.jdbc.Driver"; // MySQL 연결 Drvier, JDK 17+
  private String url = "jdbc:mysql://localhost:3306/javadb"; 
  private String user = "javauser"; 
  private String password = "1234";
  
  // INSERT INTO movie(title, score, actor, rdate)
  // VALUES('웡카', 3.4, '휴그랜트/로완 아킨슨', now());
  public int create(String title, double score, String actor) {
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결

      this.sql = new StringBuffer();
      this.sql.append(" INSERT INTO movie(title, score, actor, rdate)");
      this.sql.append(" VALUES(?, ?, ?, now())"); // ";" 제외
 
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
      this.pstmt.setString(1, title);
      this.pstmt.setDouble(2, score);
      this.pstmt.setString(3, actor);
      
      this.count = this.pstmt.executeUpdate(); // INSERT, UPDATE, DELETE, 처리한 갯수가 저장됨.
      // this.rs = this.pstmt.executeQuery();    // SELECT 
 
      if (this.count == 1){
        System.out.println("처리 성공");
      }else{
        System.out.println("처리 실패");
      }    
    } catch (SQLException e) {
      System.out.println("SQL 실행중 예외 발생");
      e.printStackTrace(); // 예외가 발생하기까지의 실행과정을 출력
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버가 없는것 같습니다.");
      e.printStackTrace();
    }finally{
      // try{ if (this.rs != null){ this.rs.close(); } }catch(Exception e){ } 
      try{ if (this.pstmt != null){ this.pstmt.close(); } }catch(Exception e){ }
      try{ if (this.con != null){ this.con.close(); } }catch(Exception e){ }
    }
    
    return this.count;
    
  }

//  SELECT movieno, title, score, actor, rdate
//  FROM movie
//  ORDER BY movieno ASC;
  public void list() {    
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결
  
      this.sql = new StringBuffer();
      this.sql.append(" SELECT movieno, title, score, actor, rdate");
      this.sql.append(" FROM movie"); 
      this.sql.append(" ORDER BY movieno ASC"); // ";" 제외
  
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
   
      this.rs = this.pstmt.executeQuery();    // SELECT
      
      while(true) {
        if (rs.next()) {
          System.out.print(rs.getInt("movieno") + ". ");
          System.out.print(rs.getString("title") + " ");
          System.out.print(" (" + rs.getDouble("score") + ") ");
          System.out.print(" 출연: " + rs.getString("actor") + " ");
//          System.out.print(rs.getDate("rdate"));
          System.out.print(rs.getString("rdate").substring(0,  10)); // 시작 index, 끝 index-1
        } else {
          break;
        }
        System.out.println();
      }
  
    } catch (SQLException e) {
      System.out.println("SQL 실행중 예외 발생");
      e.printStackTrace(); // 예외가 발생하기까지의 실행과정을 출력
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버가 없는것 같습니다.");
      e.printStackTrace();
    }finally{
      try{ if (this.rs != null){ this.rs.close(); } }catch(Exception e){ } 
      try{ if (this.pstmt != null){ this.pstmt.close(); } }catch(Exception e){ }
      try{ if (this.con != null){ this.con.close(); } }catch(Exception e){ }
    }
    
    
  }

//  SELECT movieno, title, score, actor, rdate
//  FROM movie
//  WHERE movieno=1;
    public void read(int movieno) {
      try{
        Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
        this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결
    
        this.sql = new StringBuffer();
        this.sql.append(" SELECT movieno, title, score, actor, rdate");
        this.sql.append(" FROM movie"); 
        this.sql.append(" WHERE movieno=?"); // ";" 제외
    
        this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
        this.pstmt.setInt(1, movieno);
     
        this.rs = this.pstmt.executeQuery();    // SELECT
        
        if (rs.next()) { // 첫번째 레코드 -> 마지막까지 이동
          System.out.print(rs.getInt("movieno") + ". ");
          System.out.print(rs.getString("title") + " ");
          System.out.print(" (" + rs.getDouble("score") + ") ");
          System.out.print(" 출연: " + rs.getString("actor") + " ");
  //        System.out.print(rs.getDate("rdate"));
          System.out.print(rs.getString("rdate").substring(0,  10)); // 시작 index, 끝 index-1
        }
        
      } catch (SQLException e) {
        System.out.println("SQL 실행중 예외 발생");
        e.printStackTrace(); // 예외가 발생하기까지의 실행과정을 출력
      } catch (ClassNotFoundException e) {
        System.out.println("JDBC 드라이버가 없는것 같습니다.");
        e.printStackTrace();
      }finally{
        try{ if (this.rs != null){ this.rs.close(); } }catch(Exception e){ } 
        try{ if (this.pstmt != null){ this.pstmt.close(); } }catch(Exception e){ }
        try{ if (this.con != null){ this.con.close(); } }catch(Exception e){ }
      }
      
    }
    
//    UPDATE movie
//    SET title='이미테이션 게임', score=5, actor='키이라 크리스티나 나이틀리', rdate=now()
//    WHERE movieno=5;
    public int update(String title, double score, String actor, int movieno) {
      try{
        Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
        this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결

        this.sql = new StringBuffer();
        this.sql.append(" UPDATE movie");
        this.sql.append(" SET title=?, score=?, actor=?, rdate=now()");
        this.sql.append(" WHERE movieno=?"); // ";" 제외
   
        this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
        this.pstmt.setString(1, title);
        this.pstmt.setDouble(2, score);
        this.pstmt.setString(3, actor);
        this.pstmt.setInt(4, movieno);
        
        this.count = this.pstmt.executeUpdate(); // INSERT, UPDATE, DELETE, 처리한 갯수가 저장됨.
   
        if (this.count == 1){
          System.out.println("처리 성공");
        }else{
          System.out.println("처리 실패");
        }    
      } catch (SQLException e) {
        System.out.println("SQL 실행중 예외 발생");
        e.printStackTrace(); // 예외가 발생하기까지의 실행과정을 출력
      } catch (ClassNotFoundException e) {
        System.out.println("JDBC 드라이버가 없는것 같습니다.");
        e.printStackTrace();
      }finally{
        // try{ if (this.rs != null){ this.rs.close(); } }catch(Exception e){ } 
        try{ if (this.pstmt != null){ this.pstmt.close(); } }catch(Exception e){ }
        try{ if (this.con != null){ this.con.close(); } }catch(Exception e){ }
      }
      
      return this.count;
      
    }

//    DELETE FROM movie
//    WHERE movieno=4;
  public int delete(int movieno) {
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결

      this.sql = new StringBuffer();
      this.sql.append(" DELETE FROM movie");
      this.sql.append(" WHERE movieno=?"); // ";" 제외
 
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
      this.pstmt.setInt(1, movieno);
      
      this.count = this.pstmt.executeUpdate(); // INSERT, UPDATE, DELETE, 처리한 갯수가 저장됨.
 
      if (this.count == 1){
        System.out.println("처리 성공");
      }else{
        System.out.println("처리 실패");
      }    
    } catch (SQLException e) {
      System.out.println("SQL 실행중 예외 발생");
      e.printStackTrace(); // 예외가 발생하기까지의 실행과정을 출력
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버가 없는것 같습니다.");
      e.printStackTrace();
    }finally{
      // try{ if (this.rs != null){ this.rs.close(); } }catch(Exception e){ } 
      try{ if (this.pstmt != null){ this.pstmt.close(); } }catch(Exception e){ }
      try{ if (this.con != null){ this.con.close(); } }catch(Exception e){ }
    }
    
    return this.count;
    
  }

// SELECT COUNT(*) AS 'cnt' 
// FROM movie
  public int count() {
    int record_count = 0;
    
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결
  
      this.sql = new StringBuffer();
      this.sql.append(" SELECT COUNT(*) AS 'cnt'");
      this.sql.append(" FROM movie"); 
  
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
   
      this.rs = this.pstmt.executeQuery();    // SELECT
      
      if (rs.next()) { // 첫번째 레코드 -> 마지막까지 이동
        record_count = rs.getInt("cnt");    
      }
      
    } catch (SQLException e) {
      System.out.println("SQL 실행중 예외 발생");
      e.printStackTrace(); // 예외가 발생하기까지의 실행과정을 출력
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버가 없는것 같습니다.");
      e.printStackTrace();
    }finally{
      try{ if (this.rs != null){ this.rs.close(); } }catch(Exception e){ } 
      try{ if (this.pstmt != null){ this.pstmt.close(); } }catch(Exception e){ }
      try{ if (this.con != null){ this.con.close(); } }catch(Exception e){ }
    }
    
    return record_count;
  }
  
  
}

