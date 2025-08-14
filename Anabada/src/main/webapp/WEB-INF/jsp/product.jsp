<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    

<!-- 상품상태 : on-sale reserved sold-out -->
<section class="product-detail onSale">

  <div class="pd-top">
    <div class="pd-gallery col-6">
      <img src="${ctx}/images/product/jacket.jpg" alt="상품 이미지">
      <!-- 판매완료 오버레이 (soldOut일 때 자동 표시) -->
      <div class="soldout-mark"><span>판매완료</span></div>
    </div>

    <div class="pd-summary col-6" >
      <h1 class="pd-title">유스 24SS M70 필드 자켓 블랙 S</h1>
      <div class="pd-price"><strong>150,000</strong> <span>원</span></div>

      <div class="line"></div>
      <div class="pd-meta">
        <span><i class="fa-solid fa-heart"></i> 24</span>
        <span><i class="fa-solid fa-eye"></i> 50</span>
        <span><i class="fa-solid fa-clock"></i> 2025.08.01</span>

        <!-- 판매자만 보이는 상태 셀렉트 -->
        <div class="pd-status">
          <select class="form-select">
            <option>판매중</option>
            <option>예약중</option>
            <option>판매완료</option>
          </select>
        </div>
      </div>


      <ul class="pd-attrs">
        <li><span>상품상태</span>새 상품</li>
        <li><span>거래방식</span>택배 거래</li>
      </ul>

      <!-- 버튼 영역 -->
      <div class="pd-actions">

        <!-- 구매자 전용 -->
        <div class="buyer-actions">
          <div class="row-actions">
            <button type="button" class="btn-line">찜하기</button>
            <button type="button" class="btn-line">문의하기</button>
          </div>
          <button type="button" class="btn-primary btn-lg">구매하기</button>
        </div>

        <!-- 판매자 전용 -->
        <div class="seller-actions">
          <div class="row-actions">
            <button type="button" class="btn-line">글 수정</button>
            <button type="button" class="btn-line">글 삭제</button>
          </div>
          <button type="button" class="btn-primary btn-lg is-disabled">예약 중</button>
        </div>

        <!-- 판매완료 전용 -->
        <div class="sold-actions">
          <button type="button" class="btn-primary btn-lg is-disabled" disabled>판매완료</button>
        </div>

      </div>


    </div>
  </div>

  <!-- 상품 정보 -->
  <section class="pd-section">
    <h2 class="pd-sec-title">상품 정보</h2>
    <p class="pd-desc">
      집에서 시착만 해보고 택 그대로 있는 새상품입니다.<br>
      정가 184000원인데 현재는 품절 상품입니다.<br>
      무광 톤다운된 카키로 데일리하게 입을 수 있는 제품이고<br>
      충분한 주머니가 달려있어서 실용성까지 챙길 수 있는 멋드러진 상품입니다. <br><br>
      택배거래 가능하며, <br>
      반택은 부피가 커서 불가합니다. <br>
      직거래 원하시면 문의주세요.
      <br><br>네고불가
    </p>
  </section>

  <!-- 정보 카드 3열 -->
  <section class="pd-cards">
    <div class="pd-card">
      <div class="pd-card-head"><i class="fa-solid fa-location-dot"></i> 직거래 지역</div>
      <div class="pd-card-body">-</div>
    </div>
    <div class="pd-card">
      <div class="pd-card-head"><i class="fa-solid fa-folder-open"></i> 카테고리</div>
      <div class="pd-card-body">의류</div>
    </div>
    <div class="pd-card">
      <div class="pd-card-head"><i class="fa-solid fa-hashtag"></i> 상품태그</div>
      <div class="pd-card-body">#남성의류 #자켓 #카키자켓</div>
    </div>
  </section>

  <!-- 지도 -->
  <section class="pd-map">
    <div class="map-box">[ 지도 영역 ]</div>
  </section>

  <!-- 문의하기 안내 -->
  <section class="pd-qna-head">
    <h2 class="pd-sec-title">문의하기</h2>
    <p class="pd-help">구매하려는 상품에 대해 궁금한 점이 있는 경우 판매자에게 문의해보세요.</p>
    <button type="button" class="btn-primary">상품 문의하기</button>
  </section>

  <!-- 문의 목록 -->
  <section class="pd-qna-list">
    <table class="qna-table">
      <colgroup>
        <col>
        <col style="width:120px">
        <col style="width:140px">
      </colgroup>
      <thead>
        <tr>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>반택해주시면 안되나요?</td>
          <td>user01</td>
          <td>2025.08.01</td>
        </tr>
        <tr>
          <td>제가 음촌동 30일날 받는데 그때까지 상품 판매안하고 있어주시면 안되나요?</td>
          <td>user22</td>
          <td>2025.08.01</td>
        </tr>
        <tr>
          <td>직거래면 지하철역 까지 와주시는 건가요...</td>
          <td>user12</td>
          <td>2025.08.01</td>
        </tr>
        <tr>
          <td>목부분 찢겨짐? 아닌 그냥 가벼인가요?</td>
          <td>user34</td>
          <td>2025.08.01</td>
        </tr>
        <tr>
          <td>비밀글입니다 <i class="fa-solid fa-lock"></i></td>
          <td>user34</td>
          <td>2025.08.01</td>
        </tr>
      </tbody>
    </table>

    <nav aria-label="...">
      <ul class="pagination">
        <li class="page-item disabled">
          <a class="page-link"><i class="fa-solid fa-chevron-left"></i></a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item active">
          <a class="page-link" href="#" aria-current="page">2</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
          <a class="page-link" href="#"><i class="fa-solid fa-chevron-right"></i></a>
        </li>
      </ul>
    </nav>
  </section>

</section>