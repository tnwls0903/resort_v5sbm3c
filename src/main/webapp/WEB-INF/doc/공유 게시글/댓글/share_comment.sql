INSERT INTO share_comment(scmt_no, scon_no, scmt_comment,scmt_date, pro_no)
VALUES(share_comment_SEQ.nextval,2,'좋은 정보 감사합니다.',sysdate,1);

INSERT INTO share_comment(scmt_no, scon_no, scmt_comment,scmt_date, pro_no)
VALUES(share_comment_SEQ.nextval,2,'감사합니다.',sysdate,1);

INSERT INTO share_comment(scmt_no, scon_no, scmt_comment,scmt_date, pro_no)
VALUES(share_comment_SEQ.nextval,2,'좋아요',sysdate,1);


select scmt_comment
from share_comment
where  scon_no=2;

select share_comment