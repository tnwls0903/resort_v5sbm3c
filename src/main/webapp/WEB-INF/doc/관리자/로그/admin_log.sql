/**********************************/
/* Table Name: 관리자로그 */
/**********************************/
DROP TABLE ADMIN_LOG;

CREATE TABLE ADMIN_LOG(
		ADMIN_LOG_NO NUMBER(10),
		ADM_NO NUMBER(10),
		ADMIN_LOG_IP VARCHAR2(15) NOT NULL,
		ADMIN_LOG_DATE DATE NOT NULL,
  FOREIGN KEY (ADM_NO) REFERENCES ADMIN (ADM_NO)
);