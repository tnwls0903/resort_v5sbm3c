/**********************************/
/* Table Name: 오버렌딩 카테고리 */
/**********************************/
DROP TABLE HOTPLACE CASCADE CONSTRAINTS; -- 자식 테이블을 무시하고삭제

CREATE TABLE HOTPLACE(
        HOTPLACENO                                NUMBER(10)         NOT NULL         PRIMARY KEY,
        A                                  VARCHAR2(30)         NOT NULL,
        B                               VARCHAR2(30)         DEFAULT '-'         NOT NULL,
        CNT                                   NUMBER(7)         DEFAULT 0         NOT NULL,
        RDATE                                 DATE         NOT NULL,
        SEQNO                                 NUMBER(5)         DEFAULT 0         NOT NULL,
        VISIBLE                               CHAR(1)         DEFAULT 'Y'         NOT NULL
);

COMMENT ON TABLE HOTPLACE is '카테고리';
COMMENT ON COLUMN HOTPLACE.HOTPLACENO is '카테고리번호';
COMMENT ON COLUMN HOTPLACE.A is '중분류명';
COMMENT ON COLUMN HOTPLACE.B is '소분류명';
COMMENT ON COLUMN HOTPLACE.CNT is '관련 자료수';
COMMENT ON COLUMN HOTPLACE.RDATE is '등록일';
COMMENT ON COLUMN HOTPLACE.SEQNO is '출력 순서';
COMMENT ON COLUMN HOTPLACE.VISIBLE is '출력 모드';

DROP SEQUENCE HOTPLACE_SEQ;

CREATE SEQUENCE HOTPLACE_SEQ
    START WITH 1         -- 시작 번호
    INCREMENT BY 1       -- 증가값
    MAXVALUE 9999999999  -- 최대값: 9999999999 --> NUMBER(10) 대응
    CACHE 2              -- 2번은 메모리에서만 계산
    NOCYCLE;             -- 다시 1부터 생성되는 것을 방지
       
-- CREATE
INSERT INTO hotplace(hotplaceno, a, b, cnt, rdate, seqno, visible)
VALUES(HOTPLACE_SEQ.nextval, '서울', '-', 0, sysdate, 1, 'Y');

INSERT INTO hotplace(hotplaceno, a, b, cnt, rdate, seqno, visible)
VALUES(HOTPLACE_SEQ.nextval, '경기도', '-', 0, sysdate, 2, 'Y');

INSERT INTO hotplace(hotplaceno, a, b, cnt, rdate, seqno, visible)
VALUES(HOTPLACE_SEQ.nextval, '서울', '강남', 0, sysdate, 31, 'Y');

INSERT INTO hotplace(hotplaceno, a, b, cnt, rdate, seqno, visible)
VALUES(HOTPLACE_SEQ.nextval, '서울', '건대입구', 0, sysdate, 32, 'Y');

INSERT INTO hotplace(hotplaceno, a, b, cnt, rdate, seqno, visible)
VALUES(HOTPLACE_SEQ.nextval, '경기도', '남양주', 0, sysdate, 61, 'Y');

SELECT * FROM hotplace;

COMMIT;

-- READ: 목록
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
ORDER BY hotplaceno ASC;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
ORDER BY a ASC, b ASC;

-- 대분류
-- SUCCESS
SELECT DISTINCT a, hotplaceno
FROM hotplace
ORDER BY a ASC;

SELECT DISTINCT a
FROM hotplace
ORDER BY a ASC;

-- 서울 그룹
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE a='서울' AND b != '-';

-- 경기도 그룹
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE a='경기도' AND b != '-';

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace 
WHERE name IN (
    SELECT DISTINCT a
    FROM hotplace
) AND b = '-';

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace 
WHERE b = '-'
ORDER BY name ASC;

-- READ: 조회
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE hotplaceno=1;

-- UPDATE: 수정
UPDATE hotplace
SET a='서울', b='홍대', cnt=100, rdate=sysdate, seqno=4, visible='Y'
WHERE hotplaceno=32;

SELECT * FROM hotplace;

COMMIT;

-- DELETE: 삭제
DELETE FROM hotplace WHERE hotplaceno=3;

SELECT * FROM hotplace;

rollback;

SELECT COUNT(*) as cnt FROM hotplace;

-- 관련 글수 증가
UPDATE hotplace SET cnt = cnt + 1 WHERE hotplaceno = 1;
SELECT * FROM hotplace;

-- 관련 글수 감소
UPDATE hotplace SET cnt = cnt - 1 WHERE hotplaceno = 1;
SELECT * FROM hotplace;

-- 출력 순서 높임: seqno 10 -> 1
UPDATE hotplace SET seqno = seqno - 1 WHERE hotplaceno = 1;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
ORDER BY a ASC, seqno ASC;

-- 출력 순서 낮춤: seqno 1 -> 10
UPDATE hotplace SET seqno = seqno + 1 WHERE hotplaceno = 1;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
ORDER BY seqno ASC;

-- 카테고리 공개 설정
UPDATE hotplace SET visible='Y' WHERE hotplaceno = 1;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
ORDER BY seqno ASC;

-- 카테고리 비공개 설정         
UPDATE hotplace SET visible='N' WHERE hotplaceno = 1;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
ORDER BY seqno ASC;   

commit;

-- 중분류 출력, 2단 메뉴
-- 중복 출력
SELECT hotplaceno, a, b
FROM hotplace
ORDER BY seqno ASC;

SELECT DISTINCT a
FROM hotplace
ORDER BY a ASC;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace 
WHERE a IN (
    SELECT DISTINCT a
    FROM hotplace
) AND b = '-'
ORDER BY seqno ASC;

-- 소분류 출력 
-- 서울 그룹
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE a='서울' AND b != '-'
ORDER BY seqno ASC;

SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE a='경기도' AND b != '-'
ORDER BY seqno ASC;

-- 회원/비회원에게 공개할 중분류 목록
SELECT hotplaceno, a, b, visible
FROM hotplace 
WHERE a IN (
    SELECT DISTINCT a
    FROM hotplace
) AND b = '-' AND visible='Y'
ORDER BY seqno ASC;

-- 회원/비회원에게 공개할 소분류 목록
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace 
WHERE a = '서울' AND b != '-' AND visible = 'Y'
ORDER BY seqno ASC;

-- 검색: 중분류, 소분류
-- 대소문자 구분함
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE a LIKE 'KOREA%'
ORDER BY hotplaceno ASC;

-- Gangnam으로 시작하는 레코드
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE UPPER(b) LIKE UPPER('Gangnam%')
ORDER BY hotplaceno ASC;

-- Gangnam으로 끝나는 레코드
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE UPPER(b) LIKE UPPER('%Gangnam')
ORDER BY hotplaceno ASC;

-- SEOUL 또는 Gangnam이란 단어가 있는 경우
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE UPPER(a) LIKE UPPER('%SEOUL%') OR UPPER(b) LIKE UPPER('%Gangnam%')
ORDER BY hotplaceno ASC;

-- 한글은 대소문자 관련 없음
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE UPPER(a) LIKE UPPER('%서울%') OR UPPER(b) LIKE UPPER('%강남%')
ORDER BY hotplaceno ASC;

-- MyBATIS 사용
SELECT hotplaceno, a, b, cnt, rdate, seqno, visible
FROM hotplace
WHERE UPPER(a) LIKE '%' || UPPER('서울') || '%' OR UPPER(b) LIKE '%' || UPPER('강남') || '%'
ORDER BY hotplaceno ASC;


