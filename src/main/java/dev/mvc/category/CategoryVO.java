package dev.mvc.category;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE CATEGORY(
//    CATE_NO NUMBER(10) NOT NULL PRIMARY KEY,
//    CATE_NAME VARCHAR2(30) NOT NULL,
//    CATE_CNT NUMBER(7) DEFAULT 0 NOT NULL,
//    CATE_SEQNO NUMBER(5) DEFAULT 0 NOT NULL,
//    CATE_VISIBLE CHAR(1) DEFAULT 'Y' NOT NULL
//);

@Setter @Getter
public class CategoryVO {
  /**
   * 카테고리 번호
   */
  private Integer cate_no=0;
  
  /**
   *  카테고리 이름
   */
  @NotEmpty(message="카테고리 이름은 필수 입력 항목입니다.")
  @Size(min=1, max=30, message="카테고리 이름 입력 글자 수는 최소 1자에서 30자이어야 합니다.")
  private String cate_name="";
  
  /**
   * 관련 자료수
   */
  @NotEmpty(message="관련 자료수는 필수 입력 항목입니다.")
  @Min(value=0)
  @Max(value=1000000)
  private int cate_cnt=0;
  
  /**
   * 출력 순서
   */
  @NotEmpty(message="출력 순서는 필수 입력 항목입니다.")
  @Min(value=0)
  @Max(value=1000000)
  private int cate_seqno;
  
  /**
   * 출력 모드
   */
  @NotEmpty(message="출력 모드는 필수 입력 항목입니다.")
  @Pattern(regexp="^[YN]$", message="Y 또는 N만 입력 가능합니다.")
  private String cate_visible="Y";
}
