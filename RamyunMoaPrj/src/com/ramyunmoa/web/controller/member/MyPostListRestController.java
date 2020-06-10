package com.ramyunmoa.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/admin/board/notice/list-data")// data ->xml,csv, json
public class MyPostListRestController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		int page=1;
//		String page_ =request.getParameter("p");
//		if(page_ != null && !page_.equals(""))
//			page = Integer.parseInt(page_);
//		
//		NoticeService service = new NoticeService();
//		List<NoticeView> list = null;
//		try {
//			list = service.getNoticeList(page);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Gson gson = new Gson()
//		//String json = new Gson().toJson(list);
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		String json = gson.toJson(list);
//		
//
//		
//		PrintWriter out = response.getWriter();
//		out.write(json);
	}
}
