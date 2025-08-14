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

public class ProductListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductVO dao = new ProductVO();
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.productList(dao);
		
		req.setAttribute("productList", list);
		req.getRequestDispatcher("WEB-INF/jsp/product_list.jsp").forward(req, resp);
		
		
	}	

}
