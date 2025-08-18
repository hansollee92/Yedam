package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductSaleStatusControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String saleStatus = req.getParameter("saleStatus");
		int prdNo = Integer.parseInt(req.getParameter("prdNo"));
		
		ProductService svc = new ProductServiceImpl();
		boolean product = svc.productSaleStatus(saleStatus, prdNo);
		
		if(product) {
			req.setAttribute("product", product);
			req.setAttribute("prdNo", prdNo);
			resp.sendRedirect(req.getContextPath() + "/product.do?prdNo=" + prdNo);				
		}else {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("<script>alert('판매상태 변경에 실패했습니다.'); history.back();</script>");
		}
		
		
	}

}
