<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<h2>찜목록</h2>
<div class="items-grid">
    <c:forEach var="wish" items="${wish_list}" >
        <div class="item-card">
            <div class="item-img"><c:out value="${wish.prdImg}" /></div>
            <div class="item-desc"><c:out value="${wish.prdName}" /></div>
            <div class="item-price"><fmt:formatNumber value="${wish.price}" pattern="#,###" /></div>
        </div>
    </c:forEach>
</div>