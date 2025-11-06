<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	가입완료 <br>
	${param.name}   <!-- 파라미터는 param. 으로 작성해야함 -->
	<script>
		let msg = '${msg}';
		if(msg) {
			alert(msg);
		}
	</script>
</body>
</html>