package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.QnaReplyService;
import com.yedam.service.QnaReplyServiceImpl;
import com.yedam.vo.QnaReplyVO;

public class QnaReplyListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/json;charset=utf-8");         // 인코딩
		
		String qnaNo = req.getParameter("qnaNo");
		
		QnaReplyService svc = new QnaReplyServiceImpl();
		List<QnaReplyVO> list = svc.searchQnaReplyList(Integer.parseInt(qnaNo));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);		
		
		
	}

}
