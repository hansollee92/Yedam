<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!-- 로그인 사용자 객체 저장 -->
<c:set var="loginMember" value="${sessionScope.logMember}" />

<%-- 판매자 여부 : 세션에 로그인 객체가 있고, 상품 주인이면 true --%>
<c:set var="isOwner" value="${not empty loginMember and product.memberNo eq loginMember.memberNo}" />

<div class="product-wrap">
<div class="product-meta">
	<div class="thumbnail-box">
		<img src="${ctx}/images/product/${product.prdImg}" alt="${product.prdName}">
		<c:if test="${product.saleStatus eq '판매완료'}">
    		<div class="soldout-mark"><span>판매완료</span></div>
  		</c:if>
	</div>

	<div class="product-detail">

		<div class="top">
			<div class="product-Info">
				<div class="prdNo"># ${product.prdNo}</div>
				<div class="prdName">${product.prdName}</div>
				<div class="prdPrice">
					<fmt:formatNumber value="${product.price}" pattern="#,###" /> 원</div>
			</div>

			<%-- 판매자 배지 --%>
			<c:if test="${isOwner}">
				<div class="seller">나의 판매상품</div>
			</c:if>
		</div>

		<div class="line"></div>

		<div class="product-subInfo">
			<div class="wish">
				<i class="fa-solid fa-heart"></i>
				<c:choose>
					<c:when test="${countWish == 0}">0</c:when>
					<c:otherwise>${countWish}</c:otherwise>
				</c:choose>
			</div>
			<div class="view-cnt">
				<i class="fa-solid fa-eye"></i> ${product.viewCnt}
			</div>
			<div class="date">
				<i class="fa-solid fa-clock"></i>
				<fmt:formatDate value="${product.prdDate}" pattern="yyyy년 MM월 dd일" />
			</div>
			<div class="writer">
				<i class="fa-solid fa-user"></i> ${productMember}
			</div>
		</div>

		<div class="product-option">
			<ul class="left" style="padding-left: 0;">
				<li><span>상품상태</span> ${product.prdStatus}</li>
				<li><span>거래방식</span> ${product.tradeType}</li>
				<c:if test="${isOwner}">
					<li class="pd-option-help">판매상태를 변경할려면 오른쪽에서 판매중/예약중/판매완료를 선택하세요.</li>
				</c:if>
			</ul>

			<%-- 판매자만 상태 변경 셀렉트 표시 --%>
			<c:if test="${isOwner}">
			  <div class="right">
			    <form id="statusForm" method="post" action="${ctx}/productSaleStatus.do">
			      <input type="hidden" name="prdNo" value="${product.prdNo}">
			      <select class="form-select" name="saleStatus"
			              onchange="if(confirm('판매상태를 변경할까요?')) this.form.submit(); else this.selectedIndex=this.dataset.prevIdx;">
			        <option value="판매중"   ${product.saleStatus eq '판매중'   ? 'selected' : ''}>판매중</option>
			        <option value="예약중"   ${product.saleStatus eq '예약중'   ? 'selected' : ''}>예약중</option>
			        <option value="판매완료" ${product.saleStatus eq '판매완료' ? 'selected' : ''}>판매완료</option>
			      </select>
			    </form>
			  </div>
			</c:if>
			
		</div>

		<%-- 버튼 영역 : “판매자”와 “구매자/비로그인”을 분기 --%>
		<div class="Pd-btn-container">

			<c:choose>
				<%-- 1) 판매자 화면--%>
				<c:when test="${isOwner}">
					<div class="top">
						<button type="button" class="abtn" onclick="location.href='${ctx}/productModifyForm.do?prdNo=${product.prdNo}'">글
							수정</button>
						<form action="${ctx}/productRemove.do" method="post" onsubmit="return confirm('삭제할까요?')">
							<input type="hidden" name="prdNo" value="${product.prdNo}">
							<button type="submit" class="abtn">글 삭제</button>
						</form>
					</div>

					<%-- 상태 버튼 3가지(모양·폭 통일 --%>
					<c:choose>
						<c:when test="${product.saleStatus eq '판매중'}">
							<%-- 판매중: 예약중 버튼 노출(예시) --%>
							<button type="button" class="btn-primary btn-lg saleStaus-btn" onclick="alert('판매상태를 변경할려면 오른쪽에서 판매중/예약중/판매완료를 선택하세요.');">판매중</button>
						</c:when>
						<c:when test="${product.saleStatus eq '예약중'}">
							<button type="button" class="btn-primary btn-lg saleStaus-btn" disabled>예약중</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn-primary btn-lg saleStaus-btn" disabled>판매완료</button>
						</c:otherwise>
					</c:choose>
				</c:when>

				<%-- 2) 구매자/비로그인 화면 --%>
				<c:otherwise>
					<div class="top" style="display: flex; gap: 8px;">
					    <c:choose>
						    <c:when test="${empty loginMember}">
						      <button type="button" class="abtn" id="wish-login-btn"
						         <c:if test="${product.saleStatus eq '판매완료' or product.saleStatus eq '예약중'}">disabled</c:if>>찜하기</button>
						    </c:when>
						    <c:otherwise>
						      <form action="${ctx}/wishToggle.do" method="post">
						        <input type="hidden" name="prdNo" value="${product.prdNo}">
						        <button type="submit" class="abtn" 
						          <c:if test="${product.saleStatus eq '판매완료' or product.saleStatus eq '예약중'}">disabled</c:if>>찜하기</button>
						      </form>
						    </c:otherwise>
					    </c:choose>						

						<c:choose>
						  <c:when test="${empty loginMember}">
						    <button type="button" class="abtn" id="qna-login-btn"
						      <c:if test="${product.saleStatus eq '판매완료' or product.saleStatus eq '예약중'}">disabled</c:if>>문의하기</button>
						  </c:when>
						  <c:otherwise>
						    <a class="abtn" href="#pd-qna" 
						      <c:if test="${product.saleStatus eq '판매완료' or product.saleStatus eq '예약중'}">disabled</c:if>>문의하기</a>
						  </c:otherwise>
						</c:choose>
					</div>

					<%-- 상태 버튼 3가지(모양·폭 통일) --%>
					<c:choose>
						<c:when test="${product.saleStatus eq '판매중'}">
							<button type="button" id="purchase-btn" class="btn-primary btn-lg saleStaus-btn">구매하기</button>
						</c:when>
						<c:when test="${product.saleStatus eq '예약중'}">
							<button type="button" class="btn-primary btn-lg saleStaus-btn" disabled>예약중</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn-primary btn-lg saleStaus-btn" disabled>판매완료</button>
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
		<div class="pd-card-head">
			<i class="fa-solid fa-location-dot"></i> 직거래 지역
		</div>
		<div class="pd-card-body">${product.sido}${product.sigungu}
			${product.dong}</div>
	</div>
	<div class="pd-card">
		<div class="pd-card-head">
			<i class="fa-solid fa-folder-open"></i> 카테고리
		</div>
		<div class="pd-card-body">${product.category}</div>
	</div>
	<div class="pd-card">
		<div class="pd-card-head">
			<i class="fa-solid fa-hashtag"></i> 상품태그
		</div>
		<div class="pd-card-body tags">
			<!-- <span>잘려진 태그1</span> 
      	   <span>잘려진 태그2</span> 
      	   <span>잘려진 태그3</span> 
      	-->
		</div>
	</div>
