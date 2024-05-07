package jcf;

import java.util.ArrayList;

public class Generics3 {

  public static void main(String[] args) {
    ArrayList<CateVO> List = new ArrayList<CateVO>();

    List.add(new CateVO(1, "SF", "2023-08-31", 500));
    List.add(new CateVO(2, "드라마", "2023-09-01", 300));
    List.add(new CateVO(3, "휴먼", "2023-09-05", 300));

    for (CateVO cate : List) {
      System.out.println(cate.getCateno());
      System.out.println(cate.getName());
      System.out.println(cate.getRdate());
      System.out.println(cate.getCnt());
      System.out.println("-------------------------");
    }
  }
}

