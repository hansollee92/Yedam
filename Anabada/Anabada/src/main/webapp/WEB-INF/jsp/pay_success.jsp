<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="max-width:560px;margin:60px auto;background:#fff;border-radius:12px;box-shadow:0 8px 24px rgba(0,0,0,0.06);padding:32px;">
  <h1 style="margin:0 0 12px;font-size:22px;font-weight:700;">결제 완료</h1>
  <p style="color:#189a7e;margin:0 0 20px;">결제가 정상적으로 승인되었습니다.</p>

  <ul style="line-height:1.8;">
    <li style="margin-bottom: 5px;">구매자: <b><c:out value="${customerName}"/></b></li>
    <li style="margin-bottom: 5px;">상품이름: <b><c:out value="${orderName}"/></b></li>
    <li style="margin-bottom: 5px;">결제금액: <b><c:out value="${amount}"/></b> 원</li>
  </ul>

  <div style="display:flex;gap:10px;margin-top:24px;">
    <a href="<c:url value='/main.do'/>" style="flex:1;height:44px;display:inline-flex;align-items:center;justify-content:center;background:#0C8274;border-radius:8px;color: #fff !important;font-weight:700;text-decoration:none;">메인으로</a>
  </div>
</div>
