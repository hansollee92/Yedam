/**
 * 로그인화면(joinForm.do) Java Script
 */

document.addEventListener("DOMContentLoaded", function() {
	// jsp에 있는 요소 가져오기
	const checkIdBtn = document.querySelector("#checkIdBtn");
	const memberIdInput = document.querySelector("#memberId");
	
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
				} else {
					alert("사용 가능한 아이디입니다");
				}
			})
			.catch(error => {
				console.error("중복확인 요청 실패:", error);
				alert("중복확인 중 오류가 발생했습니다");
			})
	});
});