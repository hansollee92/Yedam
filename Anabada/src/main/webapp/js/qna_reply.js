/**
 * qna_reply.js
 */

fetch("qnaReplyList.do?qnaNo=" + qnaNo)
	.then(function(resolve) {
		return resolve.json();
	})
	.then(function(result) {
		console.log(result);
	})
	.catch(function(err) {
		console.error(err);
	})


  /*<li>
  		<span>번호</span>
		<span>글쓴이</span>
		<span>댓글내용</span>
		<span>댓글날짜</span>
		<span><button type="button">삭제</button></span>
	</li>*/
	
function makeRow(reply){
	
	let li = document.createElement('li');
	['qnaReplyNo', 'memberId', 'qnaReplyContent', 'qnaReplyDate'].forEach(elem => {
		let span = document.createElement('span');
		span.innerText = reply[elem];
	})
	
}
	
	
/*function makeRow (reply){

	
	let li = document.createElement('li');	
	// 글번호 내용 댓글작성자 이렇게 나와야하니깐 일일이 작성하면 코드 중복이 높아지닌 반복문을 사용할것임
	['replyNo', 'reply', 'replyer'].forEach(elem => {
		let span = document.createElement('span');
		span.innerText = reply[elem];
		if(elem == 'reply'){ //글내용은 class값이 col-sm-5가 들어가야하니
			span.setAttribute('class', 'col-sm-5');
		}else{
			span.setAttribute('class', 'col-sm-2');			
		}
		li.appendChild(span);	
	});
	
	// 삭제버튼
	let span = document.createElement('span');
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	span.appendChild(btn);
	li.appendChild(span);
	
	return li;	
}	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
/*
function makeRow(reply) {

	let target = document.querySelector('ul.qnaReply-container');
	let text = `<li>
					<div class="img-box">
						<img src="#none" alt="사용자 이미지">
					</div>
					<ul class="reply-meta">
						<li>글쓴이</li>
						<li>댓글내용</li>
						<li>댓글작성날짜 <span class="del-btn">삭제</span></li>
					</ul>
			    </li>`;
	target.insertAdjacentHTML('beforeend', text);
	
} */