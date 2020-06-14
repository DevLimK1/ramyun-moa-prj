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

@WebServlet("/member/quit-member")
public class MemberQuitController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원탈퇴 doGet 작동");
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("member.quit-member", request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		System.out.println("회원탈퇴 doPost 작동");
		HttpSession session = request.getSession();
		MemberService service= new MemberService();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			String pwd = request.getParameter("pwd");
			PrintWriter out = response.getWriter();
			
			String uid = (String) session.getAttribute("uid");
			
			if(service.checkPwd(pwd)) {
				service.deleteMember(uid,pwd);
				
				out.println("<script>alert('회원탈퇴가 완료되었습니다'); location.href='/main'; </script>");
				session.invalidate();
				//out.flush();
				//response.sendRedirect("main");
			//session.setAttribute("id", id); //세션에 id 세팅
		}else {
			out.println("<script>alert('비밀번호를 확인해 주세요'); location.href='quit-member';</script>");
			//out.flush();
		
		}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
