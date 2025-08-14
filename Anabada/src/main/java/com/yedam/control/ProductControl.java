package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;

import com.yedam.mapper.ProductMapper;

import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//incoding
		resp.setContentType("text/json;charset=utf-8");

		// ?prdNo=
		String prdNo = req.getParameter("prdNo");

		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.findProduct(Integer.parseInt(prdNo));

		req.setAttribute("product", product);

		req.getRequestDispatcher("product/product.tiles").forward(req, resp);

	}

}
