package com.ramyunmoa.web.controller.discussion;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
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
import com.ramyunmoa.web.entity.discussion.DiscussionCmt;
import com.ramyunmoa.web.service.DiscussionService;
import com.ramyunmoa.web.view.review.DiscussionListView;

/**
 * Servlet implementation class ReviewDetailController
 */
@WebServlet("/discussion/detail")
public class DiscussionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		DiscussionService service=new DiscussionService();
		DiscussionListView rdv=null;
		
		List<DiscussionCmt> cmt= null;
		
//		List<ReviewCmt> children=null;
		
		try {
			rdv=service.getDiscussionDetailView(id);
			cmt=service.getDiscussionCmt(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("rdv:"+rdv);
		
		request.setAttribute("cmt", cmt);
		request.setAttribute("r", rdv);
		
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("board.discussion.detail", request, response);
//		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/view/board/review/detail.jsp");
//		dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
//		int id=Integer.parseInt(request.getParameter("id"));
		
//		System.out.println("detail-dopost-id:"+id);
		
		System.out.println("hel");
		InputStream iStream =request.getInputStream(); //byte계열
		Scanner scan=new Scanner(iStream,"UTF-8"); //한글처리 해줘야함
		String lineString =scan.nextLine();
		System.out.println(lineString);
		
		Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
//		Gson gson = new Gson();
		DiscussionCmt cmt =gson.fromJson(lineString, DiscussionCmt.class);
		
		System.out.println(cmt);
		DiscussionService service=new DiscussionService();
		DiscussionCmt result=null;
		
		try {
			result=service.insertCmt(cmt);
			System.out.println("result"+result);
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("/error?n=404"); //에러 controller
		}
		
		String resultJson =gson.toJson(result);

		response.getWriter().write(resultJson);
//		response.getWriter().write(result+"");
		
		System.out.println(resultJson);
		
	}

}




//package com.ramyunmoa.web.controller.discussion;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Scanner;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.tiles.TilesContainer;
//import org.apache.tiles.access.TilesAccess;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.ramyunmoa.web.entity.review.ReviewCmt;
//import com.ramyunmoa.web.service.ReviewService;
//import com.ramyunmoa.web.view.review.ReviewDetailView;
//
///**
// * Servlet implementation class ReviewDetailController
// */
//@WebServlet("/discussion/detail")
//public class DiscussionDetailController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id=Integer.parseInt(request.getParameter("id"));
//		System.out.println("id:"+id);
//		ReviewService service=new ReviewService();
//		ReviewDetailView rdv=null;
//		
//		List<ReviewCmt> cmt= null;
//		
////		List<ReviewCmt> children=null;
//		
//		try {
//			rdv=service.getReviewDetailView(id);
//			cmt=service.getReviewCmt(id);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("rdv:"+rdv);
//		
//		request.setAttribute("cmt", cmt);
//		request.setAttribute("r", rdv);
//		
//		
//		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
//		container.render("board.discussion.detail", request, response);
////		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/view/board/review/detail.jsp");
////		dispatcher.forward(request, response);
//	
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
////		int id=Integer.parseInt(request.getParameter("id"));
//		
////		System.out.println("detail-dopost-id:"+id);
//		
//		System.out.println("hel");
//		InputStream iStream =request.getInputStream(); //byte계열
//		Scanner scan=new Scanner(iStream,"UTF-8"); //한글처리 해줘야함
//		String lineString =scan.nextLine();
//		System.out.println(lineString);
//		
//		Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd")
//                .create();
////		Gson gson = new Gson();
//		ReviewCmt cmt =gson.fromJson(lineString, ReviewCmt.class);
//		
//		System.out.println(cmt);
//		ReviewService service=new ReviewService();
//		ReviewCmt result=null;
//		
//		try {
//			result=service.insertCmt(cmt);
//			System.out.println("result"+result);
//		} catch (ClassNotFoundException | SQLException e) {
//			response.sendRedirect("/error?n=404"); //에러 controller
//		}
//		
//		String resultJson =gson.toJson(result);
//
//		response.getWriter().write(resultJson);
////		response.getWriter().write(result+"");
//		
//		System.out.println(resultJson);
//		
//	}
//
//}
