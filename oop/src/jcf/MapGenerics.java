package jcf;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class MapGenerics {

  public static void main(String[] args) {
    // Map map = new Map();
    HashMap<String, Object> map = new HashMap<String, Object>();
    
    Map<String, Object> hashmap = new HashMap<String, Object>();
    // 왜 13라인 코드를 쓰느냐?
    
    Map<String, Object> hashtable = new Hashtable<String, Object>();
    // 최초 HashMap 기준으로 개발 했으나, Client의 요구에 의해 기능 변경이 발생하여 
    // Hashtable 기준으로 변경해도 다른 소스에 영향을 겨의 미치지 않음

    hashtable.put("area", "동해");
    
    // 객체 지향 쓰는 이유?(장점)
    // 재사용성 문제가 아니라 소스 변경에 효율성이 매우 높음
    
  }

}
