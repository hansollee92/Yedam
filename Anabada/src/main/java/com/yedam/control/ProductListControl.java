package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.vo.PageVO;          // ✅ 반드시 import
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

public class ProductListControl implements Control {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1) 파라미터
        String pageParam = req.getParameter("page");
        String sc        = req.getParameter("searchCondition"); // "N"(상품명) / "T"(태그)
        String kw        = req.getParameter("keyword");
        String category = req.getParameter("category");

        int amount  = 12; // 페이지당 12개
        int page = 1;
        try { page = Integer.parseInt(req.getParameter("page")); } catch (Exception ignore) {}

        // 2) 검색 VO
        SearchVO s = new SearchVO();
        s.setSearchCondition(sc);
        s.setKeyword(kw);
        s.setCategory(category);   
        s.setPage(page);
        s.setAmount(amount);        // ✅ SearchVO에 amount 필드/게터세터 있어야 함

        // 3) 서비스 호출 (검색 + 총건수)
        ProductService svc = new ProductServiceImpl();
        List<ProductVO> list = svc.searchProducts(s);   // ✅ 메서드명 수정
        int totalCnt  = svc.countProducts(s);     // ✅ 총건수

        // 4) 페이징
        PageVO paging = new PageVO(page, totalCnt);

        // 5) JSP 전달 (키 이름 일관)
        req.setAttribute("productList", list);   // ✅ productList로 통일
        req.setAttribute("paging", paging);
        req.setAttribute("searchCondition", sc);
        req.setAttribute("keyword", kw);
        req.setAttribute("category", category);

        // 6) 포워드 (상품 리스트 뷰)
        req.getRequestDispatcher("product/product_list.tiles").forward(req, resp);
    }
}