/**
 * boardService.js
 */

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
	
	
}