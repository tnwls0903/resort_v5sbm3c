package dev.mvc.resort_v1sbm3c;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import dev.mvc.cate.CateDAOInter;
import dev.mvc.cate.CateProcInter;
import dev.mvc.cate.CateVO;

@SpringBootTest
class ResortV1sbm3cApplicationTests {
  @Autowired // CateDAOInter를 구현한 클래스의 객체를 생성하여 cateDAO 변수에 할당
  private CateDAOInter cateDAO;

  @Autowired // CateProcInter를 구현한 클래스의 객체를 생성하여 cateProc 변수에 할당
  @Qualifier("dev.mvc.cate.CateProc")
  private CateProcInter cateProc;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testCreate() {
//    CateVO cateVO = new CateVO();	 
//    cateVO.setName("개발");
//    cateVO.setNamesub("오라클");
//    
//    int cnt = this.cateDAO.create(cateVO);
//    System.out.println("-> cnt: " + cnt);
//	}

//	 @Test
//	  public void testCreate() {
//	    CateVO cateVO = new CateVO();  
//	    cateVO.setName("개발");
//	    cateVO.setNamesub("자바스크립트");
//	    
//	    int cnt = this.cateProc.create(cateVO);
//	    System.out.println("-> cnt: " + cnt);
//	  }
	 
//	 @Test
//	 public void testList_all() {
//	   ArrayList<CateVO> list = this.cateDAO.list_all();
//	   for (CateVO cateVO : list) {
//	     System.out.println(cateVO.getName() + " - " + cateVO.getNamesub());
//	   }	   
//	 }

//  @Test
//  public void testList_all() {
//    ArrayList<CateVO> list = this.cateProc.list_all();
//    for (CateVO cateVO : list) {
//      System.out.println(cateVO.getName() + " - " + cateVO.getNamesub());
//    }     
//  }

}







