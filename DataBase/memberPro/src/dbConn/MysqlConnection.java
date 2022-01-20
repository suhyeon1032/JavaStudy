package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnection {
		// �������, ��ü����
	
		// 1. ����̺�ε�
		static { // static {}�� ���๮�� ����� �� �ִ� ������ �ȴ�.
			// ���๮, �������
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception e) {
				System.out.println("����̺�ε� ���� �߻�!!!!");
			}
		}
		// ��������� ������ �����Ѵ�.
		protected Connection conn = null;
		protected PreparedStatement pstmt = null;
		protected ResultSet rs = null;
		// 2. �����ͺ��̽� ���� �޼ҵ�
		public void getConn() {
			String url = "jdbc:mysql://localhost/mydb";
			String id = "root";
			String password = "root1234";
			try {
			conn = DriverManager.getConnection(url, id, password);
			}catch (Exception e) {
				System.out.println("�����ͺ��̽� ���� ���� �߻�!!!!");
			}
		}
		
		// 3. �����ͺ��̽� ���� �޼ҵ�(��� �Ŀ� ����)
		public void dbClose() {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("�����ͺ��̽� �ݱ� ���� �߻�!!!!");
			}
		}
//		public static void main(String[] args) {
//			
//		}
		
}
