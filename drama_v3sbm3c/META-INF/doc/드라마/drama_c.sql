/**********************************/
/* Table Name: 오버렌딩 카테고리 */
/**********************************/
DROP TABLE DRAMA CASCADE CONSTRAINTS; -- 자식 테이블을 무시하고삭제

CREATE TABLE DRAMA(
        DRAMANO                                NUMBER(10)         NOT NULL         PRIMARY KEY,
        NATION                                  VARCHAR2(30)         NOT NULL,
        GENRE                               VARCHAR2(30)         DEFAULT '-'         NOT NULL,
        CNT                                   NUMBER(7)         DEFAULT 0         NOT NULL,
        RDATE                                 DATE         NOT NULL,
        SEQNO                                 NUMBER(5)         DEFAULT 0         NOT NULL,
        VISIBLE                               CHAR(1)         DEFAULT 'Y'         NOT NULL
);

COMMENT ON TABLE DRAMA is '카테고리';
COMMENT ON COLUMN DRAMA.DRAMANO is '카테고리번호';
COMMENT ON COLUMN DRAMA.NATION is '중분류명';
COMMENT ON COLUMN DRAMA.GENRE is '소분류명';
COMMENT ON COLUMN DRAMA.CNT is '관련 자료수';
COMMENT ON COLUMN DRAMA.RDATE is '등록일';
COMMENT ON COLUMN DRAMA.SEQNO is '출력 순서';
COMMENT ON COLUMN DRAMA.VISIBLE is '출력 모드';

DROP SEQUENCE DRAMA_SEQ;

CREATE SEQUENCE DRAMA_SEQ
    START WITH 1         -- 시작 번호
    INCREMENT BY 1       -- 증가값
    MAXVALUE 9999999999  -- 최대값: 9999999999 --> NUMBER(10) 대응
    CACHE 2              -- 2번은 메모리에서만 계산
    NOCYCLE;             -- 다시 1부터 생성되는 것을 방지
       
-- CREATE
INSERT INTO drama(dramano, nation, genre, cnt, rdate, seqno, visible)
VALUES(DRAMA_SEQ.nextval, '국내', '-', 0, sysdate, 1, 'Y');

INSERT INTO drama(dramano, nation, genre, cnt, rdate, seqno, visible)
VALUES(DRAMA_SEQ.nextval, '해외', '-', 0, sysdate, 2, 'Y');

INSERT INTO drama(dramano, nation, genre, cnt, rdate, seqno, visible)
VALUES(DRAMA_SEQ.nextval, '국내', '사극', 0, sysdate, 31, 'Y');

INSERT INTO drama(dramano, nation, genre, cnt, rdate, seqno, visible)
VALUES(DRAMA_SEQ.nextval, '국내', '스릴러', 0, sysdate, 32, 'Y');

INSERT INTO drama(dramano, nation, genre, cnt, rdate, seqno, visible)
VALUES(DRAMA_SEQ.nextval, '해외', '스릴러', 0, sysdate, 61, 'Y');

INSERT INTO drama(dramano, nation, genre, cnt, rdate, seqno, visible)
VALUES(DRAMA_SEQ.nextval, '해외', '미스테리', 0, sysdate, 62, 'Y');

SELECT * FROM drama;

COMMIT;

-- READ: 목록
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
ORDER BY dramano ASC;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
ORDER BY nation ASC, genre ASC;

-- 대분류
-- ERROR
SELECT dramano, DISTINCT nation
FROM drama
ORDER BY nation ASC;

-- SUCCESS
SELECT DISTINCT nation, dramano
FROM drama
ORDER BY nation ASC;

SELECT DISTINCT nation
FROM drama
ORDER BY nation ASC;

-- 국내 그룹
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE nation='국내' AND genre != '-';

-- 해외 그룹
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE nation='해외' AND genre != '-';

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama 
WHERE name IN (
    SELECT DISTINCT nation
    FROM drama
) AND genre = '-';

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama 
WHERE genre = '-'
ORDER BY name ASC;

