package com.ramyunmoa.web.controller.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

/**
 * Servlet implementation class listController
 */
//사용자 요청 url
@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("main", request, response);
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/WEB-INF/view/main.jsp");
//		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
