<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Bootstrap CDN -->
	<link
	  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	  rel="stylesheet"
	  integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	  crossorigin="anonymous">
	<!-- jQuery CDN -->
    <script
      src="https://code.jquery.com/jquery-3.7.1.min.js"
      integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
      crossorigin="anonymous"
    ></script>
	<title>Insert title here</title>
</head>
<body>
	<h3>게시글 상세보기</h3>
	
	<div>#${board.bno}</div>
	<div>작성자: ${board.writer}</div>
	<div>작성날짜: ${board.regdate}</div>
	<div>내용: ${board.content}</div>
	<div>
		<input type="text" id="replyer" name="replyer" placeholder="작성자">
		<input type="text" id="reply" name="reply" placeholder="댓글을 등록해주세요." >
		<button type="button" class="btnInsert">등록</button>
	</div>
	<div id="replyList"></div>
	
	<script>
		let bno = ${board.bno};
		
		// 등록
		$(".btnInsert").on('click', (e) => {
			// input태그값을 콘솔에 출력 val()
			const replyer = $("#replyer").val();
			const reply = $("#reply").val();
			console.log(replyer, reply);
			
			fetch('/reply', {
				  method: 'POST',
				  body: JSON.stringify({replyer, reply, bno}), 
				  // {replyer:replyer, reply:reply}와 같은 표현
				  // 칼럼명이랑 값이 같으면 이런식으로 생략 가능
				  headers: {
				    'Content-type': 'application/json; charset=UTF-8',
				  },
				})
				  .then((response) => response.json())  // 등록값을 int로 한다면 text()로 받아야함 
				  .then((response) => {
					  let data = response.data;
					  let replyList = document.querySelector("#replyList");
					  let newTag = `<div class="row" data-rno="\${data.rno}">
							<div class="col">\${data.replyer}</div>
							<div class="col-7">\${data.reply}</div>
							<div class="col">
								<button class="btn btn-danger btnDelete">삭제</button>
				                <button class="btn btn-secondary btnUpdate">수정</button>
				            </div>
						</div>`;
					  replyList.insertAdjacentHTML("afterbegin", newTag);
					  
				  });

		});
			
	
		// 전체조회
		// \${}으로 작성안하면 안됨 => 왜? 
		fetch(`http://localhost:81/board/\${bno}/reply`)
		  .then((response) => response.json())
		  .then((datas) => {
			  let replyList = document.querySelector("#replyList");
			  for(data of datas){
				  let newTag = `<div class="row" data-rno="\${data.rno}">
						<div class="col">\${data.replyer}</div>
						<div class="col-7">\${data.reply}</div>
						<div class="col">
							<button class="btn btn-danger btnDelete">삭제</button>
			                <button class="btn btn-secondary btnUpdate">수정</button>
			            </div>
					</div>`;
				  replyList.insertAdjacentHTML("beforeend", newTag);
			  }
		  });


		// 이벤트가 아래와 같이 들어가는 이유는 동적으로 들어가기 때문에 -> 일일이 하나씩 이벤트를 걸지 않고 이벤트위임(그룹이벤트)를 이용
		$("#reply").on("click", ".btnDelete", (e) => {
			const rno = $(e.target).closest(".row").data("rno");
			console.log(rno)
			fetch(`http://localhost:81/reply/\${rno}`, {
				method: 'DELETE'
			})
				.then((result) => result.text())  // .json넘겨주는게 아님
				.then((data) => {
					console.log(data);
					$(e.target).closest(".row").remove();
					alert('해당 댓글이 삭제되었습니다.');					
				})
		})
		
	</script>
</body>
</html>  




 
 --%>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>

