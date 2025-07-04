let userItems = document.querySelector('#item');
let addBtn = document.querySelector('#add');
let itemList = document.querySelector('#itemList');

// 배열 생성
let items = [];
addBtn.onclick = addItem;

// 사용자 입력값 배열에 추가
function addItem(){
  if(userItems.value == ''){
    // 빈칸 입력 알림창
    alert('빈칸입니다. 여행 준비물을 입력해주세요');
  }else if(items.indexOf(userItems.value) != -1){
    // 중복된 목록 입력 알림창
    alert('이미 있는 여행준비물 입니다. 다시 입력해주세요.')
  }else{
    items.push(userItems.value);
  }
  userItems.value = '';  //초기화
  userItems.focus();     //커서
  
  show(); 
}

// 문서에 여행리스트 출력하는 함수
function show(){
  let list = `<ul>`;
  for(let i=0; i<items.length; i++){
    list += `<li>${items[i]} 
    <span id=${i} class='close'>X</span></li>`;
  }
  list += `</ul>`;
  itemList.innerHTML = list;

  // 삭제
  let delList = document.querySelectorAll('.close');
  for(let ele of delList){
    ele.onclick = remove;
  }
}

// x 표시를 클릭하면 목록이 배열에서 제거되어 화면에 X
function remove(){
  let delNum = this.getAttribute('id');
  items.splice(delNum, 1);
  show();
}
