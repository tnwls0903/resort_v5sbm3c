package dev.mvc.hotplace;

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

@RequestMapping("/hotplace")
@Controller
public class HotplaceCont {
  @Autowired
  @Qualifier("dev.mvc.hotplace.HotplaceProc")
  private HotplaceProcInter hotplaceProc;
  
  /** 페이지당 출력할 레코드 갯수, nowPage는 1부터 시작 */
  public int record_per_page = 3;

  /** 블럭당 페이지 수, 하나의 블럭은 10개의 페이지로 구성됨 */
  public int page_per_block = 10;
  
  public HotplaceCont() {
    System.out.println("-> HotplaceCont created.");  
  }
  
  /**
   * create 폼 데이터 처리
   * http://localhost:9093/hotplace/list_search
   * @param model
   * @param hotplaceVO
   * @param bindingResult
   * @return
   */
  @PostMapping(value="/create") // http://localhost:9093/hotplace/create
  public String create(Model model, @Valid HotplaceVO hotplaceVO, BindingResult bindingResult, 
      @RequestParam(name="word", defaultValue="") String word,
      @RequestParam(name="now_page", defaultValue="1") int now_page) {
    
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    if (bindingResult.hasErrors()) {
      // 페이징 목록
      ArrayList<HotplaceVO> list = this.hotplaceProc.list_search_paging(word, now_page, this.record_per_page);
      model.addAttribute("list", list);
      
      // 페이징 버튼 목록
      int search_count = this.hotplaceProc.list_search_count(word);
      String paging = this.hotplaceProc.pagingBox(now_page, 
          word, "hotplace/list_search", search_count, this.record_per_page, this.page_per_block);
      model.addAttribute("paging", paging);
      model.addAttribute("now_page", now_page);
      
      return "hotplace/list_search";  // /templates/hotplace/list_search.html
    }
    
    int cnt = this.hotplaceProc.create(hotplaceVO);
//    System.out.println("-> cnt: " + cnt);

    model.addAttribute("cnt", cnt);
    if (cnt == 1) { // 등록 성공      
      return "redirect:/hotplace/list_search"; // /hotplace/list_search.html    
    } else { // 실패
      model.addAttribute("code", "create_fail");
      return "hotplace/msg"; // /templates/hotplace/msg.html
    }
  }

  /**
   * 조회 + 목록
   * @param model
   * @param hotplaceno 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/read/{hotplaceno}")
  public String read(Model model, 
                         @PathVariable("hotplaceno") Integer hotplaceno, 
                         @RequestParam(name="word", defaultValue = "") String word,
                         @RequestParam(name="now_page", defaultValue="1") int now_page) {
    
//    word = Tool.checkNull(word);
    
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    HotplaceVO hotplaceVO = this.hotplaceProc.read(hotplaceno);
    model.addAttribute("hotplaceVO", hotplaceVO);
    
    // 페이징 목록
    ArrayList<HotplaceVO> list = this.hotplaceProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.hotplaceProc.list_search_count(word);
    String paging = this.hotplaceProc.pagingBox(now_page, 
        word, "/hotplace/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 5 - ((1 - 1) * 3) = 5
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "hotplace/read";  // /templates/hotplace/read.html
    
  }
  
  /**
   * 수정폼
   * @param model
   * @param hotplaceno 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update/{hotplaceno}")
  public String update(Model model, 
                                @PathVariable("hotplaceno") Integer hotplaceno, 
                                @RequestParam(name="word", defaultValue = "") String word,
                                @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    HotplaceVO hotplaceVO = this.hotplaceProc.read(hotplaceno);
    model.addAttribute("hotplaceVO", hotplaceVO);
    
    // 페이징 목록
    ArrayList<HotplaceVO> list = this.hotplaceProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.hotplaceProc.list_search_count(word);
    String paging = this.hotplaceProc.pagingBox(now_page, 
        word, "/hotplace/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "hotplace/update";  // /templates/hotplace/update.html
    
  }
  
  /**
   * 수정 처리
   * @param model
   * @param hotplaceVO
   * @param bindingResult
   * @return
   */
  @PostMapping(value="/update") // http://localhost:9093/hotplace/update
  public String update_process(Model model, 
                            @Valid HotplaceVO hotplaceVO, BindingResult bindingResult, 
                            @RequestParam(name="word", defaultValue = "") String word,
                            @RequestParam(name="now_page", defaultValue="1") int now_page) {
    
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    if (bindingResult.hasErrors()) {
      // 페이징 목록
      ArrayList<HotplaceVO> list = this.hotplaceProc.list_search_paging(word, now_page, this.record_per_page);
      model.addAttribute("list", list);
      
      // 페이징 버튼 목록
      int search_count = this.hotplaceProc.list_search_count(word);
      String paging = this.hotplaceProc.pagingBox(now_page, 
          word, "hotplace/list_search", search_count, this.record_per_page, this.page_per_block);
      model.addAttribute("paging", paging);
      model.addAttribute("now_page", now_page);
      
      return "hotplace/update";  // /templates/hotplace/update.html
    }
    
    int cnt = this.hotplaceProc.update(hotplaceVO);
//    System.out.println("-> cnt: " + cnt);

    model.addAttribute("cnt", cnt);
    if (cnt == 1) {
      return "redirect:/hotplace/update/" + hotplaceVO.getHotplaceno() + "?word=" + Tool.encode(word) + "&now_page=" + now_page;
      
    } else {
      model.addAttribute("code", "update_fail");
      return "hotplace/msg"; // /templates/hotplace/msg.html
    }

  }
  
