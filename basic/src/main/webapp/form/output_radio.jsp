<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, width=device-width" /> 
<title>http://localhost:9091/form/output_radio.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String nations = "노르웨이/핀란드/아이슬란드/알래스카/캐나다";
String[] nations_split = nations.split("/");
%>
여행할 국가<br>
<%
for (String nation: nations_split) {
%>
  <input type="radio" name="nation" value="<%=nation %>"> <%=nation %><br>
<%
}
%>
<br><br>
여행할 국가(핀란드)<br>
<%
for (String nation: nations_split) {
%>
  <input type="radio" name="nation" value="<%=nation %>" <%=nation.equals("핀란드")?"checked='checked'":"" %>> <%=nation %><br>
<%
}
%>
</body>
</html>

