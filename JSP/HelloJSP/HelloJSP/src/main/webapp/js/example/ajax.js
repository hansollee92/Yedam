/**
 * ajax.js
 * Asynchronous JavaScript And Xml : 비동기 방식의 자바스크립트 와 xml 
 * 
 * xml는 Markup Language로
 * 예전에는 서버에서 데이터를 주고받을때 xml 형태로 주고받았다.
 * 최근에는 JSON형태로 받고 있음
 * 
 * 동기방식은 무엇이고 비동기방식은 뭔데?
 * 
 */

// 동기방식 vs. 비동기방식
// 1000 = 1초
setTimeout(function(){
	console.log('1');
	
}, 1000);

setTimeout(function(){
	console.log('2');
	
}, 2000);

setTimeout(function(){
	console.log('3');
	
}, 500);

// 코드순서는 1,2,3인데 실제로 실행을 해보면 
// 3,1,2  순서로 진행된다. 



const xhtp = new XMLHttpRequest();







