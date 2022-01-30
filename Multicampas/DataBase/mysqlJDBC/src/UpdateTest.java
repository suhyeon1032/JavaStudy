import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateTest {
	Scanner sc = new Scanner(System.in);
	public UpdateTest() {
		
	}
	public void start() {
		// 사원번호와 급여를 입력받아 해당사원 급여를 수정하는 프로그램 작성
		// 데이터 입력
		System.out.println("수정할 사원번호 : ");
		int empno = sc.nextInt();
		System.out.println("수정할 급여 : ");
		int sal = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. 드라이브 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. db연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root1234");
			// 3. 쿼리문 작성 객체생성 사원의 급여 -> 업데이트 데이터 이름 set 수정할 데이터
			//								 1			   2
			String sql = "update emp set sal=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			// 3-1 : 필요 데이터 셋팅
			pstmt.setInt(1, sal); // 첫번째 물음표는 sal
			pstmt.setInt(2, empno); // 두번째 물음표는 empno
			
			// 4. 실행 : 수정한 레코드의 수를 리턴해준다.
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"개의 레코드가 수정되었습니다.");
			}else {
				System.out.println("수정한 레코드가 없습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. dbclose
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				
			}
		}
		
	}
	public static void main(String[] args) {
		new UpdateTest().start();

	}

}
