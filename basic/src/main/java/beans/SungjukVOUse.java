package beans;

public class SungjukVOUse {

//  성명: 왕눈이
//  java: 90
//  jsp: 90
//  spring: 90
//  tot: 270
//  avg: 90
  public static void main(String[] args) {
    SungjukVO sungjukVO = new SungjukVO(); // 객체명: sungjukVO, 클래스명: SungjukVO
    
    // sungjukVO.name = "";  // X
    sungjukVO.setName("왕눈이");
    sungjukVO.setJava(90);
    sungjukVO.setJsp(90);
    sungjukVO.setSpring(90);
    
    int tot = sungjukVO.getJava() + sungjukVO.getJsp() + sungjukVO.getSpring(); 
    sungjukVO.setTot(tot);
    
    int avg = sungjukVO.getTot() / 3;
    sungjukVO.setAvg(avg);

    System.out.println("성명: " + sungjukVO.getName());
    System.out.println("java: " + sungjukVO.getJava());
    System.out.println("jsp: " + sungjukVO.getJsp());
    System.out.println("spring: " + sungjukVO.getSpring());
    System.out.println("tot: " + sungjukVO.getTot());
    System.out.println("avg: " + sungjukVO.getAvg());
  }

}

