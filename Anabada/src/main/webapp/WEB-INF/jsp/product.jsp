<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 

<!-- <c:set var="이름" value="값" />
     JSP 페이지에서 잠깐 사용할 임시변수를 만들 수 있는 set -->
     
<!-- 로그인 사용자 객체 저장 -->
<c:set var="loginMember" value="${sessionScope.logMember}" />
<!-- 판매자 본인여부 체크(ture/false) -->
<c:set var="owner" value="${not empty loginMember and loginMember.memberNo == product.memberNo }" />
<!-- 판매상태를 css클래스용 문자열로 변환 (이중삼항연산자)-->
<c:set var="saleClass" value="${product.saleStatus eq '판매중' ? 'onsale'
                         : (product.saleStatus eq '예약중' ? 'reserved' : 'soldout')}" />


<!-- 상품상태 : onsale reserved soldout -->
<!-- ${owner ? 'sellerView' : ''} : 판매자일경우(true) 판매자 화면만 보이게끔 처리 -->
<section class="product-detail ${saleClass} ${owner ? 'sellerView' : ''}">

  <div class="pd-top">
    <div class="pd-gallery col-6">
      <img src="${ctx}/images/product/${product.prdImg}" alt="${product.prdName}">
      <!-- 판매완료 오버레이 (soldout일 때 자동 표시) -->
      <div class="soldout-mark"><span>판매완료</span></div>
    </div>

    <div class="pd-summary col-6" >
      <h1 class="pd-title">${product.prdName}</h1>
      <div class="pd-price"><strong><fmt:formatNumber value="${product.price}" pattern="#,###"/></strong> <span>원</span></div>

      <div class="line"></div>
      <div class="pd-meta">
        <span><i class="fa-solid fa-heart"></i> 24</span>
        <span><i class="fa-solid fa-eye"></i> ${product.viewCnt}</span>
        <span><i class="fa-solid fa-clock"></i> ${product.prdDate}</span>

	    <!-- 판매자만 보이는 상태 셀렉트 -->
	    <c:if test="${owner}">
	        <div class="pd-status">
	          <select class="form-select" name="saleStatus">
	            <option ${product.saleStatus == '판매중' ? 'selected' : ''}>판매중</option>
	            <option ${product.saleStatus == '예약중' ? 'selected' : ''}>예약중</option>
	            <option ${product.saleStatus == '판매완료' ? 'selected' : ''}>판매완료</option>
	          </select>
	        </div>
        </c:if>
      </div>


      <ul class="pd-attrs">
        <li><span>상품상태</span>${product.prdStatus}</li>
        <li><span>거래방식</span>${product.tradeType}</li>
      </ul>

      <!-- 버튼 영역 -->
      <div class="pd-actions">

		<c:choose>		
		    <%-- 1) 판매자(소유자) 화면 --%>
		    <c:when test="${owner}">
		      <c:choose>
		        <%-- 판매완료면 '판매완료' 만 --%>
		        <c:when test="${product.saleStatus eq '판매완료'}">
		          <div class="sold-actions">
		            <button type="button" class="btn-primary btn-lg is-disabled" disabled>판매완료</button>
		          </div>
		        </c:when>
		
		        <%-- 그 외(판매중/예약중)면 판매자용 버튼 --%>
		        <c:otherwise>
		          <div class="seller-actions">
		            <div class="row-actions">
		              <%-- 예시: 수정/삭제 액션 연결 --%>
		              <button type="button"
		                      class="abtn common-btn seller-btn"
		                      onclick="location.href='${ctx}/productModifyForm.do?prdNo=${product.prdNo}'">
		                글 수정
		              </button>
		
		              <form action="${ctx}/productDelete.do" method="post" onsubmit="return confirm('삭제할까요?')" style="display:inline">
		                <input type="hidden" name="prdNo" value="${product.prdNo}">
		                <button type="submit" class="abtn common-btn">글 삭제</button>
		              </form>
		            </div>
		
		            <%-- 예약중 버튼: 상태가 '예약중' 일 때만 활성 --%>
		            <button type="button"
		                    class="btn-primary btn-lg ${product.saleStatus eq '예약중' ? '' : 'disabled'}"
		                    ${product.saleStatus eq '예약중' ? '' : 'disabled'}>
		              예약 중
		            </button>
		          </div>
		        </c:otherwise>
		      </c:choose>
		    </c:when>
		
		    <%-- 2) 구매자/비로그인 화면 --%>
		    <c:otherwise>
		      <c:choose>
		        <%-- 판매완료면 '판매완료' 만 --%>
		        <c:when test="${product.saleStatus eq '판매완료'}">
		          <div class="sold-actions">
		            <button type="button" class="btn-primary btn-lg is-disabled" disabled>판매완료</button>
		          </div>
		        </c:when>
		
		        <%-- 판매중/예약중: 구매자용 버튼 --%>
		        <c:otherwise>
		          <div class="buyer-actions">
		            <div class="row-actions">
		              <%-- 예시: 찜/문의 액션 연결 --%>
		              <form action="${ctx}/wishToggle.do" method="post">
		                <input type="hidden" name="prdNo" value="${product.prdNo}">
		                <button type="submit" class="abtn common-btn">찜하기</button>
		              </form>
		              <a class="abtn" href="#none">문의하기</a>
		            </div>
		
		            <%-- 구매하기: '판매중' 일 때만 활성 --%>
		            <button type="button"
		                    class="btn-primary btn-lg ${product.saleStatus ne '판매중' ? 'disabled' : ''}"
		                    ${product.saleStatus ne '판매중' ? 'disabled' : ''}>
		              구매하기
		            </button>
		          </div>
		        </c:otherwise>
		      </c:choose>
		    </c:otherwise>
		
		  </c:choose>

      </div>


    </div>
  </div>

  <!-- 상품 정보 -->
  <section class="pd-section">
    <h2 class="pd-sec-title">상품 정보</h2>
    <p class="pd-desc">${product.prdDesc}</p>
  </section>

  <!-- 정보 카드 3열 -->
  <section class="pd-cards">
    <div class="pd-card">
      <div class="pd-card-head"><i class="fa-solid fa-location-dot"></i> 직거래 지역</div>
      <div class="pd-card-body">${product.sido} ${product.sigungu} ${product.dong}</div>
    </div>
    <div class="pd-card">
      <div class="pd-card-head"><i class="fa-solid fa-folder-open"></i> 카테고리</div>
      <div class="pd-card-body">${product.category}</div>
    </div>
    <div class="pd-card">
      <div class="pd-card-head"><i class="fa-solid fa-hashtag"></i> 상품태그</div>
      <div class="pd-card-body tags">
      	<!-- <span>잘려진 태그1</span> 
      	     <span>잘려진 태그2</span> 
      	     <span>잘려진 태그3</span> 
      	-->
      </div>
    </div>
  </section>

  <!-- 지도 -->
  <section class="pd-map">
    <div class="map-box"><div id="map"></div></div>
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

<!-- kakao map api -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dd689b27e4b7fc12b2893cb036221eb8"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(${product.lat}, ${product.lng}), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(${product.lat}, ${product.lng}); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	
	// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
	// marker.setMap(null);    
</script>

<!-- tag 잘라서 화면에 다시 출력하기 -->
<script>
	let tags = '${product.prdTag}';
	
	let tagArray = tags.split(",").map(tag => tag.trim());
	
	tagArray.forEach(tag => {
		let span = document.createElement('span');
		span.classList.add('tag');
	    span.textContent = tag;
	    document.querySelector('.tags').appendChild(span);
	})
	
</script>