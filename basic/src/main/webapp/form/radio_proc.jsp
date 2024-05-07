<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0,
                                 maximum-scale=10.0, width=device-width" /> 
<title>축제</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
  축제 예약<br>
  ----------------------------------------<br>
  축제: <%=request.getParameter("festival") %><br>
  참가인원: <%=request.getParameter("count") %> 명<br>
  연락처: <%=request.getParameter("mobile") %><br>
  번호: <%=request.getParameter("mobileno") %><br>
  <br>
  <A href='./radio_form.html'>예약 계속</A>
</body>
</html>
 