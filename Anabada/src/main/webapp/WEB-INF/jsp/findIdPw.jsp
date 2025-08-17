<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body class="find-page">
  <div class="find-wrapper">
    <div class="find-container">
      <h1 class="find-title">아이디/비밀번호 찾기</h1>
      <p class="find-subtitle">가입 시 입력하신 정보를 정확히 입력해주세요.</p>

      <!-- 아이디 찾기 -->
      <section class="finder-panel">
        <h2 class="panel-title">아이디 찾기</h2>
        <form id="findIdForm" action="${ctx}/findId.do" method="post" autocomplete="off">
          <div class="fi-group">
            <input type="text" id="memberName" name="memberName" required />
            <label for="memberName">이름</label>
          </div>
          <div class="fi-group">
            <input type="tel" id="memberPhone" name="memberPhone" required placeholder="01012345678" />
            <label for="memberPhone">휴대폰번호</label>
          </div>
          <div class="fi-group">
            <input type="text" id="memberBirth" name="memberBirth" required placeholder="19950105"/>
            <label for="memberBirth">생년월일</label>
          </div>

          <div class="btn-row">
            <button type="submit" class="fbtn fbtn-primary">아이디 찾기</button>
          </div>
        </form>
      </section>

      <!-- 비밀번호 찾기 -->
      <section class="finder-panel">
        <h2 class="panel-title">비밀번호 찾기</h2>
        <form id="findPwForm" action="${ctx}/findPw.do" method="post" autocomplete="off">
          <div class="fi-group">
            <input type="text" id="memberId" name="memberId" required />
            <label for="memberId">아이디</label>
          </div>
          <div class="fi-group">
            <input type="text" id="memberName" name="memberName" required />
            <label for="memberName">이름</label>
          </div>
          <div class="fi-group">
            <input type="tel" id="memberPhone" name="memberPhone" required placeholder="01012345678" />
            <label for="memberPhone">휴대폰번호</label>
          </div>
          <div class="fi-group">
            <input type="text" id="memberBirth" name="memberBirth" required placeholder="19950105" />
            <label for="memberBirth">생년월일</label>
          </div>

          <div class="btn-row">
            <button type="submit" class="fbtn fbtn-primary">비밀번호 찾기</button>
          </div>
        </form>
      </section>

      <!-- 취소 버튼 -->
      <div class="cancel-row">
        <button type="button" class="fbtn fbtn-cancel" onclick="history.back()">취소</button>
      </div>
    </div>
  </div>
</body>