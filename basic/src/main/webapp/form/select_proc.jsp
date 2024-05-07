<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=10.0, width=device-width">
  <title>http://localhost:9091/</title>
 <style type="text/css">
   *{ font-family: Malgun Gothic; font-size: 22px;}
 </style>
</head>
<body>
<%
String travel1 = request.getParameter("travel1");
String travel2 = request.getParameter("travel2");
%>
1박 2일 국내 여행 직접 입력: <%=travel1 %><br>
3박 4일 해외 여행지: <%=travel2 %><br>
</body>
</html>
