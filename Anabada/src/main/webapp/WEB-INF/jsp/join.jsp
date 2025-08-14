<!-- document.querySelect('body').style.backgroundColor = '#eee'; 형태로 나중에 조작 부탁 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<h1>회원가입</h1>
<p>본인 정보를 입력해주세요</p>

<form id="joinForm" action="${ctx}/join.do" method="post">
	<fieldset class="topJoinInfo">
	  <div>
	    <label for="memberId">아이디</label>
	    <input type="text" id="memberId" name="memberId" required>
	    <button type="button" id="checkIdBtn">중복확인</button>
	  </div>
	  
	  <div>
	    <label for="memberPw">비밀번호</label>
	    <input type="password" id="memberPw" name="memberPw" required>
	  </div>
	  
	  <div>
	    <label for="PwConfirm">비밀번호 확인</label>
	    <input type="password" id="PwConfirm" required>
	  </div>
	</fieldset>
	
	
	<fieldset class="bottomJoinInfo">
		<div>
			<label for="memberName">이름</label>
			<input type="text" id="memberName" name="memberName" required>
		</div>
		
		<div>
		  <label for="birthYear">생년월일</label>
		  <select id="birthYear" name="birthYear" required>
		    <option value="">연도</option>
		    <% for(int y = 1950; y <= 2025; y++) { %>
		      <option value="<%=y%>"><%=y%></option>
		    <% } %>
		  </select>
		
		  <select id="birthMonth" name="birthMonth" required>
		    <option value="">월</option>
		    <% for(int m = 1; m <= 12; m++) { %>
		      <option value="<%=m%>"><%=m%></option>
		    <% } %>
		  </select>
		
		  <select id="birthDay" name="birthDay" required>
		    <option value="">일</option>
		    <% for(int d = 1; d <= 31; d++) { %>
		    	<option value="<%=d%>"><%=d%></option>
		    <% } %>
		  </select>
		  
		  <!-- 서버로 보낼 실제 생년월일 -->
      <input type="hidden" id="memberBirth" name="memberBirth">
		</div>
		
		<div>
			<label for="memberPhone">연락처</label>
			<input type="tel" id="memberPhone" name="memberPhone" required placeholder='0101231234 ( - 생략)'>
		</div>
	</fieldset>
	
	<fieldset class="joinBtn">
		<button type="submit">회원가입</button>
		<button type="button" onclick="location.href='http://localhost/Anabada/loginForm.do'">취소</button>
	</fieldset>
</form>