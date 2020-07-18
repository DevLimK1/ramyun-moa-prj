package com.ramyunmoa.web.controller.discussion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ramyunmoa.web.entity.discussion.Discussion;
import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.service.DiscussionService;
import com.ramyunmoa.web.service.ReviewService;
import com.ramyunmoa.web.view.review.MfcProductView;

@WebServlet("/discussion/reg-data")
public class DiscussionRegRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MfcProductView> mpv = new ArrayList<MfcProductView>();
		List<Grade> grade = new ArrayList<Grade>();
		Member member=new Member();
		HttpSession session = request.getSession();
		
		String uid=(String)session.getAttribute("uid");
		
		ReviewService service = new ReviewService();

		try {
			mpv = service.getMfcProductViewList();
			grade = service.getGrade();
			member=service.getMember(uid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(member);

		request.setAttribute("mpv", mpv);
		request.setAttribute("grade", grade);
		request.setAttribute("member", member);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/board/discussion/reg.jsp");
		dispatcher.forward(request, response);

//		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
//		container.render("review.reg", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");

		// reg.jsp에서 값 받아온다
		String mfcProduct = request.getParameter("mfc-product");
//		String mpvId_=request.getParameter("mpvId");
		String writerId_=request.getParameter("writerId");
		String gradeId_ = request.getParameter("grade");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writerName=request.getParameter("writerName");
		String topic= request.getParameter("topic");
		int topicId=0;
		int mpvId=0;
		
		System.out.println("writerName:"+writerName);
		System.out.println("mfcProduct:"+mfcProduct);
		System.out.println("writerId:"+writerId_);
		System.out.println("gradeId:"+gradeId_);
		System.out.println("title:"+title);
		System.out.println("content:"+content);
		
		int writerId=Integer.parseInt(writerId_);
//		int mpvId=Integer.parseInt(mpvId_);
		/* int gradeId = Integer.parseInt(gradeId_); */
		
		System.out.println("mfcProduct:"+mfcProduct);
		System.out.println("writerId:"+writerId);
		System.out.println("mmpvId:"+mpvId);

		// MfcProductView와 Grade에 데이터 set

		DiscussionService service = new DiscussionService();
		Discussion dis= new Discussion();
System.out.println(topic);
		try {
			topicId=service.getTopicId(topic);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		dis.setTitle(title);
		dis.setContent(content);
		dis.setWriterId(writerId);
		dis.setTopicId(topicId);
		
		System.out.println("review:"+dis);

		try {
			// service객체에서 추가메소드실행
			service.insertDiscussion(dis);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("list");

	}

}