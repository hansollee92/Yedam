let userId = document.querySelector('#user-id');
let userPw = document.querySelector('#user-pw1');
let userPwC = document.querySelector('#user-pw2');

userId.onchange = idCheck;
userPw.onchange = pwCheck;
userPwC.onchange = pw2check;

function idCheck(){
  let userIdlen = userId.value.length;
  if(userIdlen < 4 || userIdlen > 15){
    alert('아이디는 4글자 이상 15자리 이하로 작성해주세요');
    userId.select();
  }
}
function pwCheck(){
  let userPwlen = userPw.value.length;
  if( userPwlen < 8 ){
    alert('비밀번호는 8자리 이상 작성해주세요.');
    userPw.value = '';
    userPw.focus();
  }
}
function pw2check(){
  if( userPw.value != userPwC.value ){
    alert('비밀번호가 일치하지 않습니다.');
    userPwC.value = '';
    userPwC.focus();
  }
}
