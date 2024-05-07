package dev.mvc.drama;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.mvc.tool.Tool;
import jakarta.validation.Valid;

@RequestMapping("/drama")
@Controller
public class DramaCont {
  @Autowired
  @Qualifier("dev.mvc.drama.DramaProc")
  private DramaProcInter dramaProc;
  
  /** 페이지당 출력할 레코드 갯수, nowPage는 1부터 시작 */
  public int record_per_page = 4;

  /** 블럭당 페이지 수, 하나의 블럭은 10개의 페이지로 구성됨 */
  public int page_per_block = 10;
  
  public DramaCont() {
    System.out.println("-> DramaCont created.");  
  }
  
//  @GetMapping(value="/create") // http://localhost:9092/drama/create
//  @ResponseBody
//  public String create() {
//    return "<h2>Create test.</h2>";    
//  }

  // create 폼 출력
//  @GetMapping(value="/create") // http://localhost:9092/drama/create
//  public String create(Model model, DramaVO dramaVO) {
//    
//    ArrayList<DramaVO> list = this.dramaProc.list_search();
//    model.addAttribute("list", list);
//    
//    return "drama/create"; // /templates/drama/create.html
//  }
  
  /**
   * create 폼 데이터 처리
   * http://localhost:9092/drama/list_search
   * @param model
   * @param dramaVO
   * @param bindingResult
   * @return
   */
  @PostMapping(value="/create") // http://localhost:9092/drama/create
  public String create(Model model, @Valid DramaVO dramaVO, BindingResult bindingResult, 
      @RequestParam(name="word", defaultValue="") String word,
      @RequestParam(name="now_page", defaultValue="1") int now_page) {
    
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    if (bindingResult.hasErrors()) {
      // 페이징 목록
      ArrayList<DramaVO> list = this.dramaProc.list_search_paging(word, now_page, this.record_per_page);
      model.addAttribute("list", list);
      
      // 페이징 버튼 목록
      int search_count = this.dramaProc.list_search_count(word);
      String paging = this.dramaProc.pagingBox(now_page, 
          word, "drama/list_search", search_count, this.record_per_page, this.page_per_block);
      model.addAttribute("paging", paging);
      model.addAttribute("now_page", now_page);
      
      return "drama/list_search";  // /templates/drama/list_search.html
    }
    
    int cnt = this.dramaProc.create(dramaVO);
//    System.out.println("-> cnt: " + cnt);

    model.addAttribute("cnt", cnt);
    if (cnt == 1) { // 등록 성공
//      model.addAttribute("code", "create_success");
//      model.addAttribute("name", dramaVO.getName());
//      model.addAttribute("namesub", dramaVO.getNamesub());
      
      return "redirect:/drama/list_search"; // /drama/list_search.html
      
    } else { // 실패
      model.addAttribute("code", "create_fail");
      return "drama/msg"; // /templates/drama/msg.html
    }
  }
  
//  /**
//   * 등록폼 + 목록
//   * @param model
//   * @param dramaVO
//   * @return
//   */
//  @GetMapping(value="/list_search")
//  public String list_all(Model model, DramaVO dramaVO) {
//    // dramaVO.setNamesub("-"); // 폼 초기값 설정
//    
//    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
//    model.addAttribute("menu", menu);
//    
//    ArrayList<DramaVO> list = this.dramaProc.list_search();
//    model.addAttribute("list", list);
//    
//    return "drama/list_search"; // /drama/list_search.html
//  }

