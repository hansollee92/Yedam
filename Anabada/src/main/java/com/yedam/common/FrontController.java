package com.yedam.common;

import com.yedam.control.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// init - service -detroy
// *.do -> 실행할 컨트롤
// 요청 url -> 실행할 컨트롤


public class FrontController extends HttpServlet{

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl()); // 글목록
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/register.do", new RegisterControl()); // 등록화면
		map.put("/addBoard.do", new AddBoardControl()); // 등록처리
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new Modify());

		map.put("bonggeun", new bongTest());

	}

}
