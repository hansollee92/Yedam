
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body class="join-page">
  <script>window.APP_CTX = '${ctx}';</script>
  <script src="${ctx}/js/joinForm.js"></script>

  <div class="join-wrapper">
  
    <div class="join-container">

      <div class="joinTitle">
        <h1>회원가입</h1>
        <p>본인 정보를 입력해주세요</p>
      </div>

      <form id="joinForm" action="${ctx}/join.do" method="post">
        <fieldset class="topJoinInfo">
          <div class="input-wrapper">
            <label for="memberId" class="inside-label">아이디</label>
            <input type="text" id="memberId" name="memberId" required>
            <button type="button" id="checkIdBtn">중복확인</button>
          </div>

          <div class="input-wrapper">
            <label for="memberPw" class="inside-label">비밀번호</label>
            <input type="password" id="memberPw" name="memberPw" required>
          </div>

          <div class="input-wrapper">
            <label for="pwConfirm" class="inside-label">비밀번호 확인</label>
            <input type="password" id="pwConfirm" required>
          </div>
            <span class="inline-msg" id="pwMsg" aria-live="polite"></span>
        </fieldset>

        <fieldset class="bottomJoinInfo">
          <div class="input-wrapper">
            <label for="memberName" class="inside-label">이름</label>
            <input type="text" id="memberName" name="memberName" required>
          </div>

          <div class="input-wrapper">
            <label for="memberBirth" class="inside-label">생년월일</label>
            <input type="text" id="memberBirth" name="memberBirth" required placeholder="19950105">
          </div>

          <div class="input-wrapper">
            <label for="memberPhone" class="inside-label">휴대폰번호</label>
            <input type="tel" id="memberPhone" name="memberPhone" required placeholder="0101231234">
          </div>
        </fieldset>

        <fieldset class="joinBtn">
          <button type="submit">회원가입</button>
          <button type="button" onclick="location.href='${ctx}/main.do'">취소</button>
        </fieldset>
      </form>

    </div>
  </div>
</body>