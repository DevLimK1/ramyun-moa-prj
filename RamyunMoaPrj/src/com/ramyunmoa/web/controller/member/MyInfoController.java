package com.ramyunmoa.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.entity.member.Role;
import com.ramyunmoa.web.service.MemberService;
import com.ramyunmoa.web.view.member.MemberView;

@WebServlet("/member/my-info")
public class MyInfoController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id = (int) session.getAttribute("id");
		String uid = (String) session.getAttribute("uid");
		
		MemberService service = new MemberService();
		Member m = null;
		MemberView mv = null;
		
		try {
			m = service.getMember(id);
			mv = service.getRoleByUserId(uid);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("m", m);
		request.setAttribute("role", mv);
		
		
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("mypage.my-info", request, response);
		
	}
}

