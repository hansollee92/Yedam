package com.yedam.control;

import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PurListControl implements com.yedam.common.Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberNo = req.getParameter("memberNo");

        ProductService svc = new ProductServiceImpl();
        List<ProductVO> list = svc.searchPur(Integer.parseInt(memberNo));

        req.setAttribute("pur_list", list);

        req.getRequestDispatcher("mylist/pur_list.tiles").forward(req, resp);
    }
}
