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

import com.ramyunmoa.web.entity.admin.board.ReportAdmin;
import com.ramyunmoa.web.service.admin.board.ReviewServiceAdmin;

@WebServlet("/admin/board/discussion/report")
public class ReportController1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReviewServiceAdmin service = new ReviewServiceAdmin();
		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();

		int page = 1;
		String page_ = req.getParameter("p");
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		String field = "title";
		String field_ = req.getParameter("f");
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		String searchName = "";
		String searchName_ = req.getParameter("s");
		if (searchName_ != null && !searchName_.equals("")) {
			searchName = searchName_;
		}

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

		List<ReportAdmin> list = null;
		int count = 0;

		try {

			list = service.getReportAdminList(startDate, endDate, field, searchName, page);
			count = service.getReportAdminCount(startDate, endDate, field, searchName);

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
		container.render("admin.board.discussion.report", req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReviewServiceAdmin service = new ReviewServiceAdmin();

		int[] delIds = null;
		String[] delIds_ = req.getParameterValues("delId");
		if (delIds_ != null) {
			delIds = new int[delIds_.length];
			for (int i = 0; i < delIds_.length; i++) {
				delIds[i] = Integer.parseInt(delIds_[i]);
			}
		}

		String btn = req.getParameter("btn");

		try {
			service.delReportAll(delIds);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("report");

	}

}
