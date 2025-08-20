package com.yedam.control;

import com.yedam.service.WishService;
import com.yedam.service.WishServiceImpl;
import com.yedam.vo.WishVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WishControl implements com.yedam.common.Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prdNo = req.getParameter("prdNo");
        String memberNo = req.getParameter("memberNo");

        WishService svc = new WishServiceImpl();

        WishVO parm = new WishVO();

        parm.setPrdNo(Integer.parseInt(prdNo));
        parm.setMemberNo(Integer.parseInt(memberNo));

        if (svc.findProductMember(Integer.parseInt(prdNo)) == Integer.parseInt(memberNo)) {
            svc.removeWish(parm);
            System.out.println("do wish remove");
        }
        else {
            svc.registerWish(parm);
            System.out.println("do wish add");
        }

        int countWish = svc.countProductWish(Integer.parseInt(prdNo));

        // 상세로 리다이렉트 (필요 시 상태/카운트 전달)
        resp.sendRedirect(req.getContextPath() + "/product.do?prdNo=" + prdNo);
    }
}
