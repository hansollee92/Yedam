/**
 * 로그인화면(joinForm.do) Java Script
 */

document.addEventListener("DOMContentLoaded", function() {
	// jsp에 있는 요소 가져오기
	const checkIdBtn = document.querySelector("#checkIdBtn");
	const memberIdInput = document.querySelector("#memberId");
	const memberPwInput = document.querySelector("#memberPw");
  const pwConfirmInput = document.querySelector("#pwConfirm");
  const memberBirthInput = document.querySelector("#memberBirth");
  const memberPhoneInput = document.querySelector("#memberPhone");
	const pwMsg = document.querySelector("#pwMsg");
	
	memberIdInput.focus();
	
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
				} else {
					alert("사용 가능한 아이디입니다");
					memberPwInput.focus();
				}
			})
			.catch(error => {
				console.error("중복확인 요청 실패:", error);
				alert("중복확인 중 오류가 발생했습니다");
			})
	});
	
	// 비밀번호 확인
	pwConfirmInput.addEventListener("blur", function () {
    const pw = memberPwInput.value.trim();
    const pwConfirm = pwConfirmInput.value.trim();

    // 둘 다 입력된 경우만 판단
    if (pw && pwConfirm) {
      if (pw === pwConfirm) {
        pwMsg.textContent = "일치";
        pwMsg.classList.remove("bad");
        pwMsg.classList.add("ok");
      } else {
        pwMsg.textContent = "불일치";
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

	// 생년월일 검사
	memberBirthInput.addEventListener("blur", function () {
	  if (lockBirth) return;
	  const v = memberBirthInput.value.trim();
	  if (v && !/^\d{8}$/.test(v)) {
	    lockBirth = true;
	    alert("19950105 형식으로 작성해주세요");
			memberBirthInput.value = "";
	    setTimeout(() => { memberBirthInput.focus(); lockBirth = false; }, 0);
	  }
	});

	// 휴대폰번호 검사
	memberPhoneInput.addEventListener("blur", function () {
	  if (lockPhone) return;
	  const v = memberPhoneInput.value.trim();
	  if (v && !/^\d{11}$/.test(v)) {
	    lockPhone = true;
	    alert("0101231234 ( - 제외 ) 형식으로 작성해주세요");
	    setTimeout(() => { memberPhoneInput.focus(); lockPhone = false; }, 0);
	  }
	});
	
	// 생년월일 검사
	memberBirthInput.addEventListener("blur", function () {
	  const birthVal = memberBirthInput.value.trim();
	  if (birthVal && !/^\d{8}$/.test(birthVal)) {
	    alert("19950105 (YYYYMMDD) 형식으로 작성해주세요");
			memberBirthInput.value = "";
	    memberBirthInput.focus();
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