package movie;

//CREATE TABLE movie(
//    movieno  INT          NOT NULL AUTO_INCREMENT, -- 번호
//    title    VARCHAR(30)  NOT NULL, -- 제목
//    score    FLOAT        NOT NULL, -- 평점
//    actor    VARCHAR(30)  NOT NULL, -- 출연
//    rdate    DATETIME     NOT NULL, -- 등록일
//    PRIMARY KEY(movieno)  
//  );
public class MovieVO {
  private int movieno;
  private String title;
  private double score;
  private String actor;
  private String rdate;
  
  public MovieVO() {
  
  }

  public MovieVO(String title, double score, String actor) {
    this.title = title;
    this.score = score;
    this.actor = actor;
  }

  public MovieVO(int movieno, String title, double score, String actor) {
    this.movieno = movieno;
    this.title = title;
    this.score = score;
    this.actor = actor;
  }
  
  public MovieVO(int movieno, String title, double score, String actor, String rdate) {
    this.movieno = movieno;
    this.title = title;
    this.score = score;
    this.actor = actor;
    this.rdate = rdate;
  }

  public int getMovieno() {
    return movieno;
  }

  public void setMovieno(int movieno) {
    this.movieno = movieno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public String getActor() {
    return actor;
  }

  public void setActor(String actor) {
    this.actor = actor;
  }

  public String getRdate() {
    return rdate;
  }

  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
}

