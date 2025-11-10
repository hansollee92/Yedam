<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/board/register">
		<input type="hidden" name="bno" value="${board.bno}">
		<div>
			<label>제목</label>	
			<input name="title" value="${board.title}">		
		</div>
		<div>
			<label>작성자</label>
			<input name="writer" value="${board.writer}">		
		</div>
		<div>
			<label>내용</label>
			<textarea name="content">${board.content}</textarea>		
		</div>
		<button type="submit">등록</button>
	</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>

<!-- ✅ Bootstrap CDN -->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
  crossorigin="anonymous">

<style>
  :root {
    --head-bg: #1f2937;   /* 딥그레이 */
    --muted: #6b7280;     /* 서브텍스트 */
  }

  body {
    background-color: #f8f9fa;
  }

  .form-wrapper {
    max-width: 650px;
    margin: 80px auto;
    background: #fff;
    border-radius: 0.75rem;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.05);
    padding: 2.5rem 3rem;
  }

  h3 {
    border-bottom: 2px solid var(--head-bg);
    padding-bottom: .6rem;
    margin-bottom: 2rem;
  }

  label {
    font-weight: 600;
    color: #374151;
  }

  .form-control:focus {
    border-color: var(--head-bg);
    box-shadow: 0 0 0 0.2rem rgba(31, 41, 55, 0.15);
  }

  .btn-dark {
    background-color: var(--head-bg);
    border: none;
  }
</style>
</head>

<body>
  <div class="container">
    <div class="form-wrapper">
<%--       <c:if test="${empty board.bno}">
	      <h3 class="text-center">게시글 등록</h3>   
      </c:if>
      <c:if test="${not empty board.bno}">
      	  <h3 class="text-center">게시글 수정</h3>   
      </c:if> --%>
      <h3 style="text-align:center;">게시글 ${empty board.bno ? "등록" : "수정"}</h3>

      <form method="post" action="/board/${empty board.bno ? 'register' : 'update'}" name="frm">
        <input type="hidden" name="bno" value="${board.bno}">

        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" class="form-control" id="title" name="title" value="${board.title}" placeholder="제목을 입력하세요">
        </div>

        <div class="mb-3">
          <label for="writer" class="form-label">작성자</label>
          <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" placeholder="작성자를 입력하세요">
        </div>

        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea class="form-control" id="content" name="content" rows="6" placeholder="내용을 입력하세요">${board.content}</textarea>
        </div>

        <div class="d-flex justify-content-between mt-4">
          <a href="/board" class="btn btn-outline-secondary">목록으로</a>
          <c:if test="${not empty board.bno}">	
          	<button type="button" formaction="/board/delete" class="btn btn-outline-secondary" onclick="boardDelete()">삭제</button>
          </c:if>
          <button type="submit" class="btn btn-dark">${empty board.bno ? "등록" : "수정"}하기</button>
        </div>
      </form>
    </div>
  </div>
  
  <script>
 
  /* 삭제이벤트 */
	function boardDelete(){
	  if(confirm('삭제할까요?')){
		  document.frm.action = '/board/delete';
		  document.frm.submit();
	  }
  }
 
 </script>
  
</body>
</html>
