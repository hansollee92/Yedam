package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class CheckIdControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// JSON 응답 준비
		resp.setContentType("application/json; charset=UTF-8");
		
		// 파라미터 받기
		String memberId = req.getParameter("memberId");
		
		// 기본값
		boolean exists = false;
		
		// 값이 비어있지 않을때만 서비스 호출
		if (memberId != null && !memberId.trim().isEmpty()) {
			MemberService svc = new MemberServiceImpl();
			// DB에 같은 아이디가 있으면 true, 없으면 false를 리턴하도록 서비스에 위임
			exists = svc.isDuplicateId(memberId.trim());
		}
		
		// JSON 으로 응답
		Map<String, Object> result = new HashMap<>();
		result.put("exists", exists);
		
		String json = new Gson().toJson(result);
        resp.getWriter().print(json);
	}
}