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
import com.ramyunmoa.web.service.MemberService;

@WebServlet("/member/mypage")
public class MyPageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("mypage.mypage", request, response);
		
	}
}
