<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>http://localhost:9091/core/script1.jsp</title>
</head>
<body>
<% // 스크립틀릿
String name = "왕눈이";
int kor = 90;
int eng = 70;
int mat = 80;

int tot = kor + eng + mat;
int avg = tot / 3;
%>
<h2>성적 처리</h2><br>
<%
System.out.println("-> name: " + name); // 서버로 출력
// out: Client로 출력
out.println("WEB");
out.println("국어: " + kor);
out.println("영어: " + eng);
out.println("수학: "+ mat);
out.println("총점: " + tot);
out.println("평균: " + avg);
%>
</body>
</html>
