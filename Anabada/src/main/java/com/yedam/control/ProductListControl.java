package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductListControl implements Control {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1) 파라미터
    	String page 	 = req.getParameter("page");
        String sc        = req.getParameter("searchCondition"); // "N"(상품명) / "T"(태그)
        String kw        = req.getParameter("keyword");
        String cat  	 = req.getParameter("category");
        String sort 	 = req.getParameter("sort");
        
        page = page == null ? "1" : page;
        
        // 2) 검색 DTO
        SearchDTO search = new SearchDTO();
        search.setPage(Integer.parseInt(page));
        search.setSearchCondition(sc);
        search.setKeyword(kw);
        search.setCategory(cat);
        search.setSort(sort);
      
        ProductService svc = new ProductServiceImpl();  //각각의 데이터 공간을 처리해줌
        List<ProductVO> list = svc.searchProducts(search);   // ✅ 메서드명 수정
        
        
        // 4) 페이징
        int totalCnt = svc.countProducts(search); // ★ 목록 WHERE와 동일 조건
        PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);

		

        // 5) JSP 전달 (키 이름 일관)
        req.setAttribute("productList", list);   // ✅ productList로 통일
        req.setAttribute("page", page);
        req.setAttribute("searchCondition", sc);
        req.setAttribute("keyword", kw);
        req.setAttribute("category", cat);
        req.setAttribute("paging", paging);
        req.setAttribute("sort", sort);

        // 6) 포워드 (상품 리스트 뷰)
        req.getRequestDispatcher("product/product_list.tiles").forward(req, resp);
    }
}

