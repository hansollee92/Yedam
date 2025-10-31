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
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// param : uname, psw
		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");
		
		// DB 처리
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.userCheck(id, pw);
		
		// Session 
		if(member == null) {
			// id, pw 불일치
			
		}else {
			// 세션을 활용하여 정보 저장
			// 정상 id, pw 입력 
			HttpSession session = req.getSession();   
			//요청정보에 넘어온 값을 확인해서 Session객체를 만들어줌, 객체 이름은 HttpSession 
			session.setAttribute("logId", id);    // 속성(logId) = 로그인아이디
			session.setAttribute("auth", member.getResponsibility());    //user인지 admin인지 구분하는
			// auth가 권한을 담고 있는데 
			resp.sendRedirect("boardList.do");			
		}
		
		
	}// end of execute

}
