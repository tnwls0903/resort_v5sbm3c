package dev.boot.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Brower -> 접속 요청을 최초로 받는 클래스
public class MsgCont {
  public MsgCont() {
    System.out.println("-> MsgCont created.");
  }
  
  //http://localhost:9091/msg, http://localhost:9091/msg.seoul
  @GetMapping(value={"/", "/msg", "/msg.seoul"}) // GET 방식 요청
  @ResponseBody // 리턴하는 내용이 파일이 아님
  public String msg() {
    return "<h2>콘트롤러 정상 작동됨.</h2>";
  }
}
