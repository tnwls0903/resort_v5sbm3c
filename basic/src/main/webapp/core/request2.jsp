<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, width=device-width" /> 
<title>http://localhost:9091/core/request2.jsp?pay=2200000&su=200000</title>
<style type="text/css">
  *{ font-family: 맑은 고딕; font-size: 22px; }
</style>
</head>
<body>
  <%
  DecimalFormat df = new DecimalFormat("#,###,##0 원");
  Date date = new Date();
  
  int pay = Integer.parseInt(request.getParameter("pay"));
  int su = Integer.parseInt(request.getParameter("su"));
  int tot = pay + su;
  int tax =(int)( tot * 0.1);
  String date_str = date.toLocaleString();
  %>
<H2>급여 처리</H2>
<DIV>
  본봉: <%=df.format(pay) %><BR>
  수당: <%=df.format(su) %><BR>
  총액: <%=df.format(tot) %><BR>
  세금(10%): <%=df.format(tax) %><BR>
  실수령액: <%=df.format(tot-tax) %><BR>
  처리 시간: <%=date_str %>
</DIV>

</body>
</html>

