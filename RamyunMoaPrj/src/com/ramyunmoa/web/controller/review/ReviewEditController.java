package com.ramyunmoa.web.controller.review;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.entity.review.Review;
import com.ramyunmoa.web.service.ReviewService;
import com.ramyunmoa.web.view.review.MfcProductView;
import com.ramyunmoa.web.view.review.ReviewDetailView;

@WebServlet("/review/edit")
public class ReviewEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.사용자입력
		int id = Integer.parseInt(request.getParameter("id"));

		// 2.데이터베이스에서 쿼리
		ReviewService service = new ReviewService();
		ReviewDetailView rdv = null;
		List<MfcProductView> mpv = new ArrayList<MfcProductView>();
		List<Review> list = new ArrayList();
		List<Grade> grade = new ArrayList<Grade>();
		try {
			rdv = service.getReviewDetailView(id);
			mpv=service.getMfcProductViewList();
			grade = service.getGrade();
//			list = service.getReviewList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(rdv.getStarGrade());

		// 3.View에게 전달
		request.setAttribute("r", rdv);
		request.setAttribute("mpv", mpv);
		request.setAttribute("grade", grade);
//		request.setAttribute("list", list);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/edit.jsp");
//		dispatcher.forward(request, response);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("review.edit", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String mfcProduct = request.getParameter("mfc-product");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int gradeId=Integer.parseInt(request.getParameter("grade"));
		int mvpId=0; 
		
		Review review=new Review();
		
		

		ReviewService service = new ReviewService();
		try {
			mvpId=service.getMfcProductViewId(mfcProduct); //상품 아이디 가지고오기
			
			review.setId(id);
			review.setTitle(title);
			review.setContent(content);
			review.setGradeId(gradeId);
			review.setProductId(mvpId);
			
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
