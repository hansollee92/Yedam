<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

  <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <c:set var="sort" value="${empty param.sort ? 'latest' : param.sort}" />
  <c:set var="selectedpage" value="${empty param.page ? 1 : param.page}" />
  <c:set var="categories" value="의류,신발,악세사리,디지털/가전,스포츠,도서/티켓,가구/생활,기타" />
  <c:set var="category" value="${param.category}" />
  <c:set var="keyword" value="${not empty fn:trim(keyword) ? fn:trim(keyword) : fn:trim(param.keyword)}" />
  <c:set var="totalCount" value="${totalCount}"/>
  <c:set var="isCategoryChooser" value="${empty category and empty keyword}"/>
  

<div class="main-wrap">

	<!-- 제목  -->
  <c:set var="baseListUrl">
  <c:url value="/productList.do">
    <c:if test="${not empty category}"><c:param name="category" value="${category}"/></c:if>
    <c:if test="${not empty keyword}"><c:param name="keyword" value="${keyword}"/></c:if>
  </c:url>
</c:set>

<!-- 헤더: 왼쪽 제목 / 오른쪽 정렬 -->
<header class="list-header">
  <h2 class="lh-title">
    <c:choose>
      <c:when test="${not empty keyword and not empty category}">
        <span class="em"><c:out value="${category}"/></span>의 검색결과 상품
      </c:when>
      <c:when test="${not empty keyword}">
        <span class="em">"<c:out value='${keyword}'/>"</span>의 검색결과 상품
      </c:when>
      <c:when test="${not empty category}">
        <span class="em"><c:out value="${category}"/></span>의 상품
      </c:when>
      <c:otherwise>전체 상품</c:otherwise>
    </c:choose>
    <c:if test="${not empty totalCount}">
      <span class="lh-count"><fmt:formatNumber value="${totalCount}"/>개</span>
    </c:if>
  </h2>
  
 <nav class="lh-sort" aria-label="정렬">
  <!-- latest: sort 파라미터 없이 링크 -->
  <a class="lh-link ${sort=='latest' ? 'is-active' : ''}"
     href="${baseListUrl}&page=1">최신순</a>

  <a class="lh-link ${sort=='price_asc' ? 'is-active' : ''}"
     href="${baseListUrl}&sort=price_asc&page=1">저가순</a>

  <a class="lh-link ${sort=='price_desc' ? 'is-active' : ''}"
     href="${baseListUrl}&sort=price_desc&page=1">고가순</a>
</nav>
</header>
  
   <!-- 필터 유지용 히든 폼 -->
  <form id="filterForm" method="get" action="${ctx}/productList.do">
    <input type="hidden" name="category" id="categoryInput" value="${selectedCat}">
    <input type="hidden" name="page" id="pageInput" value="${selectedpage}">
  </form>
  
  	
  	<c:if test="${empty category and empty keyword}">
  <!-- 카테고리 선택 -->
  <nav class="cat-wrap">
    <ul class="cat-grid">
      <c:forEach var="cat" items="${fn:split(categories, ',')}">
        <c:set var="c" value="${fn:trim(cat)}" />
        <li class="cat-item">
          <button type="button"
                  class="cat-btn ${c == category ? 'active' : ''}"
                  data-cat="${c}">
            <c:out value="${c}"/>
          </button>
        </li>
      </c:forEach>
    </ul>
  </nav>
</c:if>
  
  


    <div class="prd-list">
      <!-- 상품목록(한줄에 4개씩) -->
      <c:forEach items="${productList}" var="prd" varStatus="status">      
	      <article class="card">
	        <a href="product.do?prdNo=${prd.prdNo}">
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
<nav aria-label="Page navigation">
  <ul class="pagination justify-content-center">
  

    <!-- Prev -->
    <c:choose>
      <c:when test="${paging.previous}">
        <c:url var="prevUrl" value="/productList.do">
          <!-- 이전 블록의 마지막 페이지로 이동 -->
          <c:param name="page" value="${paging.start - 1}" />
          <!-- 기존 파라미터 순서를 유지: category -> searchCondition -> keyword -> page -->
          <c:if test="${not empty category}">
            <c:param name="category" value="${category}" />
          </c:if>
          <c:if test="${not empty keyword}">
            <c:param name="keyword" value="${keyword}" />
          </c:if>
           <c:if test="${not empty param.sort}">
    		<c:param name="sort" value="${param.sort}" />
  			</c:if>
        </c:url>
        <li class="page-item"><a class="page-link" href="${prevUrl}">Previous</a></li>
      </c:when>
      <c:otherwise>
        <li class="page-item disabled"><span class="page-link">Previous</span></li>
      </c:otherwise>
    </c:choose>

    <!-- 숫자 버튼 -->
    <!-- 위에서 파라미터를 선언해두고 조건절 사용해서 페이징할때 파라미터 보이게할지 만듬 -->
    <c:forEach var="p" begin="${paging.start}" end="${paging.end}">
      <c:choose>
        <c:when test="${paging.currPage eq p}">
          <li class="page-item active" aria-current="page"><span class="page-link">${p}</span></li>
        </c:when>
        <c:otherwise>
          <c:url var="pUrl" value="/productList.do">
            <!-- 기존 파라미터 순서를 유지 -->
            <c:if test="${not empty category}">
              <c:param name="category" value="${category}" />
            </c:if>
            <c:if test="${not empty keyword }">
             <c:param name="keyword" value="${keyword}" />
            </c:if>
            <c:if test="${not empty sort }">
            <c:param name="sort" value="${sort}" />
            </c:if>
            <c:param name="page" value="${p}" />
          </c:url>
          <li class="page-item"><a class="page-link" href="${pUrl}">${p}</a></li>
        </c:otherwise>
      </c:choose>
    </c:forEach>

    <!-- Next -->
    <c:choose>
      <c:when test="${paging.next}">
        <c:url var="nextUrl" value="/productList.do">
          <!-- 다음 블록의 첫 페이지로 이동 -->
          <c:param name="page" value="${paging.end + 1}" />
          <!-- 기존 파라미터 순서를 유지 -->
          <c:if test="${not empty category}">
            <c:param name="category" value="${category}" />
          </c:if>
          <c:if test="${not empty keyword}">
            <c:param name="keyword" value="${keyword}" />
          </c:if>
           <c:if test="${not empty param.sort}">
    		<c:param name="sort" value="${param.sort}" />
  			</c:if>
        </c:url>
        <li class="page-item"><a class="page-link" href="${nextUrl}">Next</a></li>
      </c:when>
      <c:otherwise>
        <li class="page-item disabled"><span class="page-link">Next</span></li>
      </c:otherwise>
    </c:choose>
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
                                
   /* 페이징 전체 */
