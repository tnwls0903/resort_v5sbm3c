package dev.mvc.member;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.mvc.tool.Security;
import dev.mvc.tool.Tool;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
public class MemberCont {
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")  // @Service("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  
  @Autowired
  Security security;
  
  public MemberCont() {
    System.out.println("-> MemberCont created.");  
  }
  
  @GetMapping(value="/checkID") // http://localhost:9091/member/checkID?id=admin
  @ResponseBody
  public String checkID(String id) {
    System.out.println("-> id: " + id);
    int cnt = this.memberProc.checkID(id);
    
    // return "cnt: " + cnt;
    // return "{\"cnt\": " + cnt + "}";    // {"cnt": 1} JSON
    
    JSONObject obj = new JSONObject();
    obj.put("cnt", cnt);
    
    return obj.toString();
  }
  
  /**
   * 회원 가입 폼
   * @param model
   * @param memberVO
   * @return
   */
  @GetMapping(value="/create") // http://localhost:9091/member/create
  public String create_form(Model model, MemberVO memberVO) {
    return "member/create";    // /template/member/create.html
  }
  
  @PostMapping(value="/create")
  public String create_proc(Model model, MemberVO memberVO) {
    int checkID_cnt = this.memberProc.checkID(memberVO.getId());
    
    if (checkID_cnt == 0) {
      memberVO.setGrade(15); // 기본 회원 15
      int cnt = this.memberProc.create(memberVO);
      
      if (cnt == 1) {
        model.addAttribute("code", "create_success");
        model.addAttribute("mname", memberVO.getMname());
        model.addAttribute("id", memberVO.getId());
      } else {
        model.addAttribute("code", "create_fail");
      }
      
      model.addAttribute("cnt", cnt);
    } else { // id 중복
      model.addAttribute("code", "duplicte_fail");
      model.addAttribute("cnt", 0);
    }
    
    return "member/msg"; // /templates/member/msg.html
  }
  
  @GetMapping(value="/list")
  public String list(HttpSession session, Model model) {
    
    if (this.memberProc.isMemberAdmin(session)) {
      ArrayList<MemberVO> list = this.memberProc.list();
      
      model.addAttribute("list", list);
      
      return "member/list";  // templates/member/list.html
    } else {
      return "redirect:/member/login_need_form";  // redirect
    }

  }
  
  /**
   * 조회 폼
   * @param model
   * @param memberno 회원 번호
   * @return 회원 정보
   */
  @GetMapping(value="/read")
  public String read(HttpSession session, Model model, int memberno) {
    // 회원은 회원 등급만 처리, 관리자: 1 ~ 10, 사용자: 11 ~ 20
    // int gradeno = this.memberProc.read(memberno).getGrade(); // 등급 번호
    String grade = (String)session.getAttribute("grade"); // 등급: admin, member, guest
    
    // 사용자: member && 11 ~ 20
    // if (grade.equals("member") && (gradeno >= 11 && gradeno <= 20) && memberno == (int)session.getAttribute("memberno")) {
    if (grade.equals("member") &&  memberno == (int)session.getAttribute("memberno")) {
      System.out.println("-> read memberno: " + memberno);
      
      MemberVO memberVO = this.memberProc.read(memberno);
      model.addAttribute("memberVO", memberVO);
      
      return "member/read";  // templates/member/read.html
      
    } else if (grade.equals("admin")) {
      System.out.println("-> read memberno: " + memberno);
      
      MemberVO memberVO = this.memberProc.read(memberno);
      model.addAttribute("memberVO", memberVO);
      
      return "member/read";  // templates/member/read.html
    } else {
      return "redirect:/member/login_need_form";  // redirect
    }
    
  }
  
  /**
   * 수정 처리
   * @param model
   * @param memberVO
   * @return
   */
  @PostMapping(value="/update")
  public String update_proc(Model model, MemberVO memberVO) {
    int cnt = this.memberProc.update(memberVO); // 수정
    
    if (cnt == 1) {
      model.addAttribute("code", "update_success");
      model.addAttribute("mname", memberVO.getMname());
      model.addAttribute("id", memberVO.getId());
    } else {
      model.addAttribute("code", "update_fail");
    }
    
    model.addAttribute("cnt", cnt);
    
    return "member/msg"; // /templates/member/msg.html
  }
  
