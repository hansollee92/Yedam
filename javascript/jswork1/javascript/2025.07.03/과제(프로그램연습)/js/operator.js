/* 함수 4개 만들기 :더하기, 뺴기, 곱하기, 나누기 변수명 3개 : 수1,수2,결과 */

// 변수
let num1 = document.querySelector('#num1');
let num2 = document.querySelector('#num2');
let result = document.querySelector('#result');

// 함수 만들기
function add(){
  result.value = `덧셈 결과는 ${parseInt(num1.value) + parseInt(num2.value)}`;
}
function sub(){
  result.value = `빼기 결과는 ${num1.value - num2.value}`;
}
function multy(){
  result.value = `곱셈 결과는 ${num1.value * num2.value}`;
}
function divid(){
  result.value = `나누기 결과는 ${num1.value / num2.value}`;
}

document.querySelector('#add').onclick = add;
document.querySelector('#sub').onclick = sub;
document.querySelector('#multy').onclick = multy;
document.querySelector('#divid').onclick = divid;