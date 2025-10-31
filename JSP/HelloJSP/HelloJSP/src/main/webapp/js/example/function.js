/**
 * function.js
 */

// 함수선언식
/*function sum(num1, num2){
	let result = num1 + num2;
	return result;	
}*/
/*let sum = function(num1, num2){
	let result = num1 + num2;
	return result;	
}*/ // 함수표현식으로 이렇게 표현 가능 (에러생김) 
// Uncaught SyntaxError: Identifier 'sum' has already been declared (at function.js:10:5)
//sum(10, 12);

// 함수표현식
/*let showInfo = function(result){
	console.log(result);
}*/

//showInfo('Hello, World');


// 함수를 정의하는 방식은 위와 같은데
// 화살표 함수는 위와같이 함수표현식일때 
// 방식들이 너무 길다해서 짧에 줄인것이 화살표함수

/*let sum = (num1, num2) => {
	return num1 + num2;
}*/

// 근데 실행구문이 하나일때 return, {}도 지울수 있음 
let sum = (num1, num2) => num1 + num2;

// 함수표현식도 더 간단하게 화살표함수로 표현 가능하다 
/*let showInfo = (result) => {
	console.log(result);
}*/

let showInfo = (result) => console.log(result);

// 표현하는 방식이 화살표함수가 매우 간단하기 때문에 될 수 있으면 이 화살표함수로 작성을 해보겠다. 

sum(10, 12);
showInfo('Hello, World');