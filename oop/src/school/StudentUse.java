package school; // school 폴더

import sungjuk.Student;

//유형 1
//import sungjuk.Student;  // sungjuk package안의 Student class 사용 선언
//유형 2, sungjuk package안의 모든 class import (권장하지 않음)
//import sungjuk.*; 

public class StudentUse {

  public static void main(String[] args) {
    // Student cannot be resolved to a type
    Student student = new Student();
    student.print();
    
  }

}
 