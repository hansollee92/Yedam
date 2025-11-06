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
