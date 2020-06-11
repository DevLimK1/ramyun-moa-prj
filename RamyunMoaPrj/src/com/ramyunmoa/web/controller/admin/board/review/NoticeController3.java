package com.ramyunmoa.web.controller.admin.board.review;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.service.admin.board.ReviewServiceAdmin;

@WebServlet("/admin/board/review/notice")
public class NoticeController3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReviewServiceAdmin service = new ReviewServiceAdmin();

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

		try {

			list = service.getReviewNoticeList(searchName, page);
			count = service.getReviewNoticeCount(searchName);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		req.setAttribute("count", count);

		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.board.review.notice", req, resp);

	}

}