</section>

<!-- 지도 -->
<c:if test="${product.tradeType ne '택배거래'}">
	<section class="pd-map">
		<div class="map-box">
			<div id="map"></div>
		</div>
	</section>
</c:if>

<!-- 문의하기 안내 -->
<section class="pd-qna-head" id="pd-qna">
	<h2 class="pd-sec-title">문의하기</h2>
	<p class="pd-help">구매하려는 상품에 대해 궁금한 점이 있는 경우 판매자에게 문의해보세요.</p>

	<!-- mgs 전달값이 있으면 메세지 출력 -->
	<c:if test="${!empty msg }">
		<div style="color: red; font-size: 13px; font-family: var(--font); margin-bottom: 10px;">
			<i class="fa-solid fa-circle-exclamation"></i> ${msg}
		</div>
	</c:if>
	<form action="qnaRegisterForm.do">
		<input type="hidden" value="${product.prdNo}" name="prdNo"> 
		<input type="submit" value="상품 문의하기" class="qnaBtn btn-primary" id="direct-btn">
	</form>
</section>




<!-- 문의 목록 -->
<section class="pd-qna-list">
	<table class="qna-table">
		<colgroup>
			<col style="width: 10%">
			<col style="width: 50%">
			<col style="width: 10%">
			<col style="width: 10%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty qna_list}">
				<tr class="no-qna">
					<td colspan="4">문의가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="qna" items="${qna_list}" varStatus="status">
				<tr>
					<td>${qna.qnaNo}</td>
					<td><a href="${ctx}/qna.do?prdNo=${qna.prdNo}&qnaNo=${qna.qnaNo}"
						style="text-decoration: none; color: #333;">${qna.qnaTitle}</a></td>
					<td>${qna.memberId}</td>
					<td><fmt:formatDate value="${qna.qnaDate}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%-- 페이지네이션 --%>
	<nav id="pg-nav" aria-label="Page navigation example">
		<ul class="pagination justify-content-center"
			style="--bs-pagination-color: var(--black-color); --bs-pagination-bg: #fff; --bs-pagination-border-color: var(--light-gray); --bs-pagination-hover-color: var(--primary-color); --bs-pagination-hover-bg: rgba(12, 130, 117, .06); --bs-pagination-hover-border-color: var(--primary-color); --bs-pagination-active-color: #fff; --bs-pagination-active-bg: var(--primary-color); --bs-pagination-active-border-color: var(--primary-color); --bs-pagination-disabled-color: var(--gray); --bs-pagination-disabled-bg: #f4f5f6; --bs-pagination-disabled-border-color: var(--light-gray); --bs-pagination-padding-x: 0; --bs-pagination-padding-y: 0; --bs-pagination-font-size: 14px; --bs-pagination-border-radius: 10px; gap: 8px;">

			<%-- 이전페이지 --%>
			<c:choose>
				<c:when test="${paging.previous}">
					<li class="page-item">
						<a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${paging.start -1}#pg-nav">
							<i class="fa-solid fa-angle-left"></i>
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled">
						<a class="page-link">
							<i  class="fa-solid fa-angle-left"></i>
						</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:forEach var="p" begin="${paging.start}" end="${paging.end}">
				<c:choose>
					<c:when test="${paging.currPage eq p}">
						<li class="page-item active" aria-current="page">
						<span class="page-link">${p}</span></li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
						<a class="page-link" href="product.do?prdNo=${product.prdNo}&page=${p}#pg-nav">${p}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<%-- 다음 페이지 --%>
			<c:choose>
				<c:when test="${paging.next}">
					<li class="page-item"><a class="page-link"
						href="product.do?prdNo=${product.prdNo}&page=${paging.end +1}#pg-nav">
							<i class="fa-solid fa-angle-right"></i>
					</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link"><i
							class="fa-solid fa-angle-right"></i></a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</nav>

