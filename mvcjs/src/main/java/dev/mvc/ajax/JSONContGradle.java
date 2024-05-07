package dev.mvc.ajax;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("jsonlib")
@Controller
public class JSONContGradle {
  public JSONContGradle() {
    System.out.println("-> JSONContGradle created.");
  }
  
  // 하나의 JSON 객체 출력
  @GetMapping(value="/object1") // http://localhost:9091/jsonlib/object1
  @ResponseBody
  public String object1() {
    /*
      {
      "no": 1,
      "name": "모닝",
      "price": 7000000,
      "grade": true
      }
    */
    JSONObject object = new JSONObject();
    object.put("no", 1);
    object.put("name",  "캐스퍼");
    object.put("price", 7000000);
    object.put("grade", true);
    
    return object.toString();
  }
  
  // JSON 배열 출력
  @GetMapping(value="/array1") // http://localhost:9091/jsonlib/array1
  @ResponseBody
  public String array1() {
    /* 
    ["모닝", "스파크", "트렉스"]
     */
    JSONArray array = new JSONArray();
    array.put("모닝");
    array.put("스파크");
    array.put("트렉스");
    array.put("기종");
    array.put("메뉴");
    
    return array.toString();
  }
  
//JSON 배열 출력
 @GetMapping(value="/array2") // http://localhost:9091/jsonlib/array2
 @ResponseBody
 public String array2() {
   /*
    [
    {"no":1,"price":7000000,"grade":true,"name":"캐스퍼"},
    {"no":2,"price":9000000,"grade":true,"name":"레이"},
    {"no":3,"price":6000000,"grade":true,"name":"모닝"}
    ]
  */
   JSONObject object = new JSONObject();
   JSONArray array = new JSONArray();
   
   object.put("no", 1);
   object.put("name",  "캐스퍼");
   object.put("price", 7000000);
   object.put("grade", true); 
   array.put(object);
   
   object = new JSONObject();
   object.put("no", 2);
   object.put("name",  "레이");
   object.put("price", 9000000);
   object.put("grade", true); 
   array.put(object);
   
   object = new JSONObject();
   object.put("no", 3);
   object.put("name",  "모닝");
   object.put("price", 6000000);
   object.put("grade", true); 
   array.put(object);
   
   return array.toString();
 } 
}
