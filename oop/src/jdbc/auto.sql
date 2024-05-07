1. 테이블 생성
CREATE TABLE sungjuk(
  hakno INT         NOT NULL AUTO_INCREMENT, -- 필수 입력, 고유 일련 번호
  name  VARCHAR(10) NOT NULL, -- NOT NULL은 INSERT시 반드시 값 필요
  grade INT             NULL, -- NULL은 INSERT시 값 생략 가능
  PRIMARY KEY(hakno)          -- 중복된 값이 오면 안됨, 레코드 구분시 사용
); 
 
-- DROP TABLE sungjuk;
 
 
2. 실습
 
1) 자동 증가 컬럼(hakno)은 등록시 컬럼명을 명시하지 않습니다.
INSERT INTO sungjuk(name, grade)
VALUES('왕눈이', 3);
 
-- WHERE문이 없음으로 모든 레코드 출력, *는 모든 컬럼
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|   1   | 왕눈이    |   3   |
+-------+-----------+-------+
 
2) grade 컬럼은 NULL 속성이 지정되어있어 생략 가능함.
- NULL: 컬럼에 데이터 입력이 발생한 적이 없음. 
 
INSERT INTO sungjuk(name)
VALUES('아로미');
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|   1   | 왕눈이    |  3    |
|   2   | 아로미    |  NULL |
+-------+-----------+-------+
 
 
INSERT INTO sungjuk(name)
VALUES('홍길동');
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | 왕눈이    |     3 |
|     2 | 아로미    |  NULL |
|     3 | 홍길동    |  NULL |
+-------+-----------+-------+
 
INSERT INTO sungjuk(name)
VALUES('가길순');
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | 왕눈이    |     3 |
|     2 | 아로미    |  NULL |
|     3 | 홍길동    |  NULL |
|     4 | 가길순    |  NULL |
+-------+-----------+-------+
 
 
3. NOT NULL 컬럼인 name을 생략한 경우
- NOT NULL: INSERT 등록시 값이 존재해야함, 중요한 값이라 생략 불가능.

INSERT INTO sungjuk(grade)
VALUES(2);
 
- 에러 메시지
ERROR 1364 (HY000): Field 'name' doesn't have a default value
 
- NOT NULL 컬럼은 insert시에 반드시 값이 있어야 합니다.
- AUTO_INCREMENT가 적용된 컬럼은 생략해야함.
 
 
3. AUTO_INCREMENT로 발생한 숫자가 삭제되어도 처음 상태로기본적으로
   변경 불가능합니다. 중복값 발생을 피하기위해 증가만 합니다.
   * DBMS 옵션에 가능한 기능이 있으나 개발시 사용되지 않고  권장하지 않음.
 
DELETE FROM sungjuk
WHERE hakno = 4;
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | 왕눈이    |     3 |
|     2 | 아로미    |  NULL |
|     3 | 홍길동    |  NULL |
+-------+-----------+-------+

-- 새로운 레코드 추가 
INSERT INTO sungjuk(name, grade)
VALUES('투투투', 1);
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | 왕눈이    |     3 |
|     2 | 아로미    |  NULL |
|     3 | 홍길동    |  NULL |
|     5 | 투투투    |     1 | <- 4번 될 수 없음.
+-------+-----------+-------+

-- PK는 레코드가 삭제되도 기존에 생성된 번호가 만들어 지면 안됨.
-- 4 번상품 노트북 삭제
-- 4 번상품 모니터 추가
-- 연말 매출액 계산시 4번 노트북의 판매액은 4번 모니터로 인식됨.
-- 따라서 한번 생성된 번호는 재사용하면 안됨.

 
 