package com.ramyunmoa.web.controller.recipe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.entity.review.Member;
import com.ramyunmoa.web.entity.review.Review;
import com.ramyunmoa.web.service.ReviewService;
import com.ramyunmoa.web.view.review.MfcProductView;

@WebServlet("/recipe/reg-cmt")
public class RecipeRegCmtController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");

		// detail.jsp에서 값 받아온다
		String contents=request.getParameter("contents");
		


		ReviewService service = new ReviewService();
		Review review= new Review();

		try {
			mpvId=service.getMfcProductViewId(mfcProduct);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		review.setTitle(title);
		review.setContent(content);
		review.setProductId(mpvId);
		review.setGradeId(gradeId);
		review.setWriterId(writerId);
		
		System.out.println("review:"+review);

		try {
			// service객체에서 추가메소드실행
			service.insertReview(review);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("list");

	}

}
