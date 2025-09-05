package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.loginMember(memberId, memberPw);
		
		//파라미터 기본 검증
		if(memberId == null || memberPw == null || memberId.isBlank() || memberPw.isBlank()) {
			resp.sendRedirect(req.getContextPath() + "/loginForm.do?err=1");
			return;
		}

		//로그인 인증
		if(member == null) {
			//id, pw 불일치
			resp.sendRedirect(req.getContextPath() + "/loginForm.do?err=1");
		}else {
			//로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("logMember", member);
			resp.sendRedirect(req.getContextPath() + "/main.do");
		}

	}

}
