package com.ramyunmoa.web.controller.feedback;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.notice.Feedback;
import com.ramyunmoa.web.service.FeedbackService;

@WebServlet("/feedback/reg")
public class FeedbackRegController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("feedback.reg", request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Feedback feedback = new Feedback();
		feedback.setTitle(title);
		feedback.setContent(content);
		feedback.setWriterId("주정태");
		
		FeedbackService service = new FeedbackService();
		
		try {
			service.insertFeedback(feedback);
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
