package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductRemoveControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prdNo = req.getParameter("prdNo");
		
		ProductService svc = new ProductServiceImpl();
		boolean product = svc.productRemove(Integer.parseInt(prdNo));
		
		if(product) {
			resp.sendRedirect("main.do");
		}else {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("<script>alert('삭제에 실패했습니다.'); history.back();</script>");
		}
		
	}

}
