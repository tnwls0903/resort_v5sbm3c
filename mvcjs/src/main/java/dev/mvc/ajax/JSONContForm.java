package dev.mvc.ajax;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ajax")
@Controller
public class JSONContForm {
  public JSONContForm() {
    System.out.println("JSONContForm created.");
  }
  
  @GetMapping(value="/select_food_fetch") // http://localhost:9091/ajax/select_food_fetch
  public String select_food_fetch(Model model) {
    
    ArrayList<FoodVO> foods = new ArrayList<FoodVO>();
    
    foods.add(new  FoodVO(1, "김밥 천국"));
    foods.add(new  FoodVO(2, "종로 짬뽕"));
    foods.add(new  FoodVO(3, "남산 한정식"));
    foods.add(new  FoodVO(4, "탄도항 횟집"));
    foods.add(new  FoodVO(5, "남산 돈까스"));
    model.addAttribute("foods", foods);
    
    return "ajax/select_food_fetch"; // /templates/ajax/select_food_fetch.html
  }
  
  @GetMapping(value="/select_menu_fetch") // http://localhost:9091/ajax/selct_menu_fetch
  @ResponseBody
  public String selct_menu_fetch(Model model, int foodno) {
    System.out.println("-> foodno: " + foodno);
    
    try {
      Thread.sleep(3000); // 3초 시간 지연
    } catch (Exception e) {
      
    }
    
    DecimalFormat df = new DecimalFormat("#,###,### 원");
    
    // ArrayList<MenuVO> menus = new ArrayList<MenuVO>();
    JSONArray menus = new JSONArray();
    JSONObject menu = null;
    
    if (foodno == 1) { // 김밥 천국
      menu = new JSONObject();
      menu.put("menuno", 1);
      menu.put("name", "라면");
      menu.put("price", df.format(4000));
      menus.put(menu);
      
      menu = new JSONObject();
      menu.put("menuno", 2);
      menu.put("name", "김밥");
      menu.put("price", df.format(3000));
      menus.put(menu);
      
      menu = new JSONObject();
      menu.put("menuno", 3);
      menu.put("name", "만두");
      menu.put("price", df.format(5000));
      menus.put(menu);
      
    } else if (foodno == 2) { // 종로 짬뽕
      menu = new JSONObject();
      menu.put("menuno", 4);
      menu.put("name", "짬뽕");
      menu.put("price", df.format(8000));
      menus.put(menu);

      menu = new JSONObject();
      menu.put("menuno", 5);
      menu.put("name", "짜장면");
      menu.put("price", df.format(7000));
      menus.put(menu);
      
      menu = new JSONObject();
      menu.put("menuno", 6);
      menu.put("name", "탕수육");
      menu.put("price", df.format(18000));
      menus.put(menu);

    } else if (foodno == 3) { // 남산 한정식
      menu = new JSONObject();
      menu.put("menuno", 7);
      menu.put("name", "VIP 한정식");
      menu.put("price", df.format(70000));
      menus.put(menu);

      menu = new JSONObject();
      menu.put("menuno", 8);
      menu.put("name", "진달래 한정식");
      menu.put("price", df.format(50000));
      menus.put(menu);
      
      menu = new JSONObject();
      menu.put("menuno", 9);
      menu.put("name", "개나리 한정식");
      menu.put("price", df.format(40000));
      menus.put(menu);

      menu = new JSONObject();
      menu.put("menuno", 10);
      menu.put("name", "소갈비찜");
      menu.put("price", df.format(60000));
      menus.put(menu);

      menu = new JSONObject();
      menu.put("menuno", 11);
      menu.put("name", "간장 게장");
      menu.put("price", df.format(50000));
      menus.put(menu);
      
      menu = new JSONObject();
      menu.put("menuno", 12);
      menu.put("name", "육회");
      menu.put("price", df.format(45000));
      menus.put(menu);
    } else {
      System.out.println("-> ERROR");
    }
    
    return menus.toString();
  }
}
