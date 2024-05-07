<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, width=device-width" /> 
<title>http://localhost:9091/core/request1.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 22px;}
</style>
</head>
<body>
<%
String[] images = new String[10];
 
images[0] = "./images/tu01.jpg";
images[1] = "./images/tu02.jpg";
images[2] = "./images/tu03.jpg";
images[3] = "./images/tu04.jpg";
images[4] = "./images/tu05.jpg";
images[5] = "./images/tu06.jpg";
images[6] = "./images/tu07.jpg";
images[7] = "./images/tu08.jpg";
images[8] = "./images/tu09.jpg";
images[9] = "./images/tu10.jpg";

// http://localhost:9091/core/request1.jsp?index=1
// http://localhost:9091/core/request1.jsp?index=1&fname=tu01.jpg
// out.println(request.getParameter("index")); // String
int index = Integer.parseInt(request.getParameter("index"));

if (index >= 0 && index <= 10) {
%>

  index: <%=index %><br>
  <img src="<%=images[index-1] %>" style="width: 300px;">
<%
} else {
%>
  해당하는 이미지가 없습니다.
<%
}

String fname = request.getParameter("fname");
%>
<br>
filename: <%=fname %><br>
<img src="./images/<%=fname %>" style="width: 300px;">
</body>
</html>


