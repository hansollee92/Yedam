package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ProductVO;

public class ProductInsertFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//session 회원번호 vs product 회원번호
		
		HttpSession session = req.getSession(false);     //세션 가져오기(없으면 null)
		MemberVO login = null;
		if(session != null) {
			// 세션이 존재할 경우 logMember 가져오기
			login = (MemberVO) session.getAttribute("logMember");
		}else {
			// 세션 없을경우 null처리
			login = null;
		}
		
		// 비로그인 -> 로그인 화면으로 보내기
		if(login == null) {
			req.getRequestDispatcher("/product/login.tiles").forward(req, resp);
			return;
		}

		
		req.getRequestDispatcher("/product/productregister.tiles").forward(req, resp);
	}

}
