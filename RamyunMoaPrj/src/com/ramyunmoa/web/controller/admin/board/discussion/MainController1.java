package com.ramyunmoa.web.controller.admin.board.discussion;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet("/admin/board/discussion/main")
public class MainController1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();

		String startDate = "1900-01-01";
		String startDate_ = req.getParameter("sd");
		if (startDate_ != null && !startDate_.equals("")) {
			startDate = startDate_;
		}

		String endDate = temp.format(time);
		String endDate_ = req.getParameter("ed");
		if (endDate_ != null && !endDate_.equals("")) {
			endDate = endDate_;
		}

		int cr = 0;
		int crc = 0;
		int crr = 0;

		ReviewServiceAdmin service = new ReviewServiceAdmin();
		try {

			cr = service.countReview(startDate, endDate);
			req.setAttribute("cr", cr);
			crc = service.countReviewCmt(startDate, endDate);
			req.setAttribute("crc", crc);
			crr = service.countReviewReport(startDate, endDate);
			req.setAttribute("crr", crr);

			List<BoardAdmin> list = service.rankingReview(startDate, endDate);
			req.setAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.board.discussion.main", req, resp);

	}

}
