<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/board/register">
		<div>
			<label>제목</label>	
			<input name="title">		
		</div>
		<div>
			<label>작성자</label>
			<input name="writer">		
		</div>
		<div>
			<label>내용</label>
			<textarea name="content"></textarea>		
		</div>
		<button type="submit">등록</button>
	</form>
</body>
</html>