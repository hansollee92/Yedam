<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<header>
    <link rel="stylesheet" href="${ctx}/css/mypage.css">
</header>
<body>
<h2>구매 내역</h2>
<div class="items-grid">
    <c:forEach var="pur" items="${pur_list}" >
        <div>
            <a href="product.do?prdNo=${pur.prdNo}" class="item-card" data-prd-name="${pur.prdName}" data-prd-no="${pur.prdNo}" data-pur-no="${pur.purNo}">
                <div class="item-img"><img src="${ctx}/images/product/${pur.prdImg}" alt="상품이미지"></div>
                <div class="item-desc"><c:out value="${pur.prdName}" /></div>
                <div class="item-price"><fmt:formatNumber value="${pur.price}" pattern="#,###" />원</div>
            </a>
            <c:choose>
                <c:when test="${pur.reviewNo == 0}">
                    <button class="btn btn-primary btn-open-review">리뷰 작성</button>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-disabled" disabled>리뷰 완료</button>
                </c:otherwise>
            </c:choose>
        </div>
    </c:forEach>
</div>

<%--
<!-- Review Modal -->
<div id="reviewModal" class="modal-backdrop" role="dialog" aria-modal="true" aria-hidden="true">
    <div class="modal">
        <div class="modal-header">
            <div class="modal-title">리뷰 등록</div>
            <button type="button" class="modal-close" aria-label="닫기">&times;</button>
        </div>
        <div class="modal-body">
            <div style="margin-bottom:6px; font-size:13px; color:#666;">상품: <span id="mPrdName"></span></div>
            <div id="starWrap" class="stars" aria-label="별점 선택" role="radiogroup" style="margin-bottom:10px;">
                <span data-v="1">&#9733;</span>
                <span data-v="2">&#9733;</span>
                <span data-v="3">&#9733;</span>
                <span data-v="4">&#9733;</span>
                <span data-v="5">&#9733;</span>
            </div>
            <textarea id="mContent" placeholder="구매 후기를 남겨주세요. (최대 200자)"></textarea>
        </div>
        <div class="modal-footer">
            <button id="btnSaveReview" class="btn btn-primary" type="button">등록</button>
        </div>
        <form id="reviewForm" method="post" action="${ctx}/review/save.do" style="display:none;">
            <input type="hidden" name="purNo" id="fPurNo">
            <input type="hidden" name="prdNo" id="fPrdNo">
            <input type="hidden" name="score" id="fScore">
            <input type="hidden" name="content" id="fContent">
        </form>
    </div>
</div>

--%>

<script src="${ctx}/js/modal.js"></script>

<script>
    document.querySelectorAll('.item-img').forEach(function(img) {
        img.addEventListener('mouseenter', function() {
        });
        img.classList.add('clicked');
        img.addEventListener('mouseleave', function() {
            img.classList.remove('clicked');
        });
    });
</script>
</body>