<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, width=device-width" /> 
<title>http://localhost:9091/test/form.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<form name="frm" action="./proc.jsp" method = "get">
  <h3>뉴스 등록</h3>
  제목<br>
  <input type="text" name="title" value="폭염 종료" style="width: 90%;" autofocus="autofocus"><br>
  내용<br>
  <textarea name="content" style="width: 90%; height:200px;">
기본값1
기본값2
기본값3
  </textarea><br>
  기부<br>
  <input type="number" name="donate" min="1000" max="1000000" step="100" value="1000" style="width: 20%;"><br>
  패스워드<br>
  <input type="password" name="passwd" value="123" style="width: 20%;"><br>
  <br>
  <button type="submit">등록</button>
</form> 
</body>
</html>

