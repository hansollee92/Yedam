<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<div class="main-wrap">

 <!-- ▶ 카테고리 그리드 (배너 삭제하고 이 블록만 상단에 둠) -->
  <c:set var="selectedCat" value="${param.category}" />
  <c:set var="categories" value="의류,신발,악세사리,디지털/가전,스포츠,도서/티켓,가구/생활,기타" />
  
   <!-- 필터 유지용 히든 폼 -->
  <form id="filterForm" method="get" action="${ctx}/productList.do">
    <input type="hidden" name="category" id="categoryInput" value="${selectedCat}">
  </form>
  
  <!--  --><nav class="cat-wrap">
    <ul class="cat-grid">
      <c:forEach var="cat" items="${fn:split(categories, ',')}">
        <c:set var="c" value="${fn:trim(cat)}" />
        <li class="cat-item">
          <button type="button"
                  class="cat-btn ${c == selectedCat ? 'active' : ''}"
                  data-cat="${c}">
            ${c}
          </button>
        </li>
      </c:forEach>
    </ul>
  </nav>
  
  
  
<section>
  <div class="sec-head">
  <h3>
    <c:choose>
      <c:when test="${not empty selectedCat}">
        ${selectedCat} 상품
      </c:when>
      <c:when test="${not empty keyword}">
        <c:choose>
          <c:when test="${searchCondition == 'T'}">태그 ‘${keyword}’ 상품</c:when>
          <c:otherwise>‘${keyword}’ 상품</c:otherwise>
        </c:choose>
      </c:when>
      <c:otherwise>
        오늘의 상품 추천
      </c:otherwise>
    </c:choose>
  </h3>

  <!-- 조건 없을 때만 안내 링크 노출 (원하면 항상 보이게 두세요) -->
  <c:if test="${empty selectedCat and empty keyword}">
    <a href="${ctx}/productList.do" class="sec-sub">오늘 올라온 상품이 궁금하다면 확인 &gt;</a>
  </c:if>
</div>

    <div class="prd-list">
      <!-- 상품목록(한줄에 4개씩) -->
      <c:forEach items="${productList}" var="prd" varStatus="status">      
	      <article class="card">
	        <a href="#">
	          <div class="thumb">
	          	<img src="${ctx}/images/product/${prd.prdImg}" alt="상품이미지 : ${prd.prdName}">
	          </div>
	          <div class="meta">
	            <div class="title">${prd.prdName}</div>
	            <div class="price">
	            	<fmt:formatNumber value="${prd.price}" pattern="#,###"/><small>원</small>
	            </div>
	            <div class="date">
	            	${prd.prdDate}
	            </div>
	          </div>
	        </a>
	      </article>
      </c:forEach>
    </div>
    
  </section>
</div>

<!-- paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">

    <!-- 이전 -->
    <c:url var="prevUrl" value="/productList.do">
      <c:param name="page" value="${paging.start - 1}"/>
    </c:url>
    <li class="page-item ${paging.previous ? '' : 'disabled'}">
      <a class="page-link" href="${paging.previous ? prevUrl : '#'}">Previous</a>
    </li>

    <!-- 숫자 페이지 -->
    <c:forEach var="p" begin="${paging.start}" end="${paging.end}">
      <c:choose>
        <c:when test="${paging.currPage eq p}">
          <li class="page-item active" aria-current="page">
            <span class="page-link">${p}</span>
          </li>
        </c:when>
        <c:otherwise>
          <c:url var="pageUrl" value="/productList.do">
            <c:param name="page" value="${page}"/>
          </c:url>
          <li class="page-item">
            <a class="page-link" href="${pageUrl}">${p}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>

    <!-- 다음 -->
    <c:url var="nextUrl" value="/productList.do">
      <c:param name="page" value="${paging.end + 1}"/>
    </c:url>
    <li class="page-item ${paging.next ? '' : 'disabled'}">
      <a class="page-link" href="${paging.next ? nextUrl : '#'}">Next</a>
    </li>

  </ul>
</nav>

