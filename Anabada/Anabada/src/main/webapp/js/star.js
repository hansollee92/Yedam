// 별점 동작 관련

const ratingDisplay = document.getElementById('rating-value');
console.log(document.getElementById('rating-value').value);
const starContainer = document.getElementById('star-container');
let currentRating = parseFloat(ratingDisplay.textContent);
let isDragging = false;

function renderStars(rating) {
    const stars = Array.from(starContainer.querySelectorAll('span'));
    stars.forEach(star => {
        const starValue = parseInt(star.dataset.star, 10);
        star.classList.remove('full', 'partial');
        star.style.removeProperty('--percent');

        if (rating >= starValue) {
            star.classList.add('full');
        }
        else if (rating > starValue - 1 && rating < starValue) {
            const percent = ((rating - (starValue - 1)) * 100).toFixed(0) + '%';
            star.classList.add('partial');
            star.style.setProperty('--percent', percent);
        }
    });
}

function getRatingFromEvent(e) {
    const target = e.target.closest('span');
    if (!target) return currentRating;

    const rect = target.getBoundingClientRect();
    const starValue = parseInt(target.dataset.star, 10);
    const clickX = e.clientX - rect.left;
    const width = rect.width;
    const percent = clickX / width;
    const preciseValue = (starValue - 1) + percent;
    return Math.min(5, Math.max(0.1, Math.round(preciseValue * 10) / 10));
}

function moveStar(e) {
    starContainer.addEventListener('mousemove', e => {
// 클릭하지 않아도 별점이 변화하게 하려면 isDragging과 버튼 확인을 빼고 바로 실행
        const previewRating = getRatingFromEvent(e);
        ratingDisplay.textContent = previewRating.toFixed(1);
        renderStars(previewRating);
    });
}

// 초기 표시
renderStars(currentRating);

//   // 마우스 이동 시 미리보기
//   starContainer.addEventListener('mousemove', e => {
//     if (isDragging || e.buttons === 1) { // 드래그 중이거나 마우스 왼쪽 버튼 눌림
//       const previewRating = getRatingFromEvent(e);
//       currentRating = previewRating;
//       ratingDisplay.textContent = currentRating.toFixed(1);
//       renderStars(currentRating);
//     }
//   });

//   // 클릭(마우스 다운)
//   starContainer.addEventListener('mousedown', e => {
//     if (e.button === 0) { // 왼쪽 버튼
//       isDragging = true;
//       currentRating = getRatingFromEvent(e);
//       ratingDisplay.textContent = currentRating.toFixed(1);
//       renderStars(currentRating);
//     }
//   });

//   // 마우스 업
//   document.addEventListener('mouseup', () => {
//     isDragging = false;
//   });

