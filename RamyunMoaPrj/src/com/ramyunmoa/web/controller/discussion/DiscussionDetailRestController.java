package com.ramyunmoa.web.controller.discussion;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import com.ramyunmoa.web.entity.review.ReviewCmt;
import com.ramyunmoa.web.service.ReviewService;
import com.ramyunmoa.web.view.review.ReviewDetailView;

/**
 * Servlet implementation class ReviewDetailController
 */
@WebServlet("/discussion/detail-data")
public class DiscussionDetailRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		ReviewService service=new ReviewService();
		ReviewDetailView rdv=null;
		
		List<ReviewCmt> cmt= null;
		
		
		try {
//			rdv=service.getReviewDetailView(id);
			cmt=service.getReviewCmt(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("cmd-->"+cmt);
		
		request.setAttribute("cmt", cmt);
//		request.setAttribute("r", rdv);
		
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm")
				.create(); // 날짜 포맷 설정방법
		
		String json = gson.toJson(cmt);
//		String json2 = gson.toJson(rdv);
		
//		json+=json2

		System.out.println(json);
		PrintWriter out= response.getWriter();
		out.write(json);
//		out.write(json2);

	
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
		ReviewCmt cmt =gson.fromJson(lineString, ReviewCmt.class);
		
		System.out.println(cmt);
		ReviewService service=new ReviewService();
		ReviewCmt result=null;
		
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
