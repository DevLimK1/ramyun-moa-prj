package com.ramyunmoa.web.controller.feedback;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.notice.Feedback;
import com.ramyunmoa.web.entity.review.Member;
import com.ramyunmoa.web.service.FeedbackService;
import com.ramyunmoa.web.service.MemberService;
import com.ramyunmoa.web.service.ReviewService;

@WebServlet("/feedback/reg")
public class FeedbackRegController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member member=new Member();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Date regdate_ = new Date();
		
		String regdate = format.format(regdate_);

		request.setAttribute("regdate", regdate);
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("feedback.reg", request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("UTF-8");
	    
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String uid = request.getParameter("uid");
		String nickname="";
		MemberService mService = new MemberService();
		
		try {
			nickname=mService.getMemberNicknameByUid(uid);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.printf("uid : ",uid);
		Feedback feedback = new Feedback();
		feedback.setTitle(title);
		feedback.setContent(content);
		feedback.setWriterId(nickname);
		
		FeedbackService service = new FeedbackService();
		
		try {
			service.insertFeedback(feedback);
			
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