  /**
   * 삭제 폼
   * @param model
   * @param memberno 회원 번호
   * @return 회원 정보
   */
  @GetMapping(value="/delete")
  public String delete(Model model, int memberno) {
    System.out.println("-> delete memberno: " + memberno);
    
    MemberVO memberVO = this.memberProc.read(memberno);
    model.addAttribute("memberVO", memberVO);
    
    return "member/delete";  // templates/member/delete.html
  }
  
  /**
   * 회원 Delete process
   * @param model
   * @param memberno 삭제할 레코드 번호
   * @return
   */
  @PostMapping(value="/delete")
  public String delete_process(Model model, Integer memberno) {
    int cnt = this.memberProc.delete(memberno);
    
    if (cnt == 1) {
      return "redirect:/member/list";
    } else {
      model.addAttribute("code", "delete_fail");
      return "member/msg"; // /templates/member/msg.html
    }
  }
  
//  /**
//   * 로그인
//   * @param model
//   * @param memberno 회원 번호
//   * @return 회원 정보
//   */
//  @GetMapping(value="/login")
//  public String login_form(Model model) {
//    return "member/login";  // templates/member/login.html
//  }
  
//  /**
//   * 로그인 처리
//   * @param model
//   * @param memberno 회원 번호
//   * @return 회원 정보
//   */
//  @PostMapping(value="/login")
//  public String login_proc(HttpSession session, Model model, String id, String passwd) {
//    HashMap<String, Object> map = new HashMap<String, Object>();
//    map.put("id", id);
//    map.put("passwd", passwd);
//    
//    int cnt = this.memberProc.login(map);
//    System.out.println("-> login_proc cnt: " + cnt);
//    
//    model.addAttribute("cnt", cnt);
//    
//    if (cnt == 1) {
//      // id를 이용하여 회원 정보 조회
//      MemberVO memverVO = this.memberProc.readById(id);
//      session.setAttribute("memberno", memverVO.getMemberno());
//      session.setAttribute("id", memverVO.getId());
//      session.setAttribute("mname", memverVO.getMname());
//      session.setAttribute("grade", memverVO.getGrade());
//      
//      return "redirect:/";
//    } else {
//      model.addAttribute("code", "login_fail");
//      return "member/msg";
//    }
//    
//  }
  
  /**
   * 로그아웃
   * @param model
   * @param memberno 회원 번호
   * @return 회원 정보
   */
  @GetMapping(value="/logout")
  public String logout(HttpSession session, Model model) {
    session.invalidate();  // 모든 세션 변수 삭제
    return "redirect:/";
  }
  
  // ----------------------------------------------------------------------------------
  // Cookie 사용 로그인 관련 코드 시작
  // ----------------------------------------------------------------------------------
  /**
   * 로그인 폼
   * @param model
   * @param memberno 회원 번호
   * @return 회원 정보
   */
  @GetMapping(value="/login")
  public String login_form(Model model, HttpServletRequest request) {
    // Cookie 관련 코드---------------------------------------------------------
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
  
    String ck_id = ""; // id 저장
    String ck_id_save = ""; // id 저장 여부를 체크
    String ck_passwd = ""; // passwd 저장
    String ck_passwd_save = ""; // passwd 저장 여부를 체크
  
    if (cookies != null) { // 쿠키가 존재한다면
      for (int i=0; i < cookies.length; i++){
        cookie = cookies[i]; // 쿠키 객체 추출
      
        if (cookie.getName().equals("ck_id")){
          ck_id = cookie.getValue();  // email
        }else if(cookie.getName().equals("ck_id_save")){
          ck_id_save = cookie.getValue();  // Y, N
        }else if (cookie.getName().equals("ck_passwd")){
          ck_passwd = cookie.getValue();         // 1234
        }else if(cookie.getName().equals("ck_passwd_save")){
          ck_passwd_save = cookie.getValue();  // Y, N
        }
      }
    }
    // ----------------------------------------------------------------------------
    
    //    <input type='text' class="form-control" name='id' id='id' 
    //            th:value='${ck_id }' required="required" 
    //            style='width: 30%;' placeholder="아이디" autofocus="autofocus">
    model.addAttribute("ck_id", ck_id);
  
    //    <input type='checkbox' name='id_save' value='Y' 
    //            th:checked="${ck_id_save == 'Y'}"> 저장
    model.addAttribute("ck_id_save", ck_id_save);
  
    model.addAttribute("ck_passwd", ck_passwd);
    model.addAttribute("ck_passwd_save", ck_passwd_save);

//    model.addAttribute("ck_id_save", "Y");
//    model.addAttribute("ck_passwd_save", "Y");
    
    return "member/login_cookie";  // templates/member/login_cookie.html
  }