  /**
   * 조회 + 목록
   * @param model
   * @param dramano 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/read/{dramano}")
  public String read(Model model, 
                         @PathVariable("dramano") Integer dramano, 
                         @RequestParam(name="word", defaultValue = "") String word,
                         @RequestParam(name="now_page", defaultValue="1") int now_page) {
    
//    word = Tool.checkNull(word);
    
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    DramaVO dramaVO = this.dramaProc.read(dramano);
    model.addAttribute("dramaVO", dramaVO);
    
    // 페이징 목록
    ArrayList<DramaVO> list = this.dramaProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.dramaProc.list_search_count(word);
    String paging = this.dramaProc.pagingBox(now_page, 
        word, "/drama/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "drama/read";  // /templates/drama/read.html
    
  }
  
  /**
   * 수정폼
   * @param model
   * @param dramano 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update/{dramano}")
  public String update(Model model, 
                                @PathVariable("dramano") Integer dramano, 
                                @RequestParam(name="word", defaultValue = "") String word,
                                @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    DramaVO dramaVO = this.dramaProc.read(dramano);
    model.addAttribute("dramaVO", dramaVO);
    
    // 페이징 목록
    ArrayList<DramaVO> list = this.dramaProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.dramaProc.list_search_count(word);
    String paging = this.dramaProc.pagingBox(now_page, 
        word, "/drama/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "drama/update";  // /templates/drama/update.html
    
  }
  
  /**
   * 수정 처리
   * @param model
   * @param dramaVO
   * @param bindingResult
   * @return
   */
  @PostMapping(value="/update") // http://localhost:9092/drama/update
  public String update_process(Model model, 
                            @Valid DramaVO dramaVO, BindingResult bindingResult, 
                            @RequestParam(name="word", defaultValue = "") String word,
                            @RequestParam(name="now_page", defaultValue="1") int now_page) {
    
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    if (bindingResult.hasErrors()) {
      // 페이징 목록
      ArrayList<DramaVO> list = this.dramaProc.list_search_paging(word, now_page, this.record_per_page);
      model.addAttribute("list", list);
      
      // 페이징 버튼 목록
      int search_count = this.dramaProc.list_search_count(word);
      String paging = this.dramaProc.pagingBox(now_page, 
          word, "drama/list_search", search_count, this.record_per_page, this.page_per_block);
      model.addAttribute("paging", paging);
      model.addAttribute("now_page", now_page);
      
      return "drama/update";  // /templates/drama/update.html
    }
    
    int cnt = this.dramaProc.update(dramaVO);
//    System.out.println("-> cnt: " + cnt);

    model.addAttribute("cnt", cnt);
    if (cnt == 1) {
//      model.addAttribute("code", "update_success");
//      model.addAttribute("nation", dramaVO.getNation());
//      model.addAttribute("genre", dramaVO.getGenre());
      return "redirect:/drama/update/" + dramaVO.getDramano() + "?word=" + Tool.encode(word) + "&now_page=" + now_page;
      
    } else {
      model.addAttribute("code", "update_fail");
      return "drama/msg"; // /templates/drama/msg.html
    }

  }
  
