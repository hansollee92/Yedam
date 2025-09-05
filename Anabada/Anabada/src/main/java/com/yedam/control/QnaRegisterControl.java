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

public class QnaRegisterControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");  // 한글입력시 인코딩
		
	    String prdNo = req.getParameter("prdNo");	    
	    String qnaTitle = req.getParameter("qnaTitle");
	    String qnaContent = req.getParameter("qnaContent");

	    //로그인유저 넘버 가져오기
		HttpSession session = req.getSession();
		MemberVO logMember = (MemberVO) session.getAttribute("logMember");
		int memberNo = logMember.getMemberNo();
		
		QnaVO param = new QnaVO();
		param.setPrdNo(Integer.parseInt(prdNo));
		param.setMemberNo(memberNo);
		param.setQnaTitle(qnaTitle);
		param.setQnaContent(qnaContent);
		
	    QnaService svc = new QnaServiceImpl();
	    
	    if(svc.qnaResigter(param)) {
	    	resp.sendRedirect("product.do?prdNo="+prdNo);
	    }else {
			// 실패 시 간단 알림 페이지로
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("<script>alert('문의글 등록에 실패했습니다.'); history.back();</script>");
	    }	    

	}

}
