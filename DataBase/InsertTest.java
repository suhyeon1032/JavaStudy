import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {
	Connection con = null;
	PreparedStatement pstmt = null;
	public InsertTest() {
		
	}
	public void empInsert() {
		// �����ȣ, �̸�, �޿�, �Ի����� ���ڵ� �߰��ϱ�
		
		try {
			// 1. ����̺� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB����									server/dbname
			con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root1234");
			
			
			// 3. preparedStatement��ü ���� : �������� �̿��Ͽ�
			// �����ȣ : 5555, �̸� : kim, �޿� : 4500, �Ի��� : ���� ��¥�� �ð����� ����
			//																 1  2  3
			String sql = "insert into emp(empno, ename, sal, hiredate) values(?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			
			// ?�� ���� �����Ѵ�.
			pstmt.setInt(1, 5555); // 1��° ����ǥ�� 5555�� �����ض�
			pstmt.setString(2, "kim");
			pstmt.setDouble(3, 3500);
			
			// 4. ���� executeUpdate() insert, update, selete�϶� ���, int�� ���� �ȴ�. 
			// ���� ���� ���������� ���� executeQuery(); executeUpdate() �� �� �ϳ� ���
			// cnt == �������� �����Ͽ� �߰� �� ���ڵ��� ���� ��ȯ�Ѵ�. 
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) { // cnt �� 1�̸� ���ڵ� �߰� ���� 0�̸� ���ڵ� �߰� ����
				System.out.println("���ڵ尡 �߰� �Ǿ����ϴ�.");
			}else {
				System.out.println("���ڵ� �߰� �����Ͽ����ϴ�.");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {// ��ü �ݾ��ֱ� ���������� ���� �� ���� �ݾ� ��� ��
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new InsertTest().empInsert();
		// ���Ⱑ �����̿��� ���⼭ ���� ����
		// ��ü�� �����ϰ� ������ ���� ������ 
	}

}
