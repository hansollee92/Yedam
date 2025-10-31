/**
 * array2.js
 * 
 * filter : 배열메소드 
 * 요소의 값 -> true일 때 그 요소를 새로운 배열에 생성
 * 
 */

// 함수를 하나 만들어보자
// 멤버 하나를 딱 던져주면 데이터를 화면에 보여주는 것
function makeRow(member) {
	// tr>td*7 기능
	
	//tr
	let tr = document.createElement('tr');

	// td
	for (let prop in member) {
		let td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}

	// 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('type', 'button');
	btn.innerHTML = '삭제';
	// 삭제 이벤트 
	btn.addEventListener('click', (e) => {
		let parent = e.target.parentElement.parentElement;
		console.log(parent.children);
		let fn = parent.children[1].innerText;
		let ln = parent.children[2].innerText;

		if (confirm(`${fn} ${ln}을 삭제하겠습니까?`)) {
			parent.remove();
		}

	})
	td.appendChild(btn);
	
	tr.appendChild(td);
	
	return tr;
}


document.querySelector('select').addEventListener('change', function(){
	searchCenterList();
})
	
function searchCenterList(sido){
	fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		//console.log(result.data[0]);
		result.data.forEach(elem =>{
			let option = document.querySelector('select>option').value;
			
			if(elem.sido == `${option}`){
				let tr = document.createElement('tr');
				['id', 'centerName', 'phoneNumber'].forEach(prop => {
					let td = document.createElement('td');
					td.innerText = elem[prop];
					tr.appendChild(td);
				})		
				document.querySelector('#list').appendChild(tr);			

			}
			
		});
	})
	.catch(err => console.error(err));	
}




// 급여가 7000 이상인 사람들을 목록에 출력
// 전체 members를 가져와서 filter 처리를 할 것임 
/*members.filter(elem => {
	if(elem.salary >= 8000 && elem.gender == 'Female'){
		return true;
	}
}).forEach(elem => {
	let tr = makeRow(elem);
	document.querySelector('#show tbody').appendChild(tr);
	
})*/

// 위의 것을 아래처럼 간단하게 표현이 가능하다. 
members
    .filter(elem => elem.salary >= 8000)
	.filter(elem => elem.gender == 'Female')
	.map(elem => {
		let {id, first_name, last_name, salary} = elem; //{id,fn,ln,email,gender,salary}
		let obj = {id, first_name, last_name, salary};
		return obj;
	})
    .forEach(elem => document.querySelector('#show tbody').appendChild(makeRow(elem)));




/*let result = [10, 20, 30, 40, 50].filter((elem, idx, ary) => {
	if (elem >= 30) {
		return true;
	}

});

console.log(result);*/






// Map은 매핑한다는 것
// A -> A'
// Map도 똑같이 새로운 배열을 반환해준다. 

