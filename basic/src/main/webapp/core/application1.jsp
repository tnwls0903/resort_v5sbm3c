<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.File" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0,
                                 maximum-scale=5.0, width=device-width" /> 
<title>http://localhost:9091/core/application1.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String dir = "/";
String abs_dir = application.getRealPath(dir);
out.println(abs_dir);
out.println("<br><br>");

dir = "/core/images";
abs_dir = application.getRealPath(dir);
out.println(abs_dir);
out.println("<br><br>");

dir = "/core/images_X";
abs_dir = application.getRealPath(dir); // 실제 존재하는지 검사는 안함.
out.println(abs_dir);
out.println("<br><br>");

File folder = new File(abs_dir);
if (folder.exists()) {
  out.println("폴더가 존재함");
} else {
  out.println("폴더가 존재하지 않음");
}
%> 
</body>
</html>

