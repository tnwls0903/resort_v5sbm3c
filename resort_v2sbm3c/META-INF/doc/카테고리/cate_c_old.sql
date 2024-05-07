/**********************************/
/* Table Name: 오버렌딩 카테고리 */
/**********************************/
CREATE TABLE CATE(
		CATENO                        		NUMBER(10)		 NOT NULL,
		NAME                          		VARCHAR2(30)		 NOT NULL,
		NAMESUB                       		VARCHAR2(30)		 DEFAULT '-'		 NULL ,
		CNT                           		NUMBER(7)		 DEFAULT 0		 NOT NULL,
		RDATE                         		DATE		 NOT NULL,
		SEQNO                         		NUMBER(5)		 DEFAULT 0		 NOT NULL,
		VISIBLE                       		CHAR(1)		 DEFAULT "N"		 NOT NULL
);

COMMENT ON TABLE CATE is '오버렌딩 카테고리';
COMMENT ON COLUMN CATE.CATENO is '카테고리 번호';
COMMENT ON COLUMN CATE.NAME is '중분류';
COMMENT ON COLUMN CATE.NAMESUB is '소분류';
COMMENT ON COLUMN CATE.CNT is '관련 자료 수';
COMMENT ON COLUMN CATE.RDATE is '등록일';
COMMENT ON COLUMN CATE.SEQNO is '출력 순서';
COMMENT ON COLUMN CATE.VISIBLE is '출력 모드';


/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE MEMBER(
		MEMBERNO                      		NUMBER(10)		 NOT NULL
);

COMMENT ON TABLE MEMBER is '회원';
COMMENT ON COLUMN MEMBER.MEMBERNO is '회원 번호';


/**********************************/
/* Table Name: 컨텐츠 */
/**********************************/
CREATE TABLE CONTENTS(
		CONTENTSNO                    		NUMBER(10)		 NOT NULL,
		CATENO                        		NUMBER(10)		 NULL ,
		MEMBERNO                      		NUMBER(10)		 NULL 
);

COMMENT ON TABLE CONTENTS is '컨텐츠';
COMMENT ON COLUMN CONTENTS.CONTENTSNO is '컨텐츠 번호';
COMMENT ON COLUMN CONTENTS.CATENO is '카테고리 번호';
COMMENT ON COLUMN CONTENTS.MEMBERNO is '회원 번호';



ALTER TABLE CATE ADD CONSTRAINT IDX_CATE_PK PRIMARY KEY (CATENO);

ALTER TABLE MEMBER ADD CONSTRAINT IDX_MEMBER_PK PRIMARY KEY (MEMBERNO);

ALTER TABLE CONTENTS ADD CONSTRAINT IDX_CONTENTS_PK PRIMARY KEY (CONTENTSNO);
ALTER TABLE CONTENTS ADD CONSTRAINT IDX_CONTENTS_FK0 FOREIGN KEY (CATENO) REFERENCES CATE (CATENO);
ALTER TABLE CONTENTS ADD CONSTRAINT IDX_CONTENTS_FK1 FOREIGN KEY (MEMBERNO) REFERENCES MEMBER (MEMBERNO);

