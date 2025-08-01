package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RegisterControl;
import com.yedam.control.SignFormControl;
import com.yedam.control.SignUpControl;

// init - service - destroy 생명주기
// *.do -> 실행할 컨트롤.
// 요청url === 실행할 컨트롤 
public class FrontController extends HttpServlet {
	         // 이름에도 알수있듯이 컨트롤되는 것들을 모두 여기에 넣을 것이다. 
	         // Front를 붙인건, 안내데스크를 프론트라고 하듯이 기능들을 안내한다는 의미에서 붙여졌다.
	
	Map<String, Control> map;	
	
	//생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	// init, service [Ctrl] + [Space]로 만들기
	@Override
	public void init() throws ServletException {   //여기서는 호출
		map.put("/boardList.do", new BoardListControl());   //글목록
		map.put("/board.do", new BoardControl());           //상세화면
		// BoardListControl, BoardControl은 다른 패키지에 있어서 import해줘야함
		
		map.put("/register.do", new RegisterControl());    //글등록화면
		map.put("/addBoard.do", new AddBoardControl());    //글등록처리
		
		map.put("/modifyForm.do", new ModifyFormControl());  //수정화면(처리아님)
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정처리
		
		map.put("/deleteBoard.do", new DeleteBoardControl()); //글삭제처리
		
		map.put("/signForm.do", new SignFormControl());  //회원가입 화면
		map.put("/signup.do", new SignUpControl());      //회원가입처리
		
		map.put("/loginForm.do", new LoginFormControl());    //로그인 화면
		map.put("/login.do", new LoginControl());            //로그인처리
		map.put("/logout.do", new LogoutControl());          //로그아웃
		
		map.put("/memberList.do", new MemberListControl());  //회원목록 화면
	}
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url vs. uri.
		// http://localhost:8080/HelloJSP/boardList.do  (url)
		//                       ---------------------
		//                       uri : url에서 호스트와 포트를 제외한 나머지 부분을 uri
		
		String uri = req.getRequestURI();    //req.getRequestURI()가 즉, 저 부분을 반환해주는 메소드이다.
		String context = req.getContextPath();     //tomcat에서 context~라고 나오면 프로젝트 정보이다.(/HelloJSP의 정보를 반환해줌)
		String page = uri.substring(context.length());  // 전체 uri값에서 context를 뺀 이후가 우리가 실제적으로 호출하는 페이지! 
		                                 // 그래서 저 값을 알고 싶어서 subString <- 문자를 어디에서 어디까지 자르는 메소드를 들고와서 반환할꺼임
		// substring은 매개값으로 시작값과 끝나는값 두가지가 올 수 있는데 하나의 값만 있으면 저 길이만큼을 빼겠다는 거임. 
		
		Control control = map.get(page);
		control.execute(req, resp);		
		
	}
	
	
}
