package com.ramyunmoa.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.service.MemberService;



@WebServlet("/member/regist")
public class MemberRegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget �۵�");
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("member.regist", request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost �۵�");
		request.setCharacterEncoding("UTF-8");

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1+"@"+email2;
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
	

		Member member = new Member();
		
		member.setUid(uid);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setNickname(nickname);
		member.setGender(gender);

		MemberService service= new MemberService();
		
		try {
			
			service.insertMember(member);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('라면모아 회원가입되었습니다. 환영합니다 ^-^ '); location.href='login'; </script>");
			out.flush();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//===============================================
	}
}



