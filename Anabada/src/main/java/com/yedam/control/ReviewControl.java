package com.yedam.control;

import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;
import com.yedam.vo.ReviewVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReviewControl implements com.yedam.common.Control {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberNo = req.getParameter("memberNo");

        ReviewService svc = new ReviewServiceImpl();
        List<ReviewVO> myReviewList = svc.searchMyReview(Integer.parseInt(memberNo));
        List<ReviewVO> otherReviewList = svc.searchOtherReview(Integer.parseInt(memberNo));

        req.setAttribute("myReviewList", myReviewList);
        req.setAttribute("otherReviewList", otherReviewList);

        req.getRequestDispatcher("mylist/review_list.tiles").forward(req, resp);

    }
}
