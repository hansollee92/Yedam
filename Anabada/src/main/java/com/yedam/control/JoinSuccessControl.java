package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class JoinSuccessControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원가입 성공시 success, 실패시 fail
		String status = req.getParameter("status"); // "success" or "fail"
	    req.setAttribute("status", status);
	    req.getRequestDispatcher("/member/join_success.tiles").forward(req, resp);

	}

}
