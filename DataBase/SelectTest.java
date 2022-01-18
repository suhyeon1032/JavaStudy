import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

   public SelectTest() {
      
   }
   private void start() {
      try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      }catch (ClassNotFoundException cnfe) {
         System.out.println("����̺� �ε� ����");
      }
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         // 2. DB����
         // DriverManagerŬ������ getConnection()�޼ҵ带 �����ϸ�
         // �����ͺ��̽��� �����Ͽ� Connection��ü �������ش�
         //                           ����ip / db��
         String url = "jdbc:mysql://127.0.0.1/demo";
         //                         �����ּ�, ����, ���   
         conn = DriverManager.getConnection(url, "root", "root1234");
      
         // 3. PreparedStatement��ü�� ����
         // ������ - ���ڵ弱��(select)
         String sql = "SELECT empno, ename, hiredate, sal FROM emp ORDER BY ename asc";
         pstmt = conn.prepareStatement(sql);
         
         // 4. pstmt�� �����Ѵ�.
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            int empno = rs.getInt(1); // re.getInt("empno"); �̷��� �ᵵ ���������� �� �Ⱦ�
            String ename = rs.getString(2);
            String hiredate = rs.getString(3);
            double sal = rs.getDouble(4);
            System.out.printf("%6d %10s %22s %10.2f\n", empno, ename, hiredate, sal);
            
         }
         
         
      } catch (SQLException se) {
         System.out.println("DB���� ���� �߻�....");
      }finally {
         // �������� �������� �ؾ���
         try {
            if(rs != null) {rs.close();}
            if(pstmt != null) {pstmt.close();}
            if(conn != null) {conn.close();}
         }catch (Exception e) {}
      }
   }

   public static void main(String[] args) {
      new SelectTest().start();
   }

}