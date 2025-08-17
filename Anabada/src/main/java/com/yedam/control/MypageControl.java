package com.yedam.control;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MypageControl implements com.yedam.common.Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberNo = req.getParameter("memberNo");

        MemberService msvc = new MemberServiceImpl();
        MemberVO member = msvc.searchMember(Integer.parseInt(memberNo));

        ProductService psvc = new ProductServiceImpl();
        List<ProductVO> list = psvc.searchWish(Integer.parseInt(memberNo));

        req.setAttribute("member_info", member);
        req.setAttribute("wish_list", list);

        req.getRequestDispatcher("mypage/wish.tiles").forward(req, resp);
    }
}
