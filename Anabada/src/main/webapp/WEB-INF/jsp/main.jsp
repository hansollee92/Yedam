<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<div class="main-wrap">

  <!-- Swiper -->
  <div class="swiper mySwiper">
    <div class="swiper-wrapper">
      <div class="swiper-slide"><img src="${ctx}/images/main/banner01.jpg" alt="banner image01"></div>
      <div class="swiper-slide"><img src="${ctx}/images/main/banner02.jpg" alt="banner image02"></div>
      <div class="swiper-slide"><img src="${ctx}/images/main/banner03.jpg" alt="banner image03"></div>
    </div>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
  </div>

  <!-- Product List -->
  <section class="products">
    <div class="sec-head">
      <h3>오늘의 상품 추천</h3>
      <a href="${ctx}/productList.do" class="sec-sub">오늘 올라온 상품이 궁금하다면 확인 ></a>
    </div>

    <div class="prd-list">
      <!-- 상품목록(한줄에 4개씩) -->
      <c:forEach items="${product_list}" var="prd" varStatus="status">      
	      <article class="card">
	        <a href="${ctx}/product.do?prdNo=${prd.prdNo}">
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