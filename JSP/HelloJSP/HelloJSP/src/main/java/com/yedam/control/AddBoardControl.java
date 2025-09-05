package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");  // 한글입력시 인코딩
		
		// key=value + 파일 => 처리
		// 그래서 아래의 기존의 방식으로는 처리할 수 없다. 
		// 라이브러리 cos.jar를 사용할것임 -> 가장 간단하게 multipart를 처리할 수 있는 라이브러리
		// 게시글 DB Insert
		
		// 서버상의 upload폴더에 저장
		String upload = req.getServletContext().getRealPath("upload");
		// 자바 서블릿에서 파일 업로드 같은 작업을 할때 서버내부의 실제 폴더경로를 구하기 위해 사용되는 코드
		// req : 클라이언트 요청 정보를 담고 있는 객체 HttpServletRequest
		// getServletContext() : 현재 웹 애플리케이션의 컨텍스트(context) 정보를 가져옴
		//                       * 컨텍스트 : 웹 애플리케이션 전체를 대표하는 정보공간 
		//                                 우리가 만든 웹 프로젝트 하나가 톰캣 서버에 배포되면 하나의 가방처럼 동작
		//                                 이 가방안에 JSP파일, HTML, 이미, 업로드 폴더, 자바 클래스 등이 있다.
		//                                 이 가방 전체를 대표하는 객체가 바로 ServeletContext
		// getRealPath("upload") : webapp/upload 폴더의 실제 서버경로(로컬경로)를 반환 
		System.out.println(upload);
		
		MultipartRequest mr = new MultipartRequest(
				req, //요청정보
				upload, //업로드정보
				1024 * 1024 * 5, //최대파일크기
				"UTF-8",  //인코딩방식
				new DefaultFileRenamePolicy() //리네임정책
				);
		
		// MultipartRequest는 매개값이 5개가 들어간다. 
		// 1) 어떤값이 들어왔는지를 확인하는 것이 HttpServletRequest인데 위에서 req이니 이게 파라미터로 필요함 
		// 2) 업로드하는 경로 (서버가 실행되고 있는 경로를 기준으로 realPath)
		// 3) 업로드하는 파일의 최대파일을 지정해야한다(이걸 넘어서면 파일전송실패)
		//    1024 * 1024 * 5 라고 적으면 5메가
		// 4) 파일명안에 영어외의 다른 문장이 있을 경우 인코딩 방식을 지정해줘야함 
		// 5) DefaultFileRenamePolicy 여러사람이 파일을 업로드할때 똑같은 파일이름이 있을 경우 그 파일이 삭제되면 안되니 
		//                            그 파일의 이름을 다른 이름으로 rename해주는 정책임 (1,2,3.. 이런식으로 붙여서)
		
		
		
		// Mutipart mr을 기준으로 getParameter 작성해줘야함
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		String img = mr.getFilesystemName("images");   //파일이름
		
		// BoardVO에도 image라는 필드를 추가하자(테이블에 칼럼추가했으니)
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setWriter(writer);
		param.setContent(content);
		param.setImage(img);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.registerBoard(param)) {
			// 정상등록
			// 목록이동
			resp.sendRedirect("boardList.do");
		}else {
			// 등록실패
			System.out.println("에러발생");
		}
		
		
		
		
		
		
		
		// 예전코드(파일업로드 만들기전)
		// addBoard.do?title=???&writer=????&content=????
//		String title = req.getParameter("title");
//		String writer = req.getParameter("writer");
//		String content = req.getParameter("content");
//		
//		BoardVO param = new BoardVO();
//		param.setTitle(title);
//		param.setWriter(writer);
//		param.setContent(content);
//		
//		BoardService svc = new BoardServiceImpl();
//		if(svc.registerBoard(param)) {
//			// 정상등록
//			// 목록이동
//			resp.sendRedirect("boardList.do");
//		}else {
//			// 등록실패
//			System.out.println("에러발생");
//		}
		
	}//end of execute

}
