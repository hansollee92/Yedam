/**
 * qnaReply.js
 */

let page = 1;

// 댓글 목록
function showReplyList(){

	//기존 목록 지우기 
	document.querySelectorAll('ul.qnaReply-container>li').forEach((elem, idx) => {
		elem.remove();
	})

	//목록 출력
	svc.replyList(qnaNo,
		result => {
			result.forEach(reply => {
				let target = document.querySelector('ul.qnaReply-container');

				//날짜 형식 변경
				let date = new Date(reply.qnaReplyDate);
				let formattedDate = date.toLocaleDateString("ko-KR", {
					year: "numeric", 
					month: "2-digit", 
					day: "2-digit", 
					hour: "2-digit", 
					minute: "2-digit" 
				})
				
				//댓글 데이터 없을 때
				if(!Array.isArray(result) || result.length == 0) return;

				let text = `<li>
					<div class="img-box">
						<img src="images/mypage/user-default2.png" alt="사용자 이미지">
					</div>
					<ul class="reply-meta">
						<li>${reply.qnaReplyNo}</li>
						<li>${reply.memberId}</li>
						<li>${reply.qnaReplyContent}</li>
						<li>${formattedDate} <span class="del-btn">삭제</span></li>
					</ul>
			    </li>`;
				target.insertAdjacentHTML('beforeend', text);
				
				//삭제 이벤트
				document.querySelector('.del-btn').addEventListener('click', deleteRowFnc);
			})
			//페이징 목록
		},
		err => console.error(err)
	);
}
showReplyList();




// 댓글 등록
window.addEventListener('DOMContentLoaded', () => {
	document.querySelector('#replySubmit').addEventListener('click', onReplySubmit);
})

function onReplySubmit(){
	const reply = document.querySelector('#replyContent');
	
	const qnaReplyContent = (reply.value || '').trim();
	console.log('[DEBUG]', { qnaNo, qnaReplyContent, len: qnaReplyContent.length,
	                           count: document.querySelectorAll('#replyContent').length });
	
	
	
	if(!qnaNo || qnaReplyContent.length == 0 ){
		alert('내용을 입력해주세요');
		return;
	}
	svc.registerReply({qnaNo, qnaReplyContent},
		result => {
			if(result.retCode == 'OK'){
				let r = result.retVal;
				showReplyList(r);
				reply.value = ''; //입력창 초기화
			}else if(result.retCode == 'NG'){
				alert('댓글 등록에 실패했습니다.');
			}else{
				alert('댓글 등록 중 오류가 발생했습니다.');
			}
		},
		err => console.error(err)
	)
	
}








// 댓글 하나 그려주는 함수
function makeRow(reply){
	let target = document.querySelector('ul.qnaReply-container');
		let text = `<li>
		<div class="img-box">
			<img src="images/mypage/user-default2.png" alt="사용자 이미지">
		</div>
		<ul class="reply-meta">
			<li>${reply.qnaReplyNo}</li>
			<li>${reply.memberId}</li>
			<li>${reply.qnaReplyContent}</li>
			<li>${formattedDate} <span class="del-btn">삭제</span></li>
		</ul>
		</li>`;
	target.insertAdjacentHTML('beforeend', text);
}






// 댓글 삭제 함수
function deleteRowFnc(e){
	let qnaReplyNo = e.target.parentElement.parentElement.children[0].innerText;
	
	if(!confirm(`${qnaReplyNo}번 댓글을 삭제하시겠습니까?`)){
		alert('삭제를 취소했습니다.');
		return;
	}

	svc.removeReply(qnaReplyNo,
		result => {
			if (result.retCode == 'OK') {
				showReplyList();
			} else if (result.retCode == 'NG') {
				alert('댓글 삭제를 실패했습니다.');
			} else {
				alert('댓글 삭제 중 오류가 발생했습니다.');
			}
		},
		err => console.error(err)
	)
};



