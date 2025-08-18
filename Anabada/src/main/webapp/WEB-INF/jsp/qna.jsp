<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<main class="qnaDetail-container">
  <h2 class="qna-title">상품 문의하기</h2>
  <div class="line"></div>

  <%-- 문의게시판 상세 --%>
  <table class="qna-table table">
    <tbody>
      <tr>
        <th>번호</th>
        <td colspan="3">${qna.qnaNo}</td>
      </tr>
      <tr>
        <th>제목</th>
        <td colspan="3">${qna.qnaTitle}</td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>${qna.memberId}</td>
        <th>작성일</th>
        <td><fmt:formatDate value="${qna.qnaDate}" pattern="yyyy년 MM월 dd일 hh:mm a" /></td>
      </tr>
      <tr>
        <td colspan="4">${qna.qnaContent}</td> <%-- 내용 --%>
      </tr>
    </tbody>
  </table>

  <%-- 수정,삭제 버튼 --%>
  <div class="qna-actions qna-button" role="group" aria-label="QnA actions">
	  <a href="#" class="btn btn-edit" aria-label="문의 수정">글 수정</a>
	  <button type="button" class="btn btn-delete" aria-label="문의 삭제">글 삭제</button>
  </div>
  
  <!-- 댓글 목록 -->
  <section class="qna-comments">
    <h3 class="qna-subtitle"><i class="fa-solid fa-comment-dots"></i> 댓글 목록</h3>

    <!-- 페이지네이션 -->
  </section>  
  
</main>
    