  /**
   * Delete form
   * http://localhost:9092/drama/delete/1
   * @param model
   * @param dramano Category number to delete.
   * @return
   */
  @GetMapping(value="/delete/{dramano}")
  public String delete(Model model, 
                            @PathVariable("dramano") Integer dramano, 
                            @RequestParam(name="word", defaultValue = "") String word,
                            @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    DramaVO dramaVO = this.dramaProc.read(dramano);
    model.addAttribute("dramaVO", dramaVO);
    
    // 페이징 목록
    ArrayList<DramaVO> list = this.dramaProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.dramaProc.list_search_count(word);
    String paging = this.dramaProc.pagingBox(now_page, 
        word, "/drama/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "drama/delete";  // /templates/drama/delete.html
    
  }
  
  /**
   * Delete process
   * @param model
   * @param dramano 삭제할 레코드 번호
   * @param bindingResult
   * @return
   */
  @PostMapping(value="/delete")
  public String delete_process(Model model, Integer dramano, 
      @RequestParam(name="word", defaultValue = "") String word, 
      @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    int cnt = this.dramaProc.delete(dramano); // 삭제
    
    // ---------------------------------------------------------------------------------------------------
    // 마지막 페이지에서 모든 레코드가 삭제되면, 페이지 수(번호)를 1 감소 시켜야함.
    int search_cnt = this.dramaProc.list_search_count(word);
    if (search_cnt % this.record_per_page == 0) {
      now_page = now_page -1;
      if (now_page < 1) {
        now_page = 1; // 최소 시작 페이지
      }
    }
    // ---------------------------------------------------------------------------------------------------

    if (cnt == 1) {
//    model.addAttribute("code", "update_success");
//    model.addAttribute("nation", dramaVO.getNation());
//    model.addAttribute("genre", dramaVO.getGenre());
      return "redirect:/drama/list_search?word=" + Tool.encode(word) + "&now_page=" + now_page;
    } else {
      model.addAttribute("code", "delete_fail"); 
      return "drama/msg"; // /templates/drama/msg.html
    }
  }

  /**
   * 출력 순서 높임: seqno 10 -> 1
   * http://localhost:9092/drama/update_seqno_forward/1
   * @param model
   * @param dramano 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_seqno_forward/{dramano}")
  public String update_seqno_forward(Model model, 
                                                @PathVariable("dramano") Integer dramano, 
                                                @RequestParam(name="word", defaultValue = "") String word,
                                                @RequestParam(name="now_page", defaultValue = "1") int now_page) {

    this.dramaProc.update_seqno_forward(dramano);
    
    return "redirect:/drama/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/drama/list_search.html
    
  }

  /**
   * 출력 순서 낮춤: seqno 1 -> 10
   * http://localhost:9092/drama/update_seqno_backward/1
   * @param model
   * @param dramano 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_seqno_backward/{dramano}")
  public String update_seqno_backward(Model model, 
                                                  @PathVariable("dramano") Integer dramano, 
                                                  @RequestParam(name="word", defaultValue = "") String word,
                                                  @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    this.dramaProc.update_seqno_backward(dramano);

    return "redirect:/drama/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/drama/list_search.html
    
  }
  
  /**
   * 카테고리 공개 설정
   * http://localhost:9092/drama/update_visible_y/1
   * @param model
   * @param dramano 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_visible_y/{dramano}")
  public String update_visible_y(Model model, 
                                        @PathVariable("dramano") Integer dramano, 
                                        @RequestParam(name="word", defaultValue = "") String word,
                                        @RequestParam(name="now_page", defaultValue = "1") int now_page) {

    this.dramaProc.update_visible_y(dramano);
    
    return "redirect:/drama/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/drama/list_search.html
    
  }
  
  /**
   * 카테고리 비공개 설정
   * http://localhost:9092/drama/update_visible_n/1
   * @param model
   * @param dramano 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_visible_n/{dramano}")
  public String update_visible_n(Model model, 
                                        @PathVariable("dramano") Integer dramano, 
                                        @RequestParam(name="word", defaultValue = "") String word,
                                        @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    this.dramaProc.update_visible_n(dramano);

    return "redirect:/drama/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/drama/list_search.html
    
  }

//  /**
//   * 등록폼 + 검색 목록
//   *  http://localhost:9092/drama/list_search?word=개발 ← GET Form
//   *  http://localhost:9092/drama/list_search/개발 ← @PathVariable
//   * @param model
//   * @param dramaVO
//   * @return
//   */
//  @GetMapping(value="/list_search")
//  public String list_search(Model model, DramaVO dramaVO, String word) {
//    
//    // dramaVO.setGenre("-"); // 폼 초기값 설정
//    word = Tool.checkNull(word).trim(); // 문자열 앞 뒤 공백 제거
//    System.out.println("--> word: " + word);
//    
//    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
//    model.addAttribute("menu", menu);
//    
//    ArrayList<DramaVO> list = this.dramaProc.list_search(word);
//    model.addAttribute("list", list);
//    
//    model.addAttribute("word", word);
//    
//    return "/drama/list_search"; // /drama/list_search.html
//  }
  
  /**
   * 등록폼 + 검색 목록
   *  http://localhost:9092/drama/list_search?word=개발 ← GET Form
   *  http://localhost:9092/drama/list_search/개발 ← @PathVariable
   * @param model
   * @param dramaVO
   * @param word 검색어
   * @param now_page 현재 페이지 번호
   * @return
   */
  @GetMapping(value="/list_search")
  public String list_search(Model model, DramaVO dramaVO, String word,
                                @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    // dramaVO.setGenre("-"); // 폼 초기값 설정
    word = Tool.checkNull(word).trim(); // 문자열 앞 뒤 공백 제거
    System.out.println("--> word: " + word);
    
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    // 페이징 목록
    ArrayList<DramaVO> list = this.dramaProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.dramaProc.list_search_count(word);
    String paging = this.dramaProc.pagingBox(now_page, word, 
                         "/drama/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "drama/list_search"; // /drama/list_search.html
  }
  
}



