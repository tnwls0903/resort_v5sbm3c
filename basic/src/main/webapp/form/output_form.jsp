<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<% 
request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지

DecimalFormat df = new DecimalFormat("#,###,##0");
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
String title = "초가을 날씨";
String content = "신청 날짜:\n신청 인원:\n결재 금액:\n";
int price1=2300000;
int price2=2300000;
int gdp=35000;
String btn = "업로드";
%>
<form name="frm" action="./output_proc.jsp" method = "post">
  <input type="text" name="title" value="<%=title %>" style="width: 90%;" autofocus="autofocus"><br>
  <br>
  <textarea name="content" style="width: 90%; height:200px;"><%=content %></textarea>
  <br>
  <input type="number" name="price1" min="1000" max="10000000" step="100" value="<%=price1 %>" style="width: 40%;"> 원<br>
  <input type="number" name="price2" min="1000" max="10000000" step="100" value="<%=price2 %>" style="width: 40%;"> 원 출력안됨<br>
  GDP: <input type="text" name="gdp" value="<%=gdp %>" style="width: 40%;"> $<br>
  <button type="button" onclick="alert('태그에 초기값 출력하기');" style="margin-top: 5px;"><%=btn %></button>
  <button type="submit" style="margin-top: 5px;">등록</button>
</form>
</body>
</html>