package com.yedam.control;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class JoinControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

        // 폼 파라미터 받기
        String memberId    = req.getParameter("memberId");
        String memberPw    = req.getParameter("memberPw");
        String memberName  = req.getParameter("memberName");
        String birthStr    = req.getParameter("memberBirth"); // "yyyyMMdd" 형식(예: 19950105)
        String memberPhone = req.getParameter("memberPhone");

        // 필수값(서버사이드) 간단 체크
        if (isBlank(memberId) || isBlank(memberPw) || isBlank(memberName) || isBlank(birthStr) || isBlank(memberPhone)) {
            resp.sendRedirect("joinForm.do?msg=invalid");
            return;
        }

        MemberService svc = new MemberServiceImpl();

        // 중복 아이디 최종 확인
        if (svc.isDuplicateId(memberId)) {
            resp.sendRedirect("joinForm.do?msg=dup");
            return;
        }

        // 생년월일 "yyyyMMdd" → java.sql.Date 변환
        Date birthDate;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate ld = LocalDate.parse(birthStr, fmt);
            birthDate = Date.valueOf(ld);
        } catch (Exception e) {
            // 파싱 실패 시
            resp.sendRedirect("joinForm.do?msg=badBirth");
            return;
        }

        // VO에 담기
        MemberVO vo = new MemberVO();
        vo.setMemberId(memberId);
        vo.setMemberPw(memberPw);
        vo.setMemberName(memberName);
        vo.setMemberBirth(birthDate);   // VO가 java.util.Date여도 java.sql.Date는 업캐스트로 들어감
        vo.setMemberPhone(memberPhone);

        // 저장 시도
        boolean ok = svc.registerMember(vo);

        // 결과에 따라 리다이렉트 + 메시지
        if (ok) {
            resp.sendRedirect("joinForm.do?msg=success");
        } else {
            resp.sendRedirect("joinForm.do?msg=fail");
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();

	}

}
