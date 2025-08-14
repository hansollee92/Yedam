package com.yedam.common;

import com.yedam.control.MemberControl;
import com.yedam.control.ProductControl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {
    Map<String, Control> map;

    public FrontController() {
        map = new HashMap<String, Control>();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("/member.do", new MemberControl());
        map.put("/wish.do", new ProductControl());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String page = uri.substring(context.length());

        Control control = map.get(page);
        control.execute(req, resp);
    }


}