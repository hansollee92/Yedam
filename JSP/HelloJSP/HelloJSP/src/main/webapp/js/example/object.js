/**
 * object.js
 */

//console.log(members);

console.log(members[0]);

// for of
// for...of는 배열, 문자열, Map, Set 등 "반복 가능한(iterable)" 객체를 순서대로 하나씩 꺼내서 사용할 수 있게 해주는 문법
for(let member of members){
	
	//let member = members[0]; 
	//let id = member.id;
	//let first_name = member.first_name;
	//let {id, first_name, last_name, email} = member;
	//console.log(`${id}, ${first_name}, ${last_name}`);
	
	let tr = document.createElement('tr'); 
	
	// for in 반복문 (객체의 속성을 가져올수 있는)
	for(let prop in member){
		//console.log(`속성: ${prop}, 값: ${member[prop]}`); 
		if(prop == 'gender'){
			if(member[prop] == 'Female'){
				tr.style.backgroundColor = '#ffe6ea';
			}else if(member[prop] == 'Male'){
				tr.style.backgroundColor = '#d5f5ff';
			}
		}
		let td = document.createElement('td'); 
		td.innerHTML = member[prop];
		tr.appendChild(td); 
	}
	
	// 문제2 : 삭제버튼을 만들려고 한다면?
	// <td><button>삭제</button></td>
	let td = document.createElement('td'); 
	let btn = document.createElement('button');
	btn.setAttribute('type', 'button'); 
	btn.innerHTML = '삭제'; 	
	// 이벤트 & 이벤트핸들러
	btn.addEventListener('click', (e) => {
		/// console.dir(e.target.parentElement.parentElement);
		let parent = e.target.parentElement.parentElement;
		console.log(parent.children);
		let fn = parent.children[1].innerText; 
		let ln = parent.children[2].innerText; 
		
		if(confirm(`${fn} ${ln}을 삭제하겠습니까?`)){
			parent.remove();
		}
		
	})	
	td.appendChild(btn);
	tr.appendChild(td);		
	
	
	// tbody는 이미 js.jsp에 많으니 명시해줘야함
	document.querySelector('#show tbody').appendChild(tr);
	
	
}

let sum = 0;
// 배열은 아니지만 배열처럼 처리가 가능함 
document.querySelectorAll('#show tbody tr td:nth-of-type(6)')
       .forEach(elem => sum += parseInt(elem.innerText));
// parseInt를 붙이는 것은 화면상에 보이는 것 문자열이기 때문
console.log(`합계는 ${sum}`);

/*let sum2 = 0;
// nth-of-type이 아니라 childern을 사용할 경우 
document.querySelectorAll('#show tbody tr')
       .forEach(elem => {
			//console.log(elem);
			let salary = elem.children[5].innerText;
			sum2 += parseInt(salary);
	   });
console.log(`합계는 ${sum2}`);*/
