package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 댓글번호 -> 실제 DB삭제 -> 잘삭제되었다는 정보(=처리결과) 컨트롤러에 반환
		
		String rno = req.getParameter("rno");  //replyNO의 의미로 rno
		
		// 서비스호출
		ReplyService svc = new ReplyServiceImpl();
		if(svc.removeReply(Integer.parseInt(rno))) { //Service쪽의 removeReply가 잘 처리되면
			
			//타입반환은 json으로
			// {"retCode":"OK"}    returnCode라는 의미의 retCode
			resp.getWriter().print("{\"retCode\":\"OK\"}");
			// 이 Json문자열 {\"retCode\":\"OK\"}이건 ""쓰고 위의 {"retCode":"OK"}이거 그냥 복사 붙여넣기 하면 자동으로 저렇게 들어가짐 (이클립스가해줌)
			
			
		}else { // 처리가 안되면
			// {"retCode":"NG"}
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
		
	}

}
