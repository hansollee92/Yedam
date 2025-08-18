<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body class="success-page">
  <div class="success-wrapper">
    <div class="success-container">
      <h1>
			  <c:choose>
			    <c:when test="${status == 'success'}">
			      회원가입이 완료되었습니다.
			    </c:when>
			    <c:otherwise>
			      회원가입에 실패하였습니다.
			    </c:otherwise>
			  </c:choose>
			</h1>
			
			<c:if test="${status != 'success'}">
			  <p class="fail-subtext">회원가입 정보를 확인 후 다시 시도해주세요.</p>
			</c:if>

      <c:choose>
        <c:when test="${status == 'success'}">
          <div class="button-group">
            <a class="btn-login" href="${pageContext.request.contextPath}/loginForm.do">로그인</a>
            <a class="btn-home" href="${pageContext.request.contextPath}/main.do">홈</a>
          </div>
        </c:when>
        <c:otherwise>
          <div class="button-group">
            <a class="btn-home" href="${pageContext.request.contextPath}/main.do">홈</a>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</body>