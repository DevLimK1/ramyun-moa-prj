package com.ramyunmoa.web.controller.admin.board.feedback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.notice.Feedback;
import com.ramyunmoa.web.entity.notice.FeedbackComment;
import com.ramyunmoa.web.service.FeedbackCommentService;
import com.ramyunmoa.web.service.FeedbackService;
import com.ramyunmoa.web.view.notice.FeedbackCommentView;

@WebServlet("/admin/board/feedback/detail")
public class AdminFeedbackDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		FeedbackService fService = new FeedbackService();
		Feedback feedback = null;
		
		try {
			feedback = fService.getFeedback(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 이전페이지
		Feedback prevFeedback = null;
		try {
			prevFeedback = fService.getPrevFeedback(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 다음페이지
		Feedback nextFeedback = null;
		try {
			nextFeedback = fService.getNextFeedback(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FeedbackCommentService cService = new FeedbackCommentService();
		List<FeedbackCommentView> comments = null;
		
		try {
			comments = cService.getFeedbackComment(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("prev", prevFeedback);
		request.setAttribute("next", nextFeedback);
		
		request.setAttribute("comments", comments);
		request.setAttribute("f", feedback);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("admin.board.feedback.detail", request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("UTF-8");
		
		String content = request.getParameter("content");
		String writerId = request.getParameter("writerId");

		String boardId_ = request.getParameter("boardId");
		int boardId = Integer.parseInt(boardId_);
		
		FeedbackComment comment = new FeedbackComment();
		comment.setContent(content);
		comment.setWriterId("주정태");
		comment.setBoardId(boardId);
		
		FeedbackCommentService cService = new FeedbackCommentService();
		
		try {
			cService.insertComment(comment);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("detail?id=" + boardId);
	
	}
}
