var replyService = {
	add: function(data, callback){
		fetch('/reply', {
			  method: 'POST',
			  body: JSON.stringify(data),  //== {reply:reply, replyer:replyer}
			  headers: {
			    'Content-type': 'application/json; charset=UTF-8',
			  },
			})
	   .then((response) => response.json())   //text()
	   .then((response) => {  callback(response.data);  });  // end of then
	},	
	remove : function (rno, callback){
			fetch(`/reply/${rno}`, {method:"delete"})
			.then( response => result.text() )
			.then( response => { 
				if (callback)
					callback(result)	
			})
	},
	
	getList : function(callback){
		fetch(`http://localhost:81/board/${bno}/reply`)
		.then((response) => response.json())
		.then((datas) => {
			if (callback) {
				callback(datas);
			}
		});
	}
}



add();     //등록이벤트
remove();  //삭제이벤트
getList(); //전체조회

/*-----------------------------------
 * 댓글등록
 -----------------------------------*/
function add() {
	$(".btnInsert").on("click", e => {
		//인풋태그값을 콘솔에 출력  val()
		const replyer = $('[name="replyer"]').val()   //name속성으로 찾기
		const reply = $('[name="reply"]').val() 
		const data = {replyer, reply, bno}
		replyService.add(data, function(){
		  let data = response.data;
		  let reply = document.querySelector("#replyList");
		  let newTag = 
				`<div class="row mb-2" data-rno="\${data.rno}">
					<div class="col">\${data.replyer}</div>
					<div class="col-7">\${data.reply}</div>
					<div class="col"><button class="btn btn-danger btnDelete me-3">삭제</button>
					                 <button class="btn btn-success btnUpdate">수정</button></div>
				</div>`
				reply.insertAdjacentHTML("afterbegin",newTag);  //afterbegin
	  });  // end of service
	})  // end of on
} // end of function

/*-----------------------------------
 * 댓글조회
 -----------------------------------*/
function getList(){
	replyService.getList(function(){
		let reply = document.querySelector("#replyList");
		for(data of datas) {
			let newTag = 
			`<div class="row mb-2" data-rno="\${data.rno}">
				<div class="col">\${data.replyer}</div>
				<div class="col-7">\${data.reply}</div>
				<div class="col"><button class="btn btn-danger btnDelete me-3">삭제</button>
				                 <button class="btn btn-success btnUpdate">수정</button></div>
			</div>`
			reply.insertAdjacentHTML("beforeend",newTag);
		}	
	});
}

/*-----------------------------------
 * 댓글삭제
 -----------------------------------*/
function remove() {
	$("#reply").on("click", ".btnDelete", e=>{
		const rno = $(e.target).closest(".row").data("rno");
		replyService.remove(rno, function(){
			$(e.target).closest(".row").remove();			
		})
	})
}