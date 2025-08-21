<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />

    <!-- Product Modify Page -->
    <section class="pm-wrap">
      <h2 class="pm-title">판매할 상품 등록</h2>
      <div class="line line-hard"></div>

      <form class="pm-form" action="${ctx}/productInsert.do" method="post" enctype="multipart/form-data">
        <!-- 상품번호 (숨김) -->
     <%--    <input type="hidden" name="prdNo" value="${product.prdNo}" /> --%>

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
          
          <!-- 수정 -->
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

        <!-- 상품 상태 --> <!-- checked 조건 제거 -->
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

        <!-- 상품 설명 수정; ${product.prdDesc} -->
        <div class="pm-row">
          <label class="pm-label" for="prdDesc">상품 설명</label>
          <textarea id="prdDesc" name="prdDesc" class="pm-textarea" rows="7"
            placeholder="브랜드, 구매 시기, 하자 유무 등 상세 정보를 작성해주세요.">${product.prdDesc}</textarea>
        </div>
        <div class="line line-middle"></div>

        <!-- 태그 수정; value 제거-->
        <div class="pm-row">
          <label class="pm-label" for="prdTag">태그 <span class="pm-optional">(선택)</span></label>
          <div class="pm-tag-box">
            <input id="prdTag" name="prdTag" class="pm-input" type="text" placeholder="쉼표(,)로 구분해서 최대 5개"
              value="${product.prdTag}" />
            <div class="pm-help">
              <div>∙ 내 상품을 다양한 태그로 표현해 보세요.</div>
              <div>∙ 상품과 관련 없는 태그를 입력할 경우, 판매에 제재를 받을 수 있어요.</div>
            </div>
          </div>
        </div>
        <div class="line line-middle"></div>

        <!-- 가격 수정; value제거-->
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
			    <input type="radio" name="tradeType" value="택배거래"
			         ${product.tradeType=='택배거래' ? 'checked' :''} /> 택배거래
			  </label>
			  <label class="pm-radio">
			    <input type="radio" name="tradeType" value="직거래"
				     ${empty product.tradeType || product.tradeType=='직거래' ? 'checked' :''} /> 직거래
			  </label>
            </div>

            <!-- value 제거, disabled 추가 -->
            <input id="pm-location" name="location" class="pm-input pm-location" type="text"
              placeholder="직거래 지역을 입력해주세요. (예: 대구 범어동)" value="${product.sido} ${product.sigungu} ${product.dong}" />
          </div>
        </div>

        <!-- DB저장용 input hidden 수정; value 제거-->
        <input type="hidden" id="sido" name="sido" value="${product.sido}">
        <input type="hidden" id="sigungu" name="sigungu" value="${product.sigungu}">
        <input type="hidden" id="dong" name="dong" value="${product.dong}">
        <input type="hidden" id="lat" name="lat" value="${product.lat}">
        <input type="hidden" id="lng" name="lng" value="${product.lng}">

        <!-- 하단 버튼 수정; 취소 이동경로-->
        <div class="pm-actions">
          <button type="submit" class="pm-btn pm-btn--primary">등록</button>
          <a href="${ctx}/main.do" class="pm-btn pm-btn--ghost">취소</a>
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
      // 수정; if
      tradeRadios.forEach(r => r.addEventListener('change', toggleLoc));
      toggleLoc(); // 초기화


      //태그 입력시 스페이스 누르면 자동으로 콤마(,) 추가
      const tagInput = document.getElementById('prdTag');
      if (tagInput) {
        tagInput.addEventListener('keydown', function (e) {
          if (e.code === 'Space' || e.key === ' ') {
            e.preventDefault(); // 스페이스바 기본 입력 막기
            const val = this.value.trim();
            if (val.length > 0 && !val.endsWith(',')) {
              this.value = val + ',';
            }
          }
        });
      }

    </script>


    <!-- 카카오 우편 api & 지도 api
      
       1) 우편번호 주소 선택 
       2) 선택된 주소 문자열로 입력칸을 채움 
       3) kakao map 으로 addressSearch() 호출
       4) 응답받은 위도, 경도를 hidden 필드에 저장 
     
    -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <!--services libraries=services 추가  -->
    <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dd689b27e4b7fc12b2893cb036221eb8&libraries=services"></script>

<script>
  // 필요한 요소들 '모두' 이 블록에서 안전하게 잡기
  const locInput = document.getElementById('pm-location');   // ← 빠져있던 선언 추가
  const sidoInput = document.getElementById('sido');
  const sigunguInput = document.getElementById('sigungu');
  const dongInput = document.getElementById('dong');
  const latInput = document.getElementById('lat');
  const lngInput = document.getElementById('lng');

  const geocoder = new kakao.maps.services.Geocoder();

  // 클릭 한 번에 팝업 2개 열리는 것 방지: 같은 이름의 팝업 재사용
  function openPostcode() {
    new daum.Postcode({
      oncomplete: function (data) {
        try {
          // "시도 시군구 법정동" 형태
          const jibunArea = [data.sido, data.sigungu, data.bname].filter(Boolean).join(' ');

          // 입력창/히든 값 세팅
          if (locInput) locInput.value = jibunArea;
          if (sidoInput)    sidoInput.value    = data.sido    || '';
          if (sigunguInput) sigunguInput.value = data.sigungu || '';
          if (dongInput)    dongInput.value    = data.bname   || '';

          // 좌표 세팅 (jibunArea → 실패 시 jibun/roadAddress 순서로 재시도)
          const query = jibunArea || data.jibunAddress || data.roadAddress || '';
          if (!query) { latInput.value = ''; lngInput.value = ''; return; }

          geocoder.addressSearch(query, function (results, status) {
            if (status === kakao.maps.services.Status.OK && results.length) {
              latInput.value = results[0].y;  // 위도
              lngInput.value = results[0].x;  // 경도
            } else {
              latInput.value = '';
              lngInput.value = '';
            }
          });

          // ❌ 팝업 모드에선 명시적 close() 불필요(자동 닫힘)
          // this.close();  <- 지움
        } catch (err) {
          console.error('[postcode oncomplete error]', err);
          // 에러 시에도 폼이 계속 진행되도록 좌표는 비워둠
          latInput.value = '';
          lngInput.value = '';
        }
      }
    }).open({ popupName: 'postcode-popup' }); // ← 고정 이름으로 중복 팝업 방지
  }

  // input 클릭 시: 직거래일 때만 열기 (리스너 중복 방지)
  if (locInput) {
    locInput.addEventListener('click', () => {
      const isDirect = document.querySelector('input[name="tradeType"]:checked')?.value === '직거래';
      if (isDirect) openPostcode();
    }, { passive: true });
  }
</script>