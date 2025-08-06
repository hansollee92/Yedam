/**
 * board.js
 * 123 댓글 정보 => json 반환 
 */

let page = 1;   //page 변경
// 페이지로딩시점에 실행
function showReplyList(){
	
	//기존 목록을 지우고
	document.querySelectorAll('div.content>ul>li').forEach((elem, idx) => {
		if(idx >= 2){
			elem.remove();
		}
	})
	
	// 목록출력
	svc.replyList({bno, page}, //첫번째 param
		result => {
			result.forEach(reply => {
				let li = makeRow(reply);
				document.querySelector('div.content>ul').appendChild(li);
			})
		},  //두번째 param
		err => console.error(err) //세번째 param
	);	
}
showReplyList();  // 최초목록 출력
	
// 이벤트 등록
document.querySelector('#addReply').addEventListener('click', function(e){
	// 댓번호(bno), 작성자(logId), 댓글(reply)

	let reply = document.querySelector('#reply').value;
	if(!bno || !reply || !logId){   
		// 자바스크립트에서는 true/false 값이 명확하게 있는데 거짓처럼 느껴지게 하는 것들이 있다. 
		// 그게 falsy라고 하여 0, '', null, undefined가 그런것들이다.
		alert('필수값을 입력하세요');
	}
			
	svc.registerReply({bno, reply, replyer:logId},
		result => {
					console.log(result);
					if(result.retCode == 'OK'){
						let r = result.retVal;    //댓글하나 넘겨주면
						let li = makeRow(r);
						document.querySelector('div.content>ul').appendChild(li);	
						document.querySelector('#reply').value = ''; // 입력창 초기화		
					}else if(result.retCode == 'NG'){
						alert('처리중 예외발생');
					}else{
						alert('알수 없는 코드');
					}
				},
		err => console.error(err)
	);

})

// 페이징 링크에 클릭 이벤트
document.querySelectorAll('div.footer>div.pagination>a').forEach(atag => {
	atag.addEventListener('click', e => {
		e.preventDefault(); //a태그가 페이지의 기본기능인데 실제 이동하면 안되니깐 이 기능을 차단하겠다는 의미 
		// a태그를 눌렀을때 눌렀던 a(target)의 innerText(=page)을 불러와서 그 page로 이동해야함
		page = e.target.innerText;
		// 목록그려주기 
		showReplyList();
		
	})
})

	
	
	
function makeRow(reply) {

	let li = document.createElement('li');
	// 화면에 출력할 정보를 배열로 선언
	['replyNo', 'reply', 'replyer'].forEach(elem => {
		// 위의 replyNo, reply.... 그건 서버가 보내준 JSON 객체의 키값
		let span = document.createElement('span');
		span.innerText = reply[elem];
		if (elem == 'reply') {
			span.setAttribute('class', 'col-sm-5');
		} else {
			span.setAttribute('class', 'col-sm-2');
		}
		li.appendChild(span);
	});

	// 삭제버튼 - 이벤트(실행하는 함수를 이벤트핸들러라고 함)
	let span = document.createElement('span');
	span.setAttribute('class', 'col-sm-2');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRowFnc);  //삭제이벤트
	btn.innerText = '삭제';
	span.appendChild(btn);
	li.appendChild(span);

	return li;
}

// 데이터 삭제 함수 핸들러
function deleteRowFnc(e) {
	// 내가 버튼 누른 놈의 번호를 가져올 수 있어야함 
	let rno = e.target.parentElement.parentElement.children[0].innerText;
	console.log(rno);

	// 사용자에게 글삭제여부 확인
	if (!confirm(`${rno}번 글을 삭제하겠습니까?`)) {
		//confirm() : JavaScript의 confirm()은 사용자에게 "확인" 또는 "취소"를 물어보는 팝업 창을 띄우는 내장 함수			
		alert('삭제를 취소했습니다.');
		return;
	}

	// fetch 서버프로그램 호출		
	svc.removeReply(rno,
		result => {
					if (result.retCode == 'OK') {
						e.target.parentElement.parentElement.remove();
					} else if (result.retCoe == 'NG') {
						alert('삭제실패!!');
					} else {
						alert('알수없는 코드입니다.');
					}
				},
		err => console.error(err)
	);
}









