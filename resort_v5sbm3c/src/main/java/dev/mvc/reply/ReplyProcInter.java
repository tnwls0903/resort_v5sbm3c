package dev.mvc.reply;

import java.util.ArrayList;
import java.util.List;

public interface ReplyProcInter {
  /**
   * 등록
   * @param replyVO
   * @return
   */
  public int create(ReplyVO replyVO); 

  /**
   * 글 조회시 댓글 목록 출력
   * @param contentsno
   * @return
   */
  public List<ReplyMemberVO> list_by_contentsno_join(int contentsno);
  
  /**
   * 최신 글 500 건
   * @param contentsno
   * @return
   */
  public List<ReplyMemberVO> list_by_contentsno_join_500(int contentsno);
  
  /**
   * 읽기 
   * @param replyno
   * @return
   */
  public ReplyVO read (int replyno);
  
  /**
   * 댓글  수정
   * @param replyVO
   * @return
   */
  public int update(ReplyVO replyVO);
  
  /**
   * 삭제
   * @param replyno
   * @return
   */
  public int delete(int replyno);
  
  
}


