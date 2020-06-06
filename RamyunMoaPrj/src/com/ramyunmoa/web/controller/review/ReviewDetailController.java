package com.ramyunmoa.web.controller.review;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ramyunmoa.web.entity.Review;
import com.ramyunmoa.web.entity.ReviewCmt;
import com.ramyunmoa.web.service.ReviewService;

/**
 * Servlet implementation class ReviewDetailController
 */
@WebServlet("/review/detail")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		ReviewService service=new ReviewService();
		Review review=null;
		try {
			review=service.getReview(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("r", review);
		
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("review.detail", request, response);
//		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/view/review/detail.jsp");
//		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		InputStream iStream =request.getInputStream(); //byte계열
		Scanner scan=new Scanner(iStream,"UTF-8"); //한글처리 해줘야함
		String lineString =scan.nextLine();
		System.out.println(lineString);
		
//		Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd")
//                .create();
		Gson gson = new Gson();
		ReviewCmt cmt =gson.fromJson(lineString, ReviewCmt.class);
		
		System.out.println(cmt);
		ReviewService service=new ReviewService();
		ReviewCmt result=null;
		
		try {
			result=service.insertCmt(cmt);
			System.out.println(result);
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("/error?n=404"); //에러 controller
		}
		
		String resultJson =gson.toJson(result);

		response.getWriter().write(resultJson);
//		response.getWriter().write(result+"");
		
		System.out.println(resultJson);
		
	}

}
