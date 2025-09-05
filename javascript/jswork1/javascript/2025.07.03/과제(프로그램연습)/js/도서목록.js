// // 입력상자와 버튼에 접근
// let btitle = document.querySelector('#book');
// let aBtn = document.querySelector('#add');

// // 도서 목록 저장 배열 생성
// let books = [];

// // 추가 버튼에 클릭 이벤트 연결
// aBtn.onclick = addBook;

// // 배열에 도서 목록 추가
// function addBook() {
//   if (btitle.value == '') {
//     // 빈칸이 아니여야함
//     alert('책 제목을 입력하세요');
//   } else if (books.indexOf(btitle.value) != -1) {
//     // 중복이 아니여야함(위는 중복일 때라는 의미)
//     alert('중복된 책입니다.');
//   } else {
//     books.push(btitle.value);
//   }
//   // 커서 위에 다 반복되어지니 아래에 넣어주기(공통된 항목)
//   btitle.value = '';    // 내용 들어있으니 지우기
//   btitle.focus();

//   show();   // 도서목록 출력 함수
// }

// // 문서에 도서목록 출력(<ul><li>)
// function show() {
//   let list = `<ul>`;
//   for (let i = 0; i < books.length; i++) {
//     list += `<li>${books[i]} 
//     <span id='${i}' class='del'>삭제</span></li>`; //버튼 눌렀을때 삭제가 되어야해서 id값을 넣어야하는데 방번호를 알아야하니
//      // id=${id}라고 입력해도 되지만 문자로 받으면 오류날수 있으니 안전하게 '', "" 작성하는 것이 좋음 
//   }
//   list += `</ul>`;

//   // 위에 만든 것들을 document안에 넣어야함
//   // innerText로 넣으면 안됨
//   document.querySelector('#bookList').innerHTML = list;

//   let delList = document.querySelectorAll('.del');  //진짜배열x 유사배열임 
//   // console.log(delList);    //delList확인
//   for(let ele of delList){
//     ele.onclick = remove;    // 여기서 ele은 span.del임 > 그리고 지우는 함수연결
//      // for(let i=0; i<delList.length; i++){
//      //   delList[i].onclick = remove;
//      // }
//      // 일반 반복문을 쓴다면 위와 같이 작성 가능

//   } 
// }

// // 문서에 도서 목록 삭제
// function remove() {
//   let delNum = this.getAttribute('id');   // 지울방번호 = 삭제버튼id
//   books.splice(delNum, 1);   //books배열에 삭제될거 1개
//   show();
// }

// //------------------------------------------------------
// // 삭제했을 때 내가 선택한 애가 잘 선택되는지 꼭 확인!!!!!!!!!
// // > 이걸 할 수 있으면 성적 처리 할 수 있게 하고 석차 확인할 수 있는 것을 확인할 수 있는 걸 만들어 낼 수 있다? 





// ----------------------------------------------------------------------
// 생각을 해봐~
// 값을 내가 저 인풋에 넣었어. 그러고 버튼을 눌렀어. 
// 그러고 그게 북리스트에 입력이 되고 있어 

let btitle = document.querySelector('#book');
let bAdd = document.querySelector('#add');
let bList = document.querySelector('#bookList');

bAdd.onclick = bookList;

// 여러가지 나오니 배열
let books = [];

// 사용자가 입력한 북리스트 배열에 저장하는 함수
function bookList(){
  if( books){

  }

  books.push(btitle.value);
  btitle.value = '';
  btitle.focus();

  show();
}

// 출력
function show(){
  let bookTitleList = '<ul>';
  for(let i=0; i<books.length; i++){
    bookTitleList += `<li>${books[i]} 
    <span id='${i}' class='del'>삭제</span></li>`
  }
  bookTitleList += '</ul>';

  bList.innerHTML = bookTitleList;

  let delList = document.querySelectorAll('.del');
  for(let ele of delList){
    ele.onclick = remove;
  }
}

function remove() {
  let delNum = this.getAttribute('id');   // 지울방번호 = 삭제버튼id
  books.splice(delNum, 1);   //books배열에 삭제될거 1개
  show();
}
