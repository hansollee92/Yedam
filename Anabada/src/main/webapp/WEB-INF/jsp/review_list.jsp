<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
  <link rel="stylesheet" href="${ctx}/css/mypage.css">
</header>
<body>
<div class="mypage-review-wrap">
  <h2 class="mypage-review-title">리뷰 내역</h2>
  <!-- 내가 쓴 리뷰 -->
  <section class="review-section">
    <h4 class="section-title">나의 리뷰</h4>
    <div class="review-list">
      <c:forEach var="review" items="${myReviewList}">
        <div class="review-item">
          <div class="review-thumb">
            <img src="${review.imgUrl}" alt="상품이미지">
          </div>
          <div class="review-content">
            <div class="review-product-name">${review.productName}</div>
            <div class="review-rating">
              <c:forEach begin="1" end="${review.rating}">
                <span class="star">&#9733;</span>
              </c:forEach>
              <c:forEach begin="${review.rating+1}" end="5">
                <span class="star empty">&#9734;</span>
              </c:forEach>
            </div>
            <div class="review-desc">${review.content}</div>
          </div>
        </div>
      </c:forEach>
    </div>

    <%-- 페이지네이션 붙이는 부분 --%>
    <jsp:include page="/WEB-INF/views/common/pagination.jsp" />
    <%-- 페이징 코드 전달해주신 것 그대로 사용 --%>
  </section>

  <!-- 내가 받은 리뷰 -->
  <section class="review-section">
    <h2 class="section-title">내가 받은 리뷰</h2>
    <div class="review-list">
      <c:forEach var="review" items="${receivedReviewList}">
        <div class="review-item">
          <div class="review-thumb">
            <img src="${review.imgUrl}" alt="상품이미지">
          </div>
          <div class="review-content">
            <div class="review-product-name">${review.productName}</div>
            <div class="review-user">구매자 : ${review.reviewerName}</div>
            <div class="review-desc">${review.content}</div>
          </div>
        </div>
      </c:forEach>
    </div>

    <%-- 페이지네이션 동일하게 적용 --%>
    <jsp:include page="/WEB-INF/views/common/pagination.jsp" />
  </section>
</div>

