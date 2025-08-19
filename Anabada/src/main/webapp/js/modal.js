// 이미지 호버 확대 완화 (요청 반영)
document.querySelectorAll('.item-img').forEach(function(box){
    box.addEventListener('mouseenter', ()=> box.classList.add('hover'));
    box.addEventListener('mouseleave', ()=> box.classList.remove('hover'));
});

// 모달 상태
const $modal = document.getElementById('reviewModal');
const $prdName = document.getElementById('mPrdName');
const $fPurNo = document.getElementById('fPurNo');
const $fPrdNo = document.getElementById('fPrdNo');
const $fScore = document.getElementById('fScore');
const $fContent = document.getElementById('fContent');
const $content = document.getElementById('mContent');
const $starWrap = document.getElementById('starWrap');
let currentScore = 0;


// 모달 열기
document.querySelectorAll('.btn-open-review').forEach(btn=>{
    btn.addEventListener('click', function(){
        const card = this.parentNode.querySelector('.item-card');
        if (!card) {
            alert("상품 카드 정보를 찾을 수 없습니다.");
            return;
        }
        $prdName.textContent = card.dataset.prdName;
        $fPurNo.value = card.dataset.purNo;
        $fPrdNo.value = card.dataset.prdNo;
        currentScore = 0;
        paintStars(0);
        $content.value = '';
        openModal();
    });
});


function openModal(){
    $modal.style.display = 'flex';
    $modal.setAttribute('aria-hidden', 'false');
}
function closeModal(){
    $modal.style.display = 'none';
    $modal.setAttribute('aria-hidden', 'true');
}
document.querySelector('.modal-close').addEventListener('click', closeModal);
$modal.addEventListener('click', (e)=> { if(e.target === $modal) closeModal(); });

// 별점 UX
function paintStars(score){
    $starWrap.querySelectorAll('span').forEach(el=>{
        const v = parseInt(el.dataset.v,10);
        el.classList.toggle('on', v <= score);
    });
}
$starWrap.addEventListener('mousemove', function(e){
    if(e.target.dataset.v) paintStars(parseInt(e.target.dataset.v,10));
});
$starWrap.addEventListener('mouseleave', function(){ paintStars(currentScore); });
$starWrap.addEventListener('click', function(e){
    if(e.target.dataset.v){
        currentScore = parseInt(e.target.dataset.v,10);
        paintStars(currentScore);
    }
});

// 저장
document.getElementById('btnSaveReview').addEventListener('click', function(){
    if(currentScore < 1){ alert('별점을 선택해주세요.'); return; }
    const text = $content.value.trim();
    if(text.length === 0){ alert('리뷰 내용을 입력해주세요.'); return; }
    if(text.length > 200){ alert('리뷰는 200자 이내로 입력해주세요.'); return; }

    $fScore.value = currentScore;
    $fContent.value = text;
    document.getElementById('reviewForm').submit();
});