  /**
   * Cookie 기반 로그인 처리
   * @param session
   * @param request
   * @param response
   * @param model
   * @param id 아이디
   * @param passwd 패스워드
   * @param id_save 아이디 저장 여부
   * @param passwd_save 패스워드 저장 여부
   * @return
   */
  @PostMapping(value="/login")
  public String login_proc(HttpSession session,
                                     HttpServletRequest request,
                                     HttpServletResponse response,
                                     Model model, 
                                     String id, 
                                     String passwd,
                                     @RequestParam(value="id_save", defaultValue = "") String id_save,
                                     @RequestParam(value="passwd_save", defaultValue = "") String passwd_save
                                     ) {
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("id", id);
    // map.put("passwd", new Security().aesEncode(passwd));
    map.put("passwd", this.security.aesEncode(passwd));
    
    int cnt = this.memberProc.login(map);
    System.out.println("-> login_proc cnt: " + cnt);
    
    model.addAttribute("cnt", cnt);
    
    if (cnt == 1) {
      // id를 이용하여 회원 정보 조회
      MemberVO memverVO = this.memberProc.readById(id);
      session.setAttribute("memberno", memverVO.getMemberno());      
      // int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기

      session.setAttribute("id", memverVO.getId());
      session.setAttribute("mname", memverVO.getMname());
      // session.setAttribute("grade", memverVO.getGrade());
      
      if (memverVO.getGrade() >= 1 && memverVO.getGrade() <= 10) {
        session.setAttribute("grade", "admin");
      } else if (memverVO.getGrade() >= 11 && memverVO.getGrade() <= 20) {
        session.setAttribute("grade", "member");
      } else if (memverVO.getGrade() >= 21) {
        session.setAttribute("grade", "guest");
      }
      
      // Cookie 관련 코드---------------------------------------------------------
      // -------------------------------------------------------------------
      // id 관련 쿠기 저장
      // -------------------------------------------------------------------
      if (id_save.equals("Y")) { // id를 저장할 경우, Checkbox를 체크한 경우
        Cookie ck_id = new Cookie("ck_id", id);
        ck_id.setPath("/");  // root 폴더에 쿠키를 기록함으로 모든 경로에서 쿠기 접근 가능
        ck_id.setMaxAge(60 * 60 * 24 * 30); // 30 day, 초단위
        response.addCookie(ck_id); // id 저장
      } else { // N, id를 저장하지 않는 경우, Checkbox를 체크 해제한 경우
        Cookie ck_id = new Cookie("ck_id", "");
        ck_id.setPath("/");
        ck_id.setMaxAge(0);
        response.addCookie(ck_id); // id 저장
      }
      
      // id를 저장할지 선택하는  CheckBox 체크 여부
      Cookie ck_id_save = new Cookie("ck_id_save", id_save);
      ck_id_save.setPath("/");
      ck_id_save.setMaxAge(60 * 60 * 24 * 30); // 30 day
      response.addCookie(ck_id_save);
      // -------------------------------------------------------------------
  
      // -------------------------------------------------------------------
      // Password 관련 쿠기 저장
      // -------------------------------------------------------------------
      if (passwd_save.equals("Y")) { // 패스워드 저장할 경우
        Cookie ck_passwd = new Cookie("ck_passwd", passwd);
        ck_passwd.setPath("/");
        ck_passwd.setMaxAge(60 * 60 * 24 * 30); // 30 day
        response.addCookie(ck_passwd);
      } else { // N, 패스워드를 저장하지 않을 경우
        Cookie ck_passwd = new Cookie("ck_passwd", "");
        ck_passwd.setPath("/");
        ck_passwd.setMaxAge(0);
        response.addCookie(ck_passwd);
      }
      // passwd를 저장할지 선택하는  CheckBox 체크 여부
      Cookie ck_passwd_save = new Cookie("ck_passwd_save", passwd_save);
      ck_passwd_save.setPath("/");
      ck_passwd_save.setMaxAge(60 * 60 * 24 * 30); // 30 day
      response.addCookie(ck_passwd_save);
      // -------------------------------------------------------------------
      // ----------------------------------------------------------------------------     
      
      return "redirect:/";
    } else {
      model.addAttribute("code", "login_fail");
      return "member/msg";
    }
  }
  
