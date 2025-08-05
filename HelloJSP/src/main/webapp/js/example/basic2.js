/**
 * 
 */

// 배열에 대해서 좀더 알아보자 
// 자바스크립트에서는 []을 넣으면 배열을 만드는 것이다.
const fruits = ['apple', 'banana', 'cherry'];    //new Array(); 
fruits[3] = 'orange';

// 추가, 삭제
// 배열에서는 추가, 삭제기능을 아래와 같이 사용할 수 있다. 
fruits.push('melon');   //값 추가
fruits.unshift('mango');    //값추가(첫번째로)
fruits.pop();   //제거 : melon제거
fruits.pop();   //제거 : orange제거
fruits.shift();   //첫번째 제거 : mango 제거
fruits.shift();   //첫번째 제거 : appple 제거


// for of 반복문
for(let fruit of fruits){
	// fruits의 값을 하나씩 받아와서 fruit에 넣겠다. 
	console.log(fruit);
	// 위와 같이 콘솔에 넣으면 값을 하나씩 받아오는 것을 볼 수 있다. 
}


// 배열에 객체타입을 넣을수도 있다 
const members = [{id:'user01', name:'Hong', point: 100}];
members.push({id:'user02', name:'Park', point: 120});     //값을 넣을려면 이렇게
members.push({id:'user03', name:'kim', point: 90});
// members 라는 변수에는 3개의 객체가 들어가있는데 id, name, point라는 것으로 값이 들어가있다. 

// index값으로도 넣을수 있고 for of문으로도 값을 출력할수도 있는데 지금은 index로 해보겠다.
for(let i = 0; i<members.length; i++){
	// 포인트가 100포인트인 사람만 보고 싶다면 if문을 넣으면 된다.
	if(members[i].point >= 100)
	console.log(`id: ${members[i].id}, name: ${members[i].name}, point: ${members[i].point}`);
}

// 위에는 우리가 익히 잘 알고 있는 방식인데 
// 자바스크립트에서는 반복문을 쓸때 forEach를 많이 사용하니 이걸 기억해두자
// 참고로 이 forEach()메소드는 변수가 배열일 때만 사용할 수 있다. 
// 매개값으로는 함수를 받는다. function(){}
// 이 매개값으로 받는 첫번째, 두번째는 정해져있다. 잘 모르겠으니 abc,로 해서 콘솔에 찍어보자
/*members.forEach(function(elem, idx, ary){
	if(elem.point >= 100)
	// console.log(elem);
	// 콘솔로그에다가 백틱을 이용해서 위에 처럼 작성을 해서 찍어보자.
	console.log(`id: ${elem.id}, name: ${elem.name}, point: ${elem.point}`);
});*/


// elem 값(id,name,point)을 던져주면 js.jsp에 만들었던 ul태그 아래에 li태그로 찍힐 수 있도록 해보겠다
// <li>아이디: user01, 이름: Hong, 포인트: 100</li> 
// forEach문을 사용해서 <li></li> 태그 안에다가 위의 형식으로 나오도록 할것이다. 
/*members.forEach(function(elem, idx, ary){
	
	// str 변수 선언
	let str = `<li>아이디: ${elem.id}, 이름: ${elem.name}, 포인트: ${elem.point}</li>`; 
	
	// 이렇게 만들어진 태그를 js.jsp의 <ul id="list"></ul>안에 넣어야한다. 
	// innerHTML 
	// querySelector는 CSS의 선택자 방식으로 가져올수 있는 것 
	document.querySelector('#list').innerHTML += str;
	// 이렇게 넣으면 값이 3개가 나올것 같은데 마지막 하나만 나온다. 
	// 그래서 +=으로 해줘야함
	
}); */


// 화면에 배열의 갯수만큼 회원정보를 출력하는 함수
function showList(){	
	members.forEach((elem, idx, ary) => {
		let str = `<li>아이디: ${elem.id}, 이름: ${elem.name}, 포인트: ${elem.point}</li>`; 
		document.querySelector('#list').innerHTML += str;
	})	
}
showList();

// 이벤트
// addEventListener : 메소드로 매개값으로 이벤트유형(클릭)과 기능(함수)을 받는다.
document.querySelector('#addBtn').addEventListener('click', () => {
	// 사용자가 입력한 값을 읽어들여서 배열에 객체로 추가해야한다. 
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let point = document.querySelector('#point').value;
	
	// 필수값을 입력하도록 하는 if문
	if(id == '' || name == '' || point == ''){
		window.alert('필수값을 입력하세요!!');
		return;
	}
	
	// 초기화
	document.querySelector('#list').innerHTML = '';	
	
	// 배열에 추가
	members.push({id: id, name: name, point: point});
	
	// 화면에 출력
	// 같은 코드를 쓰는것은 좋지 못하니(중복코드발생)
	// 그러니 화면에 출력해주는 반복문을 함수로 만들어서 함수를 쓰자.
	showList(); 
	
	// 입력값 초기화 
	document.querySelector('#mid').value= '';
	document.querySelector('#mname').value= '';
	document.querySelector('#point').value= '';

});













