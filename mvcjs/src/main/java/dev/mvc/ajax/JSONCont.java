package dev.mvc.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/json")
@Controller
public class JSONCont {
  public JSONCont() {
    System.out.println("-> JSONCont created.");
  }
  
  // 하나의 JSON 객체 출력
  @GetMapping(value="/object1") // http://localhost:9091/json/object1
  @ResponseBody
  public String object1() {
    String object = "";
    /*
      {
      "no": 1,
      "name": "모닝",
      "price": 7000000,
      "grade": true
      }
    */
    object += "{";
    object += "\"no\": 1,";
    object += "\"name\": \"모닝\",";
    object += "\"price\": 7000000,";
    object += "\"grade\": true";
    object += "}";
    
    return object;
  }
  
  // JSON 배열 출력
  @GetMapping(value="/array1") // http://localhost:9091/json/array1
  @ResponseBody
  public String array1() {
    String array = "";
    /* 
      ["모닝", "스파크", "트렉스"]
    */ 
    array = "[\"모닝\", \"스파크\", \"트렉스\"]";
    
    return array;
  }
}
