package dev.mvc.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.mvc.tool.Tool;

@Service("dev.mvc.reply.ReplyProc")
public class ReplyProc implements ReplyProcInter {
  @Autowired
  private ReplyDAOInter replyDAO;
  
  @Override
  public int create(ReplyVO replyVO) {
    int cnt = this.replyDAO.create(replyVO);
    return cnt;
  }

  @Override
  public List<ReplyMemberVO> list_by_contentsno_join(int contentsno) {
    List<ReplyMemberVO> list = replyDAO.list_by_contentsno_join(contentsno);
    String content = "";
    
    // 특수 문자 변경
    for (ReplyMemberVO replyMemberVO:list) {
      content = replyMemberVO.getContent();
      content = Tool.convertChar(content);
      replyMemberVO.setContent(content);
    }
    return list;
  }
  
  
  @Override
  public List<ReplyMemberVO> list_by_contentsno_join_500(int contentsno) {
    List<ReplyMemberVO> list = this.replyDAO.list_by_contentsno_join_500(contentsno);
    return list;
  }
  
  @Override
  public ReplyVO read(int replyno) {
    ReplyVO replyVO =this.replyDAO.read(replyno);
    return replyVO;
  }
  
  @Override
  public int update(ReplyVO replyVO) {
    int cnt = this.replyDAO.update(replyVO);
    return cnt;
  }

  @Override
  public int delete(int replyno) {
    int cnt = this.replyDAO.delete(replyno);
    return cnt;
  }
  
}



