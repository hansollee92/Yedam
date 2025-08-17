package com.yedam.control;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductModifyControl implements Control {

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
				1024 * 1024 * 5,
				"UTF-8",
				new DefaultFileRenamePolicy() 				
				);		
	
		int prdNo = Integer.parseInt(mr.getParameter("prdNo"), -1);
		if(prdNo < 0) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 요청입니다.");
			return;
		}				
		
		ProductService svc = new ProductServiceImpl();
		ProductVO origin = svc.findProduct(prdNo);  //기존 데이터 (이미지/좌표) 보존용
		if(origin == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}				
		
		String prdName = mr.getParameter("prdName");
		String price = mr.getParameter("price");
		String category = mr.getParameter("category");
		String prdStatus = mr.getParameter("prdStatus");
		String prdDesc = mr.getParameter("prdDesc");
		String prdTag = mr.getParameter("prdTag");
		
		String tradeType = mr.getParameter("tradeType");
		String sido = mr.getParameter("sido");
		String sigungu = mr.getParameter("sigungu");
		String dong = mr.getParameter("dong");
		String lat = mr.getParameter("lat");
		String lng = mr.getParameter("lng");
		
		
		//확장자 포함된 파일명으로 저장
		String newImage = mr.getFilesystemName("imageFile");   
		String finalImg = (newImage != null) ? newImage : origin.getPrdImg();		
		
		
		ProductVO param = new ProductVO();
		param.setPrdNo(prdNo);
		param.setPrdName(prdName);
		param.setPrice(Integer.parseInt(price));
		param.setCategory(category);
		param.setPrdStatus(prdStatus);
		param.setPrdDesc(prdDesc);
		param.setPrdTag(prdTag);
		param.setTradeType(tradeType);
		param.setSido(sido);
		param.setSigungu(sigungu);
		param.setDong(dong);
		param.setLat(Double.parseDouble(lat));
		param.setLng(Double.parseDouble(lng));
		param.setPrdImg(finalImg);		
		
		if(svc.productModify(param)) {
			resp.sendRedirect("main.do");
		}else {
			// 실패 시 간단 알림 페이지로
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("<script>alert('수정에 실패했습니다.'); history.back();</script>");
		}
		

		
	}

}
