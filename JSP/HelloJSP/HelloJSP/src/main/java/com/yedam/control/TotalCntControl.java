package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class TotalCntControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 몇번 원본글(bno)을 받고 json으로 반환 (건수를 반환) 
		// {"totalCnt" : 78} 이런식으로 값을 반환하는 걸로 
		// 파라미터 bno에 게시글번호 123번이 들어가면 그 boardNO가 서비스에 들어갈거고 그 메소드를 통해서 최종적으로 
		// 위와 같은 {"totalCnt" : 78} json문자열이 나오도록 하는 작업을 만들어봐야함 		
		
		String bno = req.getParameter("bno");   //파라미터 
		
		ReplyService svc = new ReplyServiceImpl();  //서비스객체 생성
		int totalCnt = svc.replyCount(Integer.parseInt(bno));
		// int로 받고 객체형태로 넘겨야하니 Map으로 감싸기 
		
//		Map<String, Integer> result = new HashMap<>();
//		result.put("totalCnt", totalCnt);
//		
//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(result);
		
		resp.getWriter().print("{\"totalCnt\": " + totalCnt + "}");
//		{"totalCnt": 12}
		

	}

}
