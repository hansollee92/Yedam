package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.QnaReplyService;
import com.yedam.service.QnaReplyServiceImpl;

public class QnaReplyRemoveControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String qnaReplyNo = req.getParameter("qnaReplyNo");
		
		QnaReplyService svc = new QnaReplyServiceImpl();
		
		if(svc.removeQnaReply(Integer.parseInt(qnaReplyNo))) {
			// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			// {"retCode":"NG"}
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
		
		
	}

}
