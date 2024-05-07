package jcf;

import java.util.Map;

public class MapData {
  public void print(Map map) {
    String item = (String)map.get("ai");
    System.out.println(item.toUpperCase());
    
    item = (String)map.get("bigdata");
    System.out.println(item);
    
    int year = (int)map.get("year");
    System.out.println(year + 1);
  }
}
