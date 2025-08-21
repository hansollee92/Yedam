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

			// 회원가입
			map.put("/joinForm.do", new JoinFormControl());        // 회원가입 화면
			map.put("/join.do", new JoinControl());                // 회원가입 기능
			map.put("/joinSuccess.do", new JoinSuccessControl());  // 회원가입 성공 시 보이는 화면
			map.put("/checkId.do", new CheckIdControl());		   // 아이디 중복체크
			
			// 로그인
			map.put("/loginForm.do", new LoginFormControl());      // 로그인 화면
			map.put("/login.do", new LoginControl());              // 로그인 기능
			map.put("/logout.do", new LogoutControl());            // 로그아웃 기능
			
			// 결제
			map.put("/payForm.do", new PayFormControl());          // 결제 화면
			map.put("/paySuccess.do", new PaySuccessControl());    // 결제 성공
			map.put("/payFail.do", new PayFailControl());          // 결제 실패

			// 메인 및 검색 리스트
			map.put("/main.do", new MainControl());	                //메인페이지
			map.put("/productList.do", new ProductListControl());   //상품리스트
			
			// 상품 
			map.put("/productInsertForm.do", new ProductInsertFormControl());    //상품 등록 화면 
			map.put("/productInsert.do", new ProductInsertControl());            //상품 등록 처리(post)			
			map.put("/product.do", new ProductControl());                        //상품 상세 + 조회수 + 문의하기 목록 + 문의 페이징
			map.put("/productModifyForm.do", new ProductModifyFormControl());    //상품 수정 화면 
			map.put("/productModify.do", new ProductModifyControl());            //상품 수정 처리(post)
			map.put("/productRemove.do", new ProductRemoveControl());            //상품 삭제
			map.put("/productSaleStatus.do", new ProductSaleStatusControl());    //상품 판매상태 수정 (수정필요)
			map.put("/wishToggle.do", new WishControl());
			
			//문의하기 
			map.put("/qna.do", new QnaControl());                                //문의하기 게시판 상세
			map.put("/qnaRegisterForm.do", new QnaRegisterFormControl());        //문의하기 등록 화면
		    map.put("/qnaRegister.do", new QnaRegisterControl());                //문의하기 등록 처리
			map.put("/qnaModifyForm.do", new QnaModifyFormControl());            //문의하기 수정 화면
			map.put("/qnaModify.do", new QnaModifyControl());                    //문의하기 수정 처리
			map.put("/qnaRemove.do", new QnaRemoveControl());                    //문의하기 삭제
			
			//문의하기 게시판 댓글
			map.put("/qnaReplyList.do", new QnaReplyListControl());              //댓글 목록
			map.put("/qnaReplyRemove.do", new QnaReplyRemoveControl());          //댓글 삭제
			map.put("/qnaReplyAdd.do", new QnaReplyAddControl());                //댓글 등록

			// 마이페이지
			map.put("/mypage.do", new MypageControl());                          // 마이페이지
			map.put("/wishList.do", new WishListControl());                      // 찜목록
			map.put("/saleList.do", new SaleListControl());                      // 판매 내역
			map.put("/purList.do", new PurListControl());                        // 구매 내역
			map.put("/reviewList.do", new ReviewControl());                      // 리뷰목록
			
			//커뮤니티
			map.put("/commuList.do", new CommuListControl());                   // 커뮤니티 상세
			map.put("/commuForm.do", new CommuFormControl());                   // 커뮤니티 화면 
			map.put("/commuInsert.do", new CommuInsertControl());               // 커뮤니티 등록 처리	
			map.put("/commuRemove.do", new CommuRemoveControl());               // 커뮤니티 삭제
			
			//공지사항
			map.put("/notice.do", new NoticeControl());                         //공지사항
			
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

