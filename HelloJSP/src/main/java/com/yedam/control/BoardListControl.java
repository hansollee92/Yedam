package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//WEB-INF/html/register_form.html
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;		
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));  //글목록
		// 저기에 담겨있는 데이터를 아래의 페이지에 넘겨줘야함 
		// req(요청정보)에 값을 담아서!
		// 그럼 어떻게 담냐? 
	
		// 페이징
		int totalCnt = 96;
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);				
		
		// jsp(뷰역할) 페이지에 데이터 전달
		req.setAttribute("board_list", list);	
		req.setAttribute("paging", paging);
		
		//요청재지정
		req.getRequestDispatcher("WEB-INF/html/board_list.jsp").forward(req, resp);
	}

}
