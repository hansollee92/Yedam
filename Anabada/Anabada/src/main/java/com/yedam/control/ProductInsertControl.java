package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ProductVO;

public class ProductInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");  //한글인코딩
		
		// 업로드 경로
		String upload = req.getServletContext().getRealPath("/images/product");
		System.out.println(upload);
		
		// cos
		MultipartRequest mr = new MultipartRequest(
				req, 
				upload,
				1024 * 1024 * 10,
				"UTF-8",
				new DefaultFileRenamePolicy() 				
				);		
		
		// 아래 주석처리 -> "상품등록" 에선 필요없음
		
//		int prdNo = Integer.parseInt(mr.getParameter("prdNo"));		
//		if(prdNo < 0) {
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 요청입니다.");
//			return;
//		}				
//		
//		ProductService svc = new ProductServiceImpl();
//		ProductVO origin = svc.findProduct(prdNo);  //기존 데이터 (이미지/좌표) 보존용
//		if(origin == null) {
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}				
		
		// 로그인 세션 (객체는 필요)
        HttpSession session = req.getSession(false);
        MemberVO login = (session == null) ? null : (MemberVO) session.getAttribute("logMember");
        if (login == null) {
            // 혹시 모를 비로그인 진입 보호
            resp.sendRedirect(req.getContextPath() + "/loginForm.do");
            return;
        }
		
		// 파라미터 받기
		String prdName   = mr.getParameter("prdName");
	    String priceStr  = mr.getParameter("price");
	    String category  = mr.getParameter("category");
	    String prdStatus = mr.getParameter("prdStatus");
	    String prdDesc   = mr.getParameter("prdDesc");
	    String prdTag    = mr.getParameter("prdTag");
	    String tradeType = mr.getParameter("tradeType");
	    String sido      = mr.getParameter("sido");
	    String sigungu   = mr.getParameter("sigungu");
	    String dong      = mr.getParameter("dong");
	    String latStr    = mr.getParameter("lat");
	    String lngStr    = mr.getParameter("lng");
		
	    // 파일명 (신규 등록이라 origin 없음)
	    String prdImg = mr.getFilesystemName("imageFile"); // 없으면 null
	    
	    // VO 구성
	    ProductVO param = new ProductVO();
	    // 신규등록 prdNo는 오라클에서 시퀀스로 생성 -> 여기서 세팅하지 않음
	    param.setPrdName(prdName);
	    param.setPrice(priceStr == null || priceStr.isBlank() ? 0 : Integer.parseInt(priceStr));
	    param.setCategory(category);
	    param.setPrdStatus(prdStatus);
	    param.setPrdDesc(prdDesc);
	    param.setPrdTag(prdTag);
	    param.setTradeType(tradeType);
	    param.setSido(sido);
	    param.setSigungu(sigungu);
	    param.setDong(dong);
	    
	    // lat/lng은 ProductVO가 double 이므로 "값 있을 때만" 세팅 (없으면 0.0 유지)
        if (latStr != null && !latStr.isBlank()) {
            param.setLat(Double.parseDouble(latStr));
        }
        if (lngStr != null && !lngStr.isBlank()) {
            param.setLng(Double.parseDouble(lngStr));
        }
        
        // 오라클에서 디폴트값을 줬어도 여기서 다시 판매중 디폴트를 해야함
        if (param.getSaleStatus() == null || param.getSaleStatus().isBlank()) {
            param.setSaleStatus("판매중");
        }
        
        // 이미지 파일명 세팅 (finalImg 사용 X)
        param.setPrdImg(prdImg);
        
        // FK
        param.setMemberNo(login.getMemberNo());
	    
	    // 저장
        ProductService svc = new ProductServiceImpl();
        boolean ok = svc.productInsert(param);
        
        if (ok) {
            // (selectKey를 쓰지 않으므로 prdNo는 0일 수 있음 → 목록으로 보냄)
            resp.sendRedirect(req.getContextPath() + "/productList.do");
        } else {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("<script>alert('등록에 실패했습니다.'); history.back();</script>");
        }
	}
}
