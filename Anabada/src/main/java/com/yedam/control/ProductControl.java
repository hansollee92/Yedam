package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.PageQnaDTO;
import com.yedam.service.*;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ProductVO;
import com.yedam.vo.QnaVO;
import com.yedam.vo.WishVO;

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
		WishService wishsvc = new WishServiceImpl();

		// 찜 데이터 넘겨주는 코드
		MemberVO loginMember = (MemberVO) req.getSession().getAttribute("logMember");
		boolean wished = false;

		if (loginMember != null) {
			WishVO wishVo = new WishVO();
			wishVo.setPrdNo(Integer.parseInt(prdNo));
			wishVo.setMemberNo(loginMember.getMemberNo());

			wished = wishsvc.exists(wishVo);
		}

		req.setAttribute("wished", wished);


		//페이징
		int totalCnt = qsvc.totalCnt(Integer.parseInt(prdNo));
		PageQnaDTO paging = new PageQnaDTO(Integer.parseInt(page), totalCnt);	
		
		ProductVO product = svc.findProduct(Integer.parseInt(prdNo));
		String productMember = svc.searchProductMember(Integer.parseInt(prdNo));

		List<QnaVO> qna = qsvc.searchQnaList(Integer.parseInt(prdNo), Integer.parseInt(page));
		int countWish = wishsvc.countProductWish(Integer.parseInt(prdNo));

		req.setAttribute("product", product);
		req.setAttribute("qna_list", qna);
		req.setAttribute("paging", paging);
		req.setAttribute("countWish", countWish);
		req.setAttribute("productMember", productMember);

		req.getRequestDispatcher("product/product.tiles").forward(req, resp);

	}

}
