package com.ramyunmoa.web.controller.admin.board.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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

@WebServlet("/admin/board/notice/list")
public class AdminNoticeListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		List<NoticeView> list = null;
		
		// 페이징
		String page_ = request.getParameter("p");
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		// 검색
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		String field = "title";
		String query = "";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		if(query_ != null && !query_.equals(""))
			query = query_;
				
		try {
			list = service.getNoticeList(field, query, page);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 카운트
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
		container.render("admin.board.notice.list", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NoticeService service = new NoticeService();
		
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		
		String[] ids = ids_.trim().split(" ");
		
		List<String> oids = null;
		List<String> cids = new ArrayList(Arrays.asList(ids));
		
		switch(cmd) {
			
			case "open":
				
				System.out.println(cids);
				if(openIds == null) 
					oids = null;
				
				else {
					oids = Arrays.asList(openIds);
					cids.removeAll(oids);
				}
		
				try {
					service.pubNoticeAll(oids, cids);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "del" : 
				
				if(delIds == null)
					break;
				
				int[] dIds = new int[delIds.length];
				for(int i=0; i<delIds.length;i++)
					dIds[i] = Integer.parseInt(delIds[i]);
				
			try {
				int result = service.deletNoticeAll(dIds);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		}
		
		
//		if(cmd.equals("open")) {
//			
//			System.out.println(cids);
//			if(openIds == null) 
//				oids = null;
//			
//			else {
//				oids = Arrays.asList(openIds);
//				cids.removeAll(oids);
//			}
//	
//			try {
//				service.pubNoticeAll(oids, cids);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		response.sendRedirect("list");
		
	}
}
