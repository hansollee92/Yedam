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
				// insertAdjacentHTML(position, text) 메서드 
				// 일단 대상이 있어야 한다. ul태그를 기준으로 우리는 beforeend로 넣을려고 한다. (=ul 닫는태그 안쪽으로 넣을려고 한다)
				let target = document.querySelector('div.content>ul');
				let text = `<li>
					<span class="col-sm-2">${reply.replyNo}</span>
					<span class="col-sm-5">${reply.reply}</span>
					<span class="col-sm-2">${reply.replyer}</span>
					<span class="col-sm-2"><button class="btn btn-light" onclick='deleteRowFnc(event)'>삭제</button></span>
					</li>`;
				target.insertAdjacentHTML('beforeend', text); 				
				
				//let li = makeRow(reply);
				//document.querySelector('div.content>ul').appendChild(li);
			})
			// 페이징 목록 그려주기
			showPagingList();
			
		},  //두번째 param
		err => console.error(err) //세번째 param
	);	
}
showReplyList();  // 최초목록 출력
	

// 페이징목록 출력
function showPagingList(){
	svc.replyTotalCount(bno, 
		result => {
			//console.log(result);
			let totalCnt = result.totalCnt;
			let paging = new PageVO(page, totalCnt);
			//console.log(paging);
			
			
			// parent 요소
			let target = document.querySelector('div.pagination');
			// 기존에 있는 pagination의 a태그들 삭제
			target.innerHTML = ''; 
			
			// 이전페이지 여부 
			if(paging.prev){
				//true 값이면 <a href="#">&laquo;</a> 이 형태로 나타나게 하면 됨
				let atag = document.createElement('a');
				atag.href = paging.start - 1;
				atag.setAttribute('data-page', paging.start - 1);
				
				atag.innerHTML = '&laquo;'    //text말고 여기선 HTML
				target.appendChild(atag);
			}		
			
			
			
			
			// start ~ end
			// 반복문으로 페이지네이션 1,2,3... 버튼들을 만들려고 한다.
			for(let p=paging.start; p<=paging.end; p++){
				
				//이 안에 a태그에 href속성을 주고 innerText도 줘야한다. 
				//<a href="#">1</a> 이런형태로 
				let atag = document.createElement('a');
				//atag.setAttribute('href', p); 이렇게 작성을 해도 되고 아래와 같이도 작성 가능
				// href는 속성이여서 가능
				
				atag.href = p;
				atag.setAttribute('data-page', p);
				
				// 내가 보고 있는 페이징번호 활성화 시키는 코드값 넣기
				if(paging.currPage == p){
					atag.setAttribute('class', 'active');
				}				
				atag.innerText = p;
				target.appendChild(atag);
			}
			
			// 이후페이지 여부
			if(paging.next){
				//true 값이면 <a href="#">&raquo;</a> 이 형태로 나타나게 하면 됨
				let atag = document.createElement('a');
				atag.href = paging.end + 1;
				atag.setAttribute('data-page', paging.end + 1);
				
				atag.innerHTML = '&raquo;'    //text말고 여기선 HTML
				target.appendChild(atag);
			}		
			
			//a 태그에 대한 이벤트 함수 실행
			addEvent();
						
		},
		err => console.error(err)
	);
	
}//end of showPagingList();





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
					//console.log(result);
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
function addEvent(){
	document.querySelectorAll('div.footer>div.pagination>a').forEach(atag => {
		atag.addEventListener('click', e => {
			e.preventDefault(); //a태그가 페이지의 기본기능인데 실제 이동하면 안되니깐 이 기능을 차단하겠다는 의미 
			// a태그를 눌렀을때 눌렀던 a(target)의 innerText(=page)을 불러와서 그 page로 이동해야함   
			//data-page => dataset.page 을 사용
			page = e.target.dataset.page;
			console.log(page);			
			
			// 목록그려주기 
			showReplyList();
			
		})
	})
}


// li>span 그려주는 함수	
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
	rno = e.target.closest('li').firstElementChild.innerText;
	//console.log(rno);

	// 사용자에게 글삭제여부 확인
	if (!confirm(`${rno}번 댓글을 삭제하겠습니까?`)) {
		//confirm() : JavaScript의 confirm()은 사용자에게 "확인" 또는 "취소"를 물어보는 팝업 창을 띄우는 내장 함수			
		alert('삭제를 취소했습니다.');
		return;
	}

	// fetch 서버프로그램 호출		
	svc.removeReply(rno,
		result => {
					if (result.retCode == 'OK') {
						//e.target.parentElement.parentElement.remove();  (onclick으로 지워주니)
						showReplyList();
					} else if (result.retCoe == 'NG') {
						alert('삭제실패!!');
					} else {
						alert('알수없는 코드입니다.');
					}
				},
		err => console.error(err)
	);
}


