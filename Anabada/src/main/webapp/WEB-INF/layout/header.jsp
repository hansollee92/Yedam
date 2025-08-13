<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
    
<!-- header 파일. -->
<header>
  <div class="wrapper">
    <div class="header-top">
      <div class="logo">
        <a href="#none">
          <img src="${ctx}/images/logo.png" alt="아나바다 로고">
          <span class="visually-hidden">아나바다</span>
        </a>
      </div>

      <div class="search">
        <form id="search-form" action="#none" method="get">
          <input type="text" placeholder="어떤 상품을 찾으시나요? 상품명, 지역명, 태그 검색" class="form-control">
          <button class="btn" type="button" id="button-addon2">
            <i class="fa-solid fa-magnifying-glass" aria-hidden="true"></i>
            <span class="visually-hidden">검색</span>
          </button>
        </form>
      </div>

      <ul class="auth">
        <li><a href="#none"><i class="fa-regular fa-circle-user"></i> 로그인</a></li>
        <li class="v-line"></li>
        <li><a href="#none"><i class="fa-solid fa-circle-plus"></i> 회원가입</a></li>
      </ul>
    </div>

    <nav class="main-nav">
      <div class="dropdown">
        <a class="dropdown-toggle" href="#none"><i class="fa-solid fa-bars"></i></a>
        <ul class="dropdown-menu">
          <li class="label">전체 카테고리</li>
          <li><a class="dropdown-item" href="#none">의류</a></li>
          <li><a class="dropdown-item" href="#none">신발</a></li>
          <li><a class="dropdown-item" href="#none">악세사리</a></li>
          <li><a class="dropdown-item" href="#none">디지털/가전</a></li>
          <li><a class="dropdown-item" href="#none">스포츠</a></li>
          <li><a class="dropdown-item" href="#none">도서/티켓</a></li>
          <li><a class="dropdown-item" href="#none">가구/생활</a></li>
          <li><a class="dropdown-item" href="#none">기타</a></li>
        </ul>
      </div>
      <div><a href="#none" class="notice-link">공지사항</a></div>
    </nav>
  </div>
</header>
<div class="line"></div>

<!--top button-->
<div class="top-btn"><a href="#">TOP</a></div>