<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/mypage.css">
</head>

<body>
<!-- <img src="../images/mypage/user-default.png"> -->

<div class="mypage-container">
    <aside class="sidebar">
        <div class="profile-img"></div>
        <div class="profile-info">
            <strong>홍길동</strong>
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
            <div>현재 평점: <span id="rating-value">2</span></div>
        </div>


        <ul class="menu-list">
            <li><a href="#" data-url="/">찜목록</a></li>
            <li><a href="#" data-url="/mypage/sales">판매 내역</a></li>
            <li><a href="#" data-url="/mypage/purchases">구매 내역</a></li>
            <li><a href="#" data-url="/mypage/reviews">리뷰 내역</a></li>
        </ul>

        <a href="/mypage/update" class="update-myInfo">회원정보 수정</a>
    </aside>

    <main class="main-content">
        <h2>찜목록</h2>
        <div class="items-grid">
            <!-- 아이템 카드 반복 -->
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
            <div class="item-card">
                <div class="item-img"></div>
                <div class="item-desc">애플펜슬 프로 미개봉</div>
                <div class="item-price">145,000원</div>
            </div>
        </div>
    </main>

    <!-- 별 동작 부분 -->
    <script src="../js/star.js"></script>
</div>
</body>

</html>