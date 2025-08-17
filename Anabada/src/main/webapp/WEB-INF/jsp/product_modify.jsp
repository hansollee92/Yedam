<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Product Modify Page -->
<section class="pm-wrap">
  <h2 class="pm-title">판매할 상품 수정</h2>
  <div class="line line-hard"></div>

  <form class="pm-form" action="/product/update.do" method="post" enctype="multipart/form-data">
    <!-- 상품번호 (숨김) -->
    <input type="hidden" name="prdNo" value="${product.prdNo}" />

    <!-- 이미지 업로드 -->
    <div class="pm-row">
      <label class="pm-label">상품 이미지</label>
      <div class="pm-image">
        <div class="pm-image-box">
          <img id="pm-image-preview" src="${ctx}/images/product/${product.prdImg}" alt="상품 이미지 미리보기" />
          <span class="pm-image-placeholder">이미지 등록</span>
        </div>
        <input id="pm-image-input" type="file" name="imageFile" accept="image/*" />
      </div>
    </div>
    <div class="line line-middle"></div>

    <!-- 상품명 -->
    <div class="pm-row">
      <label class="pm-label" for="prdName">상품명</label>
      <input id="prdName" name="prdName" class="pm-input" type="text" placeholder="상품명을 입력해주세요."
        value="${product.prdName}" required />
    </div>
    <div class="line line-middle"></div>

    <!-- 카테고리 -->
    <div class="pm-row">
      <label class="pm-label" for="category">카테고리</label>
      <div class="pm-category">
        <select id="category" name="category" size="8" class="pm-select" required>
          <option ${product.category=='의류' ? 'selected' :''}>의류</option>
          <option ${product.category=='신발' ? 'selected' :''}>신발</option>
          <option ${product.category=='악세사리' ? 'selected' :''}>악세사리</option>
          <option ${product.category=='디지털/가전' ? 'selected' :''}>디지털/가전</option>
          <option ${product.category=='스포츠' ? 'selected' :''}>스포츠</option>
          <option ${product.category=='도서/티켓' ? 'selected' :''}>도서/티켓</option>
          <option ${product.category=='가구/생활' ? 'selected' :''}>가구/생활</option>
          <option ${product.category=='기타' ? 'selected' :''}>기타</option>
        </select>
        <p class="pm-category-selected">
          선택한 카테고리 : <strong id="pm-cat-text">${product.category}</strong>
        </p>
      </div>
    </div>
    <div class="line line-middle"></div>

    <!-- 상품 상태 -->
    <div class="pm-row">
      <span class="pm-label">상품 상태</span>
      <div class="pm-radios">
        <label class="pm-radio">
          <input type="radio" name="prdStatus" value="새상품(미사용)" ${product.prdStatus=='새상품(미사용)' ? 'checked' :''} />
          새상품(미사용) <em>사용하지 않은 새 상품</em>
        </label>
        <label class="pm-radio">
          <input type="radio" name="prdStatus" value="사용감 없음" ${product.prdStatus=='사용감 없음' ? 'checked' :''} />
          사용감 없음 <em>사용은 했지만 눈에 띄는 흔적이나 얼룩이 없음</em>
        </label>
        <label class="pm-radio">
          <input type="radio" name="prdStatus" value="사용감 적음" ${product.prdStatus=='사용감 적음' ? 'checked' :''} />
          사용감 적음 <em>눈에 띄는 흔적이나 얼룩이 약간 있음</em>
        </label>
        <label class="pm-radio">
          <input type="radio" name="prdStatus" value="사용감 많음" ${product.prdStatus=='사용감 많음' ? 'checked' :''} />
          사용감 많음 <em>눈에 띄는 흔적이나 얼룩이 많이 있음</em>
        </label>
        <label class="pm-radio">
          <input type="radio" name="prdStatus" value="고장/파손 상품" ${product.prdStatus=='고장/파손 상품' ? 'checked' :''} />
          고장/파손 상품 <em>기능 이상이나 외관 손상 등으로 수리필요 </em>
        </label>
      </div>
    </div>
    <div class="line line-middle"></div>

    <!-- 상품 설명 -->
    <div class="pm-row">
      <label class="pm-label" for="prdDesc">상품 설명</label>
      <textarea id="prdDesc" name="prdDesc" class="pm-textarea" rows="7"
        placeholder="브랜드, 구매 시기, 하자 유무 등 상세 정보를 작성해주세요.">${product.prdDesc}</textarea>
    </div>
    </div>
    <div class="line line-middle"></div>

    <!-- 태그 -->
    <div class="pm-row">
      <label class="pm-label" for="prdTag">태그 <span class="pm-optional">(선택)</span></label>
      <div class="pm-tag-box">
        <input id="prdTag" name="prdTag" class="pm-input" type="text" placeholder="쉼표(,)로 구분해서 최대 5개"
          value="${product.prdTag}" />
        <div class="pm-help">
          <div>∙ 내 상품을 다양한 태그로 표현해 보세요.</div>
          <div>∙ 내 상품을 다양한 태그로 표현해 보세요.</div>
          <div>∙ 상품과 관련 없는 태그를 입력할 경우, 판매에 제재를 받을 수 있어요.</div>
        </div>
      </div>
    </div>
    <div class="line line-middle"></div>

    <!-- 가격 -->
    <div class="pm-row">
      <label class="pm-label" for="price">가격</label>
      <div class="pm-price">
        <input id="price" name="price" class="pm-input" type="number" min="0" step="100" placeholder="가격을 입력해주세요."
          value="${product.price}" required />
        <span class="pm-price-unit">원</span>
      </div>
    </div>
    <div class="line line-middle"></div>

    <!-- 거래 방법 -->
    <div class="pm-row">
      <span class="pm-label">거래 방법</span>
      <div class="pm-trade-box">
        <div class="pm-radios">
          <label class="pm-radio">
            <input type="radio" name="tradeType" value="택배거래" ${product.tradeType=='택배거래' ? 'checked' :''} /> 택배거래
          </label>
          <label class="pm-radio">
            <input type="radio" name="tradeType" value="직거래" ${product.tradeType=='직거래' ? 'checked' :''} /> 직거래
          </label>
        </div>

        <input id="pm-location" name="location" class="pm-input pm-location" type="text"
          placeholder="직거래 지역을 입력해주세요. (예: 대구 범어동)" value="${product.sido} ${product.sigungu} ${product.dong}" />
      </div>
    </div>

    <!-- 하단 버튼 -->
    <div class="pm-actions">
      <button type="submit" class="pm-btn pm-btn--primary">수정</button>
      <a href="${ctx}/product.do?prdNo=${product.prdNo}" class="pm-btn pm-btn--ghost">취소</a>
    </div>
  </form>
