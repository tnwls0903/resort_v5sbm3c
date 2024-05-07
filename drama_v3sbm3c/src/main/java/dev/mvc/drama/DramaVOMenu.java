package dev.mvc.drama;

import java.util.ArrayList;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE DRAMA(
//DRAMANO                                NUMBER(10)         NOT NULL         PRIMARY KEY,
//NATION                                  VARCHAR2(30)         NOT NULL,
//GENRE                               VARCHAR2(30)         DEFAULT '-'         NOT NULL,
//CNT                                   NUMBER(7)         DEFAULT 0         NOT NULL,
//RDATE                                 DATE         NOT NULL,
//SEQNO                                 NUMBER(5)         DEFAULT 0         NOT NULL,
//VISIBLE                               CHAR(1)         DEFAULT 'Y'         NOT NULL
//);

@Setter @Getter
public class DramaVOMenu {
  /** 중분류명 */
  private String nation;
  
  /** 소분류명 */
  ArrayList<DramaVO> list_genre;
  
}


