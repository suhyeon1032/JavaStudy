import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {
	Connection con = null;
	PreparedStatement pstmt = null;
	public InsertTest() {
		
	}
	public void empInsert() {
		// 사원번호, 이름, 급여, 입사일을 레코드 추가하기
		
		try {
			// 1. 드라이브 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB연결									server/dbname
			con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root1234");
			
			
			// 3. preparedStatement객체 생성 : 쿼리문을 이용하여
			// 사원번호 : 5555, 이름 : kim, 급여 : 4500, 입사일 : 현재 날짜와 시간으로 설정
			//																 1  2  3
			String sql = "insert into emp(empno, ename, sal, hiredate) values(?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			
			// ?에 값을 셋팅한다.
			pstmt.setInt(1, 5555); // 1번째 물음표에 5555를 셋팅해라
			pstmt.setString(2, "kim");
			pstmt.setDouble(3, 3500);
			
			// 4. 실행 executeUpdate() insert, update, selete일때 사용, int가 리턴 된다. 
			// 쿼리 값이 무엇인지에 따라서 executeQuery(); executeUpdate() 둘 줄 하나 사용
			// cnt == 쿼리문을 실행하여 추가 된 레코드의 수를 반환한다. 
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) { // cnt 가 1이면 레코드 추가 성공 0이면 레코드 추가 실패
				System.out.println("레코드가 추가 되었습니다.");
			}else {
				System.out.println("레코드 추가 실패하였습니다.");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {// 객체 닫아주기 마지막으로 열린 것 부터 닫아 줘야 함
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new InsertTest().empInsert();
		// 여기가 메인이여서 여기서 부터 실행
		// 객체를 생성하고 위에서 부터 착착착 
	}

}
