package com.ramyunmoa.web.controller.admin.board.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramyunmoa.web.service.NoticeService;

@WebServlet("/admin/board/notice/del")
public class AdminNoticeDelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
//		int cId = Integer.parseInt(request.getParameter("cId"));
		
		NoticeService nService = new NoticeService();
		
		try {
			nService.deleteNotice(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		/* comment */
//		NoticeCommentService cService = new NoticeCommentService();
//		NoticeComment comment = new NoticeComment();
//		
//		try {
//			cService.deleteNoticeComment(cd);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
			response.sendRedirect("list");
	}
	
}
