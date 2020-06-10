package com.ramyunmoa.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.service.MemberService;

@WebServlet("/member/quitMember")
public class MemberQuitController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Å»Åð µÎ°Ù ÀÛµ¿");
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("member.quitMember", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id =  (int) session.getAttribute("id");
		String pwd = request.getParameter("pwd");
		
		MemberService service= new MemberService();
		
		try {
			service.deleteMember(id);
			System.out.println("Å»Åð µÎÆ÷½ºÆ® ÀÛµ¿");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("main");
		
	}
}
