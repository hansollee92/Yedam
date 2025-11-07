<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>

<!-- ✅ Bootstrap CDN -->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
  crossorigin="anonymous">

<style>
  :root {
    --head-bg: #1f2937;   /* 딥그레이 */
    --muted: #6b7280;     /* 서브텍스트 */
  }

  body {
    background-color: #f8f9fa;
  }

  .form-wrapper {
    max-width: 650px;
    margin: 80px auto;
    background: #fff;
    border-radius: 0.75rem;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.05);
    padding: 2.5rem 3rem;
  }

  h3 {
    border-bottom: 2px solid var(--head-bg);
    padding-bottom: .6rem;
    margin-bottom: 2rem;
  }

  label {
    font-weight: 600;
    color: #374151;
  }

  .form-control:focus {
    border-color: var(--head-bg);
    box-shadow: 0 0 0 0.2rem rgba(31, 41, 55, 0.15);
  }

  .btn-dark {
    background-color: var(--head-bg);
    border: none;
  }
</style>
</head>

<body>
  <div class="container">
    <div class="form-wrapper">
<%--       <c:if test="${empty board.bno}">
	      <h3 class="text-center">게시글 등록</h3>   
      </c:if>
      <c:if test="${not empty board.bno}">
      	  <h3 class="text-center">게시글 수정</h3>   
      </c:if> --%>
      <h3 style="text-align:center;">게시글 ${empty board.bno ? "등록" : "수정"}</h3>

      <form method="post" action="/board/${empty board.bno ? 'register' : 'update'}" name="frm">
        <input type="hidden" name="bno" value="${board.bno}">

        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" class="form-control" id="title" name="title" value="${board.title}" placeholder="제목을 입력하세요">
        </div>

        <div class="mb-3">
          <label for="writer" class="form-label">작성자</label>
          <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" placeholder="작성자를 입력하세요">
        </div>

        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea class="form-control" id="content" name="content" rows="6" placeholder="내용을 입력하세요">${board.content}</textarea>
        </div>

        <div class="d-flex justify-content-between mt-4">
          <a href="/board" class="btn btn-outline-secondary">목록으로</a>
          <c:if test="${not empty board.bno}">	
          	<button type="button" formaction="/board/delete" class="btn btn-outline-secondary" onclick="boardDelete()">삭제</button>
          </c:if>
          <button type="submit" class="btn btn-dark">${empty board.bno ? "등록" : "수정"}하기</button>
        </div>
      </form>
    </div>
  </div>
  
  <script>
 
  /* 삭제이벤트 */
	function boardDelete(){
	  if(confirm('삭제할까요?')){
		  document.frm.action = '/board/delete';
		  document.frm.submit();
	  }
  }
 
 </script>
  
</body>
</html>

 
 
 <%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>

<!-- Bootstrap -->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
  rel="stylesheet">
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css"
  rel="stylesheet">

<style>
  :root{
    --grad-start:#4f46e5; /* indigo-600 */
    --grad-end:#2563eb;   /* blue-600  */
    --bg:#f8fafc;         /* slate-50  */
    --text:#0f172a;
    --muted:#6b7280;
    --border:#e2e8f0;
    --focus-ring: 0 0 0 .2rem rgba(37,99,235,.25);
  }

  body{ background:var(--bg); font-family:"Pretendard","Noto Sans KR",sans-serif; }

  .form-card{
    max-width:760px; margin:72px auto;
    background:#fff; border-radius:1rem; overflow:hidden;
    box-shadow:0 12px 30px rgba(16,24,40,.08);
    border:1px solid #eef1f6;
  }

  .form-card .card-header{
    background:linear-gradient(135deg,var(--grad-start),var(--grad-end));
    color:#fff; padding:1.25rem 1.5rem;
    display:flex; align-items:center; justify-content:space-between;
  }
  .form-card .card-header h3{ margin:0; font-weight:800; letter-spacing:.2px; }

  .card-body{ padding:2rem 2.25rem; }

  label{ font-weight:700; color:#374151; }

  .form-control:focus, .form-select:focus{
    border-color:var(--grad-end);
    box-shadow:var(--focus-ring);
  }

  .hint{ color:var(--muted); font-size:.85rem; }

  .btn-primary{
    background:linear-gradient(135deg,var(--grad-start),var(--grad-end));
    border:none; font-weight:700;
  }
  .btn-primary:hover{ filter:brightness(.95); }
  .btn-outline-secondary{ border-color:#cbd5e1; }

  .btn-icon{
    display:inline-flex; align-items:center; gap:.4rem;
  }
</style>
</head>

<body>
  <div class="container">
    <div class="form-card">
      <div class="card-header">
        <h3>
          <i class="bi bi-journal-text me-2"></i>
          게시글 ${empty board.bno ? "등록" : "수정"}
        </h3>
        <a href="/board" class="btn btn-sm btn-light btn-icon">
          <i class="bi bi-list-ul"></i><span>목록</span>
        </a>
      </div>

      <div class="card-body">
        <form method="post" action="/board/${empty board.bno ? 'register' : 'update'}" name="frm">
          <input type="hidden" name="bno" value="${board.bno}"/>

          <!-- 제목 -->
          <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="title"
                   value="${board.title}" placeholder="제목을 입력하세요" autofocus>
            <div class="form-text hint">프로젝트/이슈 키워드가 들어가면 검색이 쉬워집니다.</div>
          </div>

          <!-- 작성자 & (선택) 카테고리 영역 예시 -->
          <div class="row g-3">
            <div class="col-md-6">
              <label for="writer" class="form-label">작성자</label>
              <input type="text" class="form-control" id="writer" name="writer"
                     value="${board.writer}" placeholder="작성자를 입력하세요">
            </div>
            <div class="col-md-6 d-none"><!-- 필요 시 살려 쓰세요
              <label for="category" class="form-label">카테고리</label>
              <select id="category" class="form-select" name="category">
                <option value="">선택</option>
                <option>공지</option><option>질문</option><option>자유</option>
              </select>
            --></div>
          </div>

          <!-- 내용 -->
          <div class="mb-3 mt-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" id="content" name="content" rows="8"
                      placeholder="내용을 입력하세요">${board.content}</textarea>
          </div>

          <!-- 액션 -->
          <div class="d-flex justify-content-between align-items-center mt-4">
            <a href="/board" class="btn btn-outline-secondary btn-icon">
              <i class="bi bi-arrow-left"></i><span>목록으로</span>
            </a>

            <div class="d-flex gap-2">
              <c:if test="${not empty board.bno}">
                <button type="button"
                        class="btn btn-outline-secondary btn-icon"
                        onclick="boardDelete()">
                  <i class="bi bi-trash"></i><span>삭제</span>
                </button>
              </c:if>
              <button type="submit" class="btn btn-primary btn-icon">
                <i class="bi bi-check2-circle"></i>
                <span>${empty board.bno ? "등록" : "수정"}하기</span>
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

  <script>
    // 삭제 이벤트
    function boardDelete(){
      if(confirm('정말 삭제하시겠습니까?')){
        const f = document.forms['frm'];
        f.action = '/board/delete';
        f.method = 'post';
        f.submit();
      }
    }

    // 작은 UX: 제목 비었을 때 등록/수정 클릭 시 포커스
    document.forms['frm']?.addEventListener('submit', function(e){
      const t = document.getElementById('title');
      if(t && !t.value.trim()){
        e.preventDefault();
        t.focus();
      }
    });
  </script>
</body>
</html>
 
 
 
 --%> 