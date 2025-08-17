package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.CheckIdControl;
import com.yedam.control.JoinControl;
import com.yedam.control.JoinFormControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MemberControl;
import com.yedam.control.PayControl;
import com.yedam.control.PayFormControl;
import com.yedam.control.ProdcutRemoveControl;
import com.yedam.control.ProductControl;
import com.yedam.control.ProductListControl;
import com.yedam.control.ProductModifyControl;
import com.yedam.control.ProductModifyFormControl;


	public class FrontController extends HttpServlet {// HttpServlet를 상속받음
		
		Map<String, Control> map;

		// 생성자
		public FrontController() {
			map = new HashMap<String, Control>();
		}

		// 메소드
		@Override
		public void init(ServletConfig config) throws ServletException {

			// Start 오민수
			map.put("/joinForm.do", new JoinFormControl());         // 회원가입 화면
			map.put("/join.do", new JoinControl());                 // 회원가입 기능(처리)
			map.put("/loginForm.do", new LoginFormControl());       // 로그인 화면
			map.put("/login.do", new LoginControl());               // 로그인 기능(처리)
		    map.put("/checkId.do", new CheckIdControl());		    // 아이디 중복체크
			map.put("/logout.do", new LogoutControl());             // 로그아웃 기능
			map.put("/payForm.do", new PayFormControl());           // 결제 화면
			map.put("/pay.do", new PayControl());                   // 결제 기능
			// End 오민수
			
			map.put("/main.do", new MainControl());	//메인페이지
			
			// 상품 
			map.put("/productList.do", new ProductListControl());                //상품리스트
			map.put("/product.do", new ProductControl());                        //상품 상세 + 조회수
			map.put("/productModifyForm.do", new ProductModifyFormControl());    //상품 수정 화면 
			map.put("/prodcutModify.do", new ProductModifyControl());            //상품 수정 처리(post)
			map.put("/productRemove.do", new ProdcutRemoveControl());            //상품 삭제
			
			// 회원
			map.put("/member.do", new MemberControl());
			
			// 마이페이지
			map.put("/wish.do", new ProductControl()); 
			
			
		}

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// url , uri
			// http://localhost/Anabada/join.do => url
			// /Anabada/join.do                      => uri
			String uri = req.getRequestURI();
			String context = req.getContextPath();// Anabada
			String page = uri.substring(context.length());

			Control control = map.get(page);
			control.execute(req, resp);
		}
	}