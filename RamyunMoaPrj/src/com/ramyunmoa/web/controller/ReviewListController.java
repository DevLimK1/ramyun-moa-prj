package com.ramyunmoa.web.controller;

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

import com.ramyunmoa.web.entity.Review;
import com.ramyunmoa.web.service.ReviewService;

/**
 * Servlet implementation class listController
 */
//사용자 요청 url
@WebServlet("/list")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Review> list=new ArrayList();
		
		ReviewService service=new ReviewService();
		
		try {
			list=service.getReviewList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/review/list.jsp");
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
