package dev.mvc.resort_v1sbm3c;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import dev.mvc.hotplace.HotplaceProcInter;
import dev.mvc.member.MemberProc;
import dev.mvc.member.MemberProcInter;

@SpringBootTest
public class MemberTest {
  @Autowired
  @Qualifier("dev.mvc.hotplace.HotplaceProc")  // @Component("dev.mvc.hotplace.HotplaceProc")
  private HotplaceProcInter hotplaceProc;
  
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



