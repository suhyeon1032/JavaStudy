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
         System.out.println("드라이브 로딩 실패");
      }
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         // 2. DB연결
         // DriverManager클래스의 getConnection()메소드를 실행하면
         // 데이터베이스를 연결하여 Connection객체 리턴해준다
         //                           서버ip / db명
         String url = "jdbc:mysql://127.0.0.1/demo";
         //                         서버주소, 계정, 비번   
         conn = DriverManager.getConnection(url, "root", "root1234");
      
         // 3. PreparedStatement객체를 생성
         // 쿼리문 - 레코드선택(select)
         String sql = "SELECT empno, ename, hiredate, sal FROM emp ORDER BY ename asc";
         pstmt = conn.prepareStatement(sql);
         
         // 4. pstmt를 실행한다.
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            int empno = rs.getInt(1); // re.getInt("empno"); 이렇게 써도 가능하지만 잘 안씀
            String ename = rs.getString(2);
            String hiredate = rs.getString(3);
            double sal = rs.getDouble(4);
            System.out.printf("%6d %10s %22s %10.2f\n", empno, ename, hiredate, sal);
            
         }
         
         
      } catch (SQLException se) {
         System.out.println("DB연결 에러 발생....");
      }finally {
         // 연결종료 역순으로 해야함
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