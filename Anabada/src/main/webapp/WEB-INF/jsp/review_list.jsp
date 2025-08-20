<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<header>
  <link rel="stylesheet" href="${ctx}/css/mypage.css">
</header>
<body>
<h2>리뷰 내역</h2>
<section class="review-section">
    <h6>나의 리뷰</h6>
    <div class="my-list">
        <c:if test="${empty myReviewList}">
            <div class="no-review">작성하신 리뷰가 없습니다.</div>
        </c:if>

        <c:forEach var="myReview" items="${myReviewList}" >
            <hr>
            <div class="review-item-img"><img src="${ctx}/images/product/${myReview.prdImg}" alt="상품이미지"></div>
            <div class="review-item-name"><c:out value="${myReview.prdName}" /> </div>


            <!-- 내 별점 -->
            <div id="my_score">
                <div class="star-rating" id="star-container">
                    <span data-star="5">★</span>
                    <span data-star="4">★</span>
                    <span data-star="3">★</span>
                    <span data-star="2">★</span>
                    <span data-star="1">★</span>
                </div>
            </div>

            <div><span id="rating-value"><c:out value="${myReview.reviewScore}" /></span></div>

            <div class="review-item-content"><c:out value="${myReview.reviewContent}" /></div>
        </c:forEach>
    </div>
    <%-- 페이지네이션 --%>
    <nav id="pg-nav" aria-label="Page navigation example">
        <ul class="pagination justify-content-center"
            style="
		            --bs-pagination-color: var(--black-color);
			        --bs-pagination-bg: #fff;
			        --bs-pagination-border-color: var(--light-gray);

			        --bs-pagination-hover-color: var(--primary-color);
			        --bs-pagination-hover-bg: rgba(12,130,117,.06);
			        --bs-pagination-hover-border-color: var(--primary-color);

			        --bs-pagination-active-color: #fff;
			        --bs-pagination-active-bg: var(--primary-color);
			        --bs-pagination-active-border-color: var(--primary-color);

			        --bs-pagination-disabled-color: var(--gray);
			        --bs-pagination-disabled-bg: #f4f5f6;
			        --bs-pagination-disabled-border-color: var(--light-gray);

			        --bs-pagination-padding-x: 0;
			        --bs-pagination-padding-y: 0;
			        --bs-pagination-font-size: 14px;
			        --bs-pagination-border-radius: 10px;
			        gap: 8px;
		        ">

            <%-- 이전페이지 --%>
            <c:choose>
                <c:when test="${paging.previous}">
                    <li class="page-item">
                        <a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${paging.start -1}#pg-nav">
                            <i class="fa-solid fa-angle-left"></i>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled">
                        <a class="page-link"><i class="fa-solid fa-angle-left"></i></a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:forEach var="p" begin="${paging.start}" end="${paging.end}">
                <c:choose>
                    <c:when test="${paging.currPage eq p}">
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">${p}</span>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${p}#pg-nav">${p}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%-- 다음 페이지 --%>
            <c:choose>
                <c:when test="${paging.next}">
                    <li class="page-item">
                        <a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${paging.end +1}#pg-nav">
                            <i class="fa-solid fa-angle-right"></i>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled">
                        <a class="page-link"><i class="fa-solid fa-angle-right"></i></a>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>
</section>

<section class="review-section">
    <div class="other-list">
        <h6>내가 받은 리뷰</h6>
        <c:if test="${empty otherReviewList}">
            <div class="no-review">받으신 리뷰가 없습니다.</div>
        </c:if>

        <c:forEach var="otherReview" items="${otherReviewList}" >
            <hr>
            <div class="review-item-img"><img src="${ctx}/images/product/${otherReview.prdImg}" alt="상품이미지"></div>
            <div class="review-item-name"><c:out value="${otherReview.prdName}" /> </div>
            <div class="review-item-score"><c:out value="${otherReview.memberName}" /></div>
            <div class="review-item-content"><c:out value="${otherReview.reviewContent}" /></div>
        </c:forEach>
    </div>
    <%-- 페이지네이션 --%>
    <nav id="pg-nav" aria-label="Page navigation example">
        <ul class="pagination justify-content-center"
            style="
		            --bs-pagination-color: var(--black-color);
			        --bs-pagination-bg: #fff;
			        --bs-pagination-border-color: var(--light-gray);

			        --bs-pagination-hover-color: var(--primary-color);
			        --bs-pagination-hover-bg: rgba(12,130,117,.06);
			        --bs-pagination-hover-border-color: var(--primary-color);

			        --bs-pagination-active-color: #fff;
			        --bs-pagination-active-bg: var(--primary-color);
			        --bs-pagination-active-border-color: var(--primary-color);

			        --bs-pagination-disabled-color: var(--gray);
			        --bs-pagination-disabled-bg: #f4f5f6;
			        --bs-pagination-disabled-border-color: var(--light-gray);

			        --bs-pagination-padding-x: 0;
			        --bs-pagination-padding-y: 0;
			        --bs-pagination-font-size: 14px;
			        --bs-pagination-border-radius: 10px;
			        gap: 8px;
		        ">

            <%-- 이전페이지 --%>
            <c:choose>
                <c:when test="${paging.previous}">
                    <li class="page-item">
                        <a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${paging.start -1}#pg-nav">
                            <i class="fa-solid fa-angle-left"></i>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled">
                        <a class="page-link"><i class="fa-solid fa-angle-left"></i></a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:forEach var="p" begin="${paging.start}" end="${paging.end}">
                <c:choose>
                    <c:when test="${paging.currPage eq p}">
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">${p}</span>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${p}#pg-nav">${p}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%-- 다음 페이지 --%>
            <c:choose>
                <c:when test="${paging.next}">
                    <li class="page-item">
                        <a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${paging.end +1}#pg-nav">
                            <i class="fa-solid fa-angle-right"></i>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled">
                        <a class="page-link"><i class="fa-solid fa-angle-right"></i></a>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>
</section>

<script src="${ctx}/js/mypage_paging.js" ></script>
<script src="${ctx}/js/star.js" ></script>

</body>

