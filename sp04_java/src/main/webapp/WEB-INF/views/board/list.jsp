 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
    crossorigin="anonymous">
  <title>게시글 목록</title>

  <style>
    :root {
      --head-bg: #1f2937;     /* 딥그레이 헤더 */
      --head-fg: #ffffff;     /* 헤더 텍스트 */
      --row-divider: #ebeef3;  /* 행 하단 보더 */
      --hover: #f6f7f9;        /* 행 호버 */
      --muted: #6b7280;        /* 보조 텍스트 */
      --chip-bg: #eef2f7;      /* 배지 배경 */
      --chip-fg: #334155;      /* 배지 텍스트 */
    }

    .table td, .table th { vertical-align: middle; }

    /* 2줄 말줄임 */
    .text-truncate-2 {
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      overflow: hidden;
    }

    /* 헤더: 딥그레이 + 흰 텍스트, 하단 굵은 보더 */
    thead.styled-head th {
      background: var(--head-bg) !important;
      color: var(--head-fg) !important;
      border: 0;
    }
    thead.styled-head tr {
      border-bottom: 2px solid #111827; /* 살짝 더 어두운 라인 */
    }

    /* 본문: 셀 보더 제거, 행 하단 보더만 */
    .table.clean tbody td, .table.clean tbody th {
      border: 0;
    }
    .table.clean tbody tr {
      border-bottom: 1px solid var(--row-divider);
    }

    /* 호버 효과 */
    .table.clean tbody tr:hover > * {
      background: var(--hover);
    }

    /* 첫 컬럼 톤 다운 */
    tbody td:first-child {
      color: var(--muted);
      font-weight: 600;
    }

    /* 댓글수 배지: 중립 칩 스타일 */
    .chip {
      display: inline-block;
      padding: 0.15rem 0.5rem;
      border-radius: 999px;
      background: var(--chip-bg);
      color: var(--chip-fg);
      font-size: .75rem;
      font-weight: 600;
      line-height: 1;
    }

    /* 댓글 블록: 테이블 톤 그대로, 라이트 그리드 */
    .reply-block {
      background: #fff;
    }
    .reply-block .list-group-item {
      border-color: var(--row-divider);
      background: transparent;
      padding-top: .6rem;
      padding-bottom: .6rem;
    }
    .reply-meta {
      color: var(--muted);
      font-weight: 600;
      margin-right: .5rem;
    }

    .rounded-3 { border-radius: .75rem !important; }
    .shadow-sm { box-shadow: 0 .5rem 1rem rgba(0,0,0,.05) !important; }
  </style>
</head>
<body>
  <div class="container-lg">
    <div class="d-flex align-items-end justify-content-between" style="margin: 50px 0 20px;">
      <h3 class="m-0">게시글 목록</h3>
      <a href="/board/register" class="btn btn-dark">새 글쓰기</a>
    </div>

    <div class="table-responsive rounded-3 shadow-sm">
      <table class="table clean align-middle m-0">
        <thead class="styled-head position-sticky top-0" style="z-index:1">
          <tr>
            <th style="width:80px;">#</th>
            <th style="width:25%;">제목</th>
            <th>내용</th>
            <th style="width:15%;">글쓴이</th>
          </tr>
        </thead>

        <tbody>
          <c:if test="${empty list}">
            <tr>
              <td colspan="4" class="text-center text-muted py-5">
                등록된 게시글이 없습니다.
              </td>
            </tr>
          </c:if>

          <c:forEach items="${list}" var="board">
            <!-- 게시글 행 -->
            <tr>
              <td>${board.bno}</td>
              <td>
                <div class="d-flex align-items-center gap-2">
                  <span class="fw-semibold"><a href="/board/update?bno=${board.bno}" style="color: inherit;">${board.title}</a></span>
                  <c:if test="${not empty board.reply}">
                    <span class="chip">${fn:length(board.reply)}</span>
                  </c:if>
                </div>
              </td>
              <td><div class="text-truncate-2">${board.content}</div></td>
              <td class="text-nowrap">${board.writer}</td>
            </tr>

            <!-- 댓글 묶음 행 -->
            <c:if test="${not empty board.reply}">
              <tr class="reply-block">
                <td colspan="4">
                  <ul class="list-group list-group-flush small">
                    <c:forEach items="${board.reply}" var="reply">
                      <li class="list-group-item d-flex align-items-start justify-content-between">
                        <div>
                          <span class="reply-meta">#${reply.rno}</span>
                          <strong class="me-2">${reply.replyer}</strong>
                          <span class="text-body-secondary">— ${reply.reply}</span>
                        </div>
                      </li>
                    </c:forEach>
                  </ul>
                </td>
              </tr>
            </c:if>
          </c:forEach>
        </tbody>
      </table>
      
      
      
    </div>
  </div>

  
