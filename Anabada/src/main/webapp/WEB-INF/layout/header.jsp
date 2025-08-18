<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
    
<!-- header 파일. -->
<header>
  <div class="wrapper">
    <div class="header-top">
      <div class="logo">
        <a href="${ctx}/main.do">
          <img src="${ctx}/images/logo.png" alt="아나바다 로고">
          <span class="visually-hidden">아나바다</span>
        </a>
      </div>

      <div class="search">
        <form id="search-form" action="${pageContext.request.contextPath}/productList.do"method="get">
          <input type="hidden" name="searchCondition" value=""> <!-- 통합검색 -->
          <input type="text" name="keyword" class="form-control" 
         		 placeholder="어떤 상품을 찾으시나요? 상품명, 지역명, 태그 검색" 
         		 value="${param.keyword}">
 		  <input type="hidden" name="page" value="1">
          <button class="btn" type="button" id="button-addon2">
            <i class="fa-solid fa-magnifying-glass" aria-hidden="true"></i>
            <span class="visually-hidden">검색</span>
          </button>
        </form>
      </div>

      <ul class="auth">
	      <c:choose>
	      		<c:when test="${empty logMember}">
	      			<li><a href="${ctx}/loginForm.do"><i class="fa-regular fa-circle-user"></i> 로그인</a></li>
			        <li class="v-line"></li>
			        <li><a href="${ctx}/joinForm.do"><i class="fa-solid fa-circle-plus"></i> 회원가입</a></li>
	      		</c:when>
	      		<c:otherwise>
	      			<li><a href="#"><i class="fa-regular fa-circle-check"></i> 판매하기</a></li>
	      			<li class="v-line"></li>
	      			<li><a href="/mypage?memberNo=${memberNo}"><i class="fa-regular fa-circle-user"></i> 마이페이지</a></li>
	      			<li class="v-line"></li>
	      			<li><a href="#"><i class="fa-solid fa-circle-xmark"></i> 로그아웃</a></li>
	      		</c:otherwise>
	      </c:choose>
      </ul>
      
    </div>

    <nav class="main-nav">
      <div class="dropdown">
        <a class="dropdown-toggle" href="#none"><i class="fa-solid fa-bars"></i></a>
        <ul class="dropdown-menu">
          <li class="label">전체 카테고리</li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=의류'/>">의류</a></li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=신발'/>">신발</a></li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=악세사리'/>">악세사리</a></li>
          <li><a class="dropdown-item"href="<c:url value='/productList.do?category=디지털%2F가전'/>">디지털/가전</a></li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=스포츠'/>">스포츠</a></li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=도서%2F티켓'/>">도서/티켓</a></li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=가구%2F생활'/>">가구/생활</a></li>
          <li><a class="dropdown-item" href="<c:url value='/productList.do?category=기타'/>">기타</a></li>
        </ul>
      </div>
      <div><a href="#none" class="notice-link">공지사항</a></div>
    </nav>
  </div>
</header>
<div class="line"></div>
