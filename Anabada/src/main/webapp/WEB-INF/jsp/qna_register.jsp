<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    

<main class="qnaWrite-container">
  <h2 class="page-title">상품 문의하기 글 등록</h2>
  <div class="line"></div>

  <form class="qna-form" action="#" method="post" novalidate>  
    <div class="form-row">
      <label for="qna-title" class="form-label">제목</label>
      <input id="qna-title" name="title" type="text" class="input form-control" placeholder="제목을 입력하세요" required>
    </div>

    <!-- 내용 -->
    <div class="form-row">
      <label for="qna-content" class="form-label">내용</label>
	      <textarea id="qna-content" name="content" class="textarea form-control" rows="10" placeholder="문의 내용을 자세히 작성해주세요." required></textarea>
    </div>
    <div class="helper">
	     <div><span id="char-count">0</span>/1,000</div>
	</div> 

    <div class="line"></div>

    <!-- 버튼 -->
    <div class="form-actions">
      <button type="submit" class="qnawBtn qnaw-btn-p">등록</button>
      <button type="button" class="qnawBtn qnaw-btn" onclick="history.back()">취소</button>
    </div>
  </form>
</main>

<script>
  // 글자수 카운트 (선택)
  const ta = document.getElementById('qna-content');
  const counter = document.getElementById('char-count');

  if (ta && counter) ta.addEventListener('input', () => {
    const max = 1000;
    const len = ta.value.length;
    counter.textContent = len;
    if (len > max) ta.value = ta.value.slice(0, max);
  });
</script>