</section>

<script>
  // 이미지 미리보기
  const input = document.getElementById('pm-image-input');
  const preview = document.getElementById('pm-image-preview');
  const placeholder = document.querySelector('.pm-image-placeholder');
  if (input) {
    input.addEventListener('change', (e) => {
      const file = e.target.files?.[0];
      if (!file) return;
      const url = URL.createObjectURL(file);
      preview.src = url;
      preview.style.display = 'block';
      placeholder.style.display = 'none';
    });
  }

  // 카테고리 선택 문구 반영
  const cat = document.getElementById('category');
  const catText = document.getElementById('pm-cat-text');
  if (cat && catText) {
    cat.addEventListener('change', () => { catText.textContent = cat.value; });
  }

  // 거래방식이 직거래일 때만 지역 입력 활성화
  const tradeRadios = document.querySelectorAll('input[name="tradeType"]');
  const locInput = document.getElementById('pm-location');
  const toggleLoc = () => {
    const val = document.querySelector('input[name="tradeType"]:checked')?.value;
    const enable = val === '직거래';
    locInput.disabled = !enable;
    locInput.classList.toggle('is-disabled', !enable);
  };
  tradeRadios.forEach(r => r.addEventListener('change', toggleLoc));
  toggleLoc(); // 초기화
</script>