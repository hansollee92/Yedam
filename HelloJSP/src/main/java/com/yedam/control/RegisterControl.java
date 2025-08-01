package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class RegisterControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
		   throws ServletException, IOException{
		// WEB-INF/html/register_form.html을 열어주는 기능		
		
//		req.getRequestDispatcher("WEB-INF/html/register_form.jsp").forward(req, resp);		
		req.getRequestDispatcher("user/register_form.tiles").forward(req, resp);		
		
		
//		try {
//			// 요청재지정
//			req.getRequestDispatcher("WEB-INF/html/register_form.jsp").forward(req, resp);
//			//getRequestDispatcher메소드는 요청 재지정해주는 기능이다.(=보여지는 페이지를 다시 새지정하겠습니다) (에러라는 이유는 예외처리안되서)
//			// 원래는 Register.do하면 그 서블릿이 표시되면 되는데 이걸로 위에로 다시 보여주게 한다. 
//			// webapp이 최상위 경로여서 구조는 WEB-INF/html/register_form.html 이렇게 된다. 
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}   
	}

}
