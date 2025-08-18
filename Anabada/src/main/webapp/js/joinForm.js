/**
 * 로그인화면(joinForm.do) Java Script
 */

document.addEventListener("DOMContentLoaded", function() {
	// jsp에 있는 요소 가져오기
	const checkIdBtn = document.querySelector("#checkIdBtn");
	const memberIdInput = document.querySelector("#memberId");
	const memberPwInput = document.querySelector("#memberPw");
  const pwConfirmInput = document.querySelector("#pwConfirm");
	const joinForm = document.querySelector("#joinForm");
  const memberBirthInput = document.querySelector("#memberBirth");
  const memberPhoneInput = document.querySelector("#memberPhone");
	const pwMsg = document.querySelector("#pwMsg");
	let isIdChecked = false; // 중복체크 완료 여부
	
	memberIdInput.focus();
	
	// 아이디 입력이 바뀌면 다시 중복체크 필요
  memberIdInput.addEventListener("input", function() {
    isIdChecked = false;
  });
	
	// 중복체크 버튼을 '클릭' 하면 발생하는 이벤트
	checkIdBtn.addEventListener("click", function() {
		// memberIdInput의 value를 가져오는데 양쪽에 공백은 제거하고 가져옴
		const memberId = memberIdInput.value.trim();
		
    // IdInput이 비어있으면..
		if (!memberId) {
			alert("아이디를 입력하세요");
			memberIdInput.focus();
			return;
		}
		
		// 서버로 아이디 중복 확인 요청, 여기서 파라미터 넘어감
		fetch(`${window.APP_CTX}/checkId.do?memberId=${encodeURIComponent(memberId)}`)
			.then(response => response.json())
			.then(data => {
				if (data.exists) {
					alert("이미 사용 중인 아이디입니다");
					memberIdInput.focus();
					isIdChecked = false;
				} else {
					alert("사용 가능한 아이디입니다");
					memberPwInput.focus();
					isIdChecked = true;
				}
			})
			.catch(error => {
				console.error("중복확인 요청 실패:", error);
				alert("중복확인 중 오류가 발생했습니다");
				isIdChecked = false;
			})
	});
	
	// 회원가입 버튼 눌렀을 때(폼 제출 시)
  joinForm.addEventListener("submit", function(event) {
    if (!isIdChecked) {
      event.preventDefault();  // 폼 제출 막음
      alert("아이디 중복체크를 해주세요");
      memberIdInput.focus();
      return;
    }
  });
	
	// 비밀번호 확인
	pwConfirmInput.addEventListener("blur", function () {
    const pw = memberPwInput.value.trim();
    const pwConfirm = pwConfirmInput.value.trim();

    // 둘 다 입력된 경우만 판단
    if (pw && pwConfirm) {
      if (pw === pwConfirm) {
        pwMsg.textContent = "비밀번호가 일치합니다.";
        pwMsg.classList.remove("bad");
        pwMsg.classList.add("ok");
      } else {
        pwMsg.textContent = "비밀번호가 일치하지 않습니다.";
        pwMsg.classList.remove("ok");
        pwMsg.classList.add("bad");

        // 입력값 초기화, 포커스 이동
        memberPwInput.value  = "";
        pwConfirmInput.value = "";
        memberPwInput.focus();
      }
    } else {
      // 하나라도 비어있으면 메시지 비움
      pwMsg.textContent = "";
      pwMsg.classList.remove("ok", "bad");
    }
  });

  // 다시 타이핑 시작하면 메시지 초기화
  memberPwInput.addEventListener("input", clearPwMsg);
  pwConfirmInput.addEventListener("input", clearPwMsg);
  function clearPwMsg() {
    pwMsg.textContent = "";
    pwMsg.classList.remove("ok", "bad");
  }
	
	// 생년월일 검사 (형식 + 실제 유효날짜 + 범위)
	memberBirthInput.addEventListener("blur", function () {
	  const v = memberBirthInput.value.trim();
	  if (!v) return;

	  // 숫자 8자리 형식 검사
	  if (!/^\d{8}$/.test(v)) {
	    alert("생년월일은 8자리 숫자(YYYYMMDD)로 작성해주세요");
	    memberBirthInput.value = "";
	    memberBirthInput.focus();
	    return;
	  }

	  // 실제 존재하는 날짜인지 체크
	  const y = parseInt(v.substring(0, 4), 10);
	  const m = parseInt(v.substring(4, 6), 10);
	  const d = parseInt(v.substring(6, 8), 10);

	  const jsDate = new Date(y, m - 1, d); // JS는 month가 0부터
	  const valid =
	    jsDate.getFullYear() === y &&
	    jsDate.getMonth() === m - 1 &&
	    jsDate.getDate() === d;

	  if (!valid) {
	    alert("존재하지 않는 날짜입니다, 확인 후 이용해주세요");
	    memberBirthInput.value = "";
	    memberBirthInput.focus();
	    return;
	  }

	  // 범위 체크: 1895-01-01 ~ 오늘
	  const min = new Date(1895, 0, 1); // 1895-01-01
	  const today = new Date();
	  // 시간 요소 제거(자정 기준 비교)
	  min.setHours(0,0,0,0);
	  today.setHours(0,0,0,0);
	  jsDate.setHours(0,0,0,0);

	  if (jsDate < min || jsDate > today) {
	    alert("회원가입이 불가능한 생년월일 입니다, 확인 후 이용해주세요");
	    memberBirthInput.value = "";
	    memberBirthInput.focus();
	    return;
	  }
	});

	// 휴대폰번호 검사
	memberPhoneInput.addEventListener("blur", function () {
	  const phoneVal = memberPhoneInput.value.trim();
	  if (phoneVal && !/^\d{11}$/.test(phoneVal)) {
	    alert("0101231234 ( - 제외 ) 형식으로 작성해주세요");
			memberPhoneInput.value = "";
	    memberPhoneInput.focus();
	  }
	});
});