import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteTest {

	Scanner sc = new Scanner(System.in);
	Connection con = null;
	PreparedStatement pstmt = null;
	
	public DeleteTest() {
	
	}
	public void start() {
		try {
			// 사원번호를 입력받아 입력 받은 사원을 삭제하라.
			System.out.println("삭제할 사원 번호 -> ");
			int no = Integer.parseInt(sc.nextLine());
			
			// 1. 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. db연결
			con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root1234");
			// 3. 
			String sql = "delete from emp where empno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			// 4. 실행
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(cnt+"개의 레코드가 삭제 되었습니다");
			} else {
				System.out.println("레코드 삭제 실패하였습니다.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close();
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (Exception e) {
				
			}
		}	
	}
	public static void main(String[] args) {
		new DeleteTest().start();
	}

}
