<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 포맷관련 -->


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
			<td colspan="4"><c:out value="${board_info.title}" /></td>
		</tr>
		<tr>
			<th>파일첨부</th>
			<td colspan="4">
				<c:choose>
					<c:when test="${!empty board_info.image}">
						<img width="150px" src='upload/${board_info.image}'>
					</c:when>
					<c:otherwise>
					
						<!-- <span style="font-size:12px; color:#aaa;">첨부파일 없음</span> -->
						<img src="https://dummyimage.com/100x50/eee/000&text=no+image">
					</c:otherwise>
				</c:choose>
			</td>
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





<!-- 댓글 start -->
<style>
	ul {list-style-type: none;}
	span {display: inline-block;}
	
	/* w3schools pagination */
	.pagination {
	  display: inline-block;
	}
	
	.pagination a {
	  color: black;
	  float: left;
	  padding: 8px 16px;
	  text-decoration: none;
	}
	
	.pagination a.active {
	  background-color: #4CAF50;
	  color: white;
	  border-radius: 5px;
	}
	
	.pagination a:hover:not(.active) {
	  background-color: #ddd;
	  border-radius: 5px;
	}
</style>
<div class="container reply">
	
	<!-- 댓글등록 -->
	<div class="header">
		<input class="col-sm-8" type="text" id="reply">
		<button class="btn btn-secondary" id="addReply">댓글등록</button>
	</div>
	
	<!-- 댓글목록 -->
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-2">댓번호</span>
				<span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">삭제</span>
			</li>
			<li><hr /></li>
			<li>
				<!-- <span class="col-sm-2">12</span>
				<span class="col-sm-5">댓글입니다</span>
				<span class="col-sm-2">user02</span>
				<span class="col-sm-2"><button>삭제</button></span> -->
			</li>
		</ul>
	</div>
	
	<!-- 댓글페이징 -->
	<div class="footer">
		<div class="pagination">
		  <a href="#">&laquo;</a>
		  <a href="#">1</a>
		  <a href="#" class="active">2</a>
		  <a href="#">3</a>
		  <a href="#">4</a>
		  <a href="#">5</a>
		  <a href="#">6</a>
		  <a href="#">&raquo;</a>
		</div>
	</div>

</div>
<!-- 댓글 end -->

<script>
	const bno = "${board_info.boardNo}";
	const logId = "${logId}";
</script>

<script src="js/boardService.js"></script>
<script src="js/board.js"></script>












