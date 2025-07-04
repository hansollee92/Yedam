// //input 상자 접근
// let uId = document.querySelector('#user-id');
// let pw1 = document.querySelector('#user-pw1');
// let pwc = document.querySelector('#user-pw2');

// //입력상자에 값이 바뀌는 이벤트 발생하면 이벤트 핸들러 연결
// // change
// uId.onchange = idchc;
// pw1.onchange = pwchc;
// pwc.onchange = pwcompare;

// // id길이 체크
// function idchc(){
//   let idlen = uId.value.length;
//   if( idlen < 3 || idlen > 10 ){
//     alert('3글자 이상 10글자 이하로 작성해주세요.');
//     uId.select();    // 이게 if 밖에 있으면 자꾸 셀렉됨
//   }
// }
// // 비밀번호 길이 체크 
// function pwchc(){
//   let pwlen = pw1.value.length;
//   if( pwlen < 4 ){
//     alert('비밀번호는 4자리 이상 작성해주세요.');
//     pw1.value = '';
//     pw1.focus();
//   }
// }
// // 비밀번호 맞는지 확인
// function pwcompare(){
//   if( pw1.value != pwc.value ){
//     alert('비밀번호가 일치하지 않습니다.');
//     pwc.value = '';
//     pwc.focus();
//   }
// }



// ---------------------------------------------------------
/*
아이디 : 3글자 이상 10자리 이하 값이 아니면 
         알림창으로 메세지를 보내고,
         다시 입력할 수 있도록 입력된 값을 선택해 주세요.
*/

let userId = document.querySelector('#user-id');

userId.onchange = userIdCheck;

function userIdCheck(){
  let userIdlen = userId.value.length;
  if( userIdlen < 3 || userIdlen > 10){
    alert('너무 짧고 너무 김 다시ㄱㄱ');
    userId.select();
  }
}



/*
비밀번호 : 4자리 이상 값이 아니면 알림창으로 메세지 보내고,
           입력된 값을 초기화 한 후,
           값을 입력할 수 있도록 focus를 줍니다.
*/

let userPw = document.querySelector('#user-pw1');

userPw.onchange = userPwCheck;

function userPwCheck(){
  let userPwlen = userPw.value.length;
  if( userPwlen < 4 ){
    alert('4자리 이상 아님, 더 글써 ㄱㄱ ');
    userPw.value = '';
    userPw.focus();
  }
}


/*
비밀번호 확인 : 비밀번호와 일치하지 않으면 메시지 알림창 보내고,
                입력된 값을 초기화 한 후,
                값을 입력할 수 있도록 focus
*/

let userPw2 = document.querySelector('#user-pw2');

userPw2.onchange = userPw2Check;

function userPw2Check(){
  if(userPw2.value != userPw.value){
    alert('비밀번호가 일치하지 않음');
    userPw2.value = '';
    userPw2.focus();
  } 
}
