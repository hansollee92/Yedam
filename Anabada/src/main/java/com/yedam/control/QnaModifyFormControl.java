package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.QnaService;
import com.yedam.service.QnaServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.QnaVO;

public class QnaModifyFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//qna단건조회 -> 수정화면		
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		int prdNo = Integer.parseInt(req.getParameter("prdNo"));
		
		//권한확인
		HttpSession session = req.getSession();
		MemberVO logMember = (MemberVO) session.getAttribute("logMember");
				
		//서비스 연결 및 단건조회		
		QnaService svc = new QnaServiceImpl();
		QnaVO qna = svc.searchQna(prdNo, qnaNo);
		
		//logMember null 확인(로그인 안된 경우)
		if(logMember == null) {
		      req.setAttribute("msg", "로그인 후 수정할 수 있습니다.");
		      req.setAttribute("qna", qna); 
		      req.getRequestDispatcher("/product/qna.tiles").forward(req, resp);
		      return;
		}
		
		int MemberNo = logMember.getMemberNo();
		
		//qna 글작성자와 로그인 작성자 비교
		if(logMember != null && MemberNo == qna.getMemberNo()) {
			// 성공시 qna_modify
			req.setAttribute("qna", qna);
			req.getRequestDispatcher("/product/qna_modify.tiles").forward(req, resp);			
		}else {
			// 다를시 메세지 
			req.setAttribute("qna", qna);
			req.setAttribute("msg", "수정할 권한이 없습니다.");
			req.getRequestDispatcher("/product/qna.tiles").forward(req, resp);				
		}

	}

}
