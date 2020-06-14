package com.ramyunmoa.web.controller.admin.board.recipe;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.service.admin.board.ReviewServiceAdmin;

@WebServlet("/admin/board/recipe/notice-detail")
public class DetailNoticeController2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReviewServiceAdmin service = new ReviewServiceAdmin();

		int id = 0;
		String id_ = req.getParameter("id");
		if (id_ != null && !id_.equals("")) {
			id = Integer.parseInt(id_);
		}

		BoardAdmin notice = null;

		try {

			notice = service.getReviewNotice(id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("notice", notice);

		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.board.recipe.notice-detail", req, resp);

	}

}
