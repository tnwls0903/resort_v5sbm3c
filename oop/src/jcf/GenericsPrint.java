package jcf;

import java.util.List;

public class GenericsPrint {
  public void print(List<String> list) {
    for(String item: list) {
      System.out.println(item);
    }
  }

  public void printInteger(List<Integer> list) {
    for(Integer item: list) {
      System.out.println(item);
    }
  }
}
