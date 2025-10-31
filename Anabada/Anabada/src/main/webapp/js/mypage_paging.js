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