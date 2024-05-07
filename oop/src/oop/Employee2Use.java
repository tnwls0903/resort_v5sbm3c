package oop;
 
public class Employee2Use {
 
  public static void main(String[] args) {
    Employee2 emp1 = new Employee2();
    // emp1.name = "아로미";  // The field Employee2.name is not visible
    // emp1.java = 100;  // X
    // emp1.web = 95;   // X
    
    // 변수에 직접 접근 할 수 없음으로 생성자를 이용하여 값 할당
    Employee2 emp2 = new Employee2("왕눈이", 68, 75, 89);  // 객체 생성

    // 변수에 직접 접근 할 수 없음으로 처리 로직 구현 불가능
    // emp2.tot = emp2.java + emp2.web + emp2.dbms;
    // emp2.avg = (emp2.tot / 3.0)+0.5;
    emp2.calc(); // 메소드에서 처리 로직 구현
    
    // 변수에 직접 접근 할 수 없음으로 출력 불가능
//    System.out.println("성명: " + emp2.name);
//    System.out.println("JAVA: " + emp2.java);
//    System.out.println("WEB: " + emp2.web);
//    System.out.println("DBMS: " + emp2.dbms);
//    System.out.println("총점: " + emp2.tot);
//    System.out.println("평균: " + (int)emp2.avg);
    emp2.print();
    
  }
 
}

