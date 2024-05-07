<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=10.0, width=device-width">
  <title>http://localhost:9091/ssi/action_main.jsp</title>
 <style type="text/css">
   *{ font-family: Malgun Gothic; font-size: 22px;}
 </style>
</head>
<body>
  <!-- sub.jsp 처리 결과가 포함됨, flush='false': 모든 jsp 파일이 실행된 후 전송 -->
  <jsp:include page="./sub.jsp" flush='false' />

  <%
  String where = "대관령 삼양 목장";
  %>

  <h2>추천 여행 2: <%=where %></h2>

</body>
</html>