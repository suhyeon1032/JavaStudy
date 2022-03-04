package com.campus.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("n") != null) {// �α׾ƿ�
			// ���� �����ϰ� ������ �̵�
			HttpSession session = req.getSession();
			session.invalidate();

			res.sendRedirect("/webServlet/index.do");
		} else {
			// �α��� ��
			res.setContentType("text/html; charset=UTF-8");

			PrintWriter pw = res.getWriter();
			String html = "<!DOCTYPE html>";

			html += "<html>";
			html += "<head><title>�α���</title>";
			html += "<script>";
			html += "function logFormCheck(){";
			html += "if(document.getElementById('userid').value==''){";
			html += "alert('���̵� �Է��ϼ���...'); return false;}";
			html += "if(document.querySelector('#userpwd').value==''){";
			html += "alert('��й�ȣ �Է��ϼ���...'); return false;}";
			html += "return true;}</script></head><body>";
			html += "<h1>�α���</h1>";
			html += "<form method='post' action='" + req.getContextPath()
					+ "/login.do' onsubmit='return logFormCheck()'>";
			html += "���̵� : <input type='text' name='userid' id='userid'/><br/>";
			html += "��й�ȣ : <input type='password' name='userpwd' id='userpwd'/><br/>";
			html += "<input type='submit' value='Login'/></form></body></html>";

			pw.println(html);
		} // �α�����
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// DB��ȸ
		String userid = req.getParameter("userid");
		String userpwd = req.getParameter("userpwd");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();

		try {
			// 1. ����̺� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB����
			String url = "jdbc:mysql://127.0.0.1/campusdb";
			String id = "root";
			String pwd = "0000";
			conn = DriverManager.getConnection(url, id, pwd);

			// 3. PreparedStatement ����
			String sql = "select userid, username from member where userid=? && userpwd=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);

			// 4. ����
			rs = pstmt.executeQuery();
			if (rs.next()) {// �α��� ����
				// ���ǿ�.... �̸��� ���̵� �����Ѵ�.
				// ���ǰ�ü�� request���� ���� �� �ִ�.
				HttpSession session = req.getSession();
				session.setAttribute("logId", rs.getString(1));
				session.setAttribute("logName", rs.getString(2));

				pw.println("<script>");
				pw.println("alert('�α��ο� �����Ͽ����ϴ�. \\n Ȩ�������� �̵��մϴ�.'); ");
				pw.println("location.href='/webServlet/index.do'; ");
				pw.println("</script>");

			} else {// �α��� ����
				pw.println("<script>");
				pw.println("alert('�α��ο� �����Ͽ����ϴ�.'); ");
				pw.println("history.back(); </script> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// db�ݱ�
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
	}

}
