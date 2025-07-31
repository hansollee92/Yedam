package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// 수정처리
		req.setCharacterEncoding("utf-8");  // 한글입력시 인코딩
		
		// modifyForm.do?bno=★★★★&title=★★★★★★&content=★★★★★★★
		String boardNo = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(boardNo));
		board.setTitle(title);
		board.setContent(content);
		
        // boardList.do?searchCondition=&keyword=&page=9 수정하고 이동하는게 
		// 원래 그 해당 페이지로 가는 방법은...? 
		BoardService svc = new BoardServiceImpl();
		if(svc.modifyBoard(board)) {
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("에러발생");
		}	
		
		
	}
}
