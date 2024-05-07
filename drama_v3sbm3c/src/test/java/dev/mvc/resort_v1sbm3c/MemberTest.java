package dev.mvc.resort_v1sbm3c;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import dev.mvc.drama.DramaProcInter;
import dev.mvc.member.MemberProc;
import dev.mvc.member.MemberProcInter;

@SpringBootTest
public class MemberTest {
  @Autowired
  @Qualifier("dev.mvc.drama.DramaProc")  // @Component("dev.mvc.drama.DramaProc")
  private DramaProcInter dramaProc;
  
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")  // @Service("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;

  @Test
  public void checkId() {
    String id = "admin1";
    int cnt = this.memberProc.checkID(id);
    System.out.println("-> cnt: " + cnt);
  }
  
  
}



