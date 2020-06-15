package com.ramyunmoa.web.controller.discussion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.service.DiscussionService;
import com.ramyunmoa.web.view.review.DiscussionListView;

/**
 * Servlet implementation class listController
 */
//사용자 요청 url
@WebServlet("/discussion/list")
public class DiscussionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<DiscussionListView> list = new ArrayList();

		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");

		String field = "title";
		if (field_ != null && !field_.equals(""))
			field = field_;

		String query = "";
		if (query_ != null && !query_.equals(""))
			query = query_;

		int page = 1;
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		DiscussionService service = new DiscussionService();
		
		int count =0 ;
		
		try {
			list = service.getDiscussionListView(field, query, page);
			count= service.getDiscussionCount(field, query);
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
		container.render("board.discussion.list", request, response);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/list.jsp");
//		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
