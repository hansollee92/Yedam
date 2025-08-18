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
        <a href="product.do?prdNo=${pur.prdNo}" class="item-card">
            <div class="item-img"><img src="${ctx}/images/product/${pur.prdImg}"></div>
            <div class="item-desc"><c:out value="${pur.prdName}" /></div>
            <div class="item-price"><fmt:formatNumber value="${pur.price}" pattern="#,###" /></div>
        </a>
    </c:forEach>
</div>
<script>
    document.querySelectorAll('.item-img').forEach(function(img) {
        img.addEventListener('mouseenter', function() {
            img.classList.add('clicked');
        });
        img.addEventListener('mouseleave', function() {
            img.classList.remove('clicked');
        });
    });
</script>
</body>