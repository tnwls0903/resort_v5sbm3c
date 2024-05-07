package jcf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

  public static void main(String[] args) {
    // Map map = new HashMap();
    HashMap map = new HashMap();
    
    map.put("ai", "NLP");
    map.put("bigdata", "주가 예측");
    map.put("year", 2024);
    map.put("date", new Date());

    MapData data = new MapData();
    data.print(map); // map 전달    
  }

}




