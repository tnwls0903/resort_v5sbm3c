package sungjuk;

public class Student {
  String name = "왕눈이";
  String grade = "A";
  
  public void print(){ // void: 값 리턴 없음
    System.out.println(this.name); // this 생략 가능
    System.out.println(this.grade);
  }

}
