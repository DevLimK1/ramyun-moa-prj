package com.ramyunmoa.web.controller.review;

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

import com.ramyunmoa.web.entity.review.Review;
import com.ramyunmoa.web.service.ReviewService;

@WebServlet("/review/edit")
public class ReviewEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.사용자입력
		int id = Integer.parseInt(request.getParameter("id"));

		// 2.데이터베이스에서 쿼리
		ReviewService service = new ReviewService();
		Review review = null;
		List<Review> list = new ArrayList();

		try {
			review = service.getReview(id);
			list = service.getReviewList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(review.getStarGrade());

		// 3.View에게 전달
		request.setAttribute("r", review);
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String item = request.getParameter("item");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String starGradeString = request.getParameter("star-grade");
		int starGrade = Integer.parseInt(starGradeString);
		String gradeTitle = "";
		String star = "";

		switch (starGrade) {
		case 1: {
			star = "★☆☆☆☆";
			gradeTitle = "집에 있어도 안먹음";
			break;
		}
		case 2:
			star = "★★☆☆☆";
			gradeTitle = "내 돈주고 먹지는 않음";
			break;
		case 3:
			star = "★★★☆☆";
			gradeTitle = "내 돈주고 사먹을만 함";
			break;
		case 4:
			star = "★★★★☆";
			gradeTitle = "맛있어서 가끔 생각남";
			break;
		case 5:
			star = "★★★★★";
			gradeTitle = "집에 쌓아놓고 먹고싶음";
			break;
		}

		Review review = new Review();
		review.setId(id);
		review.setTitle(title);
		review.setItem(item);
		review.setContent(content);
		review.setStar(star);
		review.setGradeTitle(gradeTitle);
		review.setStarGrade(starGrade);

		ReviewService service = new ReviewService();
		try {
			service.updateReview(review);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("detail?id=" + id);

	}

}
