package com.ramyunmoa.web.controller.admin.board.feedback;

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

@WebServlet("/admin/board/feedback/edit")
public class AdminFeedbackEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		FeedbackService service = new FeedbackService();
		Feedback feedback = null;
		
		try {
			feedback = service.getFeedback(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("f", feedback);
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
	      container.render("admin.board.feedback.edit", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("UTF-8");
		
	    int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Feedback feedback = new Feedback();
		feedback.setId(id);
		feedback.setTitle(title);
		feedback.setContent(content);
		
		FeedbackService service = new FeedbackService();
		
		try {
			service.updateFeedback(feedback);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("detail?id="+id);
		
	}
}
