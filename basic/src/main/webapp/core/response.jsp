<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0,
                                 maximum-scale=5.0, width=device-width" /> 
<title>http://localhost:9091/core/response.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String url = request.getParameter("url");
System.out.println("url: " + url);

if (url != null) {
  if (url.equalsIgnoreCase("kma")) {
    response.sendRedirect("http://www.kma.go.kr"); // 주소 이동
  } else if (url.equalsIgnoreCase("daum")) {
    response.sendRedirect("http://www.daum.net"); // 주소 이동
  } else if (url.equalsIgnoreCase("naver")) {
    response.sendRedirect("http://www.naver.com"); // 주소 이동
  } else {
    out.println("해당하는 url이 없습니다.");
  }
  
} else {
  out.println("url 변수값을 입력해주세요.");
}
%> 
</body>
</html>

