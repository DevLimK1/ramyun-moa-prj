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

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private MemberService service;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 doGet 작동");
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("member.login", request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("로그인 doPost 작동");
		HttpSession session = request.getSession();
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
	
		MemberService service = new MemberService();
		
		Boolean result = null;
		
		/*
		 * try { if(result != service.loginCheck(uid,pwd)) { String msg =
		 * "<script>alert('아이디 또는 비밀번호가 올바르지 않습니다.'); location.href='login';</script>";
		 * response.getWriter().println(msg); } else {
		 */
			
			try { 
				result = service.loginCheck(uid,pwd);
				
				if(result == true) {
				System.out.println("로그인 성공!");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>alert('라면모아에 오신것을 환영합니다!'); location.href='/main'; </script>");
				out.flush();
				session.setAttribute("uid",uid);
				
				//////////////역할자 미완성 코드 ////////////////////////////
				
//				String role = service.getRoleByUserId(uid);
//				session.setAttribute("role", role); //로그인할 때 한번 사용, 역할도 세션에 추가해서 계속 사용한다. 필요할 때마다 불러오는게 아니라.
//				
//				String returnURL = request.getParameter("returnURL");
//				System.out.println("returnURL:"+returnURL);
//				//만약에 returnURL이 있다면
//				if(returnURL!=null && !returnURL.equals(""))
//					response.sendRedirect(returnURL); 
//				else
//					response.sendRedirect("../index");
//
//				}
				///////////////////////////////////////////
				}
				else {
					System.out.println("로그인 실패 ㅠㅠ");
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('아이디 또는 비밀번호를 확인해 주세요.'); location.href='login'; </script>");
					return;
					//					out.flush();
					//response.sendRedirect("login");
					
					
					
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
