package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.mapper.ProductMapper;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNo = req.getParameter("memberNo");

		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.searchWish(Integer.parseInt(memberNo));

		req.setAttribute("memberNo", memberNo);
		req.getRequestDispatcher("mypage/wish.tiles").forward(req, resp);

	}

}