  /**
   * 로그인 요구에 따른 로그인 폼 출력 
   * @param model
   * @param memberno 회원 번호
   * @return 회원 정보
   */
  @GetMapping(value="/login_need_form")
  public String login_need_form(Model model, HttpServletRequest request) {
    // Cookie 관련 코드---------------------------------------------------------
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
  
    String ck_id = ""; // id 저장
    String ck_id_save = ""; // id 저장 여부를 체크
    String ck_passwd = ""; // passwd 저장
    String ck_passwd_save = ""; // passwd 저장 여부를 체크
  
    if (cookies != null) { // 쿠키가 존재한다면
      for (int i=0; i < cookies.length; i++){
        cookie = cookies[i]; // 쿠키 객체 추출
      
        if (cookie.getName().equals("ck_id")){
          ck_id = cookie.getValue();  // email
        }else if(cookie.getName().equals("ck_id_save")){
          ck_id_save = cookie.getValue();  // Y, N
        }else if (cookie.getName().equals("ck_passwd")){
          ck_passwd = cookie.getValue();         // 1234
        }else if(cookie.getName().equals("ck_passwd_save")){
          ck_passwd_save = cookie.getValue();  // Y, N
        }
      }
    }
    // ----------------------------------------------------------------------------
    
    //    <input type='text' class="form-control" name='id' id='id' 
    //            th:value='${ck_id }' required="required" 
    //            style='width: 30%;' placeholder="아이디" autofocus="autofocus">
    model.addAttribute("ck_id", ck_id);
  
    //    <input type='checkbox' name='id_save' value='Y' 
    //            th:checked="${ck_id_save == 'Y'}"> 저장
    model.addAttribute("ck_id_save", ck_id_save);
  
    model.addAttribute("ck_passwd", ck_passwd);
    model.addAttribute("ck_passwd_save", ck_passwd_save);

//    model.addAttribute("ck_id_save", "Y");
//    model.addAttribute("ck_passwd_save", "Y");
    
    return "member/login_cookie_need";  // templates/member/login_cookie_need.html
  }

  
  // ----------------------------------------------------------------------------------
  // Cookie 사용 로그인 관련 코드 종료
  // ----------------------------------------------------------------------------------
  
  /**
   * 패스워드 수정 폼
   * @param model
   * @param memberno
   * @return
   */
  @GetMapping(value="/passwd_update_form")
  public String passwd_update_form(HttpSession session, Model model) {
    int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기
    
    MemberVO memberVO = this.memberProc.read(memberno);
    
    model.addAttribute("memberVO", memberVO);
    
    return "member/passwd_update_form"; // /member/passwd_update_form.html   
  }
  
  /**
   * 현재 패스워드 확인
   * @param session
   * @param current_passwd
   * @return 1: 일치, 0: 불일치
   */
  @PostMapping(value="/passwd_check")
  @ResponseBody
  public String passwd_check(HttpSession session, @RequestBody String json_src) {
    System.out.println("-> json_src: " + json_src); // json_src: {"current_passwd":"1234"}
    JSONObject src = new JSONObject(json_src); // String -> JSON
    String current_passwd =  (String)src.get("current_passwd"); // 값 가져오기
    // System.out.println("-> current_passwd: " + current_passwd);
    
    try {
      Thread.sleep(3000);
    } catch(Exception e) {
      
    }
    
    int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("memberno", memberno);
    // map.put("passwd", new Security().aesEncode(current_passwd));
    map.put("passwd", this.security.aesEncode(current_passwd));
    
    int cnt = this.memberProc.passwd_check(map);
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    System.out.println(json.toString());
    
    return json.toString();   
  }
  
