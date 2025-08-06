/**
 * ajax2.js
 * JSON.parse(json문자열) -> 자바스크립트 객체
 */


fetch('js/MOCK_DATA.json') //Promise 객체
     .then(function(result){
		//console.log(result);    // 응답정보(body)
		return result.json();  
	 }) 
	 .then(function(result){
		//console.log(result); //result가 배열의 형태
		result.forEach(elem => {  //각 데이터 처리를 위한 forEach
			// tr
			let tr = document.createElement('tr');
			// td
			['id', 'first_name', 'last_name', 'salary'].forEach(field => {   //td를 만들기 위한 forEach
				let td = document.createElement('td');
				td.innerText = elem[field];
				tr.appendChild(td);
			});			
			//삭제버튼
			let td = document.createElement('td'); 
			let btn = document.createElement('button');
			btn.innerHTML = '삭제'; 	
			td.appendChild(btn);
			tr.appendChild(td);	
			
			document.querySelector('#show tbody').appendChild(tr);
		});
	 })
     .catch(function(err){		
		console.log(err);
	 })   

// 어제 우리는 JSON.parse해서 직접 처리를 했었는데 이렇게 할 필요없이 
// 파싱한 결과를 가지고 바로 페이지를 만들 수 있다. 