<!-- ✅ Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<style>
  :root {
    --grad-start:#4f46e5;
    --grad-end:#2563eb;
    --bg:#f8fafc;
    --muted:#6b7280;
    --border:#e2e8f0;
    --hover:#f9fafb;
    --edit-btn:#4f46e5;
    --delete-btn:#ef4444;
  }

  body { background: var(--bg); font-family: "Pretendard","Noto Sans KR",sans-serif; }

  .form-card {
    max-width: 960px;
    margin: 72px auto;
    background: #fff;
    border-radius: 1rem;
    box-shadow: 0 12px 30px rgba(16,24,40,.08);
    overflow: hidden;
    border: 1px solid #eef1f6;
  }

  .card-header {
    background: linear-gradient(135deg,var(--grad-start),var(--grad-end));
    color:#fff; padding:1.25rem 1.5rem;
    display:flex; align-items:center; justify-content:space-between;
  }
  .card-header h3 { margin:0; font-weight:800; }

  .card-body { padding:2rem 2.25rem; }

  /* 기본 정보 */
  .meta-table { border:1px solid var(--border); border-radius:12px; overflow:hidden; margin-bottom:1rem; }
  .meta-row { display:grid; grid-template-columns:140px 1fr; border-bottom:1px solid var(--border); }
  .meta-row:last-child { border-bottom:0; }
  .meta-label { background:#f7f8fa; padding:.9rem 1rem; font-weight:700; color:#374151; }
  .meta-value { padding:.9rem 1rem; color:#0f172a; }

  /* 본문 */
  .content-box {
    border:1px solid var(--border);
    border-radius:12px;
    padding:1.25rem 1rem;
    background:#fff;
    white-space: pre-wrap;
    line-height:1.65;
  }

  /* 댓글 영역 */
  .reply-wrap { margin-top:2.5rem; }
  .reply-header {
    font-weight:800; color:#111;
    border-bottom:2px solid var(--grad-start);
    padding-bottom:.5rem; margin-bottom:1rem;
    font-size:1.2rem;
  }
  .reply-input {
    border:1px solid var(--border);
    border-radius:12px;
    background:#fff;
    padding:1rem;
    margin-bottom:1rem;
  }
  .reply-list {
    border:1px solid var(--border);
    border-radius:12px;
    background:#fff;
    padding:.4rem;
  }

  #replyList > .row {
    --bs-gutter-x: 1rem;
    margin: .5rem 0 !important;
    border:1px solid var(--border);
    border-radius:10px;
    padding:.65rem .55rem;
    background:#fff;
    transition: all .2s ease;
  }
  #replyList > .row:hover {
    background: var(--hover);
    box-shadow: 0 4px 12px rgba(0,0,0,.05);
  }

  #replyList .col, #replyList .col-7 { display:flex; align-items:center; }

  /* ✅ 댓글 버튼 리디자인 */
  #replyList .btn {
    --bs-btn-padding-y: .3rem;
    --bs-btn-padding-x: .8rem;
    font-size: .85rem;
    border: none;
    border-radius: 999px;
    color: #fff;
    font-weight: 600;
    transition: all .2s ease;
  }
  #replyList .btnUpdate {
    background: linear-gradient(135deg, var(--grad-start), var(--grad-end));
  }
  #replyList .btnUpdate:hover {
    filter: brightness(.95);
    box-shadow: 0 0 0 3px rgba(79,70,229,.15);
  }
  #replyList .btnDelete {
    background: #dc2626;
  }
  #replyList .btnDelete:hover {
    background: #dc2626;
    box-shadow: 0 0 0 3px rgba(239,68,68,.15);
  }

  .btn-primary {
    background: linear-gradient(135deg,var(--grad-start),var(--grad-end));
    border:none; font-weight:700;
  }

  .btn-primary:hover { filter: brightness(.95); }

  @media (max-width:768px) {
    .meta-row { grid-template-columns:1fr; }
    .meta-label { border-bottom:1px solid var(--border); }
  }
</style>
</head>

<body>
  <div class="container">
    <div class="form-card">
      <div class="card-header">
        <h3><i class="bi bi-journal-text me-2"></i>게시글 상세</h3>
        <div class="d-flex gap-2">
          <a href="/board" class="btn btn-sm btn-light"><i class="bi bi-list-ul me-1"></i>목록</a>
          <a href="/board/update?bno=${board.bno}" class="btn btn-sm btn-outline-light"><i class="bi bi-pencil-square me-1"></i>수정</a>
        </div>
      </div>

      <div class="card-body">
        <!-- 기본 정보 -->
        <div class="meta-table">
          <div class="meta-row"><div class="meta-label">글 번호</div><div class="meta-value">#${board.bno}</div></div>
          <div class="meta-row"><div class="meta-label">작성자</div><div class="meta-value">${board.writer}</div></div>
          <div class="meta-row"><div class="meta-label">작성일</div><div class="meta-value">${board.regdate}</div></div>
        </div>

        <!-- 내용 -->
        <div class="mb-2 fw-bold">내용</div>
        <div class="content-box">${board.content}</div>

        <!-- 댓글 -->
        <div class="reply-wrap">
          <div class="reply-header"><i class="bi bi-chat-dots me-2"></i>댓글</div>

          <!-- 입력 -->
          <div class="reply-input">
            <div class="row g-2 align-items-center">
              <div class="col-12 col-md-3">
                <input type="text" id="replyer" name="replyer" class="form-control" placeholder="작성자">
              </div>
              <div class="col-12 col-md-7">
                <input type="text" id="reply" name="reply" class="form-control" placeholder="댓글을 등록해주세요.">
              </div>
              <div class="col-12 col-md-2 d-grid">
                <button type="button" class="btn btn-primary btnInsert"><i class="bi bi-send me-1"></i>등록</button>
              </div>
            </div>
          </div>

          <!-- 목록 -->
          <div id="replyList" class="reply-list"></div>
        </div>
      </div>
    </div>
  </div>

