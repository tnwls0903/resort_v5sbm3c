package dev.mvc.ajax;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ajax")
@Controller
public class JSONContFetch {
  public JSONContFetch() {
    System.out.println("-> JSONContFetch created.");
  }

  @GetMapping(value="/fetch") // http://localhost:9091/ajax/fetch
  public String fetch(Model model) {
    // System.out.println("-> fetch");
    return "ajax/fetch"; // /templates/ajax/fetch.html
  }
  
  // 하나의 JSON 객체 출력
  @GetMapping(value="/fetch_object")
  @ResponseBody
  public String object1() {
    try {
      Thread.sleep(3000); // 3 초
    } catch (Exception e) {

    }
    
    /* 
     { 
     "no": 1,
     "name": "캐스퍼",
     "price": 7000000,
     "grade": true
     }
     */
    JSONObject object = new JSONObject();
    object.put("no", 1);
    object.put("name", "캐스퍼");
    object.put("price", 7000000);
    object.put("grade", true);
    
    return object.toString();
  }
  
  // JSON 배열
  @GetMapping(value="/fetch_array")
  @ResponseBody
  public String array1() {
    try {
      Thread.sleep(3000); // 3 초
    } catch (Exception e) {

    }
    
    JSONArray array = new JSONArray();
    array.put("모닝");
    array.put("스파크");
    array.put("트렉스");
    array.put("베뉴");
    array.put("니로");
    return array.toString();
  }
  
  // JSON 객체 배열
  @GetMapping(value="/fetch_array2")
  @ResponseBody
  public String array2() {
    try {
      Thread.sleep(3000); // 3 초
    } catch (Exception e) {

    }
    
    /*
     [
     {"no":1,"price":7000000,"grade":true,"name":"모닝"},
     {"no":2,"price":13000000,"grade":true,"name":"캐스퍼"},
     {"no":3,"price":16000000,"grade":true,"name":"트렉스"}
     ]
     * */
    JSONArray array = new JSONArray();
    
    JSONObject object = new JSONObject();
    object.put("no", 1);
    object.put("name", "모닝");
    object.put("price", 7000000);
    object.put("grade", true);
    
    array.put(object);
    
    object = new JSONObject();
    object.put("no", 2);
    object.put("name", "캐스퍼");
    object.put("price", 13000000);
    object.put("grade", true);
    
    array.put(object);
    
    object = new JSONObject();
    object.put("no", 3);
    object.put("name", "트렉스");
    object.put("price", 16000000);
    object.put("grade", true);
    
    array.put(object);
    
    return array.toString();
  }
    
}
