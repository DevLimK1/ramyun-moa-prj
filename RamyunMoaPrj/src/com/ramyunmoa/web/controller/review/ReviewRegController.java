package com.ramyunmoa.web.controller.review;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramyunmoa.web.entity.Review;
import com.ramyunmoa.web.service.ReviewService;

@WebServlet("/review/reg")
public class ReviewRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/board/review/reg.jsp");
		dispatcher.forward(request, response);
//		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
//		container.render("review.reg", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
	
		//regReview.jsp에서 값 받아온다
		String item=request.getParameter("item");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String starGradeString=request.getParameter("star-grade");
		
		int starGrade=Integer.parseInt(starGradeString);
		String gradeTitle="";
		String star="";
		//Review 데이터에 set
		
//		System.out.println(title);
		

		switch (starGrade) {
		case 1: {
			star="★☆☆☆☆";
			gradeTitle="집에 있어도 안먹음";
			break;
		}
		case 2:
			star="★★☆☆☆";
			gradeTitle="내 돈주고 먹지는 않음";
			break;
		case 3:
			star="★★★☆☆";
			gradeTitle="내 돈주고 사먹을만 함";
			break;
		case 4:
			star="★★★★☆";
			gradeTitle="맛있어서 가끔 생각남";
			break;
		case 5:
			star="★★★★★";
			gradeTitle="집에 쌓아놓고 먹고싶음";
			break;
		}
		
		Review review=new Review();
		review.setItem(item);
		review.setStarGrade(starGrade);
		review.setTitle(title);
		review.setContent(content);
		review.setStar(star);
		review.setGradeTitle(gradeTitle);
		review.setWriterName("라면돌이");
		
		
		ReviewService service=new ReviewService();
		try {
			//service객체에서 추가메소드실행
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
