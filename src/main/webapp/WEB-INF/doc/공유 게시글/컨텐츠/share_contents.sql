INSERT INTO share_contents(scon_no, scon_name, scon_contents, scon_views, scon_date, pro_no ,cate_no)
VALUES(share_contents_SEQ.nextval,'데스트 테리어',' ',0,sysdate,1,1);

---삽입--
INSERT INTO share_contents(scon_no, scon_name, scon_contents, scon_views,scon_date, pro_no ,cate_no)
VALUES(share_contents_SEQ.nextval,'데스트 테리어',' ',0,sysdate,1,1);
INSERT INTO share_contents(scon_no, scon_name, scon_contents, scon_views,scon_priority, scon_date, pro_no ,cate_no)
VALUES(share_contents_SEQ.nextval,'데스트 테리어',' ',0,0,sysdate,1,1);

--목록--
SELECT scon_no, scon_name, scon_contents, scon_views, scon_date, pro_no ,cate_no 
FROM share_contents;

commit;

--모두 삭제
delete from share_contents;

--해당 게시글 삭제
delete from share_contents
where scon_no=1;

--글 ,제목 수정
update share_contents
set scon_name='데스크 투어',scon_contents='데스크데스크데스크'
where scon_no=1;

--우선순위 올리기
update share_contents
set scon_priority=scon_priority+1
where scon_no=2;

--우선순위 내리기
update share_contents
set scon_priority=scon_priority-1
where scon_no=2;

--조회수 올리기
update share_contents
set scon_views=scon_views+1
where scon_no=2;

select scon_views from share_contents;