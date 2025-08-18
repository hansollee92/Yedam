package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.PageQnaDTO;
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
		String page = req.getParameter("page");
		page = page == null ? "1" : page;	
		
		ProductService svc = new ProductServiceImpl();
		QnaService qsvc = new QnaServiceImpl();
		
		//페이징
		int totalCnt = qsvc.totalCnt(Integer.parseInt(prdNo));
		PageQnaDTO paging = new PageQnaDTO(Integer.parseInt(page), totalCnt);	
		
		ProductVO product = svc.findProduct(Integer.parseInt(prdNo));
		List<QnaVO> qna = qsvc.searchQnaList(Integer.parseInt(prdNo), Integer.parseInt(page));

		req.setAttribute("product", product);
		req.setAttribute("qna_list", qna);
		req.setAttribute("paging", paging);

		req.getRequestDispatcher("product/product.tiles").forward(req, resp);

	}

}
