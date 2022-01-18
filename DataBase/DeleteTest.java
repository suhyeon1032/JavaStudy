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
			// �����ȣ�� �Է¹޾� �Է� ���� ����� �����϶�.
			System.out.println("������ ��� ��ȣ -> ");
			int no = Integer.parseInt(sc.nextLine());
			
			// 1. 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. db����
			con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root1234");
			// 3. 
			String sql = "delete from emp where empno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			// 4. ����
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(cnt+"���� ���ڵ尡 ���� �Ǿ����ϴ�");
			} else {
				System.out.println("���ڵ� ���� �����Ͽ����ϴ�.");
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
