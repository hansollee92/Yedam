package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//WEB-INF/html/register_form.html
		
		// 파라미터. (page&searchCondition&keyword)		
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page;	
		
		// SearchDTO (메소드에 전달할 파라미터)
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);  //글목록
		// 저기에 담겨있는 데이터를 아래의 페이지에 넘겨줘야함 
		// req(요청정보)에 값을 담아서!
		// 그럼 어떻게 담냐? 
	
		// 페이징
		int totalCnt = svc.totalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);						
		
		// jsp(뷰역할) 페이지에 데이터 전달
		req.setAttribute("board_list", list);	
		req.setAttribute("paging", paging);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);		
		
		//요청재지정
//		req.getRequestDispatcher("WEB-INF/html/board_list.jsp").forward(req, resp);
		
		// 권한에 따라 템플릿적용 -> 요청재지정
		HttpSession session = req.getSession();
		String authority = (String) session.getAttribute("auth");
		
		if(authority == null) { //guest
			req.getRequestDispatcher("user/board_list.tiles").forward(req, resp);
			return; // 메소드종료
		}		
		if(authority.equals("User")) { //일반사용자
			req.getRequestDispatcher("user/board_list.tiles").forward(req, resp);	
			
		}else if(authority.equals("Admin")) { //관리자
			req.getRequestDispatcher("manager/board_list.tiles").forward(req, resp);		
		}
		
	}

}
