<!-- document.querySelect('body').style.backgroundColor = '#eee'; 형태로 나중에 조작 부탁 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script>window.APP_CTX = '${ctx}';</script>
<script src="${ctx}/js/joinForm.js"></script>

<div class="joinContainer">
	
	<div class="joinTitle">
		<h1>회원가입</h1>
		<p>본인 정보를 입력해주세요</p>
	</div>
	
	<form id="joinForm" action="${ctx}/join.do" method="post">
		<fieldset class="topJoinInfo">
		  <div class="input-wrapper">
		  	<!-- 아이디 입력 -->
		    <label for="memberId" class="inside-label">아이디</label>
		    <input type="text" id="memberId" name="memberId" required>
		    <button type="button" id="checkIdBtn">중복확인</button>
		  </div>
		  
		  <div class="input-wrapper">
		 	  <!-- 비밀번호 입력 -->
		    <label for="memberPw" class="inside-label">비밀번호</label>
		    <input type="password" id="memberPw" name="memberPw" required>
		  </div>
		  
		  <div class="input-wrapper">
		  	<!-- 비밀번호 확인 -->
		    <label for="PwConfirm" class="inside-label">비밀번호 확인</label>
		    <input type="password" id="PwConfirm" required>
		  </div>
		</fieldset>
		
		
		<fieldset class="bottomJoinInfo">
			<div class="input-wrapper">
				<!-- 이름 입력 -->
				<label for="memberName" class="inside-label">이름</label>
				<input type="text" id="memberName" name="memberName" required>
			</div>
			
			<div class="input-wrapper">
				<!-- 생년월일 입력 -->
				<label for="memberBirth" class="inside-label">생년월일</label>
				<input type="text" id="memberBirth" name="memberBirth" required placeholder="19950105">
			</div>
			
			<div class="input-wrapper">
				<!-- 휴대폰번호 입력 -->
				<label for="memberPhone" class="inside-label">휴대폰번호</label>
				<input type="tel" id="memberPhone" name="memberPhone" required placeholder="0101231234">
			</div>
		</fieldset>
		
		<fieldset class="joinBtn">
			<button type="submit">회원가입</button>
			<button type="button" onclick="location.href='http://localhost/Anabada/loginForm.do'">취소</button>
		</fieldset>
	</form>
</div>