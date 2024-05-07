package oop;

import tool.Tool;

public class ToolTest {

  public static void main(String[] args) { // 메소드 스텁, prototype, ToolTest.main(args)
    System.out.println(Tool.comma(2500000));
    System.out.println(Tool.comma(2500000.123));
    System.out.println(Tool.isImage("1231.jpg"));
    System.out.println(Tool.checkUploadFile("1231.pptx"));
    System.out.println(Tool.unit(1073741824));
    // System.out.println(unit(3073741824)); // The literal 3073741824 of type int is out of range
    System.out.println(Tool.unit(3073741824L));
    System.out.println(Tool.textLength("도심에까지 출몰하고 있는 멧돼지 수를 줄이기 위해 정부가 지방자치단체와 포상금을 내걸고 있는데요. 잡은 멧돼지를 중복으로 신고해 포상금을 여러 번 받아 챙기는 사례가 벌어지고 있습니다.", 24));
    System.out.println(Tool.getDate_rnd("MP3"));
    System.out.println(Tool.getDate_rnd("MP4"));
    
  }

}
