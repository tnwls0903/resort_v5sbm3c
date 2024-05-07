package oop;

public class Employee3Use {

  public static void main(String[] args) {
    Employee3 emp = new Employee3("조정석", 90, 100, 85);  // 객체 생성
    emp.calc();
    emp.print();
    
    // emp.name = "신세경"; // The field Employee3.name is not visible
    emp.setName("신세경");
    emp.setJava(60);
    emp.setWeb(50);
    emp.setDbms(70);
    emp.calc();
    emp.print();
    
    System.out.println(emp.getName());
    System.out.println(emp.getJava());
    
    
  }

}

