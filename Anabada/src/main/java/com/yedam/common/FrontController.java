package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.ProductControl;

public class FrontController extends HttpServlet {
	
	Map<String, Control> map;	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/product.do", new ProductControl());          //상품 상세
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String uri = req.getRequestURI();   
		String context = req.getContextPath();    
		String page = uri.substring(context.length());  
		
		Control control = map.get(page);
		control.execute(req, resp);	
		
	}
	
	
}