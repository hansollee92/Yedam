package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.QnaService;
import com.yedam.service.QnaServiceImpl;
import com.yedam.vo.QnaVO;

public class QnaControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// qna.do?prdNo=###&qnaNo=###
		int prdNo = Integer.parseInt(req.getParameter("prdNo"));
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		
		QnaService svc = new QnaServiceImpl();
		QnaVO qna = svc.searchQna(prdNo, qnaNo);
		
		req.setAttribute("qna", qna);
		
		req.getRequestDispatcher("/product/qna.tiles").forward(req, resp);
		
	}

}
