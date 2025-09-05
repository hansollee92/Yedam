package com.yedam.control;

import com.yedam.service.WishService;
import com.yedam.service.WishServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.WishVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WishStatusControl implements com.yedam.common.Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int prdNo = Integer.parseInt(req.getParameter("prdNo"));
        HttpSession session = req.getSession(false);
        MemberVO login = (session != null) ? (MemberVO) session.getAttribute("logMember") : null;
        int memberNo = (login != null) ? login.getMemberNo() : 0;

        WishService svc = new WishServiceImpl();
        WishVO parm = new WishVO();
        parm.setPrdNo(prdNo);
        parm.setMemberNo(memberNo);

        boolean wished = svc.exists(parm);
        int count = svc.countProductWish(prdNo);

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print("{\"wished\":" + wished + ",\"wishCount\":" + count + "}");
    }

}
