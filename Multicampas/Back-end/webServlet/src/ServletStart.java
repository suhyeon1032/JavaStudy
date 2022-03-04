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
		System.out.println("doGet �޼��尡 ȣ���");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");

		// index.do�� ������ Ŭ���̾�Ʈ���� ���� ������

		// 1. ���� �������� Content Type�� �����Ѵ�.
		res.setContentType("text/html; charset=UTF-8");

		// 2. response��ü ���⸦ �ϱ� ���� PrinterWriter ��ü ���´�.
		PrintWriter pw = res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>�������� ���� Ȩ������</title>");
		pw.println("<style> h1{color:red;} </style>");
		pw.println("</head>");
		pw.println("<body>");

		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		if (logId != null && !logId.equals("")) {
			pw.println((String) session.getAttribute("logName"));
			pw.println("<a href='/webServlet/login.do?n=1'>�α׾ƿ�</a>");
		} else {
			pw.println("<a href='/webServlet/login.do'>�α���</a>");
		}

		pw.println("<div><h1>Servlet Home Page</h1></div>");
		pw.println("<p>�̸�->" + name + "<br/>");
		pw.println("����ó -> " + tel + "</p>");
		pw.println("</body> </html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost �޼��尡 ȣ���");
	}

}