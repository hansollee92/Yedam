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
			} else if (result.retCoe == 'NG') {
				alert('삭제실패!!');
			} else {
				alert('알수없는 코드입니다.');
			}
		},
		err => console.error(err)
	)
};



