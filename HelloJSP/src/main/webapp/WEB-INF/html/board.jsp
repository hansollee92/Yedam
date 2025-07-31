<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 포맷관련 -->

<jsp:include page="includes/header.jsp" />

<h3>글상세화면(board.jsp)</h3>

<!-- mgs 전달값이 있으면 메세지 출력 -->
<c:if test="${!empty msg }">
	<div style="color:red;">${msg}</div>
</c:if>

<form action="modifyForm.do">
<input type="hidden" value="${board_info.boardNo}" name="bno">
<input type="hidden" value="${page}" name="page">

	<table class="table">
		<tr>
			<th>글번호</th>
			<td><c:out value="${board_info.boardNo}" /></td>
			<th>조회수</th>
			<td><c:out value="${board_info.viewCnt}" /></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><c:out value="${board_info.writer}" /></td>
			<th>작성일</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss a"
					value="${board_info.creationDate}" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><c:out value="${board_info.title}" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><c:out value="${board_info.content}" /></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="수정" class="btn btn-success">
				<button type="button" class="btn btn-danger" ${logId eq board_info.writer ? '' : 'disabled'}>삭제</button>
				<!-- 근데 단점, 이렇게 작성해버리면 개발자도구 f12들어가서 작성사자가 edit attribute로 수정해서 활성화해버릴수있다. -->
			</td>
		</tr>
	</table>
</form>

<jsp:include page="includes/footer.jsp" />