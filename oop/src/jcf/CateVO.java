package jcf;

/*
CREATE TABLE cate(
    cateno                            NUMBER(10)     NOT NULL    PRIMARY KEY,
    name                              VARCHAR2(100)    NOT NULL,
    rdate                              DATE     NOT NULL,
    cnt                                 NUMBER(10)     DEFAULT 0     NOT NULL
); 
 */
public class CateVO {
  /** 카테고리 번호 */
  private int cateno;  
  /** 카테고리 이름 */
  private String name;
  /** 등록일 */
  private String rdate;
  /** 등록된 글 수 */
  private int cnt;
  
  public CateVO() {
    
  }
  
  public CateVO(int cateno, String name, String rdate, int cnt) {
    this.cateno = cateno;
    this.name = name;
    this.rdate = rdate;
    this.cnt = cnt;
  }

  public int getCateno() {
    return cateno;
  }
  public void setCateno(int cateno) {
    this.cateno = cateno;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  
  
}
