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

public class PayFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1) 로그인 필수
	    HttpSession session = req.getSession(false);
	    MemberVO logMember = (session == null) ? null : (MemberVO) session.getAttribute("logMember");
	    if (logMember == null) {
	      req.setAttribute("error", "로그인 후 이용해주세요.");
	      req.getRequestDispatcher("/member/pay.tiles").forward(req, resp);
	      return;
	    }
		
	    // 상품번호 받기
	    String prdNoStr = req.getParameter("prdNo");
	    if (prdNoStr == null || prdNoStr.isBlank()) {
	      // 상품번호 null
	      req.setAttribute("error", "상품 번호가 없습니다.");
	      req.getRequestDispatcher("/member/pay.tiles").forward(req, resp);
	      return;
	    }

	    int prdNo;
	    try {
	      prdNo = Integer.parseInt(prdNoStr);
	    } catch (NumberFormatException e) {
	      // 숫자가 아닌 상품번호
	      req.setAttribute("error", "상품 번호가 올바르지 않습니다.");
	      req.getRequestDispatcher("/member/pay.tiles").forward(req, resp);
	      return;
	    }

	    // 상품 조회
	    ProductService psvc = new ProductServiceImpl();
	    ProductVO p = psvc.findProduct(prdNo);   // 단건조회
	    if (p == null) {
	      // 조회가 안되는 상품번호
	      req.setAttribute("error", "상품을 찾을 수 없습니다.");
	      req.getRequestDispatcher("/member/pay.tiles").forward(req, resp);
	      return;
	    }

	    // 결제 폼에 넣을 값 set
	    req.setAttribute("PrdName", p.getPrdName());                // 상품명
	    req.setAttribute("Price",    p.getPrice());                  // 금액
	    req.setAttribute("MemberName", logMember.getMemberName()); // 주문자명
	    
	    // 성공 URL에 실어 보낼 prdNo용 (구매테이블 넣기용)
	    req.setAttribute("prdNo", prdNo);
	    
	    
		req.getRequestDispatcher("/member/pay.tiles").forward(req, resp);

	}

}