  /**
   * Delete form
   * http://localhost:9093/hotplace/delete/1
   * @param model
   * @param hotplaceno Category number to delete.
   * @return
   */
  @GetMapping(value="/hotplace/{hotplaceno}")
  public String delete(Model model, 
                            @PathVariable("hotplaceno") Integer hotplaceno, 
                            @RequestParam(name="word", defaultValue = "") String word,
                            @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    HotplaceVO hotplaceVO = this.hotplaceProc.read(hotplaceno);
    model.addAttribute("hotplaceVO", hotplaceVO);
    
    // 페이징 목록
    ArrayList<HotplaceVO> list = this.hotplaceProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.hotplaceProc.list_search_count(word);
    String paging = this.hotplaceProc.pagingBox(now_page, 
        word, "/hotplace/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "hotplace/delete";  // /templates/hotplace/delete.html
    
  }
  
  /**
   * Delete process
   * @param model
   * @param hotplaceno 삭제할 레코드 번호
   * @param bindingResult
   * @return
   */
  @PostMapping(value="/delete")
  public String delete_process(Model model, Integer hotplaceno, 
      @RequestParam(name="word", defaultValue = "") String word, 
      @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    int cnt = this.hotplaceProc.delete(hotplaceno); // 삭제
    
    // ---------------------------------------------------------------------------------------------------
    // 마지막 페이지에서 모든 레코드가 삭제되면, 페이지 수(번호)를 1 감소 시켜야함.
    int search_cnt = this.hotplaceProc.list_search_count(word);
    if (search_cnt % this.record_per_page == 0) {
      now_page = now_page -1;
      if (now_page < 1) {
        now_page = 1; // 최소 시작 페이지
      }
    }
    // ---------------------------------------------------------------------------------------------------

    if (cnt == 1) {
//    model.addAttribute("code", "update_success");
//    model.addAttribute("nation", hotplaceVO.getNation());
//    model.addAttribute("genre", hotplaceVO.getGenre());
      return "redirect:/hotplace/list_search?word=" + Tool.encode(word) + "&now_page=" + now_page;
    } else {
      model.addAttribute("code", "delete_fail"); 
      return "hotplace/msg"; // /templates/hotplace/msg.html
    }
  }

  /**
   * 출력 순서 높임: seqno 10 -> 1
   * http://localhost:9093/hotplace/update_seqno_forward/1
   * @param model
   * @param hotplaceno 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_seqno_forward/{hotplaceno}")
  public String update_seqno_forward(Model model, 
                                                @PathVariable("hotplaceno") Integer hotplaceno, 
                                                @RequestParam(name="word", defaultValue = "") String word,
                                                @RequestParam(name="now_page", defaultValue = "1") int now_page) {

    this.hotplaceProc.update_seqno_forward(hotplaceno);
    
    return "redirect:/hotplace/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/hotplace/list_search.html
    
  }

  /**
   * 출력 순서 낮춤: seqno 1 -> 10
   * http://localhost:9093/hotplace/update_seqno_backward/1
   * @param model
   * @param hotplaceno 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_seqno_backward/{hotplaceno}")
  public String update_seqno_backward(Model model, 
                                                  @PathVariable("hotplaceno") Integer hotplaceno, 
                                                  @RequestParam(name="word", defaultValue = "") String word,
                                                  @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    this.hotplaceProc.update_seqno_backward(hotplaceno);

    return "redirect:/hotplace/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/hotplace/list_search.html
    
  }
  
  /**
   * 카테고리 공개 설정
   * http://localhost:9093/hotplace/update_visible_y/1
   * @param model
   * @param hotplaceno 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_visible_y/{hotplaceno}")
  public String update_visible_y(Model model, 
                                        @PathVariable("hotplaceno") Integer hotplaceno, 
                                        @RequestParam(name="word", defaultValue = "") String word,
                                        @RequestParam(name="now_page", defaultValue = "1") int now_page) {

    this.hotplaceProc.update_visible_y(hotplaceno);
    
    return "redirect:/hotplace/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/hotplace/list_search.html
    
  }
  
  /**
   * 카테고리 비공개 설정
   * http://localhost:9093/hotplace/update_visible_n/1
   * @param model
   * @param hotplaceno 조회할 카테고리 번호
   * @return
   */
  @GetMapping(value="/update_visible_n/{hotplaceno}")
  public String update_visible_n(Model model, 
                                        @PathVariable("hotplaceno") Integer hotplaceno, 
                                        @RequestParam(name="word", defaultValue = "") String word,
                                        @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    this.hotplaceProc.update_visible_n(hotplaceno);

    return "redirect:/hotplace/list_search?word=" + Tool.encode(word)  + "&now_page=" + now_page;  // /templates/hotplace/list_search.html
    
  }
  
  /**
   * 등록폼 + 검색 목록
   *  http://localhost:9093/hotplace/list_search?word=개발 ← GET Form
   *  http://localhost:9093/hotplace/list_search/개발 ← @PathVariable
   * @param model
   * @param hotplaceVO
   * @param word 검색어
   * @param now_page 현재 페이지 번호
   * @return
   */
  @GetMapping(value="/list_search")
  public String list_search(Model model, HotplaceVO hotplaceVO, String word,
                                @RequestParam(name="now_page", defaultValue = "1") int now_page) {
    
    // hotplaceVO.setGenre("-"); // 폼 초기값 설정
    word = Tool.checkNull(word).trim(); // 문자열 앞 뒤 공백 제거
    System.out.println("--> word: " + word);
    
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    // 페이징 목록
    ArrayList<HotplaceVO> list = this.hotplaceProc.list_search_paging(word, now_page, this.record_per_page);
    model.addAttribute("list", list);
    
    // 페이징 버튼 목록
    int search_count = this.hotplaceProc.list_search_count(word);
    String paging = this.hotplaceProc.pagingBox(now_page, word, 
                         "/hotplace/list_search", search_count, this.record_per_page, this.page_per_block);
    model.addAttribute("paging", paging);
    model.addAttribute("now_page", now_page);
    
    model.addAttribute("word", word);
    
    // 일련번호 생성: 레코드 갯수 - ((현재 페이지수 -1) * 페이지당 레코드 수): 7 - ((1 - 1) * 3) = 7
    int no = search_count - ((now_page -1) * this.record_per_page);
    model.addAttribute("no", no);
    
    return "hotplace/list_search"; // /hotplace/list_search.html
  }
  
}



