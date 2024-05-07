package oop;

// class 이름과 파일명은 동일해야함.
public class HanwooUse {

  public static void main(String[] args) {
    Hanwoo hanwoo = new Hanwoo("꽃등심", "횡성", 200);
    hanwoo.print();

    hanwoo = new Hanwoo("갈비살", "산외", 500);
    hanwoo.print();

  }

}