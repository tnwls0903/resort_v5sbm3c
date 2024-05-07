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
<title>http://localhost:9091/form/output_form.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String title = request.getParameter("title");
String content = request.getParameter("content");
content = content.replace("\n", "<br>");

int price1 = Integer.parseInt(request.getParameter("price1"));
// int gdp = Integer.parseInt(request.getParameter("gdp")); // X
int gdp = Integer.parseInt(request.getParameter("gdp").replace(",", ""));
gdp = gdp + 1500;
%>

title: <%=title %><br>
content:<br>
<%=content %><br>
price1: <%=price1 %><br>
gdp: <%=gdp %>
</body>
</html>

