package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.service.QnaService;
import com.yedam.service.QnaServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ProductVO;
import com.yedam.vo.QnaVO;

public class QnaRemoveControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//qna단건조회 -> 삭제
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		int prdNo = Integer.parseInt(req.getParameter("prdNo"));
		
		//서비스 연결 및 단건조회		
		ProductService psvc = new ProductServiceImpl();
		ProductVO product = psvc.findProduct(prdNo);
		QnaService svc = new QnaServiceImpl();
		QnaVO qna = svc.searchQna(prdNo, qnaNo);
		
		//권한확인
		HttpSession session = req.getSession();
		MemberVO logMember = (MemberVO) session.getAttribute("logMember");
		
		//logMember null 확인(로그인 안된 경우)
		if(logMember == null) {
		      req.setAttribute("msg", "로그인 후 삭제할 수 있습니다.");
		      req.setAttribute("qna", qna); 
		      req.getRequestDispatcher("/product/qna.tiles").forward(req, resp);
		      return;
		}
		
		int MemberNo = logMember.getMemberNo();		 
		
		//qna 글작성자와 로그인 작성자 비교
		if(logMember != null && MemberNo == qna.getMemberNo()) {
			if(svc.qnaRemove(qnaNo)) {
				req.setAttribute("product", product);
				resp.sendRedirect("product.do?prdNo=" + prdNo);
			}else {
				System.out.println("삭제 처리 중 생긴 오류");
	            resp.setContentType("text/html; charset=UTF-8");
	            resp.getWriter().write("<script>alert('삭제를 실패했습니다.'); history.back();</script>");
			}
		}else {
			// 다를시 메세지 
			req.setAttribute("qna", qna);
			req.setAttribute("msg", "삭제할 권한이 없습니다.");
			req.getRequestDispatcher("/product/qna.tiles").forward(req, resp);				
		}
		
		
		
		
	}

}
