-- 1) 테이블 생성 및 데이터 준비
DROP TABLE PAGE;
 
CREATE TABLE PAGE(
  no    NUMBER(5) NOT NULL,
  title  VARCHAR(20) NOT NULL,
  PRIMARY KEY(no )
);

-- MAX(): 최대값을 가져오는 함수, 레코드가 없으면 null을 리턴
-- NVL(MAX(no ), 0): MAX 함수가 null이면 특정값으로 대체
-- 레코드가 없는 경우 null을 리턴
SELECT MAX(no) as no  FROM page;

-- 레코드가 없는 경우 null에 대한 사칙연산은 null을 리턴
SELECT MAX(no) + 1 as no  FROM page;

-- NVL(null, 0): null이 0으로 변경됨으로 +1 정상적으로 진행됨.
SELECT NVL(MAX(no), 0)+1 as no  FROM page;
        NO
----------
         1

-- PK용 일련번호는 Subquery만 가능한 것이 아님.
-- 쿼리안에 쿼리가 있는 서브 쿼리의 사용, 서브 쿼리가 먼저 실행됨.
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '01월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '02월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '03월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '04월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '05월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '06월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '07월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '08월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '09월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '10월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '11월');
INSERT INTO page(no , title) VALUES((SELECT NVL(MAX(no ), 0) +1 as no  FROM page), '12월');

COMMIT;

SELECT no, title FROM page;

  NO TITLE
 --- -----
   1 01월
   2 02월
   3 03월
   4 04월
   5 05월
   6 06월
   7 07월
   8 08월
   9 09월
  10 10월
  11 11월
  12 12월

-- 분기별 페이징(1분기:1~3월, 2분기:4~6월, 3분기:7~9월, 4분기:10~12월)
-- 1분기
SELECT no, title, r
FROM(
  SELECT no, title, rownum as r
  FROM(
    SELECT no, title
    FROM page
    ORDER BY no ASC
    )
)
WHERE r>=1 AND r<=3;

-- 2분기
SELECT no, title, r
FROM(
  SELECT no, title, rownum as r
  FROM(
    SELECT no, title
    FROM page
    ORDER BY no ASC
    )
)
WHERE r>=4 AND r<=6;

-- 3분기
SELECT no, title, r
FROM(
  SELECT no, title, rownum as r
  FROM(
    SELECT no, title
    FROM page
    ORDER BY no ASC
    )
)
WHERE r>=7 AND r<=9;

-- 4분기
SELECT no, title, r
FROM(
  SELECT no, title, rownum as r
  FROM(
    SELECT no, title
    FROM page
    ORDER BY no ASC
    )
)
WHERE r>=10 AND r<=12;