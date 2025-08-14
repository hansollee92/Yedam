<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- body파일 -->
<body>
<!-- 배너: 21:9 비율, 높이 자동 반응형 -->
<div class="container">
  <div class="ratio ratio-21x9" style="max-height: 320px; overflow: hidden;">
    <img src="${ctx}/images/banner01.png" alt="배너"
         class="w-100 h-100" style="object-fit: cover;">
  </div>
</div>


<div class="container">
<h2 class="h5 mb-3">오늘의 상품 추천</h2>
<p><a href="">오늘 올라온 상품들이 궁금하다면 확인</a></p>
  <div class="row g-3">
    <c:forEach var="i" begin="1" end="12">
      <!-- 모바일 2열, 태블릿 3열, 데스크톱 4열 -->
      <div class="col-6 col-md-4 col-lg-3">
        <div class="card h-100">
          <div class="rati ratio-1x1">o
            <img src="${ctx}/images/sample_${i}.png"   
                 alt="상품 ${i}" class="w-100 h-100" style="object-fit: cover;">
          </div>
          <div class="card-body">
            <div class="text-truncate">상품 이름 ${i}</div>
            <div class="small text-muted mt-1">1일 전</div>
            <div class="fw-bold mt-1">100,000원</div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
