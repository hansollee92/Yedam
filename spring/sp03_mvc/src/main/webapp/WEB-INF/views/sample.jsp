<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>views/sample.jsp</title>
</head>
<body>
	<form action="/sample/ex01">
		<input name="name" placeholder="name">
		<input name="age" placeholder="age">
		<input name="birth" type="date">
		<input name="profile" type="file">
		<button>등록</button>
	</form>
</body>
</html>