/**
 * basic.js 
 */

console.log("basic");

var name = 'Hong';    //변수선언
name = 'Hwang';       //새로운 값 대입
var name = 'Park';    //변수재선언(에러안남)
console.log(name);

// 예전에는 아래와 같이 var를 이용해서 변수를 선언했었다. 
// var변수는 자바와 다르게 위와 같이 다시 새롭게 선언을 해도 에러가 나지 않는다.
// 이런식으로 예러가 나오지 않는데 개발자가 기대한 값이 나오지 않을 수 있는 것을 '논리적 오류'라고 한다.

// 그래서 자바스크립트 업그레드 버전에서는 새로운 변수를 선언하는 방식이 나타났다
// let

// let name = 'Kim'; 오류발생
let name1 = 'Kim';   // 변수의 선언은 한번만 선언!

// const : 상수
const age = 20;   
//age = 30;  

// 그렇기 때문에 우리는 웬만해서는 변수를 선언할때 let, const를 활용할 것이다.

// 그리고 자바스크립트는 문자열, 숫자, 불리언을 변수에 담을 수도 있지만, 객체타입도 담을 수 있다. 
// <Object 타입 선언 두가지 방법>
const obj1 = {}
const obj = new Object(); 
// <Object 타입의 값을 넣는 방법>
// 이런 형태로 key-value 형식으로 값을 담을 수 있다. 
obj.name = 'Hong';
obj.age = 20; 
// Object타입에는 함수를 담을 수도 있다. 
obj.info = function(){
	console.log('이름은 '+ obj.name + ', 나이는 ' + obj.age);
}

// 이렇게 출력을 해보면 name, age를 확인할 수 있다. 
console.log(obj);
console.log(obj.age);  //getter,setter 기능이 제공되고 있다고 생각하면 된다. 
console.log(obj['name']);   //console.log(obj.name);와 같은 방식   
// .연산자를 사용하면 간단하긴 한데 위의 방식을 사용하는 이유는 동적인 기능을 가져올수 있기 때문이다. 
obj.info();  //함수의 실행, 함수를 실행해서 출력을 해줄것임 


// Object에는 배열의 값도 넣을 수 있다.
obj.hobbies = ['독서', '수영', '자전거'];  //취미라는 의미의 속성을 하나 선언
console.log('첫번째 취미: ' + obj.hobbies[0]);     // Hong이라고 하는 사람의 취미의 첫번째 '독서'
console.log('두번째 취미: ' + obj['hobbies'][1]); 
console.log(`세번째 취미: ${obj['hobbies'][2]}`);  
//백틱을 이용하여 문자열을 작성할수도 있다. ${}안에 값을 넣을 수 있다.


// 이 객체의 데이터 타입의 깊이는 더 깊이 들어갈 수 있다. 아래와 같이 
obj.pets = [{name: '야옹이', age: 2}, {name: '멍멍이', age: 3}];
// 객체의 첫번째 애완동물의 이름을 알고 싶다면 아래와 같이 작성을 해줘야한다. 
obj.pets[0].name;
// 값을 바꿀 수도 있다. 
obj.pets[0].name = '고양이';
// 두번째 값의 이름을 알려면
obj.pets[1].name; 
// 이런식으로 .연산자와 []를 이용해서 객체들의 값을 가져올 수 있다. 


// 이 객체 구조를 보고 싶다면 아래를 쳐보자. 
console.log(this);
// 스크립트 영역에서 this라고 하면 window에서 가장 상위의 요소를 가리킨다. 
// window.alert("윈도우객체의 alert함수");
// 콘솔창에 alert이라는 객체가 있었는데 이것을 활용해서 위와 같이 작성을 하게 되면 알람을 띄울 수 있다. 

// JS연습
// .log는 로그 형태로 보는 것이고 .dir은 객체 형태로 보고 싶을때 사용
// documnet안에 body와 children이 있는데 이걸 계속 하위영역을 타고타고 내려가면 아래와 같은 값이 나오고 
console.dir(window.document.children[0].children[1].innerHTML);
// 이런식으로 찾아가는것은 차츰차츰 익숙해지도록 하고 
// 표현식을 쓸때 백틱으로 사용하는 방법은 꼭 기억하도록 하고 
// 객체의 값을 가져올때 []로 방식으로 가져오는 방식도 꼭 기억을 하자 


