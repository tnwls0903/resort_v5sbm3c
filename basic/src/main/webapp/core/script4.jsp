<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>http://localhost:9091/core/script4.jsp</title>
</head>
<body>
<% // 스크립틀릿
String name = "왕눈이";
int kor = 90;
int eng = 70;
int mat = 80;

int tot = kor + eng + mat;
int avg = tot / 3;
%>
<h2>성적 조회: <%=name %> script4.jsp</h2><br>
<ol>
  <li>국어: <%=kor %></li>
  <li>영어: <%=eng %></li>
  <li>수학: <%=mat %></li>
</ol>

총점: <%=tot %>
평균: <%=avg %>
</body>
</html>