.pagination {
  display: flex;
  align-items: center;
  gap: 18px; /* 버튼 간격 */
  margin: 20px 0;
}

/* 기본 숫자 버튼 */
.pagination .page-link {
  border: none !important;
  background: transparent !important;
  color: #111;
  font-size: 16px;
  line-height: 1;
  padding: 0;
  box-shadow: none !important;
}

/* 활성 페이지 (초록 칩 스타일) */
.pagination .page-item.active .page-link {
  background: #0f766e !important;
  color: #fff !important;
  font-weight: 600;
  padding: 5px 10px;
  border-radius: 6px;
  font-size: 15px;
}

/* Prev / Next 버튼을 화살표만 크게 */
.pagination .page-item:first-child .page-link,
.pagination .page-item:last-child .page-link {
  font-size: 0; /* 원래 텍스트 숨김 */
  padding: 0;
  border: none;
  background: transparent !important;
  box-shadow: none !important;
  min-width: auto;
}

/* Prev 화살표 */
.pagination .page-item:first-child .page-link::before {
  content: "\2039"; /* ‹ */
  font-size: 22px;   /* 숫자보다 약간 크게 */
  color: #777;
  display: inline-block;
  vertical-align: middle;
}

/* Next 화살표 */
.pagination .page-item:last-child .page-link::before {
  content: "\203A"; /* › */
  font-size: 22px;
  color: #777;
  display: inline-block;
  vertical-align: middle;
}

/* Hover */
.pagination .page-item:first-child .page-link:hover::before,
.pagination .page-item:last-child .page-link:hover::before {
  color: #111;
}

/* 비활성 상태 */
.pagination .page-item.disabled .page-link::before {
  color: #ccc !important;
}
/*최신순*고가순*저가순 */
/* ===== 헤더 레이아웃 & 여백 ===== */
.list-header{
  display:flex;
  align-items:flex-end;
  justify-content:space-between;
  /* 위/아래 간격 */
  margin:18px 0 20px;     /* 헤더 자체의 바깥 여백 */
  padding:12px 0;         /* 헤더 안쪽 여백 */
  border-bottom:1px solid #eee; /* 살짝 구분선 */
  gap:12px;
}

/* 제목(왼쪽) */
.lh-title{
  margin:0;
  font-size:22px;
  line-height:1.3;
  font-weight:700;
  color:#111;
}
.lh-title .em{ color:#0aa58c; }
.lh-title .lh-count{
  margin-left:8px;
  color:#9aa0a6;
  font-weight:400;
}

/* 정렬 탭(오른쪽) - 텍스트 + | 구분자 */
.lh-sort{
  margin-left:auto;                 /* 오른쪽으로 밀기 */
  display:flex; align-items:center; gap:0;
}
.lh-link{
  position:relative;
  display:inline-block;
  padding:0 12px;
  text-decoration:none;
  color:#8f8f8f;
  background:transparent !important;
  border:none !important;
  box-shadow:none !important;
  line-height:1.2;
  white-space:nowrap;
}
.lh-link:hover{ color:#111; }
.lh-link.is-active{ color:#0aa58c; font-weight:700; }

/* 가운데 구분선 |  */
.lh-link + .lh-link::before{
  content:"";
  position:absolute;
  left:0; top:50%;
  width:1px; height:14px;
  background:#e5e7eb;
  transform:translateY(-50%);
}

/* ===== 반응형 ===== */
@media (max-width: 640px){
  .list-header{ flex-wrap:wrap; row-gap:8px; }
  .lh-title{ font-size:18px; }
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
      document.getElementById("pageInput").value = 1; // 카테고리 변경 시 1페이지로 초기화
      document.getElementById('filterForm').submit();
      
    });
  });
</script>




