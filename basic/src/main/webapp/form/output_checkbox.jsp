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
<title>http://localhost:9091/form/output_checkbox.jsp</title>
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
// 요소 5개 index: 0 ~ 4
for (int i=0; i<nations_split.length; i++) {
%>
  <label style="cursor: pointer;">
    <input type="checkbox" name="nation<%=i %>" value="<%=nations_split[i] %>"><%=nations_split[i] %>
  </label>
  <br> 
<%
}
%>
<br><br>
여행할 국가(노르웨이, 핀란드, 알래스카)<br>
<%
String saved="노르웨이,핀란드,알래스카"; 

// 요소 5개 index: 0 ~ 4
for (int i=0; i<nations_split.length; i++) {
  if (saved.indexOf(nations_split[i]) >= 0) {
%>
  <label style="cursor: pointer;">
    <input type="checkbox" name="nation<%=i %>" value="<%=nations_split[i] %>" checked="checked"><%=nations_split[i] %>
  </label>
  <br> 
<%    
  } else {
%>
  <label style="cursor: pointer;">
    <input type="checkbox" name="nation<%=i %>" value="<%=nations_split[i] %>"><%=nations_split[i] %>
  </label>
  <br> 
<%
  }
}
%>
</body>
</html>

