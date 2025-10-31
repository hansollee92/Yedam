package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//회원목록
		
		MemberVO member = new MemberVO();
		
		// *** 숙제!!! 
		// 멤버정보를 들고 와 어디서? 쿼리에서 
		// 들고올려면? DB연결필요
		
		// 들고 온 값들 req.get 으로 받고
		// 그걸 setAttribute로 값을 넣어서
		// 반복문으로 출력 
		
		// 그리고 이건 일반사용자는 못봐
		
	}

}
