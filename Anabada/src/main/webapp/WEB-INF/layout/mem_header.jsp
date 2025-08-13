<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    

<!-- header 파일. -->
<header>
   <div class="logo logo-member">
     <a href="#none">
       <img src="${ctx}/images/logo.png" alt="아나바다 로고">
       <span class="visually-hidden">아나바다</span>
     </a>
   </div>
</header>
<div class="line"></div>

<!--top button-->
<div class="top-btn"><a href="#">TOP</a></div>