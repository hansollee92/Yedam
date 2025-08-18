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

public class ProductModifyFormControl implements Control {

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
		
		// 비로그인 차단
		if(login == null) {
			// 로그인 안한 상태면 로그인 페이지로 리다이렉트 
			// next에 현재 url을 담아서 로그인 후 다시 원래 페이지로 돌아올 수 있게 처리
			resp.sendRedirect(req.getContextPath() + "/loginForm.do?next=" 
                    + URLEncoder.encode(req.getRequestURI()+"?"+req.getQueryString(), "UTF-8"));
			return;
		}
		
		// 조회
		int prdNo = Integer.parseInt(req.getParameter("prdNo"));
		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.findProduct(prdNo);
		
		// 게시글 소유자 검증
		if(login.getMemberNo() == product.getMemberNo()) {
			req.setAttribute("product", product);
			req.getRequestDispatcher("/product/product_register.tiles").forward(req, resp);
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('권한이 없습니다.'); history.back();</script>");
			out.flush();
			return;
		}
	}

}