<script>
	let bno = ${board.bno};	     // jsp EL
	
	add();     //등록이벤트
	remove();  //삭제이벤트
	getList(); //전체조회	
	
	/* -------------------------------------------
			댓글 등록
	    ---------------------------------------------*/
		function add(){
			$(".btnInsert").on('click', (e) => {
				// input태그값을 콘솔에 출력 val()
				const replyer = $("#replyer").val();
				const reply = $("#reply").val();
				console.log(replyer, reply);
				
				fetch('/reply', {
					  method: 'POST',
					  body: JSON.stringify({replyer, reply, bno}), 
					  // {replyer:replyer, reply:reply}와 같은 표현
					  // 칼럼명이랑 값이 같으면 이런식으로 생략 가능
					  headers: {
					    'Content-type': 'application/json; charset=UTF-8',
					  },
					})
					  .then((response) => response.json())  // 등록값을 int로 한다면 text()로 받아야함 
					  .then((response) => {
						  //getList();
						  let data = response.data;
						  let replyList = document.querySelector("#replyList");
						  let newTag = `<div class="row" data-rno="\${data.rno}">
								<div class="col">\${data.replyer}</div>
								<div class="col-7">\${data.reply}</div>
								<div class="col">
					                <button class="btn btn-secondary btnUpdate"><i class="bi bi-pencil-square me-1"></i>수정</button>
									<button class="btn btn-danger btnDelete"><i class="bi bi-trash3 me-1"></i>삭제</button>
					            </div>
							</div>`;
						  replyList.insertAdjacentHTML("afterbegin", newTag);
						  
					  });// end of then
			}); // end of on
		}// end of function 
		
		
		/* -------------------------------------------
			전체조회
		---------------------------------------------*/
		function getList(){
			// \${}으로 작성안하면 안됨 => 왜? 
			fetch(`http://localhost:81/board/\${bno}/reply`)
			  .then((response) => response.json())
			  .then((datas) => {
				  let replyList = document.querySelector("#replyList");
				  for(data of datas){
					  let newTag = `<div class="row" data-rno="\${data.rno}">
							<div class="col">\${data.replyer}</div>
							<div class="col-7">\${data.reply}</div>
							<div class="col">
				                <button class="btn btn-secondary btnUpdate"><i class="bi bi-pencil-square me-1"></i>수정</button>
								<button class="btn btn-danger btnDelete"><i class="bi bi-trash3 me-1"></i>삭제</button>
				            </div>
						</div>`;
					  replyList.insertAdjacentHTML("beforeend", newTag);
				  }
			  });
		}	
	
		
		/* -------------------------------------------
			댓글 삭제
		---------------------------------------------*/
		function remove(){
			// 이벤트가 아래와 같이 들어가는 이유는 동적으로 들어가기 때문에 -> 일일이 하나씩 이벤트를 걸지 않고 이벤트위임(그룹이벤트)를 이용
			$("#replyList").on("click", ".btnDelete", (e) => {
				const rno = $(e.target).closest(".row").data("rno");
				console.log(rno)
				fetch(`http://localhost:81/reply/\${rno}`, {
					method: 'DELETE'
				})
					.then((result) => result.text())  // .json넘겨주는게 아님
					.then((data) => {
						console.log(data);
						$(e.target).closest(".row").remove();
						alert('해당 댓글이 삭제되었습니다.');		
					})
			})	
		} 

		
	</script>
	<!-- <script src="/resources/reply.js"></script> -->
</body>
</html>


  