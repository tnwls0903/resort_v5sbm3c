package jcf;

import java.util.ArrayList;
import java.util.List;

public class Generics2 {

  public static void main(String[] args) {
    List<String> months= new ArrayList<String>();
    months.add("JANUARY");
    months.add("FEBURARY");
    months.add("MARCH");
    
    GenericsPrint print = new GenericsPrint();
    print.print(months);
    
    List<Integer> years = new ArrayList<Integer>();
    years.add(2023);
    years.add(2024);
    years.add(2025);
    
    System.out.println("---------------");
    // print.print(years); // X
    print.printInteger(years);
  }

}
