<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- template 파일. -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">

<head>
  <title><tiles:getAsString name="title"/></title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="format-detection" content="telephone=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="author" content="">
  <meta name="keywords" content="">
  <meta name="description" content="">
	
  <link rel="stylesheet" href="${ctx}/css/mainStyle.css">
  <link rel="stylesheet" href="${ctx}/css/main.css">  
  <link rel="stylesheet" href="${ctx}/css/product.css">  
  <link rel="stylesheet" href="${ctx}/css/productModify.css">  
  <link rel="stylesheet" href="${ctx}/css/login.css">
  <link rel="stylesheet" href="${ctx}/css/findIdPw.css"> <!-- Id,Pw 찾기 CSS -->
  <link rel="stylesheet" href="${ctx}/css/joinForm.css"> <!-- 회원가입 화면 CSS -->
	<link rel="stylesheet" href="${ctx}/css/joinSuccess.css"> <!-- 회원가입 완료 화면 CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
    rel="stylesheet">
  <script src="https://kit.fontawesome.com/40f9784bbf.js" crossorigin="anonymous"></script>
</head>

<body>

  <!--header-->
  <tiles:insertAttribute name="header" />
  <div class="change-background">
	  <!-- body -->
	  <tiles:insertAttribute name="body" />
	  <!-- footer -->
	  <tiles:insertAttribute name="footer" />
  </div>

  <!--top button-->
  <div class="top-btn"><a href="#">TOP</a></div>
  <!-- script -->
  <script src="js/jquery-1.11.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>