</section>
</div>


<%-- 결제 모달창 --%>
<div id="tradeModal" class="modal" role="dialog" aria-modal="true"
	aria-labelledby="tradeModalTitle" aria-hidden="true">
	<div class="modal_overlay"></div>

	<div class="modal_dialog" role="document">
		<button class="modal_close" type="button" aria-label="닫기" data-close>
			<i class="fa-solid fa-xmark"></i>
		</button>

		<div class="modal_header">
			<h3 id="tradeModalTitle" class="modal_title">거래방식을 선택해주세요!</h3>
			<p class="modal_subtitle">
				직거래를 선택할 경우 문의하기 게시판으로<br> 바로 이동이 됩니다.
			</p>
		</div>

		<div class="modal_actions">
			<a class="trade-btn tradeBtn-primary"
				href="${ctx}/product.do?prdNo=${product.prdNo}&anchor=pd-qna">직거래
				문의하기</a> <a class="trade-btn"
				href="${ctx}/payForm.do?prdNo=${product.prdNo}">택배 거래</a>
		</div>
	</div>
</div>


<!-- kakao map api -->
<c:if test="${product.tradeType ne '택배거래'}">
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dd689b27e4b7fc12b2893cb036221eb8"></script>
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
</c:if>


<script>

	// tag 잘라서 화면에 나타내기
	let tags = '${product.prdTag}';
	
	let tagArray = tags.split(",").map(tag => tag.trim());
	
	tagArray.forEach(tag => {
		let span = document.createElement('span');
		span.classList.add('tag');
	    span.textContent = tag;
	    document.querySelector('.tags').appendChild(span);
	})	
	
	
	// 구매버튼 눌렀을 때
	document.addEventListener('DOMContentLoaded', () => {
	  // 요소 찾기
	  const modal        = document.getElementById('tradeModal');
	  const overlay      = modal?.querySelector('.modal_overlay'); 
	  const closeBtn     = modal?.querySelector('.modal_close');  
	  const purchaseBtn  = document.getElementById('purchase-btn');
	
	  // 초기 상태: CSS 없이 JS로 숨김
	  if (modal) modal.style.display = 'none';
	
	  // 열기/닫기
	  const openModal = (e) => {
	    e?.preventDefault?.();
	    if (!modal) return;
	    modal.style.display = 'block';                   // 보여주기
	    document.documentElement.style.overflow = 'hidden'; // 배경 스크롤 잠금
	    modal.querySelector('.modal_actions .trade-btn')?.focus(); // 포커스 이동(옵션)
	  };
	
	  const closeModal = () => {
	    if (!modal) return;
	    modal.style.display = 'none';                    // 숨기기
	    document.documentElement.style.overflow = '';    // 스크롤 복원
	    purchaseBtn?.focus();                            // 포커스 복귀(옵션)
	  };
	
	  // 이벤트 연결 (요소 없을 수 있으니 안전하게 ?.)
	  purchaseBtn?.addEventListener('click', openModal);
	  overlay?.addEventListener('click', closeModal);
	  closeBtn?.addEventListener('click', closeModal);
	  document.addEventListener('keydown', (e) => {
	    if (e.key === 'Escape' && modal?.style.display === 'block') closeModal();
	  });
	});

