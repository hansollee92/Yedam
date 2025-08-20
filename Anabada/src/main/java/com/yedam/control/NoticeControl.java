package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.NoticeService;
import com.yedam.service.NoticeServiceImpl;
import com.yedam.vo.NoticeVO;

public class NoticeControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		NoticeService svc = new NoticeServiceImpl();
		List<NoticeVO> list = svc.noticeList();
		
		req.setAttribute("notice", list);
		
		req.getRequestDispatcher("/WEB-INF/jsp/notice.tiles").forward(req, resp);
		
		
	}

}
