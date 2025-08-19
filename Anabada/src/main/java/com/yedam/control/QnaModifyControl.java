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

public class QnaModifyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");  // 한글입력시 인코딩
		
		String prdNo = req.getParameter("prdNo");
	    String qnaNo = req.getParameter("qnaNo");	    
	    String qnaTitle = req.getParameter("qnaTitle");
	    String qnaContent = req.getParameter("qnaContent");
		
		QnaVO param = new QnaVO();
		param.setQnaTitle(qnaTitle);
		param.setQnaContent(qnaContent);
		
	    QnaService svc = new QnaServiceImpl();
	    
	    if(svc.qnaModify(Integer.parseInt(qnaNo), qnaTitle, qnaContent)) {
	    	resp.sendRedirect("product.do?prdNo="+prdNo);
	    }else {
		  // 실패 시 간단 알림 페이지로
          resp.setContentType("text/html; charset=UTF-8");
          resp.getWriter().write("<script>alert('문의글 수정에 실패했습니다.'); history.back();</script>");
	    }
	     
	}

}
