<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body>
    <div class="mypage-container">
        <aside class="sidebar">
            <div class="profile-img">
                <img src="${ctx}/images/mypage/user-default2.png"  alt="user_default">
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
            <div class="list">
                <ul class="menu-list">
                    <%-- href로 이동시 페이지 전체 새로고침이 되어 data-url을 설정하여 fetch로 항목 변경만 함 --%>
                    <li><a href="#" class="mypage-menu" data-url="wishList.do?memberNo=${member_info.memberNo}">찜목록</a></li>
                    <li><a href="#" class="mypage-menu" data-url="saleList.do?memberNo=${member_info.memberNo}">판매 내역</a></li>
                    <li><a href="#" class="mypage-menu" data-url="purList.do?memberNo=${member_info.memberNo}">구매 내역</a></li>
                    <li><a href="#" class="mypage-menu" data-url="reviewList.do?memberNo=${member_info.memberNo}">리뷰 내역</a></li>
                </ul>
                <a href="/mypage/update" class="update-myInfo">회원정보 수정</a>
            </div>
        </aside>

        <main class="main-content" id="mainContent" ></main>
    </div>

    <!-- 별 동작 부분 -->
    <script src="${ctx}/js/star.js"></script>

    <script>
        <%-- 처음 화면 들어갔을때 찜 목록 보여주기 --%>
        document.addEventListener("DOMContentLoaded", () => {
            fetch("wishList.do?memberNo=${member_info.memberNo}")
                .then(res => res.text())
                .then(html => {
                    document.getElementById("mainContent").innerHTML = html;
                });
        });

        <!-- 메뉴 클릭시 이벤트 발생으로 화면 전환 -->
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