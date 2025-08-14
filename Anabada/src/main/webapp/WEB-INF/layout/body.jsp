<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- body파일 -->
<body>
<h1>메인 페이지(main)</h1>
<!-- 배너 -->
<div style="width:100%; margin-bottom:20px;">
    <img src="${ctx}/images/banner01.png" alt="배너" style="width:100%;">
</div>

<!-- 오늘의 상품 -->
<h2>오늘의 상품</h2>
<div style="display:flex; flex-wrap:wrap; gap:10px;">
    <!-- 샘플 상품 12개 -->
    <c:forEach var="i" begin="1" end="12">
        <div style="border:1px solid #ddd; width:200px; padding:10px;">
            <img src="${ctx}/images/sample_${i}.jpg" alt="상품_${i}" style="width:100%;">
            <p>상품 이름 ${i}</p>
            <p>가격: 100,000원</p>
        </div>
    </c:forEach>
</div>

<!-- 공지사항 -->
<h2 style="margin-top:40px;">공지사항</h2>
<ul>
    <li><a href="#">공지사항 1</a></li>
    <li><a href="#">공지사항 2</a></li>
    <li><a href="#">공지사항 3</a></li>
</ul>
</body>
