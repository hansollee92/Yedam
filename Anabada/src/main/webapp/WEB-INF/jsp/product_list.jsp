<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<section class="wrapper">
  <h2>상품 목록</h2>

  <!-- 필터/검색 -->
  <form method="get" action="${ctx}/product/product_list.tiles" class="filter-bar">
    <select name="category">
      <option value="">전체</option>
      <option value="의류"        ${category=='의류'?'selected':''}>의류</option>
      <option value="신발"        ${category=='신발'?'selected':''}>신발</option>
      <option value="악세사리"    ${category=='악세사리'?'selected':''}>악세사리</option>
      <option value="디지털/가전"  ${category=='디지털/가전'?'selected':''}>디지털/가전</option>
      <option value="스포츠"      ${category=='스포츠'?'selected':''}>스포츠</option>
      <option value="도서/티켓"    ${category=='도서/티켓'?'selected':''}>도서/티켓</option>
      <option value="가구/생활"    ${category=='가구/생활'?'selected':''}>가구/생활</option>
    </select>

    <input type="text" name="q" value="${q}" placeholder="상품명·지역명·태그로 검색">

    <select name="sort">
      <option value="recent" ${sort=='recent'?'selected':''}>최신순</option>
      <option value="low"    ${sort=='low'?'selected':''}>저가순</option>
      <option value="high"   ${sort=='high'?'selected':''}>고가순</option>
    </select>

    <button type="submit">검색</button>
  </form>

  <!-- 결과 -->
  <c:if test="${empty productList}">
    <p>검색 결과가 없습니다.</p>
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
              <div class="prod-meta">
                <span>${p.sido} ${p.sigungu}</span>
                <span>#${p.prdTag}</span>
              </div>
            </div>
          </a>
        </li>
      </c:forEach>
    </ul>
  </c:if>
</section>