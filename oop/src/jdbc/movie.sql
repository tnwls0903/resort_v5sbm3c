-- movie.sql
-- 도메인 지식: 웡카 다음 영화
DROP TABLE movie;

CREATE TABLE movie(
  movieno  INT          NOT NULL AUTO_INCREMENT, -- 번호
  title    VARCHAR(30)  NOT NULL, -- 제목
  score    FLOAT        NOT NULL, -- 평점
  actor    VARCHAR(30)  NOT NULL, -- 출연
  rdate    DATETIME     NOT NULL, -- 등록일
  PRIMARY KEY(movieno)  
);

-- 필수 구현 기능(CRUD): Create(INSERT), Read(SELECT), Update(UPDATE), Delete(DELETE)
-- 하나의 테이블 == CRUD -> 1 본
-- Create(INSERT)
INSERT INTO movie(title, score, actor, rdate)
VALUES('웡카', 3.4, '휴그랜트/로완 아킨슨', now());

SELECT movieno, title, score, actor, rdate
FROM movie;

INSERT INTO movie(title, score, actor, rdate)
VALUES('클레멘타인', 3.5, '김사랑', now());

SELECT movieno, title, score, actor, rdate
FROM movie;

INSERT INTO movie(title, score, actor, rdate)
VALUES('탑건 매버릭', 4.1, '톰크루즈', now());

SELECT movieno, title, score, actor, rdate
FROM movie;

INSERT INTO movie(title, score, actor, rdate)
VALUES('원헌드레드', 5.0, '클라크 그리핀', now());

SELECT movieno, title, score, actor, rdate
FROM movie;

-- Read(SELECT)
-- 목록
SELECT movieno, title, score, actor, rdate
FROM movie
ORDER BY movieno ASC;

-- 조회
SELECT movieno, title, score, actor, rdate
FROM movie
WHERE movieno=1;

-- Update(UPDATE)
UPDATE movie
SET title='이미테이션 게임', score=5, actor='키이라 크리스티나 나이틀리', rdate=now()
WHERE movieno=5;

-- Delete(DELETE)
DELETE FROM movie
WHERE movieno=8;

-- COUNT(*): 레코드의 갯수
-- COUNT(score): score 컬럼의 값이 null아닌 값을 가지고 있는 레코드의 갯수
SELECT COUNT(*) FROM movie;

SELECT COUNT(score) FROM movie;

-- 컬럼 별명의 지정, 메모리상에 새로운 테이블이 생성됨.
SELECT COUNT(*) AS 'cnt' 
FROM movie;

cnt
------
8




