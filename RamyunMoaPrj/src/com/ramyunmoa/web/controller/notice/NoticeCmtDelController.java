package com.ramyunmoa.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramyunmoa.web.service.NoticeCommentService;

@WebServlet("/notice/cmt-del")
public class NoticeCmtDelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cmtId = Integer.parseInt(request.getParameter("cmtId"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		NoticeCommentService service = new NoticeCommentService();
		
		try {
			service.deleteNoticeComment(cmtId);
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
