package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveEventControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json; charset=UTF-8");
		
		String title = req.getParameter("title");
		
		ReplyService svc = new ReplyServiceImpl();
		
		if(svc.deleteEvent(title)) { 
			resp.getWriter().print("{\"retCode\":\"OK\"}");			
		}else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
		
	}
}
