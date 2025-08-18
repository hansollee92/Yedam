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
    <input type="hidden" name="searchCondition" value="${searchCondition}">
    <input type="hidden" name="keyword"         value="${keyword}">
    <input type="hidden" name="page"            value="1">
    <input type="hidden" name="category"        id="categoryInput" value="${selectedCat}">
  </form>
  
  <nav class="cat-wrap">
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








<!-- <section class="wrapper">
  <h2 class="today-title">오늘의 상품 추천</h2>

  <c:if test="${empty productList}">
    <p>등록된 상품이 없습니다.</p>
  </c:if>

  <c:if test="${not empty productList}">
    <ul class="prod-grid">
      <c:forEach var="p" items="${productList}">
        <li class="prod-card">
          <a class="prod-link" href="${ctx}/product/product.tiles?prdNo=${p.prdNo}">
            <img class="prod-thumb"
                 src="${ctx}/images/${p.prdImg}"
                 alt="${p.prdName}"
                 loading="lazy"
                 onerror="this.src='${ctx}/images/noimage.png'">
            <div class="prod-info">
              <p class="prod-name">${p.prdName}</p>
              <p class="prod-price"><fmt:formatNumber value="${p.price}" type="number"/>원</p>
              <div class="prod-meta"><span>${p.sigungu}</span></div>
            </div>
          </a>
        </li>
      </c:forEach>
    </ul>
  </c:if>
</section> -->