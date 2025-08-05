package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//댓글목록(json)		
		resp.setContentType("text/json;charset=utf-8");         // 인코딩
		
		String bno = req.getParameter("bno");
		// 댓글목록은 boardNo를 가지고 가지고 온다. 
		// parameter는 String형식으로 가져옴
		
		ReplyService svc = new ReplyServiceImpl();  //서비스 객체생성
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno));
		
		//Gson 라이브러리 활용해서 json문자열 객체를 만들고자 함
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		// toJson메소드가 list를 적절히 사용하여 java 문자열을 만들어줌 
		
		// 만든 json문자열을 출력스트림
		resp.getWriter().print(json);
		
		
		
		
	}

}
