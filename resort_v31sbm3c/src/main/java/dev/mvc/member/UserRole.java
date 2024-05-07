package dev.mvc.member;

import lombok.Getter;

@Getter
public enum UserRole {
  ADMIN("ROLE_ADMIN"),  // 관리자, UserRole.ADMIN.getValue(): ROLE_ADMIN
  USER("ROLE_USER");    // 사용자
  
  private String value; // 열거형의 인스턴스 변수로, Spring Security에서 사용하는 권한 문자열을 저장함.
  
  UserRole(String value) { // 열거형의 생성자
    System.out.println("-> 열거형 생성됨: " + value);
    this.value = value; 
  }
  
}
