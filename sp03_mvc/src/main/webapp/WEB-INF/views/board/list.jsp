<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%-- 부트스트랩 CDN --%>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
		crossorigin="anonymous">
	<title>Insert title here</title>
</head>
<body>
	<div class="container-lg">
		<h3 style="margin: 50px 0 20px;">게시글 목록</h3>
		
		<table class="table">
			<thead>
				<tr>
				  <th scope="col-1">#</th>
				  <th scope="col-3">제목</th>
				  <th scope="col-6">내용</th>
				  <th scope="col-2">글쓴이</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${list}" var="board">
					<tr>
						<td class="col-1">${board.bno}</td>
						<td class="col-3">${board.title}</td>
						<td class="col-6">${board.content}</dtd>
						<td class="col-2">${board.writer}</td>
					</tr>
					<c:if test="${not empty board.reply}">
						<c:forEach items="${board.reply}" var="reply">
						<tr>
						<td>${reply.rno} ${reply.replyer} ${reply.reply}</td>
						</tr>
						</c:forEach>
					</c:if>	
				
				</c:forEach>
			</tbody>
		
		
		
		</table>		
		

	</div>
</body>
</html>