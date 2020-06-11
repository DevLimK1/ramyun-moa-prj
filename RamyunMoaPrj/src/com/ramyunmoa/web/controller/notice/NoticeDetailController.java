package com.ramyunmoa.web.controller.notice;

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

import com.ramyunmoa.web.entity.notice.Notice;
import com.ramyunmoa.web.entity.notice.NoticeComment;
import com.ramyunmoa.web.service.NoticeCommentService;
import com.ramyunmoa.web.service.NoticeService;
import com.ramyunmoa.web.view.notice.NoticeCommentView;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		NoticeService nService = new NoticeService();
		Notice notice = null;
		
		try {
			notice = nService.getNotice(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 이전페이지
		Notice prevNotice = null;
		try {
			prevNotice = nService.getPrevPubNotice(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 다음페이지
		Notice nextNotice = null;
		try {
			nextNotice = nService.getNextPubNotice(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* comment */
		NoticeCommentService cService = new NoticeCommentService();
		List<NoticeCommentView> comments = null;
		
		try {
			comments = cService.getNoticeComment(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("prev", prevNotice);
		request.setAttribute("next", nextNotice);
		
		request.setAttribute("comments", comments);
		
		
		request.setAttribute("n", notice);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("notice.detail", request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("UTF-8");
		
		String content = request.getParameter("content");
		String writerId = request.getParameter("writerId");

		String boardId_ = request.getParameter("boardId");
		int boardId = Integer.parseInt(boardId_);
		
		NoticeComment comment = new NoticeComment();
		comment.setContent(content);
		comment.setWriterId("������");
		comment.setBoardId(boardId);
		
		NoticeCommentService cService = new NoticeCommentService();
		
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
