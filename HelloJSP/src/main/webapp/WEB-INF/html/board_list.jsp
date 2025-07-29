<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 참고로 jsp는  -->
<jsp:include page="includes/header.jsp" />

<%
// 강제형변환(casting)
List<BoardVO> list = (List<BoardVO>) request.getAttribute("board_list");
PageDTO paging = (PageDTO) request.getAttribute("paging");
%>
<p><%=paging %></p>
<h3>게시글 목록</h3>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제 목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO board : list) {
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href='board.do?bno=<%=board.getBoardNo()%>'><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getViewCnt()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<!-- paging -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item disabled"><a class="page-link">Previous</a>
		</li>
		<% for(int p = paging.getStart(); p <= paging.getEnd(); p++){ %>
		<li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
		<%} %>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
		<!-- Previous, Next버튼은 내일  -->
	</ul>
</nav>


<jsp:include page="includes/footer.jsp" />








<!--  <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>-->
<!--
	<table border='2'>
		<tbody>
			< %
			BoardService svc = new BoardServiceImpl();
			// JPS 안에서 import는 붉은색으로 표시된 부분에 커서를 두고 ctrl+space를 하면 구문을 보여줌 (직접작성가능)
			// < %@page import="com.yedam.service.BoardService"% > 이런 형태로 import가 됨

			List<BoardVO> list = svc.boardList();
			for (BoardVO board : list) {
				// 어제는 HTML을 사용했을때 out.print해서 html영역을 적어줬었는데
				// JSP는 구분해서 작성해줘야한다.
			%>
			<tr>
				<td>< %=board.getBoardNo() %></td>
				<td>< %=board.getTitle() %></td>
				<td>< %=board.getWriter() %></td>
			</tr>	}
			%>
		</tbody>
	</table>
	
	
</body>
</html>
-->