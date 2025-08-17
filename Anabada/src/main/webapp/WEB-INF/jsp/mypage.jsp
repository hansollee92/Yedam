<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="${ctx}/css/mypage.css">
</head>

<body>
    <div class="mypage-container">
        <aside class="sidebar">
            <div class="profile-img">
                <img src="${ctx}/images/mypage/user-default.png"  alt="user_default">
            </div>
            <div class="profile-info">
                <strong><c:out value="${member_info.memberName}" /></strong>
                <div class="info-item">19971112</div>
                <!-- 내 별점 -->
                <div id="my_score">
                    <div class="star-rating" id="star-container">
                        <span data-star="5">★</span>
                        <span data-star="4">★</span>
                        <span data-star="3">★</span>
                        <span data-star="2">★</span>
                        <span data-star="1">★</span>
                    </div>
                </div>
                <div>현재 평점: <span id="rating-value"><c:out value="${member_info.memberScore}" /></span></div>
            </div>
            <ul class="menu-list">
                <li><a href="#" class="mypage-menu" data-url="${ctx}/mypage/wish.jsp">찜목록</a></li>
                <li><a href="#" class="mypage-menu" data-url="${ctx}/mypage/sales_list">판매 내역</a></li>
                <li><a href="#" class="mypage-menu" data-url="${ctx}/mypage/pur_list">구매 내역</a></li>
                <li><a href="#" class="mypage-menu" data-url="${ctx}/mypage/reviews">리뷰 내역</a></li>
            </ul>
            <a href="/mypage/update" class="update-myInfo">회원정보 수정</a>

        </aside>

        <main class="main-content" id="mainContent">
            <jsp:include page="wish_list.jsp" />
        </main>
    </div>

    <!-- 별 동작 부분 -->
    <script src="${ctx}/js/star.js"></script>

    <!-- 메뉴 클릭시 이벤트 발생으로 화면 전환 -->
    <script>
        document.querySelectorAll('.mypage-menu').forEach(el => {
            el.addEventListener('click', function(e) {
                e.preventDefault();
                fetch(this.dataset.url)
                    .then(res => res.text())
                    .then(html => {
                        document.getElementById('mainContent').innerHTML = html;
                    });
            });
        });
    </script>
</body>

</html>