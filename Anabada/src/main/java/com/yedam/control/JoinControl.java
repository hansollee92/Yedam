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
            resp.sendRedirect("joinSuccess.do?status=fail&reason=invalid");
            return;
        }

        MemberService svc = new MemberServiceImpl();

        // 중복 아이디 최종 확인
        if (svc.isDuplicateId(memberId)) {
            resp.sendRedirect("joinSuccess.do?status=fail&reason=dup");
            return;
        }

        // 생년월일 "yyyyMMdd" → java.sql.Date 변환
        Date birthDate;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate ld = LocalDate.parse(birthStr, fmt);

            // 범위 체크: 1895-01-01 ~ 오늘
            LocalDate min = LocalDate.of(1895, 1, 1);
            LocalDate today = LocalDate.now();
            if (ld.isBefore(min) || ld.isAfter(today)) {
                resp.sendRedirect("joinSuccess.do?status=fail&reason=badBirthRange");
                return;
            }

            birthDate = Date.valueOf(ld);
        } catch (Exception e) {
            resp.sendRedirect("joinSuccess.do?status=fail&reason=badBirthFormat");
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

        // 결과에 따라 리다이렉트 + 상태값
        if (ok) {
            resp.sendRedirect("joinSuccess.do?status=success");
        } else {
            resp.sendRedirect("joinSuccess.do?status=fail");
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();

	}

}
