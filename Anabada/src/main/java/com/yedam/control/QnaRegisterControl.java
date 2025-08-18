package com.yedam.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.QnaService;
import com.yedam.service.QnaServiceImpl;
import com.yedam.vo.QnaVO;

public class QnaRegisterControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");  // 한글입력시 인코딩
		
	    String prdNo = req.getParameter("prdNo");	    
	    String qnaTitle = req.getParameter("qnaTitle");
	    String qnaContent = req.getParameter("qnaContent");

	    
	    
//		private int qnaNo;             //문의번호
//		private String qnaTitle;       //제목
//		private String qnaContent;     //내용
//		private Date qnaDate;          //작성일
//		private int memberNo;          
//		private int prdNo;	
//		private String memberId;       //join을 위해 필요한 필드값
	    

	}

}
