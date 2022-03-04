package com.campus.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.AbstractElement;

@WebServlet("/login.do")
public class ServletStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletStart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet 메서드가 호출됨");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");

		// index.do로 접속한 클라이언트에게 정보 보내기

		// 1. 현재 페이지의 Content Type을 세팅한다.
		res.setContentType("text/html; charset=UTF-8");

		// 2. response객체 쓰기를 하기 위해 PrinterWriter 객체 얻어온다.
		PrintWriter pw = res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>서블렛으로 만든 홈페이지</title>");
		pw.println("<style> h1{color:red;} </style>");
		pw.println("</head>");
		pw.println("<body>");

		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		if (logId != null && !logId.equals("")) {
			pw.println((String) session.getAttribute("logName"));
			pw.println("<a href='/webServlet/login.do?n=1'>로그아웃</a>");
		} else {
			pw.println("<a href='/webServlet/login.do'>로그인</a>");
		}

		pw.println("<div><h1>Servlet Home Page</h1></div>");
		pw.println("<p>이름->" + name + "<br/>");
		pw.println("연락처 -> " + tel + "</p>");
		pw.println("</body> </html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 메서드가 호출됨");
	}

}