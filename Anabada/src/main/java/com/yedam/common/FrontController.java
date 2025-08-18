package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.*;


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
			map.put("/joinForm.do", new JoinFormControl());        // 회원가입 화면
			map.put("/join.do", new JoinControl());                // 회원가입 기능
			map.put("/joinSuccess.do", new JoinSuccessControl());  // 회원가입 성공 시 보이는 화면
			map.put("/checkId.do", new CheckIdControl());		       // 아이디 중복체크
			map.put("/loginForm.do", new LoginFormControl());      // 로그인 화면
			map.put("/login.do", new LoginControl());              // 로그인 기능
			map.put("/logout.do", new LogoutControl());            // 로그아웃 기능
			map.put("/payForm.do", new PayFormControl());          // 결제 화면
			map.put("/pay.do", new PayControl());                  // 결제 기능
			// End 오민수
			
			map.put("/main.do", new MainControl());	//메인페이지
			map.put("/productList.do", new ProductListControl());   //상품리스트
			
			// 상품 
			map.put("/productList.do", new ProductListControl());                //상품리스트
			map.put("/product.do", new ProductControl());                        //상품 상세 + 조회수
			map.put("/productModifyForm.do", new ProductModifyFormControl());    //상품 수정 화면 
			map.put("/productModify.do", new ProductModifyControl());            //상품 수정 처리(post)
			map.put("/productInsertForm.do", new ProductInsertFormControl());    //상품 등록 화면 
			map.put("/productInsert.do", new ProductInsertControl());            //상품 등록 처리(post)
			
			map.put("/productRemove.do", new ProdcutRemoveControl());            //상품 삭제
			
			// 회원
			map.put("/mypage.do", new MypageControl());
			// 마이페이지
			map.put("/wishList.do", new WishListControl()); // 찜목록
			
			
		}

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// url , uri
			// http://localhost/Anabada/join.do => url
			// /Anabada/join.do                 => uri
			String uri = req.getRequestURI();
			String context = req.getContextPath();// Anabada
			String page = uri.substring(context.length());

			Control control = map.get(page);
			control.execute(req, resp);
		}
	}

