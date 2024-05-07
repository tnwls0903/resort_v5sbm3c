package jcf;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListTest {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
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



