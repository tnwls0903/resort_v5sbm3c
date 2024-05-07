<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.SungjukVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0,
                                 maximum-scale=5.0, width=device-width" /> 
<title>http://localhost:9091/beans/sungjuk.jsp</title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">
</head>
 
<body>
<DIV class='container_main'>
<DIV class='content_body'>
<H2>sungjuk.jsp</H2>
<br> 
<% 
SungjukVO sungjukVO = new SungjukVO(); // 객체명: sungjukVO, 클래스명: SungjukVO
    
// sungjukVO.name = "";  // X
sungjukVO.setName("왕눈이");
sungjukVO.setJava(90);
sungjukVO.setJsp(90);
sungjukVO.setSpring(90);

int tot = sungjukVO.getJava() + sungjukVO.getJsp() + sungjukVO.getSpring(); 
sungjukVO.setTot(tot);

int avg = sungjukVO.getTot() / 3;
sungjukVO.setAvg(avg);
%>

<div style="font-size: 22px;">
  신입 직원 성명: <%=sungjukVO.getName() %><br> 
  --------------------------------<br>
  JAVA: <%=sungjukVO.getJava() %><br>
  JSP: <%=sungjukVO.getJsp() %><br>
  SPRING: <%=sungjukVO.getSpring() %><br>    
  총점: <%=sungjukVO.getTot() %><br>
  평균: <%=sungjukVO.getAvg() %><br>
</div>
 
</DIV> <!-- content_body END -->
</DIV> <!-- container_main END -->
</body>
 
</html>
 
