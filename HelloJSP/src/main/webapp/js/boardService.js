/**
 * boardService.js
 */


class PageVO{	
	//생성자 (constructor가 생성자라는 의미)
	constructor(currPage, totalCnt){
		this.currPage = currPage; 
		this.totalCnt = totalCnt; 
		
		//start, end 계산		
		this.end = Math.ceil( currPage / 10 ) * 10   // 10page
		this.start = this.end - 9;  // 1page
		
		let realEnd = Math.ceil(totalCnt / 5);   //3page
		this.end = this.end > realEnd ? realEnd : this.end; 
		// this.end가
		
		// prev, next 계산
		this.prev = this.start > 1; 
		this.next = this.end < realEnd;		
	}
}
//console.log(new PageVO(10, 153));


// 자바스크립트에서는 위와 같이 객체를 만들수도 있고 
// 아래와도 같이 작성이 가능하다. 
// 위의 방식은 계속해서 값이 바뀌어져야해서 class를 선언해서 작성을 하였고 
// 아래는 아래의 방식이 편하기 때문에 아래와같이 작성을 하였다. 

const svc = {
	count: 20, //속성(property)
	increaseCount: function(){ //메소드
		this.count++;
	},

	showCount(){ //메소드 
		return this.count;
	},
	
	//목록 ajax 메소드
	replyList(param = {bno: 1, page: 1}, successCallback, errorCallback){
		// {bno: 1, page: 1} : 파라미터가 넘어와야하는데 넘어오지 않으면 초기값으로 1을 쓰세요 
		fetch('replyList.do?bno=' + param.bno + '&page='+ param.page)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	
	//삭제 ajax 메소드	
	removeReply(rno, successCallback, errorCallback){
		fetch('removeReply.do?rno=' + rno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	
	//등록 ajax 메소드
	registerReply(param={bno, reply, replyer}, successCallback, errorCallback){
		         //파라미터가 너무 많아지니 이렇게 객체를 선언했음                                                    -
		fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	// 추가메소드 정의
	
	// bno에 대한 전체건수 얻는 ajax 메소드	
	replyTotalCount(bno, successCallback, errorCallback){
		fetch('totalReply.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	}
	
	
}