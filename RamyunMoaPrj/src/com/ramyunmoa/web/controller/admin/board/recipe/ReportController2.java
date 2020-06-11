package com.ramyunmoa.web.controller.admin.board.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.service.admin.board.RecipeServiceAdmin;

@WebServlet("/admin/board/recipe/report")
public class ReportController2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RecipeServiceAdmin service = new RecipeServiceAdmin();
		int page = 1;
		String searchName = "";
		String date = "";

		String page_ = req.getParameter("p");
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		String searchName_ = req.getParameter("s");
		if (searchName_ != null && !searchName_.equals("")) {
			searchName = searchName_;
		}

		List<BoardAdmin> list = null;
		int count = 0;

		list = service.getRecipeReportList(searchName, page);
		req.setAttribute("list", list);
		count = service.getRecipeReportCount(searchName);
		req.setAttribute("count", count);

		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.board.recipe.report", req, resp);

	}

}
