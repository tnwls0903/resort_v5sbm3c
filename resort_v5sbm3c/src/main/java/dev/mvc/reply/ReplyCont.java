package dev.mvc.reply;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.mvc.cate.CateProcInter;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/reply")
@Controller
public class ReplyCont {
  public ReplyCont() {
    System.out.println("-> ReplyCont created.");
  }

  @Autowired
  @Qualifier("dev.mvc.reply.ReplyProc")
  private ReplyProcInter replyProc;

  /**
   * 댓글 등록은 부모글 조회에서 진행함으로 구현 안함. 부모글 조회 -> Ajax -> Json -> POST
   * http://127.0.0.1:9091/reply/create { "contentsno": 1, "memberno": 1,
   * "content": "대기업의 쪼개기 지분 상장" }
   * 
   * @param replyVO
   * @return
   */
  @PostMapping(value = "/create")
  @ResponseBody
  public String create(HttpSession session, @RequestBody ReplyVO replyVO) {
    System.out.println("-> 수신 데이터:" + replyVO.toString());

    int memberno = (int) session.getAttribute("memberno"); // 보안성 향상
    replyVO.setMemberno(memberno);

    int cnt = this.replyProc.create(replyVO);

    JSONObject json = new JSONObject();
//    json.put("res", "등록 테스트");
    json.put("res", cnt);

    return json.toString();
  }

//  /**
//  컨텐츠별 댓글 목록 
//  {
//  "res":[
//     {"memberno":2,"rdate":"2024-05-31 16:11:58","replyno":12,"id":"admin","content":"44","contentsno":2},
//     {"memberno":2,"rdate":"2024-05-31 16:04:13","replyno":11,"id":"admin","content":"주식을 상품으로 사용하는 펀드에요.","contentsno":2},
//     {"memberno":2,"rdate":"2024-05-31 15:55:08","replyno":10,"id":"admin","content":"33","contentsno":2},
//     {"memberno":2,"rdate":"2024-05-31 15:53:52","replyno":9,"id":"admin","content":"22","contentsno":2},
//     {"memberno":2,"rdate":"2024-05-31 15:52:41","replyno":8,"id":"admin","content":"12","contentsno":2}
//     ]
//  }
//  * http://localhost:9091/reply/list_by_contentsno_join?contentsno=2
//  * @param contentsno
//  * @return
//  */
// @GetMapping(value="/list_by_contentsno_join")
// @ResponseBody
// public String list_by_contentsno_join(int contentsno) {
//   List<ReplyMemberVO> list = replyProc.list_by_contentsno_join(contentsno);
//   
//   JSONObject obj = new JSONObject();
//   obj.put("res", list);
//   
//   System.out.println("-> obj.toString(): " + obj.toString());
//   
//   return obj.toString();     
// }

  /**
   * 컨텐츠별 댓글 목록 { "res":[ {"memberno":2,"rdate":"2024-05-31
   * 16:11:58","replyno":12,"id":"admin","content":"44","contentsno":2},
   * {"memberno":2,"rdate":"2024-05-31
   * 16:04:13","replyno":11,"id":"admin","content":"주식을 상품으로 사용하는
   * 펀드에요.","contentsno":2}, {"memberno":2,"rdate":"2024-05-31
   * 15:55:08","replyno":10,"id":"admin","content":"33","contentsno":2},
   * {"memberno":2,"rdate":"2024-05-31
   * 15:53:52","replyno":9,"id":"admin","content":"22","contentsno":2},
   * {"memberno":2,"rdate":"2024-05-31
   * 15:52:41","replyno":8,"id":"admin","content":"12","contentsno":2} ] }
   * http://localhost:9091/reply/list_by_contentsno_join?contentsno=2
   * 
   * @param contentsno
   * @return
   */
  @GetMapping(value = "/list_by_contentsno_join")
  @ResponseBody
  public String list_by_contentsno_join(int contentsno) {
    List<ReplyMemberVO> list = replyProc.list_by_contentsno_join_500(contentsno);

    JSONObject obj = new JSONObject();
    obj.put("res", list);

    // System.out.println("-> obj.toString(): " + obj.toString());

    return obj.toString();
  }

  /**
   * 조회
   * 
   * @param contentsno
   * @return
   */
  @GetMapping(value = "/read", produces = "application/json")
  @ResponseBody
  public String read(int replyno) {
    ReplyVO replyVO = this.replyProc.read(replyno);
    // -> obj.toString(): {"res":"ReplyVO(replyno=31, contentsno=2, memberno=2, content=금요일, rdate=2024-05-31 17:24:57)"}
    JSONObject row = new JSONObject();
    
    row.put("replyno", replyVO.getReplyno());
    row.put("contentsno", replyVO.getContentsno());
    row.put("memberno", replyVO.getMemberno());
    row.put("content", replyVO.getContent());
    row.put("rdate", replyVO.getRdate());    
    
    JSONObject obj = new JSONObject();
    obj.put("res", row);

    // System.out.println("-> obj.toString(): " + obj.toString());
    return obj.toString();
  }

  /**
   * 수정 처리 
   * @param replyVO
   * @return
   */
  @PostMapping(value = "/update")
  @ResponseBody
  public String update(HttpSession session, @RequestBody ReplyVO replyVO) {
    System.out.println("-> 수정할 수신 데이터:" + replyVO.toString());

    int memberno = (int) session.getAttribute("memberno"); // 보안성 향상
    
    int cnt = 0;
    if (memberno == replyVO.getMemberno()) { // 회원 자신이 쓴글만 수정 가능
      cnt = this.replyProc.update(replyVO);
    }
    
    JSONObject json = new JSONObject();
    json.put("res", cnt);  // 1: 성공, 0: 실패

    return json.toString();
  }
  
  /**
   * 삭제 처리 
   * @param replyVO
   * @return
   */
  @PostMapping(value = "/delete")
  @ResponseBody
  public String delete(HttpSession session, @RequestBody ReplyVO replyVO) {
    // System.out.println("-> 삭제할 수신 데이터:" + replyVO.toString());

    int memberno = (int) session.getAttribute("memberno"); // 보안성 향상
    
    int cnt = 0;
    if (memberno == replyVO.getMemberno()) { // 회원 자신이 쓴글만 수정 가능
      cnt = this.replyProc.delete(replyVO.getReplyno());
    }
    
    JSONObject json = new JSONObject();
    json.put("res", cnt);  // 1: 성공, 0: 실패

    return json.toString();
  }
  
}


