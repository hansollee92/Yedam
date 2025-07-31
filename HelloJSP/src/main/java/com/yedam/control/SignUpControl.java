package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 회원정보 등록 -> 게시글 목록 페이지
		// param : id, psw, name
		// signup.do?id=user03&psw=1111&name=강하나
		
		req.setCharacterEncoding("utf-8");  // 한글입력시 인코딩
		
		String memberId = req.getParameter("id");
		String memberPw = req.getParameter("psw");
		String memberName = req.getParameter("name");
		
		MemberVO param = new MemberVO();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		param.setMemberName(memberName);
		
		MemberService svc = new MemberServiceImpl();
		if(svc.addMember(param)) {
			// 정상등록 -> 목록이동
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("회원등록 에러발생");
		}		
		
	}

}
