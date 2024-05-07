package jcf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class ListTest {

  public static void main(String[] args) {
    List list = new ArrayList();  // Web 관련 개발
    // List list = new Vector();  // Network 관련 개발
    
    list.add("Tensorflow");
    list.add(2024);
    list.add(10.5);
    list.add(new Date());
    
    Object item = list.get(0);
    String list_str = (String)item;
    System.out.println(list_str.toUpperCase());

    item = list.get(1);
    int item_int = (int)item + 1;
    System.out.println(item_int);
    
    item = list.get(2);
    double item_double = (double)item;
    System.out.println(item_double+1);
    
    item = list.get(3);
    Date item_date = (Date)item;
    System.out.println(item_date.toLocaleString());
    
    
  }

}



