package jcf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

  public static void main(String[] args) {
    // HashMap map = new HashMap();
    Map map = new HashMap();
    
    map.put("ai", "Autokeras");
    map.put("bigdata", "금융/경제 데이터 분석");
    map.put("year", 2024);
    map.put("date", new Date());
    
    String item = (String)map.get("ai");
    System.out.println(item.toUpperCase());
    
    item = (String)map.get("bigdata");
    System.out.println(item);
    
    int year = (int)map.get("year");
    System.out.println(year + 1);
    
  }

}




