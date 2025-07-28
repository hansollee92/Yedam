package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

// 서블릿의 실행순서
// 페이지 75
// liver server
// client -> 웹서버(정적 페이지) -> 서블릿컨테이너(톰캣) -> init() -> service()
//                      init()은 서버 최초요청때만 실행되고 service()는 요청때마다 실행
//                      위의 형태는 톰캣의 형태가 저렇고 다른 서버들은 다르게 받을 수도 있다. 
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메소드 호출");
	}
	// req, resp 객체를 만들어서 서비스 정보에 넣어줌
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getMethod().equals("GET")) { // get방식일때 조회
			
			resp.setContentType("text/html;charset=utf-8");   //html형식인데 한글처리를 위해 charset=utf-8을 붙임
			
			System.out.println("service() 메소드 호출");
			
			// http://localhost:8080/HelloJSP/board?board_no=3&writer=user01
			// 호출하는 페이지에 파라미터를 설정할 수 있다. (위에처럼)
			String board_no = req.getParameter("board_no");
			int bno = Integer.parseInt(board_no);
			
			BoardService svc = new BoardServiceImpl();
			BoardVO board = svc.searchBoard(bno);
			
			// 상세화면
			// 글번호 : 3      제목 : ???? 
			// 내용 : ???????
			// 작성자 : 홍길동
			// 작성일시 : 2025.07.25 13:22:18		
			String html = "<table border='2'>";
			html += "<tr><th>글번호</th><td>" + board.getBoardNo() + 
					"</td><th>제목</th><td>" + board.getTitle() + "</td></tr>";
			html += "<tr><th>내용</th><td colspan='3'>" + board.getContent() + "</td></tr>";
			html += "<tr><th>작성자</th><td colspan='3'>" + board.getWriter() + "</td></tr>";
			html += "<tr><th>작성일시</th><td colspan='3'>" + board.getCreationDate() + "</td></tr>";
			html += "</table>";
			
			html += "<div><a href='DeleteBoard?board_no="+board.getBoardNo()+"'>글삭제</a></div>";
			html += "<div><a href='BoardListServlet'>글목록이동</a></div>";
			
//		http://localhost:8080/HelloJSP/board?board_no=3
//		http://localhost:8080/HelloJSP/BoardListServlet
			
			resp.getWriter().print(html);
			
			
		}else if(req.getMethod().equals("POST")) {  //post 방식일 때 등록
			
			// 요청정보의 인코딩 지정
			req.setCharacterEncoding("utf-8");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			// BoardVO 파라미터
			BoardVO param = new BoardVO();
			param.setTitle(title);
			param.setWriter(writer);
			param.setContent(content);
			
			BoardService svc = new BoardServiceImpl();
			if(svc.registerBoard(param)) {
				// 목록
				resp.sendRedirect("BoardListServlet");   
				//sendRedirect는 보내는데 다시 지정하겠다, BoardListServlet페이지로! 
			}else {
				System.out.println("에러발생");
				// 에러페이지가 현재는 없으니 이렇게 콘솔에 출력, 나중에 에러페이지 jsp로 만들 예정
			}
			
		}
		
		/*
		 Get vs. Post
		 https://www.geeksforgeeks.org/python/python-requests-post-request-with-headers-and-body/ 그림참고

		 get방식은 header에 담겨서 전달된다. 
		    - 데이터 제한적
		    - url에 데이터가 다 드러남
		 
		 post방식은 body에 담겨서 전달되어서 
		    - 많은 양의 정보가 전달이 되고 
		    - 시간이 get보다 좀 걸린다. 
		    - 인코딩방식을 지정해줘야한다.  		 
		 */
		
		
		
		
	}//end of service.	
}//end of class.
