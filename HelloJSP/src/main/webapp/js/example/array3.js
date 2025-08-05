/*
 * array3.js
 * 
 * reduce
 * 배열메소드
 * 매개변수가 acc:누적값, 어큐뮬레이터? / elem, idx, ary로 총 4개이다. 
 * 
 */

let studentAry = [
	{name: '홍길동', score: 80},
	{name: '김민규', score: 85},
	{name: '박서하', score: 88},
	{name: '김길동', score: 76}	
]

// reduce() + DOM 을 활용해서 출력하기

let result = studentAry.reduce((acc, elem) =>{
	
	let tr = document.createElement('tr');
	for(let prop in elem){
		let td = document.createElement('td');
		td.innerText = elem[prop];
		tr.appendChild(td);
	}
	acc.appendChild(tr);
	
	return acc;
	
}, document.querySelector('#item tbody'));




/*

// 80점이 넘는 사람들만 reduce를 활용해서 콘솔에 담고 싶다면? 

let newAry = studentAry.reduce((acc, elem) => {
	if(elem.score >= 80){
		acc.push(elem);
	}
	return acc;
}, []);
console.log(newAry);


// 최고의 점수를 가진 사람의 이름과 점수를 알고 싶다면? 

let result = studentAry.reduce((acc, elem) =>{
	
	console.log('acc=> ', acc, 'elem=>', elem);
	if(acc.score < elem.score){
		acc = elem;
	}
	return acc;
	
}, studentAry[0])
console.log(`최고점자는 ${result.name}, 점수는 ${result.score}점입니다.`);

*/






/*let numAry = [10, 15, 20, 77, 25, 30];
let result = numAry.reduce((acc, elem, idx, ary) => {
	//console.log(`${acc}, ${elem}`);
	
	// acc => []
	if(elem % 2 == 0){
		acc.push(elem);
	}
	return acc;		
}, []);
console.log(result); */

// 지금은 간단히 숫자만 넣어봤는데 
// 저 안에 오브젝트(객체)가 올수도 있다. 

// 초기값을 배열객체로도 선언할 수 있다. 
//현재 acc => [] 배열이다. 