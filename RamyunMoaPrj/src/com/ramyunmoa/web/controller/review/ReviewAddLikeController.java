package com.ramyunmoa.web.controller.review;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramyunmoa.web.service.ReviewService;

/**
 * Servlet implementation class ReviewAddLikeController
 */
@WebServlet("/add-like")
public class ReviewAddLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewId=Integer.parseInt(request.getParameter("id"));
		int result=0;
		ReviewService service=new ReviewService();
		
		try {
			result=service.addLike(reviewId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		request.setAttribute("", );
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/board/review/reg.jsp");
//		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
