package dbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("드라이브로딩 예외");
		}
	}
	
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	public void getConn() {
		String url = "jdbc:mysql://127.0.0.1/mydb";
		String id = "root";
		String password = "root1234";
		try {
		conn = DriverManager.getConnection(url, id, password);
		}catch (Exception e) {
			System.out.println("데이터베이스 연결 예외 발생!!!!");
		}
	}
	
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			System.out.println("데이터베이스 닫기 예외 발생!!!!");
		}
	}
	
	
	
	public int insertBook(BookDTO bookDTO) { 
		int result = 0;
		try {
			getConn();
			
			String sql = "insert into book(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher) values(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookDTO.getNo());
			pstmt.setString(2, bookDTO.getTitle());
			pstmt.setString(3, bookDTO.getAuthor());
			pstmt.setInt(4, bookDTO.getYear());
			pstmt.setInt(5, bookDTO.getPrice());
			pstmt.setString(6, bookDTO.getPublisher());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("데이터 등록 예외 발생");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	public void selectBook() { 
		try {
			getConn();
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("%5s %5s %5s %5d %5d %5s\n", 
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			}
		}catch (Exception e) {
			
		} finally {
			dbClose();
		}
	}

	
}

