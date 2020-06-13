package com.ramyunmoa.web.controller.review;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1000 * 1024 * 1024, maxRequestSize = 3000 * 1024 * 1024)
@WebServlet("/upload")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		

		String fileNames = "";

		Collection<Part> parts = request.getParts(); // 2개 이상의 첨부파일을 받을 때 사용하기 위함

		for (Part part : parts) {

			String a1 = part.getContentType();
			String name = part.getName();

			System.out.printf("type:%s ,name:%s\n", a1, name);

			if (!name.equals("file"))
				continue;

			String fileName = "";

			// 업로드한 파일 저장하기
//			Part part = request.getPart("file");
			// Part part = request.getPart("title");
			fileName = part.getSubmittedFileName(); // 전송된 파일명
//		fileName = request.getPart("file").getSubmittedFileName();

//		String path="/upload"; //상대경로 -> , 원래는 진짜 물리경로를 알아야한다.
			String path = request.getServletContext().getRealPath("/upload");// 상대경로->시스템(물리)경로로 바꿔줌
//		path=path+"\\"+fileName; --> 역슬래쉬는 윈도우에서만..
			path += File.separator + fileName;
			System.out.println(path);
			part.write(path);
			fileNames += fileName;
			fileNames += ",";
		}

		fileNames = fileNames.substring(0, fileNames.length() - 1); // 뒤에 꼬랑지 빼는 방법

//		part.getInputStream();
//		part.write(path+fileName); //c:\temp aa.png

		// 새로 요청하는거임
		response.getWriter().print(fileNames);
	}
}
