<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>게시글 상세보기</h3>
	
	<div>#${board.bno}</div>
	<div>작성자: ${board.writer}</div>
	<div>작성날짜: ${board.regdate}</div>
	<div>내용: ${board.content}</div>
	<div id="reply"></div>
	
	<script>
		let bno = ${board.bno};
	
		// 전체조회
		// \${}으로 작성안하면 안됨 => 왜? 
		fetch(`http://localhost:81/board/\${bno}/reply`)
		  .then((response) => response.json())
		  .then((datas) => {
			  let reply = document.querySelector("#reply");
			  for(data of datas){
				  let newTag = `<div>\${data.reply} \${data.replyer}</div>`;
				  reply.insertAdjacentHTML("beforeend", newTag);
			  }
			  
		  });
	
	</script>
</body>
</html> 


 
 
 
  --%>
  
  
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 상세보기</title>

  <!-- Bootstrap & Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

  <style>
    :root{
      --grad-start:#4f46e5; --grad-end:#2563eb;
      --bg:#f8fafc; --text:#0f172a; --muted:#6b7280; --border:#e2e8f0;
    }
    body{ background:var(--bg); font-family:"Pretendard","Noto Sans KR",sans-serif; }

    .view-card{ max-width:920px; margin:64px auto; background:#fff; border-radius:1rem; overflow:hidden;
      border:1px solid #eef1f6; box-shadow:0 12px 30px rgba(16,24,40,.08); }
    .card-header{ background:linear-gradient(135deg,var(--grad-start),var(--grad-end));
      color:#fff; padding:1.25rem 1.5rem; display:flex; justify-content:space-between; align-items:center; }
    .card-header h3{ margin:0; font-weight:800; }

    .post-title{ font-size:1.5rem; font-weight:800; color:var(--text); margin-bottom:.25rem; }
    .post-meta{ color:var(--muted); font-size:.9rem; }
    .divider{ border-top:1px solid var(--border); margin:1.25rem 0; }
    .post-content{ white-space:pre-wrap; line-height:1.8; color:#111827; word-break:break-word; }

    .chip{ display:inline-flex; align-items:center; gap:.35rem; padding:.2rem .6rem; border-radius:999px;
      font-size:.75rem; font-weight:700; background:#e0f2fe; color:#0369a1; white-space:nowrap; }

    .reply-item{ display:flex; gap:.75rem; padding:.75rem 0; border-bottom:1px solid var(--border); }
    .reply-avatar{ width:36px; height:36px; border-radius:50%; background:#e5e7eb; color:#475569;
      font-weight:700; display:flex; align-items:center; justify-content:center; flex:0 0 36px; }
    .reply-meta{ font-size:.82rem; color:var(--muted); margin-bottom:.2rem; }
    .reply-bubble{ display:inline-block; background:#fff; border:1px solid var(--border); border-radius:12px;
      padding:.5rem .75rem; box-shadow:0 2px 5px rgba(0,0,0,.03); max-width:100%; }
    .empty{ color:var(--muted); padding:1rem 0; }

    .btn-primary{ background:linear-gradient(135deg,var(--grad-start),var(--grad-end)); border:none; font-weight:700; }
    .btn-primary:hover{ filter:brightness(.95); }
    .btn-light{ background:#fff; border-color:#cbd5e1; }
  </style>
</head>
<body>
  <div class="container">
    <!-- board가 모델에 있으면 data-bno로, 없으면 쿼리스트링에서 읽도록 JS에서 처리 -->
    <div class="view-card" id="postView" data-bno="${board.bno}">
      <div class="card-header">
        <h3><i class="bi bi-journal-text me-2"></i>게시글 상세보기</h3>
        <div class="d-flex gap-2">
          <a href="/board" class="btn btn-sm btn-light"><i class="bi bi-list-ul me-1"></i>목록</a>
          <c:if test="${not empty board.bno}">
            <a href="/board/update?bno=${board.bno}" class="btn btn-sm btn-primary"><i class="bi bi-pencil-square me-1"></i>수정</a>
          </c:if>
        </div>
      </div>

      <div class="card-body p-4 p-md-5">
        <div class="post-title"><c:out value="${board.title}"/></div>
        <div class="post-meta">
          <span class="me-3">#<c:out value="${board.bno}"/></span>
          <i class="bi bi-person"></i> <c:out value="${board.writer}"/>
          <span class="mx-2">·</span>
          <i class="bi bi-calendar-event"></i> <c:out value="${board.regdate}"/>
        </div>

        <div class="divider"></div>

        <div class="post-content"><c:out value="${board.content}"/></div>

        <div class="divider"></div>

        <div class="d-flex align-items-center justify-content-between">
          <h5 class="m-0"><i class="bi bi-chat-dots me-2"></i>댓글</h5>
          <span id="replyCount" class="chip"><i class="bi bi-chat-left-text"></i> 0</span>
        </div>

        <div id="replyList" class="mt-2">
          <div id="replyLoading" class="text-secondary small">불러오는 중...</div>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    // 1) bno 얻기: data-bno 우선, 없으면 ?bno= 파싱
    var container = document.getElementById('postView');
    var bno = container && container.getAttribute('data-bno');
    if (!bno) {
      var params = new URLSearchParams(location.search);
      bno = params.get('bno');
    }

    // 2) 댓글 API 호출: 경로형(/board/{bno}/reply) 시도 → 실패하면 쿼리형(/board/reply?bno=) 재시도
    function fetchReplies(bno) {
      var pathUrl = '/board/' + encodeURIComponent(bno) + '/reply';
      return fetch(pathUrl).then(function(res) {
        if (res.ok) return res.json();
        // 404/405 등일 때 쿼리형으로 폴백
        var queryUrl = '/board/reply?bno=' + encodeURIComponent(bno);
        return fetch(queryUrl).then(function(res2){
          if (!res2.ok) throw new Error('reply api not found');
          return res2.json();
        });
      });
    }

    fetchReplies(bno)
      .then(function(datas){
        var list = document.getElementById('replyList');
        var loading = document.getElementById('replyLoading');
        var count = document.getElementById('replyCount');
        if (loading) loading.remove();

        var len = Array.isArray(datas) ? datas.length : 0;
        count.innerHTML = '<i class="bi bi-chat-left-text"></i> ' + len;

        if (!Array.isArray(datas) || len === 0) {
          var empty = document.createElement('div');
          empty.className = 'empty';
          empty.textContent = '등록된 댓글이 없습니다.';
          list.appendChild(empty);
          return;
        }

        datas.forEach(function(data){
          var item = document.createElement('div');
          item.className = 'reply-item';

          var avatar = document.createElement('div');
          avatar.className = 'reply-avatar';
          avatar.textContent = (data.replyer && data.replyer.charAt) ? data.replyer.charAt(0).toUpperCase() : '?';

          var body = document.createElement('div');
          var meta = document.createElement('div');
          meta.className = 'reply-meta';
          meta.textContent = '#' + (data.rno || '') + ' · ' + (data.replyer || '익명');

          var bubble = document.createElement('div');
          bubble.className = 'reply-bubble';
          bubble.textContent = data.reply || '';

          body.appendChild(meta);
          body.appendChild(bubble);
          item.appendChild(avatar);
          item.appendChild(body);
          list.appendChild(item);
        });
      })
      .catch(function(err){
        console.error(err);
        var list = document.getElementById('replyList');
        var loading = document.getElementById('replyLoading');
        if (loading) loading.remove();
        var errBox = document.createElement('div');
        errBox.className = 'text-danger small';
        errBox.textContent = '댓글을 불러오지 못했습니다. (API 경로 확인 필요)';
        list.appendChild(errBox);
      });
  </script>
</body>
</html>
  
  
  
  