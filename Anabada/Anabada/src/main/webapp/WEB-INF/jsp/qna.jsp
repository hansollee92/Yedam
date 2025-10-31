<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<main class="qnaDetail-container">
  <h2 class="qna-title">상품 문의하기</h2>
  <div class="line"></div>
  
  <!-- mgs 전달값이 있으면 메세지 출력 -->
  <c:if test="${!empty msg }">
	 <div style="color:red; font-size: 13px; font-family: var(--font); margin-bottom: 10px;">
	     <i class="fa-solid fa-circle-exclamation"></i> ${msg}
	  </div>
  </c:if>
  
  <form action="qnaModifyForm.do" method="get">
  	<input type="hidden" value="${qna.prdNo}" name="prdNo">
  	<input type="hidden" value="${qna.qnaNo}" name="qnaNo">
  	<input type="hidden" value="${qna}" name="qna">
  
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
		  <button type="submit" class="btn btn-edit" style="margin-right: 5px;">글 수정</button>
		  <button type="submit" class="btn btn-delete" onclick="return del_confirm()" formaction="qnaRemove.do">글 삭제</button>
	  </div>
	  
  </form>
  
  <%-- 댓글 --%>
  <section class="qna-comments">
    <h3 class="qna-subtitle"><i class="fa-solid fa-comment-dots"></i> 댓글 목록</h3>

	<%-- 댓글목록 --%>
	<ul class="qnaReply-container"></ul>

    <%-- 페이징 --%>
    
    
    <%-- 댓글 등록 --%>
	<div class="qna-write" id="qna-write">
	  <div class="img-box">
	    <img src="${ctx}/images/mypage/user-default2.png" alt="사용자 이미지">
	  </div>
	
	  <div class="write-body">
	    <textarea id="replyContent" class="qna-textarea" rows="3" maxlength="500"
	      placeholder="댓글을 입력해주세요."></textarea>
	
	    <div class="write-actions">
	      <div class="btns">
	        <button type="button" class="btn-submit" id="replySubmit">등록</button>
	      </div>
	    </div>
	  </div>
	</div>
    
    
    
    
  </section>  
  
</main>

<%-- 삭제 --%>
<script>
	function del_confirm(){
		return confirm("해당 문의글을 삭제하시겠습니까?");
	}
</script>

<%-- js파일로 값 넘기기 --%>
<script>
	const qnaNo = "${qna.qnaNo}";
	const qnaReplyNo = "${qnaReply.qnaReplyNo}";
	const memberNo = "${logMember.memberNo}";
	
    const CTX = '${pageContext.request.contextPath}';
    const IS_LOGGED_IN = ${empty sessionScope.logMember ? 'false' : 'true'};
	const LOGIN_MEMBER_NO = ${empty sessionScope.logMember ? 'null' : sessionScope.logMember.memberNo};
</script>
<script src="js/qnaReplyService.js"></script>
<script src="js/qnaReply.js"></script>
    