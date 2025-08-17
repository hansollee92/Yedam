<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<section class="wrapper">
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
</section>