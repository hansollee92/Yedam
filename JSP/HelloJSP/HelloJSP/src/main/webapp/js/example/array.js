/**
 * array.js 
 * 
 * forEach, Map, filter, reduce 메소드 연습
 * 책의 메소드 연습
 * 
 */


// forEach ----------------------------------------------------------------------------------------
// document.querySelectorAll() 결과에 사용가능


// 배열 전체의 합을 구하는 기능 만들기 
// sum 변수 활용
let sum = 0;

var evenSum = (elem, idx, ary) => {
	if(elem % 2 == 0){
		sum += elem;
	}
	if(idx == ary.length - 1){
		console.log(`짝수들의 합: ${sum}`);		
	}
}

var oddSum = (elem, idx, ary) => {
	if(idx % 2 == 0){
		sum += elem;
	}
	if(idx == ary.length - 1){
		console.log(`홀수번째의 합: ${sum}`);		
	}
}

var totalSum = (elem, idx, ary) => {
	sum += elem;
	if(idx == ary.length - 1){
		console.log(`전체 합: ${sum}`);		
	}
}

[12, 34, 83, 22, 59, 77].forEach(evenSum);
[12, 34, 83, 22, 59, 77].forEach(oddSum);
[12, 34, 83, 22, 59, 77].forEach(totalSum);








