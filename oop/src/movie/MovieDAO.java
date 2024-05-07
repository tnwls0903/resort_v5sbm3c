package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO implements MovieDAOInter {
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
  
  @Override
  public int create(MovieVO movieVO) {
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결

      this.sql = new StringBuffer();
      this.sql.append(" INSERT INTO movie(title, score, actor, rdate)");
      this.sql.append(" VALUES(?, ?, ?, now())"); // ";" 제외
 
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
      this.pstmt.setString(1, movieVO.getTitle());
      this.pstmt.setDouble(2, movieVO.getScore());
      this.pstmt.setString(3, movieVO.getActor());
      
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

  @Override
  public ArrayList<MovieVO> list() {
    ArrayList<MovieVO> list = new ArrayList<MovieVO>();
    
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
        if (rs.next()) { // 첫번째 레코드로 이동 -> 마지막까지 이동
          MovieVO movieVO = new MovieVO();
          movieVO.setMovieno(rs.getInt("movieno")); // DBMS -> Java Object
          movieVO.setTitle(rs.getString("title")); // DBMS -> Java Object
          movieVO.setScore(rs.getDouble("score")); // DBMS -> Java Object
          movieVO.setActor(rs.getString("actor")); // DBMS -> Java Object
          movieVO.setRdate(rs.getString("rdate")); // DBMS -> Java Object
          
          list.add(movieVO);
        } else {
          break;
        }
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
    
    return list;
  }

  @Override
  public MovieVO read(int movieno) {
    MovieVO movieVO = new MovieVO();
    
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
      
      if (rs.next()) { // 레코드 포인터를 첫번째 레코드로 이동
        movieVO.setMovieno(rs.getInt("movieno")); // DBMS -> Java Object
        movieVO.setTitle(rs.getString("title")); // DBMS -> Java Object
        movieVO.setScore(rs.getDouble("score")); // DBMS -> Java Object
        movieVO.setActor(rs.getString("actor")); // DBMS -> Java Object
        movieVO.setRdate(rs.getString("rdate")); // DBMS -> Java Object
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
    
    return movieVO;
  }

  @Override
  public int update(MovieVO movieVO) {
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결

      this.sql = new StringBuffer();
      this.sql.append(" UPDATE movie");
      this.sql.append(" SET title=?, score=?, actor=?, rdate=now()"); // ";" 제외
      this.sql.append(" WHERE movieno=?");
 
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
      this.pstmt.setString(1, movieVO.getTitle());
      this.pstmt.setDouble(2, movieVO.getScore());
      this.pstmt.setString(3, movieVO.getActor());
      this.pstmt.setInt(4, movieVO.getMovieno());
      
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

  @Override
  public int delete(int movieno) {
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결

      this.sql = new StringBuffer();
      this.sql.append(" DELETE FROM movie");
      this.sql.append(" WHERE movieno=?");
 
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
      this.pstmt.setInt(1, movieno);
      
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

  @Override
  public int count() {
    int count = 0;
    
    try{
      Class.forName(this.className); // memory로 클래스를 로딩함, 객체는 생성하지 않음.
      this.con = DriverManager.getConnection(this.url, this.user, this.password ); // MySQL 연결
  
      this.sql = new StringBuffer();
      this.sql.append(" SELECT COUNT(*) AS 'cnt'");
      this.sql.append(" FROM movie");  // ";" 제외
  
      this.pstmt = this.con.prepareStatement(this.sql.toString()); // SQL 실행 객체 생성
      
      this.rs = this.pstmt.executeQuery();    // SELECT
      
      if (rs.next()) { // 레코드 포인터를 첫번째 레코드로 이동
        count = rs.getInt("cnt");
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
    
    return count;
  }

}