-- READ: 조회
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE dramano=1;

-- UPDATE: 수정
UPDATE drama
SET nation='국내', namesub='로맨스', cnt=100, rdate=sysdate, seqno=5, visible='Y'
WHERE dramano=32;

SELECT * FROM drama;

COMMIT;

-- DELETE: 삭제
DELETE FROM drama WHERE dramano=3;

SELECT * FROM drama;

rollback;

SELECT COUNT(*) as cnt FROM drama;

-- 관련 글수 증가
UPDATE drama SET cnt = cnt + 1 WHERE dramano = 1;
SELECT * FROM drama;

-- 관련 글수 감소
UPDATE drama SET cnt = cnt - 1 WHERE dramano = 1;
SELECT * FROM drama;

-- 출력 순서 높임: seqno 10 -> 1
UPDATE drama SET seqno = seqno - 1 WHERE dramano = 1;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
ORDER BY name ASC, seqno ASC;

-- 출력 순서 낮춤: seqno 1 -> 10
UPDATE drama SET seqno = seqno + 1 WHERE dramano = 1;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
ORDER BY seqno ASC;

-- 카테고리 공개 설정
UPDATE drama SET visible='Y' WHERE dramano = 1;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
ORDER BY seqno ASC;

-- 카테고리 비공개 설정         
UPDATE drama SET visible='N' WHERE dramano = 1;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
ORDER BY seqno ASC;   

commit;

-- 중분류 출력, 2단 메뉴
-- 중복 출력
SELECT dramano, nation, dramano
FROM drama
ORDER BY seqno ASC;

-- X. ERROR
--SELECT DISTINCT nation
--FROM drama
--ORDER BY seqno ASC;

SELECT DISTINCT nation
FROM drama
ORDER BY nation ASC;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama 
WHERE nation IN (
    SELECT DISTINCT nation
    FROM drama
) AND genre = '-'
ORDER BY seqno ASC;

-- 소분류 출력 
-- 국내 그룹
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE nation='국내' AND genre != '-'
ORDER BY seqno ASC;

SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE nation='해외' AND genre != '-'
ORDER BY seqno ASC;

-- 회원/비회원에게 공개할 중분류 목록
SELECT dramano, nation, seqno, visible
FROM drama 
WHERE nation IN (
    SELECT DISTINCT nation
    FROM drama
) AND genre = '-' AND visible='Y'
ORDER BY seqno ASC;

-- 회원/비회원에게 공개할 소분류 목록
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama 
WHERE nation = '국내' AND genre != '-' AND visible = 'Y'
ORDER BY seqno ASC;

-- 검색: 중분류, 소분류
-- 대소문자 구분함
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE nation LIKE 'KOREA%'
ORDER BY dramano ASC;

-- HISTORICAL으로 시작하는 레코드
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE UPPER(genre) LIKE UPPER('HISTORICAL%')
ORDER BY dramano ASC;

-- HISTORICAL으로 끝나는 레코드
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE UPPER(genre) LIKE UPPER('%HISTORICAL')
ORDER BY dramano ASC;

-- KOREA 또는 HISTORICAL이란 단어가 있는 경우
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE UPPER(nation) LIKE UPPER('%KOREA%') OR UPPER(genre) LIKE UPPER('%HISTORICAL%')
ORDER BY dramano ASC;

-- 한글은 대소문자 관련 없음
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE UPPER(nation) LIKE UPPER('%국내%') OR UPPER(genre) LIKE UPPER('%사극%')
ORDER BY dramano ASC;

-- MyBATIS 사용
SELECT dramano, nation, genre, cnt, rdate, seqno, visible
FROM drama
WHERE UPPER(nation) LIKE '%' || UPPER('국내') || '%' OR UPPER(genre) LIKE '%' || UPPER('사극') || '%'
ORDER BY dramano ASC;


