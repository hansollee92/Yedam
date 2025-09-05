<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<div class="wrapper notice-wrap">
  <h2 class="notice-title">공지사항</h2>

  <c:if test="${empty notices}">
    <p class="notice-empty">등록된 공지가 없습니다.</p>
  </c:if>

  <c:if test="${not empty notices}">
    <div class="notice-list">
      <c:forEach var="n" items="${notices}" varStatus="status">
        <div class="notice-item">
          <button type="button" class="notice-row notice-grid acc-btn" aria-expanded="false">
            <span class="no">${n.notiNo}</span>
            <span class="title">${n.notiTitle}</span>
            <span class="date">
              <fmt:formatDate value="${n.notiDate}" pattern="yyyy.MM.dd"/>
            </span>
          </button>

          <div class="acc-panel" hidden>
            <pre class="acc-content">${n.notiContent}</pre>
          </div>
        </div>
      </c:forEach>
    </div>
  </c:if>
</div>

<%-- 아코디언 --%>
<script>
document.addEventListener('DOMContentLoaded', () => {
  const items = document.querySelectorAll('.notice-item');

  items.forEach((it) => {
    const btn   = it.querySelector('.acc-btn');
    const panel = it.querySelector('.acc-panel');

    btn.addEventListener('click', () => {
      const isOpen = btn.getAttribute('aria-expanded') === 'true';

      // 다른 것 닫기 (단일 오픈)
      document.querySelectorAll('.notice-item .acc-btn[aria-expanded="true"]').forEach(b => {
        if (b !== btn) {
          const p = b.parentElement.querySelector('.acc-panel');
          b.setAttribute('aria-expanded', 'false');
          p.style.maxHeight = null;
          p.classList.remove('open');
          p.hidden = true;
        }
      });

      // 현재 토글
      if (!isOpen) {
        btn.setAttribute('aria-expanded','true');
        panel.hidden = false;
        panel.classList.add('open');
        panel.style.maxHeight = panel.scrollHeight + 'px';
      } else {
        btn.setAttribute('aria-expanded','false');
        panel.style.maxHeight = null;
        panel.classList.remove('open');
        // transition 끝난 뒤 hidden 처리
        panel.addEventListener('transitionend', function te(){
          panel.hidden = true;
          panel.removeEventListener('transitionend', te);
        }, { once:true });
      }
    });
  });
});
</script>