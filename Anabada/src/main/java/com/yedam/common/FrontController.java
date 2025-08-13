package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.ProductControl;
import com.yedam.control.bongTest;

public class FrontController extends HttpServlet {

	Map<String, Control> map;	
	
	//생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init() throws ServletException {
		
		// 상품 상세
		map.put("/product.do", new ProductControl());
		map.put("bonggeun", new bongTest());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();  
		String context = req.getContextPath();    
		String page = uri.substring(context.length());  	                                 
		
		Control control = map.get(page);
		control.execute(req, resp);		
	}
	
}