package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.service.QnaService;
import com.yedam.service.QnaServiceImpl;
import com.yedam.vo.ProductVO;
import com.yedam.vo.QnaVO;

public class ProductControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//incoding
		req.setCharacterEncoding("UTF-8");

		// ?prdNo=
		String prdNo = req.getParameter("prdNo");

		ProductService svc = new ProductServiceImpl();
		QnaService qsvc = new QnaServiceImpl();
		ProductVO product = svc.findProduct(Integer.parseInt(prdNo));
		List<QnaVO> qna = qsvc.searchQnaList(Integer.parseInt(prdNo));

		req.setAttribute("product", product);
		req.setAttribute("qna_list", qna);

		req.getRequestDispatcher("product/product.tiles").forward(req, resp);

	}

}
