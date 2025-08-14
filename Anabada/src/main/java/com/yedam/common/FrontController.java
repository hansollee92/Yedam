package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.ProductControl;
import com.yedam.control.ProductListControl;

public class FrontController extends HttpServlet {
	
	Map<String, Control> map;
	
	//생성자.
	public FrontController() {
		map = new HashMap<String, Control>();
}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/productList.do", new ProductListControl()); //상품 목록
		
	}
		@Override
		public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
			// url vs. uri
			// http://localhost:8080//HelloJSP/productList.do => url
			// /HelloJSP/boardList.do						=> uri
			String uri = req.getRequestURI();
			String context = req.getContextPath();		// /HelloJSP
			String page = uri.substring(context.length()); //
			
			Control control = map.get(page);
			control.execute(req, resp);
		}
}