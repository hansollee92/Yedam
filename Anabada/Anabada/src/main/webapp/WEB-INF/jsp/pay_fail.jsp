<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="max-width:560px;margin:60px auto;background:#fff;border-radius:12px;box-shadow:0 8px 24px rgba(0,0,0,0.06);padding:32px;">
  <h1 style="margin:0 0 12px;font-size:22px;font-weight:700;">결제 실패</h1>
  <p style="color:#d9534f;margin:0 0 20px;">결제가 실패했습니다.</p>

  <ul style="line-height:1.8;">
    <li>주문번호: <b><c:out value="${orderId}"/></b></li>
    <li>코드: <c:out value="${code}"/></li>
    <li>메시지: <c:out value="${message}"/></li>
    <c:if test="${not empty error}">
      <li>오류: <c:out value="${error}"/></li>
    </c:if>
  </ul>

  <div style="display:flex;gap:10px;margin-top:24px;">
    <a href="<c:url value='/payForm.do'/>" style="flex:1;height:44px;display:inline-flex;align-items:center;justify-content:center;background:#EEEEEE;border-radius:8px;color:#333;font-weight:700;text-decoration:none;">다시 시도</a>
  </div>
</div>
