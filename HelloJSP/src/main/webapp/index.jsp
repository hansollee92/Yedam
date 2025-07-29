<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello, JSP</h3>
	<!-- < % % >을 사용하여 자바코드를 사용할 수 있음 -->
	<%
	String msg = "Hello, World";
	System.out.println(msg);
	int age = 20;
	%>
	<p>여기는 HTML영역입니다</p>
	<%
	if (age >= 20) {
	%>
	<p>성년입니다</p>
	<%
	} else {
	%>
	<p>미성년입니다.</p>
	<%
	}
	%>
	<!-- 동적인 기능을 구현하고자 이런식으로 JSP에 언어를 집어넣었다
	좋긴한데 너무 혼란스러움. Java, HTML을 편하게 작성할순 있지만 이것을 읽는 입장에선 혼란스럽다 -->

</body>
</html>