package com.ramyunmoa.web.controller.review;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ramyunmoa.web.service.ReviewService;
import com.ramyunmoa.web.view.review.ReviewListView;

/**
 * Servlet implementation class listController
 */
//사용자 요청 url
@WebServlet("/review/list-data")
public class ReviewListRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ =request.getParameter("p");

		String field = "title";
		if (field_ != null&& !field_.equals(""))
			field = field_;

		String query="";
		if (query_ != null && !query_.equals(""))
			query = query_;
		
		int page=1;
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		List<ReviewListView> list = new ArrayList();
		ReviewService service = new ReviewService();
		

		try {
			list = service.getReviewListView(field,query,page);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(page);
		request.setAttribute("list", list);
		System.out.println(list);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/list.jsp");
//		dispatcher.forward(request, response);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm")
				.create(); // 날짜 포맷 설정방법
		
		String json = gson.toJson(list);

//		System.out.println(json);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		PrintWriter out= response.getWriter();
		out.write(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