</body>
</html>

 
 
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 목록</title>

  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

  <style>
    :root {
      --grad-start: #4f46e5; /* indigo-600 */
      --grad-end: #2563eb;   /* blue-600 */
      --bg: #f8fafc;         /* slate-50 */
      --text-main: #0f172a;
      --muted: #6b7280;
      --border: #e2e8f0;
      --hover: #f1f5f9;
      --chip-bg: #e0f2fe;
      --chip-fg: #0369a1;
    }

    body { background: var(--bg); font-family: "Pretendard","Noto Sans KR",sans-serif; }

    .board-card{
      background:#fff;border-radius:1rem;overflow:hidden;
      box-shadow:0 6px 20px rgba(0,0,0,.05);
    }

    .card-header{
      background:linear-gradient(135deg,var(--grad-start),var(--grad-end));
      color:#fff;padding:1.25rem 1.5rem;
    }
    .card-header h3{margin:0;font-weight:700;}

    .btn-write{background:#fff;color:var(--grad-end);font-weight:600;border-radius:50px;}
    .btn-write:hover{background:var(--grad-end);color:#fff;}

    .table.clean{margin:0;}
    .table.clean thead{background:#f8fafc;border-bottom:2px solid var(--border);}
    .table.clean thead th{color:var(--text-main);font-weight:700;border:none;}
    .table.clean tbody tr{border-bottom:1px solid var(--border);transition:background-color .15s ease,transform .1s ease;}
    .table.clean tbody tr:hover{background:var(--hover);transform:translateY(-1px);}

    .post-title{color:var(--text-main);font-weight:600;text-decoration:none;}
    .post-title:hover{color:var(--grad-end);text-decoration:underline;}

    /* 댓글 수 칩: 한 줄 고정 */
    .chip{
      display:inline-flex;align-items:center;gap:.35rem;
      padding:.2rem .6rem;border-radius:999px;font-size:.75rem;font-weight:700;
      background:var(--chip-bg);color:var(--chip-fg);white-space:nowrap;
    }

    /* 말풍선: 한 줄로 표시 (줄바꿈 방지) */
    .reply-bubble{
      display:inline-flex;align-items:center;white-space:nowrap;
      background:#fff;border:1px solid var(--border);border-radius:12px;
      padding:.45rem .6rem;box-shadow:0 2px 5px rgba(0,0,0,.03);max-width:100%;
    }

    .reply-block{background:#f9fafb;}
    .reply-block .list-group-item{background:transparent;border:none;padding:.6rem 0;display:flex;align-items:flex-start;}
    .reply-meta{font-size:.8rem;color:var(--muted);margin-bottom:.25rem;}

    /* 접힘 영역 상단에 본문 보여주는 박스 */
    .content-box{
      background:#fff;border-bottom:1px solid var(--border);
      padding:1rem 1.25rem;
    }
    .content-box .label{font-size:.8rem;color:var(--muted);margin-bottom:.25rem;}
    .content-box .body{color:#111827;line-height:1.6;}

    @media (max-width: 768px){
      /* 내용 컬럼 제거했으므로 모바일 조정만 */
    }
  </style>
</head>
<body>
  <div class="container-xl py-4">
    <div class="board-card">
      <div class="card-header d-flex justify-content-between align-items-center">
        <h3><i class="bi bi-chat-left-text me-2"></i>게시글 목록</h3>
        <a href="/board/register" class="btn btn-sm btn-write px-3">
          <i class="bi bi-pencil-square me-1"></i>새 글쓰기
        </a>
      </div>

      <div class="table-responsive">
        <table class="table clean align-middle">
          <thead>
            <tr>
              <th style="width:70px;">#</th>
              <th style="width:45%;">제목</th>
              <!-- (변경) 내용 컬럼 제거 -->
              <th style="width:20%;">글쓴이</th>
              <th style="width:60px;" class="text-center">댓글</th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${empty list}">
              <tr><td colspan="4" class="text-center text-muted py-5">등록된 게시글이 없습니다.</td></tr>
            </c:if>

            <c:forEach items="${list}" var="board">
              <!-- 행 클릭 시 댓글/내용 토글 -->
              <tr class="collapse-toggle"
                  data-bs-toggle="collapse"
                  data-bs-target="#replies-${board.bno}">
                <td class="text-muted fw-semibold">${board.bno}</td>

                <td>
                  <a class="post-title"
                     href="/board/update?bno=${board.bno}"
                     onclick="event.stopPropagation();">
                    ${board.title}
                  </a>
                </td>

                <!-- (변경) 내용 셀 삭제 -->
                <td class="text-nowrap">
                  <i class="bi bi-person me-1 text-secondary"></i>${board.writer}
                </td>

                <td class="text-center">
                  <c:set var="replyCount" value="${empty board.reply ? 0 : fn:length(board.reply)}"/>
                  <span class="chip"><i class="bi bi-chat-dots"></i> ${replyCount}</span>
                </td>
              </tr>

              <!-- 접힘 영역: 위에 본문 내용, 아래 댓글 말풍선 리스트 -->
              <tr class="reply-block">
                <!-- (변경) colspan 5 → 4 (내용 컬럼 제거 영향) -->
                <td colspan="4" class="p-0">
                  <div id="replies-${board.bno}" class="collapse">
                    <!-- 본문 내용 박스 -->
                    <div class="content-box">
                      <div class="label"><i class="bi bi-text-left me-1"></i>내용</div>
                      <div class="body">${board.content}</div>
                    </div>

                    <!-- 댓글 목록 -->
                    <ul class="list-group list-group-flush px-4 py-2">
                      <c:if test="${empty board.reply}">
                        <li class="text-muted small py-2">등록된 댓글이 없습니다.</li>
                      </c:if>

                      <c:forEach items="${board.reply}" var="reply">
                        <li class="list-group-item">
                          <div>
                            <div class="reply-meta">#${reply.rno} · ${reply.replyer}</div>
                            <!-- (핵심) 말풍선 한 줄 표시 -->
                            <div class="reply-bubble">${reply.reply}</div>
                          </div>
                        </li>
                      </c:forEach>
                    </ul>
                  </div>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
 --%>
 