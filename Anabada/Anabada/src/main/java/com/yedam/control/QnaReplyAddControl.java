package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.QnaReplyService;
import com.yedam.service.QnaReplyServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.QnaReplyVO;

public class QnaReplyAddControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 한글인코딩
		resp.setContentType("text/json;charset=utf-8");
		
		// param : qnaReplyContent, memberNo, qnaNo		
		String qnaNo = req.getParameter("qnaNo");
		String qnaReplyContent = req.getParameter("qnaReplyContent");
		
		//권한확인
		HttpSession session = req.getSession();
		MemberVO logMember = (MemberVO) session.getAttribute("logMember");
		
		if(logMember == null) {	
		    resp.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = resp.getWriter();
		    out.println("<script>");
		    out.println("alert('로그인 후 이용해주세요.');");
		    out.println("history.back();");  // 이전 페이지로
		    out.println("</script>");
		    out.close();
		    return;
		}
		
		int memberNo = logMember.getMemberNo();
		
		QnaReplyVO qnaReply = new QnaReplyVO();
		qnaReply.setMemberNo(memberNo);
		qnaReply.setQnaNo(Integer.parseInt(qnaNo));
		qnaReply.setQnaReplyContent(qnaReplyContent);	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		QnaReplyService svc = new QnaReplyServiceImpl();
		if(svc.addQnaReply(qnaReply)) {
			map.put("retCode", "OK");
			map.put("retVal", qnaReply);
		}else {
			map.put("retCode", "NG");
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); 
		resp.getWriter().print(json);
		
		
	}

}
