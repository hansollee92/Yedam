/**
 * todo1.js
 */

// students 배열 선언
const students = [];

// 샘플 데이터 (객체)
students.push({sname: '홍길동', score: 90});

// 출력 함수
function showList(){
	students.forEach((elem) => {
		let str = `<tr><td>${elem.sname}</td><td>${elem.score}</td></tr>`;
		document.querySelector('#tlist').innerHTML += str;
	})
}
// 오류1 : forEach는 매개변수를 3개를 받는데 바로 해당 배열의 속성값을 냅다 집어넣고
//        바로 ${sname}과 같이 작성하였음

showList();

// 이벤트 발생
document.querySelector('#addList').addEventListener('click', () => {
	
	let sname = document.querySelector('#std_name').value;
	let score = document.querySelector('#std_score').value;
	// 오류2 : input태그의 안의 값을 가져오는 방법은 value인데 그냥 쿼리셀렉터까지만 적음

	if(sname == '' || score == ''){
		window.alert('필수값을 입력하세요!!');
		return;
	}
	
	document.querySelector('#tlist').innerHTML = '';
		
	students.push({sname: sname, score: score});
	showList();
	
	document.querySelector('#std_name').value = '';
	document.querySelector('#std_score').value = '';
	
})