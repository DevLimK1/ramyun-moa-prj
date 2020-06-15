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

import com.ramyunmoa.web.entity.discussion.Discussion;
import com.ramyunmoa.web.entity.discussion.Topic;
import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.entity.review.Review;
import com.ramyunmoa.web.service.DiscussionService;
import com.ramyunmoa.web.view.review.DiscussionListView;

@WebServlet("/discussion/edit")
public class DiscussionEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.사용자입력
		int id = Integer.parseInt(request.getParameter("id"));

		// 2.데이터베이스에서 쿼리
		DiscussionService service = new DiscussionService();
		DiscussionListView dis = null;
		List<Topic> topic = new ArrayList<Topic>();
		List<Discussion> list = new ArrayList();
		try {
			dis = service.getDiscussionDetailView(id);
			topic=service.getTopicList();
//			list = service.getReviewList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(rdv.getStarGrade());

		// 3.View에게 전달
		request.setAttribute("dis", dis);
		request.setAttribute("topic", topic);
//		request.setAttribute("list", list);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/edit.jsp");
//		dispatcher.forward(request, response);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("board.discussion.edit", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String topic = request.getParameter("topic");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int topicId=0; 
		
		Discussion dis=new Discussion();
		
		

		DiscussionService service = new DiscussionService();
		try {
			topicId=service.getTopicId(topic); //토픽 아이디 가지고오기
			
			dis.setId(id);
			dis.setTitle(title);
			dis.setContent(content);
			dis.setTopicId(topicId);
			
			service.updateDiscussion(dis);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("detail?id=" + id);

	}

}
