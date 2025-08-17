<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="ctx" value="${pageContext.request.contextPath}" />
    
<!-- 로그인 -->
<section class="auth-card" role="form" aria-labelledby="login-title">
  <h1 id="login-title" class="auth-title">로그인</h1>
  <p class="auth-sub">아이디와 비밀번호를 입력해주세요</p>

  <!-- 서버 에러 메시지 노출용 (필요 시) -->
  <c:if test="${param.err == '1'}">
    <div class="auth-alert" role="alert">아이디 또는 비밀번호가 올바르지 않습니다.</div>
  </c:if> 

  <form action="${ctx}/login.do" method="post" autocomplete="off" class="auth-form">
    <div class="form-row">
      <input id="memberId" name="memberId" type="text" required placeholder="아이디">
    </div>

    <div class="form-row">
      <input id="memberPw" name="memberPw" type="password" required placeholder="비밀번호">
    </div>
    
    <div class="login-search">
    	<a href="#">아이디/비밀번호 찾기</a>
    </div>

    <div class="form-actions">
      <button type="submit" class="btn btn_login">로그인</button>
      <a class="btn cancel" href="${ctx}/">취소</a>
    </div>
  </form>
</section>