</script>

<%-- 페이지네이션 스타일 강제적용(부트스트랩) --%>
<script>
document.addEventListener('DOMContentLoaded', function () {
  document.querySelectorAll('.pagination .page-link').forEach(function (el) {
    el.style.display = 'flex';
    el.style.alignItems = 'center';
    el.style.justifyContent = 'center';
    el.style.minWidth = '35px';
    el.style.height = '35px';
    el.style.padding = '0';
    el.style.lineHeight = '1';
    el.style.boxShadow = 'none';
    el.style.textDecoration = 'none';
    el.style.borderWidth = '1px';
    el.style.borderStyle = 'solid';
    el.style.borderRadius = '8px';   // ← 둥글기 추가
    // 테두리 색은 변수로 가니까 여기선 생략
    // 아이콘 중앙정렬
    var i = el.querySelector('i');
    if (i) { i.style.lineHeight = '1'; i.style.fontSize = '14px'; }
  });
});
</script>

<!-- 문의하기 링크 > 앵커 처리로 이동 -->
<script>
document.addEventListener('DOMContentLoaded', () => {
	  const params = new URLSearchParams(window.location.search);
	  if (params.get("anchor") === "pd-qna") {
	    document.getElementById("pd-qna")?.scrollIntoView({behavior:"smooth"});
	  }
	});
</script>

<%-- 찜하기 비로그인 시도시 --%>
<script>
document.addEventListener('DOMContentLoaded', () => {
  const goLogin = (msg) => {
    alert(msg || '로그인이 필요합니다.');
    const back = encodeURIComponent(location.pathname + location.search + location.hash);
    location.href = '${ctx}/loginForm.do?redirect=' + back;
  };

  document.getElementById('wish-login-btn')?.addEventListener('click', () => {
    goLogin('찜하기는 로그인 후 이용 가능합니다.');
  });
  
  document.getElementById('qna-login-btn')?.addEventListener('click', () => {
	    goLogin('문의하기는 로그인 후 이용 가능합니다.');
  });

});
</script>
