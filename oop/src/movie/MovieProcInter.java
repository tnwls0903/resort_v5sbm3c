package movie;

import java.util.ArrayList;

public interface MovieProcInter {
  /**
   * 등록
   * @param movieVO
   * @return
   */
  public int create(MovieVO movieVO);
  
  /**
   * 목록
   * @return
   */
  public ArrayList<MovieVO> list();
  
  /**
   * 조회
   * @return
   */
  public MovieVO read(int movieno);
  
  /**
   * 수정
   * @param movieVO
   * @return 수정된 레코드 갯수
   */
  public int update(MovieVO movieVO);
  
  /**
   * 삭제
   * @param movieVO
   * @return 삭제된 레코드 갯수
   */
  public int delete(int movieno);
  
  /**
   * 자료수 조회
   * @return 자료수
   */
  public int count();
  
}


