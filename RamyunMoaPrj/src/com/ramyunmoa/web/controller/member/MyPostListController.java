package com.ramyunmoa.web.controller.member;

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

import com.ramyunmoa.web.service.PostService;
import com.ramyunmoa.web.view.member.PostView;

//notice/list와 url이 겹침 -> /post/list로 변경함
@WebServlet("/post/list")
public class MyPostListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int page=1;
		String page_ =request.getParameter("p");
		if(page_ != null && page_.equals(""))
			page = Integer.parseInt(page_);
		
		PostService service = new PostService();
		List<PostView> list = null;
		try {
			list = service.getPostList(page);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("list", list);

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("myPage.list", request, response);
	}
}
