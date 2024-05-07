package dev.mvc.resort_v1sbm3c;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import dev.mvc.hotplace.HotplaceDAOInter;
import dev.mvc.hotplace.HotplaceProcInter;
import dev.mvc.hotplace.HotplaceVO;

@SpringBootTest
class ResortV1sbm3cApplicationTests {
  @Autowired // DramaDAOInter를 구현한 클래스의 객체를 생성하여 dramaDAO 변수에 할당
  private HotplaceDAOInter dramaDAO;

  @Autowired // DramaProcInter를 구현한 클래스의 객체를 생성하여 dramaProc 변수에 할당
  @Qualifier("dev.mvc.drama.DramaProc")
  private HotplaceProcInter dramaProc;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testCreate() {
//    DramaVO dramaVO = new DramaVO();	 
//    dramaVO.setNation("국가");
//    dramaVO.setGenre("로맨스");
//    
//    int cnt = this.dramaDAO.create(dramaVO);
//    System.out.println("-> cnt: " + cnt);
//	}

//	 @Test
//	  public void testCreate() {
//	    DramaVO dramaVO = new DramaVO();  
//	    dramaVO.setNation("해외");
//	    dramaVO.setGenre("공포");
//	    
//	    int cnt = this.dramaProc.create(dramaVO);
//	    System.out.println("-> cnt: " + cnt);
//	  }
	 
//	 @Test
//	 public void testList_all() {
//	   ArrayList<DramaVO> list = this.dramaDAO.list_all();
//	   for (DramaVO dramaVO : list) {
//	     System.out.println(dramaVO.getNation() + " - " + dramaVO.getGenre());
//	   }	   
//	 }

//  @Test
//  public void testList_all() {
//    ArrayList<DramaVO> list = this.dramaProc.list_all();
//    for (DramaVO dramaVO : list) {
//      System.out.println(dramaVO.getNation() + " - " + dramaVO.getGenre());
//    }     
//  }
	
	@Test
	public void Hangul() {
//	  String word = URLEncoder.encode("오버렌딩");
//	  System.out.println("원본: %EC%98%A4%EB%B2%84%EB%A0%8C%EB%94%A9");
//	  System.out.println("변환: " + word);
//	  
//	  word = URLDecoder.decode("%EC%98%A4%EB%B2%84%EB%A0%8C%EB%94%A9"); 
//	  System.out.println("복원: " + word);

//	  // JDK 10+, VSCode 사용
//	  String word = URLEncoder.encode("오버렌딩", StandardCharsets.UTF_8);
//	  System.out.println("원본:%EC%98%A4%EB%B2%84%EB%A0%8C%EB%94%A9");
//	  System.out.println("변환: " + word);
//	    
//	  word = URLDecoder.decode("%EC%98%A4%EB%B2%84%EB%A0%8C%EB%94%A9", StandardCharsets.UTF_8); 
//	  System.out.println("복원: " + word);
	}
	
	@Test
  public void testcount() {
    int cnt= this.dramaProc.list_search_count("국내");
    System.out.println("-> cnt: " + cnt);
  }

}







