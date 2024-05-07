<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<% 
request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지

DecimalFormat df = new DecimalFormat("￦ #,###,### 원");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String date = sdf.format(new Date());
%>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, width=device-width" /> 
<title>http://localhost:9091/form/output_select.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String nations = "노르웨이/핀란드/아이슬란드/알래스카/캐나다";
String[] nations_split = nations.split("/");
%>
여행할 국가 순위<br>
<ol>
<%
for (String nation: nations_split) {
%>
  <li><%=nation %></li>
<%
}
%>
</ol>

<br>
여행할 국가:
<select name="nation">
<%
for (String nation: nations_split) {
  %>
  <option value="nation"><%=nation %></option>
  <%
}
%>
</select>

<br>
여행할 국가 선택 1(핀란드):
<select name="nation">
<%
for (String nation: nations_split) {
%>
  <option value="<%=nation %>" <%=(nation.equals("핀란드"))?"selected='selected'": "" %>><%=nation %></option>
<%
}
%>
</select>

<br>
여행할 국가 선택 2(핀란드, 알래스카):
<select name="nation" multiple="multiple">
  <%
  for (String nation: nations_split) {
    if (nation.equals("핀란드") || nation.equals("알래스카")) {
  %>
      <option value="<%=nation %>" selected="selected"><%=nation %></option>
  <%
    }else{
  %>
      <option value="<%=nation %>"><%=nation %></option>
  <%
    }
  }
  %>
</select>

</body>
</html>

