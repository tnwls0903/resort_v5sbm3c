<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, width=device-width" /> 
<title>http://localhost:9091/</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String title = request.getParameter("title");
String content = request.getParameter("content");
int donate = Integer.parseInt(request.getParameter("donate"));
String passwd = request.getParameter("passwd");
Date date = new Date()
// id: admin
// password: 1234
%> 
<h3>주요뉴스</h3>
<ul>
  <li>제목: <%=title %></li>
  <li>내용: <%=content %></li>
  <li>기부: <%="￦" + String.format("%,d", donate) + " 원" %></li>
  <li>패스워드: <%=passwd %></li>
  <li>등록일: <%=date.toLocaleString() %></li>
</ul>
</body>
</html>
