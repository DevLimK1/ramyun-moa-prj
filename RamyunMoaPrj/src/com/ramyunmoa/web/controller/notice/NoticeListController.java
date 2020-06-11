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

import com.ramyunmoa.web.service.NoticeService;
import com.ramyunmoa.web.view.notice.NoticeView;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		List<NoticeView> list = null;
		
		// ����¡
		String page_ = request.getParameter("p");
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		// �˻�
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		String field = "title";
		String query = "";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		try {
			list = service.getNoticePubList(field, query, page);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0;
		try {
			count = service.getNoticeCount(field, query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("notice.list", request, response);
	}

}
