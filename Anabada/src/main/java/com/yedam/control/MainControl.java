package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class MainControl implements Control {

	// 매 요청마다 생성방지
	private final ProductService svc = new ProductServiceImpl();
	@Override
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductVO> list = svc.getMainRecent(12);	
		req.setAttribute("productList", list);	
		
		req.getRequestDispatcher("/main.tiles").forward(req, resp);
	}

}
    