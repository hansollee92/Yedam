package com.yedam.control;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberControl implements com.yedam.common.Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberNo = req.getParameter("memberNo");

        MemberService svc = new MemberServiceImpl();
        MemberVO member = svc.searchMember(Integer.parseInt(memberNo));

        req.setAttribute("memberNo", memberNo);
        req.getRequestDispatcher("mypage/wish.tiles").forward(req, resp);
    }
}
