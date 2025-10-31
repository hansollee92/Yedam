package com.yedam.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class PayFailControl implements Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Toss가 넘겨주는 파라미터 예: code, message, orderId
        req.setAttribute("code", req.getParameter("code"));
        req.setAttribute("message", req.getParameter("message"));
        req.setAttribute("orderId", req.getParameter("orderId"));

        req.getRequestDispatcher("/member/pay_fail.tiles").forward(req, resp);
    }
}
