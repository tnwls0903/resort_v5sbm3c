package jcf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Generics1 {

  public static void main(String[] args) {
//    ArrayList<String> list = new ArrayList<String>();
    List<String> list = new ArrayList<String>();
    
    list.add("Tensorflow");
//    list.add(2024);  // X
//    list.add(10.5);  // X
//    list.add(new Date());  // X

    list.add("dnn");
    list.add("cnn");
    list.add("rnn");
    list.add("lstm");
    
    for (String item: list) {
      System.out.println(item.toUpperCase());
    }
    
    System.out.println("-------------------------");
    for (int index=0; index < list.size(); index++) {
      System.out.println(list.get(index).toUpperCase());
    }
    
  }

}



