package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ProductVO;

public class QnaRegisterFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터
		String prdNo = req.getParameter("prdNo");
		
		//권한확인
		HttpSession session = req.getSession();
		MemberVO logMember = (MemberVO) session.getAttribute("logMember");
		
		//서비스연결 및 단건조회
		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.findProduct(Integer.parseInt(prdNo));
		
		if(logMember == null) {	
			req.setAttribute("prdNo", prdNo);
			req.setAttribute("product", product);
			req.setAttribute("msg", "글작성 권한이 없습니다. 로그인을 먼저 해주세요!");
			req.getRequestDispatcher("/product/product.tiles").forward(req, resp);		
		}else {
			req.setAttribute("prdNo", prdNo);
			req.setAttribute("logMember", logMember);
			req.getRequestDispatcher("/product/qna_register.tiles").forward(req, resp);				
		}
		
		
		
		

	}

}
