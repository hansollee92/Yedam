/**
 * string.js
 * 
 * 반드시 기억하고 있어야할 문자열 메소드()
 * indexOf
 * substring
 * slice
 * split
 * toUpperCase
 * toLowerCase
 * trim
 * replace
 * includes
 * charAt
 * 
 * -> mdn 사이트에 가서 해당 예제 살펴보기 * 
 * 
 */


// Hello Wolrd 문자열 안에서 W가 몇번째 index인지 체크해서 값을 반환해준다. - 여기선 7
/* let idx = "Hello, World".indexOf('W');
console.log(idx); */

// 찾는 값이 없을 경우 => -1값을 반환
/*idx = "Hello, World".indexOf("Nice");
if(idx == -1){
	console.log("찾는 문자열이 없습니다.");
}
console.log(idx); */


// 문제2 : 이 네명의 사람중에 '길동' 이름이 총 몇명인지를 반환하는 함수를 생성해보세요. (forEach사용)
const names = ['홍길동', '홍길순', '김길동', '김민수'];
function getKildong(){	
	let cnt = 0;	
	names.forEach(elem => {
		if(elem.indexOf('길동') != -1){
			cnt++;
		}
	})	
	console.log(`${cnt}명`);		
}
getKildong(); // '2명'

// 여기서 김씨성을 가진 사람이 몇명이냐도 작성할 수 있다. 
// 성은 바로 인덱스의 값이 0이므로 0인 것을 찾으면 된다. 
function getKim(){	
	let cnt = 0;	r
	names.forEach(elem => {
		if(elem.indexOf('김') == 0){
			cnt++;
		}
	})	
	console.log(`${cnt}명`);		
}
getKildong(); // '2명'




// 문제 3: 아래의 문자를 결과처럼 나타나게 끔 해봐라
let strAry = [ " Hello, Java            "
	, " HTML, Css, JavaScript   "
	, "   Java is complier    "
	, "     Java and Javascript     "];
let filterWord = "java";
/* 결과 => "HELLO, ****"
          "HTML, CSS, ****SCRIPT"
	      "**** IS COMPILER"
	      "**** AND ****SCRIPT" */
		  
// toUpperCase, trim, relace
function strJava(){
	/*for(let i=0; i<strAry.length; i++){
		console.log(strAry[i].trim().toLowerCase().replace(filterWord, "****").toUpperCase());
	}	*/
	
	// forEach문으로 바꾼다면?
	strAry.forEach(elem => {
		console.log(elem.trim().toLowerCase().replace(/java/g, "****").toUpperCase());
	})	
}
strJava();		  


// 문제 4 
let noAry = ["920304-1213421", "990508 2928123", "030702-4323123"];
/* 결과 => "920304-1213421"은 남자입니다. 
         "990508 2928123"은 여자입니다.
	     "030702-4323123"은 여자입니다. */
	   
// charAt (8번째 글자)


function checkGender(){	
	/*for(let i=0; i<noAry.length; i++){		
				
		let gender = noAry[i].charAt(7);
		if(gender == 1 || gender == 3){
			console.log(`${noAry[i]}은 남자입니다.`);
		}else if(gender == 2 || gender == 4){
			console.log(`${noAry[i]}은 여자입니다.`);
		}
		
	} */	
	
	//forEach문으로 바꾸면?
	noAry.forEach(elem => {
		let gender = elem.charAt(7);
		if(gender == 1 || gender == 3){
			console.log(`${elem}은 남자입니다.`);
		}else if(gender == 2 || gender == 4){
			console.log(`${elem}은 여자입니다.`);
		}
	})
} 
checkGender();



// 문제5 
let noAry2 = ["920304-1213421", "9905082928123", "030702-4323123"];
/* 결과 => "920304-1213421"은 남자입니다. 
         "990508 2928123"은 여자입니다.
	     "030702-4323123"은 여자입니다. */
	   
// 공백이 만약에 없을 경우에는? 
// slice()를 이용해서 -로 뒤에서부터 세아리면? 

function checkGender2(){
	noAry2.forEach(elem =>{
		
		let gen = elem.slice(-7)[0];
		let gender = gen == '1' ? '남자' : (gen == '3' ? '남자' : '여자');
		
		switch(gen){
			case '1' :
			case '3' :
				gender = '남자'; break;
			case '2' :
			case '4' :
				gender = '여자'; break;
			default : 
				gender = '기타';
		}
		
		console.log(`"${elem}"은 ${gender}입니다.`);
		
	})
}
checkGender2();



















/* const obj = {
	name: '홍길동', //obj.name
	age: 20,	
	info: function(){
		return `이름은 ${this.name}, 나이는 ${this.age}`
	}
}
// 위와 같은 속성을 가진 객체가 있다고 생각을 해보자
console.log(obj.name);
// 밖에서는 이런식으로 obj.name으로 작성을 할 수 있는데
// 만약, obj라는 객체 안에 info라는 함수가 있어서 내부에서 속성을 적어야한다면 this로 작성을 해야한다.
// this는 객체 자기자신을 의미! 

// 배열(문자)메소드 정의 활용
Array.prototype.sum = function(num1){
	//자바에서는 이 기능이 되지 않는데 자바스크립트는 이 기능이 가능하다. 
	this.push(num1);
	// this = 배열 객체 자신을 의미 
}

const numbers = [1, 2];
numbers.push(3);
numbers.sum(4);
console.log(numbers); */