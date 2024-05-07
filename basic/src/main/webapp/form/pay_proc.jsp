<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0,
                                 maximum-scale=10.0, width=device-width" /> 
<title></title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
DecimalFormat df = new DecimalFormat("￦ #,###,##0 원");
int pay = Integer.parseInt(request.getParameter("pay")); // name 속성
int su = Integer.parseInt(request.getParameter("su")); // name 속성
int tot = pay + su;
int tax = (int)(tot * 0.1);  // 10%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

// Date date_obj = new Date();
// String date = sdf.format(date_obj);
String date = sdf.format(new Date()); // Date class의 객체가 1회만 사용되는 경우

int year = pay * 12;
%> 
<H2>급여 처리</H2>
<DIV>
  본봉: <%=df.format(pay) %><BR>
  수당: <%=df.format(su) %><BR>
  총액: <%=df.format(tot) %><BR>
  세금(10%): <%=df.format(tax) %><BR>
  실수령액: <%=df.format(tot-tax) %><BR>
  근무일: <%=date %><br>
  년봉: <%=df.format(year) %>
</DIV>
 
</body>
</html>

