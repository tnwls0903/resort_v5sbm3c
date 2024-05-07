package dev.mvc.ajax;

import java.text.DecimalFormat;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ajax")
@Controller
public class PayContFetch {
  public PayContFetch() {
    System.out.println("PayContFetch created.");
  }
  
  @GetMapping(value="/pay") // http://localhost:9091/ajax/pay
  public String pay(Model model) {
    // System.out.println("-> pay");
    return "ajax/pay"; // /templates/ajax/pay.html
  }
  
  @PostMapping(value="/pay_fetch") // http://localhost:9091/ajax/pay_fetch
  @ResponseBody // JSON 객체 응답받을 때 필요
  public String pay_fetch(Model model, String id, String passwd) {
    System.out.println("-> id: " + id);
    System.out.println("-> passwd: " + passwd);
    
    try {
      Thread.sleep(3000); // 3초 시간 지연
    } catch (Exception e) {
      
    }
    
    DecimalFormat df = new DecimalFormat("#,###,### 원");
    JSONObject json = new JSONObject();
    if (id.equals("user1") && passwd.equals("1234")) { // id, passwd 일치할 경우
      json.put("code", "success");
      
      json.put("mname", "아로미");
      json.put("id", id);
      json.put("bonbong", df.format(2500000));
      json.put("sudang", df.format(500000));
      json.put("total", df.format(3000000));
    } else { // 일치 X
      json.put("code", "fail");
    }
    
    return json.toString();
  }
}