<!-- 스타일: 카테고리 표처럼, 간격 일정 -->
<style>
  .cat-wrap { margin: 50px 0; }
  .cat-grid {
    display: grid;
    grid-template-columns: repeat(6, 1fr);   /* 데스크탑 6칸 */
    border-top: 1px solid #eaeaea;
    border-left: 1px solid #eaeaea;
    margin: 0; padding: 0; list-style: none;
  }
  .cat-item {
    border-right: 1px solid #eaeaea;
    border-bottom: 1px solid #eaeaea;
  }
  .cat-btn {
    width: 100%; height: 48px;
    display:flex; align-items:center; justify-content:center;
    background:none; border:none; outline:none;
    font-size:14px; color:#444; cursor:pointer;
  }
  .cat-btn:hover { background:#fafafa; color:#111; }
  .cat-btn.active { font-weight:700; color:#0a9a7a; border-bottom:2px solid #0a9a7a; }

  /* 목록 카드 그리드가 있다면 여기도 간격 정돈 (필요 시) */
  .prd-list { display:grid; grid-template-columns:repeat(4, 1fr); gap:16px; }
  @media (max-width: 1024px) { .cat-grid { grid-template-columns: repeat(4, 1fr); }
                                .prd-list { grid-template-columns: repeat(3, 1fr); } }
  @media (max-width: 640px)  { .cat-grid { grid-template-columns: repeat(2, 1fr); }
                                .prd-list { grid-template-columns: repeat(2, 1fr); } }
                                
 /* 색상 커스터마이즈 */
:root{
  --pg-primary: #137e78;                 /* 활성/호버 포인트 색 */
  --pg-text:    #4B5563;                  /* 기본 숫자 색 */
  --pg-hover-bg: rgba(19,126,120,.12);    /* 호버 배경 */
}

/* 컨테이너 간격 + 정렬 */
nav[aria-label="Page navigation example"] .pagination{
  justify-content: center;
  gap: 12px;
  margin: 28px 0;                         /* 위/아래 간격 */
}

/* 기본: 숫자만(박스 없음) */
nav[aria-label="Page navigation example"] .pagination .page-item .page-link{
  display: inline-flex; align-items: center; justify-content: center;
  min-width: 36px; height: 36px;
  padding: 0 8px;
  background: transparent;
  border: none;
  border-radius: 6px;
  color: var(--pg-text);
  font-weight: 600;
  line-height: 1;
  text-decoration: none;
  transition: background-color .15s ease, color .15s ease, box-shadow .15s ease, transform .05s ease;
}

/* Hover: 박스가 '그때만' 생김 */
nav[aria-label="Page navigation example"] .pagination
.page-item:not(.active):not(.disabled) .page-link:hover{
  background: var(--pg-hover-bg);
  color: var(--pg-primary);
  box-shadow: inset 0 0 0 1px var(--pg-primary);
  transform: translateY(-1px);
}

/* 활성 페이지(현재) */
nav[aria-label="Page navigation example"] .pagination .page-item.active .page-link{
  background: var(--pg-primary);
  color: #fff;
  box-shadow: none;
  cursor: default;
}

/* 비활성 */
nav[aria-label="Page navigation example"] .pagination .page-item.disabled .page-link{
  color: #9CA3AF; pointer-events: none;
}

/* ▼ Prev / Next: 텍스트 숨기고 화살표만 크게 보여주기 */
/* first/last-child 대신 first/last-of-type로 더 안전하게 */
nav[aria-label="Page navigation example"] .pagination .page-item:first-of-type .page-link,
nav[aria-label="Page navigation example"] .pagination .page-item:last-of-type  .page-link{
  font-size: 0 !important;      /* 텍스트 숨김 */
  padding: 0 !important;
  min-width: 36px; height: 36px;
}

/* 왼쪽 화살표 */
nav[aria-label="Page navigation example"] .pagination .page-item:first-of-type .page-link::before{
  content: '\2039';              /* ‹ */
  font-size: 30px;               /* ← 작게 보이면 이 값 키우기 */
  line-height: 1;
  color: inherit;
}

/* 오른쪽 화살표 */
nav[aria-label="Page navigation example"] .pagination .page-item:last-of-type .page-link::before{
  content: '\203A';              /* › */
  font-size: 30px;
  line-height: 1;
  color: inherit;
}

/* 키보드 포커스 링 */
nav[aria-label="Page navigation example"] .pagination .page-item .page-link:focus-visible{
  outline: 2px solid var(--pg-primary);
  outline-offset: 2px;
}

/* 모바일 */
@media (max-width:480px){
  nav[aria-label="Page navigation example"] .pagination{ gap: 8px; }
  nav[aria-label="Page navigation example"] .pagination .page-item .page-link{
    min-width: 32px; height: 32px; border-radius: 6px;
  }
}
</style>


<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<!-- Initialize Swiper -->
<script>
  var swiper = new Swiper(".mySwiper", {
	loop: true,
    autoplay: {
        delay: 3000,
        disableOnInteraction: false,
      },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
</script>

<script>
  // 카테고리 클릭 → hidden form에 값 세팅 후 제출
  document.querySelectorAll('.cat-btn').forEach(btn => {
    btn.addEventListener('click', () => {
      document.getElementById('categoryInput').value = btn.dataset.cat;
      document.getElementById('filterForm').submit();
    });
  });
</script>
