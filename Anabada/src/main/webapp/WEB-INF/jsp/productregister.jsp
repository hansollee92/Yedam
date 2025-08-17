<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    

<h1>판매할 상품 등록</h1>

<form action="${ctx}/product/register.do" method="post" enctype="multipart/form-data">

    <!-- 상품 이미지 -->
    <div class="productImage">
        <label>상품이미지</label>
        <input type="file" id="productImage" name="productImage" accept="image/*">
    </div>

    <!-- 상품명 -->A
    <div class="prdname">
        <label>상품명</label>
        <input type="text" id="productText" name="prdText" placeholder="상품명을 입력해주세요">
    </div>

    <!-- 카테고리 -->
    <div class="category">
        <label>카테고리</label>
        <select id="category" name="category">
            <option value="">카테고리 선택</option>
            <option value="의류">의류</option>
            <option value="신발">신발</option>
            <option value="악세사리">악세사리</option>
            <option value="디지털/가전">디지털/가전</option>
            <option value="스포츠">스포츠</option>
            <option value="도서/티켓">도서/티켓</option>
            <option value="가구/생활">가구/생활</option>
        </select>
        <div id="pick" class="result">
            선택한 카테고리 : <b>-</b>
        </div>
    </div>

    <!-- 상품 상태 -->
    <div class="prdstatus">
        <label>상품 상태</label><br>
        <input type="radio" name="condition" value="새상품(미사용)"> 새상품(미사용)<br>
        <input type="radio" name="condition" value="사용감없음"> 사용감 없음<br>
        <input type="radio" name="condition" value="사용감적음"> 사용감 적음<br>
        <input type="radio" name="condition" value="사용감많음"> 사용감 많음<br>
        <input type="radio" name="condition" value="고장/파손상품"> 고장/파손 상품<br>
    </div>

    <!-- 상품 설명 -->
    <div class="prdDesc">
        <label>상품설명</label>
        <!-- [수정2] textarea 안에 텍스트 제거하고 placeholder 속성으로 변경 -->
        <textarea id="description" name="description" 
            placeholder="브랜드, 모델명, 구매 시기, 하자 유무 등 상품 설명을 최대한 자세히 적어주세요.&#10;전화번호, SNS, 계정 등 개인정보 입력은 제한될 수 있어요."></textarea>
    </div>

    <!-- 태그 -->
    <div class="tag">
        <label>태그<span>(선택)</span></label>
        <input type="text" name="tags" placeholder="예: 노트북, 갤럭시, 삼성">
    </div>

    <!-- 가격 -->
    <div class="price">
        <label>가격</label>
        <input type="text" name="price" placeholder="가격을 입력해 주세요"> 원
    </div>

    <!-- 거래 방법 -->
    <div class="tradeType">
        <label>거래방법</label><br>
        <input type="radio" name="tradeType" value="택배거래"> 택배거래
        <input type="radio" name="tradeType" value="직거래"> 직거래
        <!-- [수정3] value="직거래방법" → placeholder 로 변경 -->
        <input type="text" name="tradeLocation" placeholder="직거래 지역을 입력하세요 (예: 대구 반월당)">
    </div>

    <!-- 버튼 -->
    <div class="btns">
        <button type="submit">등록</button>
        <button type="reset">취소</button>
    </div>

</form>

<script>
    // 카테고리 선택 시 표시
    const selectEl = document.getElementById('category');
    const pickedEl = document.getElementById('pick').querySelector('b');

    if (selectEl.value) pickedEl.textContent = selectEl.value;

    selectEl.addEventListener('change', function () {
        pickedEl.textContent = this.value || '-';
    });
</script>