  /**
   * 패스워드 변경 처리
   * http://localhost:9091/member/passwd_update_proc?current_passwd=00000000000&passwd=7777
   * @param session
   * @param model
   * @param current_passwd 현재 패스워드
   * @param passwd 새로운 패스워드
   * @return
   */
  @PostMapping(value="/passwd_update_proc")
  public String passwd_update_proc(HttpSession session, 
                                                    Model model, 
                                                    String current_passwd, 
                                                    String passwd) {
    
    if (this.memberProc.isMember(session)) {
      int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("memberno", memberno);
      // map.put("passwd", new Security().aesEncode(current_passwd)); // 현재 패스워드 이름 주의
      map.put("passwd", this.security.aesEncode(current_passwd)); // 현재 패스워드 이름 주의
      
      // System.out.println("-> passwd_update_proc current_passwd: " + current_passwd);
      // Form 없이 해커가 해킹 했을 경우를 대비하여 다시 패스워드 검사
      int cnt = this.memberProc.passwd_check(map); 
      
      if (cnt == 0) { // 현재 패스워드 불일치
        model.addAttribute("code", "passwd_not_equal");
        model.addAttribute("cnt", 0);
        
      } else { // 현재 패스워드 일치
        HashMap<String, Object> map_new_passwd = new HashMap<String, Object>();
        map_new_passwd.put("memberno", memberno);
        // map_new_passwd.put("passwd", new Security().aesEncode(passwd)); // 새로운 패스워드
        map_new_passwd.put("passwd", this.security.aesEncode(passwd)); // 새로운 패스워드
        // System.out.println("-> passwd_update_proc passwd 변경: " + passwd);
        
        int passwd_change_cnt = this.memberProc.passwd_update(map_new_passwd);
        
        if (passwd_change_cnt == 1) {
          model.addAttribute("code", "passwd_change_success");
          model.addAttribute("cnt", 1);
        } else {
          model.addAttribute("code", "passwd_change_fail");
          model.addAttribute("cnt", 0);
        }
      }

      return "member/msg";   // /templates/member/msg.html
    } else {
      return "redirect:/member/login_need_form";
    }

  }
  
  /**
   * 등급 변경 폼
   * @param session
   * @param model
   * @return
   */
  @GetMapping(value="/grade_update_form")
  public String grade_update_form(HttpSession session, Model model) {
    
    if (this.memberProc.isMemberAdmin(session)) {
      int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기
      
      MemberVO memberVO = this.memberProc.read(memberno);
      
      model.addAttribute("memberVO", memberVO);
          
      return "member/grade_update_form"; // /member/grade_update.html   
    } else {
      return "redirect:/member/login_need_form";  // redirect
    }

  }
  
  /**
   * 현재 등급 확인
   * @param session
   * @param current_grade
   * @return 1: 일치, 0: 불일치
   */
  @PostMapping(value="/grade_check")
  @ResponseBody
  public String grade_check(HttpSession session, @RequestBody String json_src) {
    System.out.println("-> json_src: " + json_src); // json_src: {"current_grade":"16"}
    JSONObject src = new JSONObject(json_src); // String -> JSON
    String current_grade = (String)src.get("current_grade"); // 값 가져오기
    System.out.println("-> current_grade: " + current_grade);
    
    try {
      Thread.sleep(3000);
    } catch(Exception e) {
      
    }
    
    int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("memberno", memberno);
    map.put("grade", current_grade);
    
    int cnt = this.memberProc.grade_check(map);
    
    JSONObject json = new JSONObject();
    json.put("cnt", cnt);
    System.out.println(json.toString());
    
    return json.toString();   
  }
  
  /**
   * 등급 변경 처리
   * @param session
   * @param model
   * @param current_grade 현재 등급
   * @param grade 새로운 등급
   * @return
   */
  @PostMapping(value="/grade_update_proc")
  public String grade_update_process(HttpSession session, 
                                                    Model model, 
                                                    int current_grade, 
                                                    int grade) {
    int memberno = (int)session.getAttribute("memberno"); // session에서 가져오기

    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("memberno", memberno);
    map.put("grade", current_grade); // 현재 등급 이름 주의
    
    // System.out.println("-> grade_update_process of current_grade: " + current_grade);
    // Form 없이 해커가 해킹 했을 경우를 대비하여 다시 등급 검사
    int cnt = this.memberProc.grade_check(map);
    
    if (cnt == 0) { // 현재 등급 불일치, 실패
      model.addAttribute("code", "grade_not_equal");
      model.addAttribute("code", "memberno_not_exist");
      model.addAttribute("cnt", 0);
    } else { // 현재 등급 불일치, 1차 성공
      HashMap<String, Object> map_new_grade= new HashMap<String, Object>();
      map_new_grade.put("memberno", memberno);
      map_new_grade.put("grade", grade); // 새로운 등급
      // System.out.println("-> grade_update_process of grade 변경: " + grade);
      
      int grade_change_cnt = this.memberProc.grade_update(map_new_grade);
      
      if (grade_change_cnt == 1) { // 2차 성공, 마무리.
        model.addAttribute("code", "grade_change_success");
        model.addAttribute("cnt", 1);
      } else { // 실패
        model.addAttribute("code", "grade_change_fail");
        model.addAttribute("cnt", 0);
      }
    }

    return "member/msg";   // /templates/member/msg.html
  }
  
}













