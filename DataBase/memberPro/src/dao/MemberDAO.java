package dao;

import dbConn.MysqlConnection;
import java.util.ArrayList;
import java.util.List;


import dto.MemberDTO;

public class MemberDAO extends MysqlConnection{
	// ȸ������
	public List<MemberDTO> memberList() {
		// dto��ü�� ���� ArrayList��ü�� �����Ѵ�.
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			getConn(); // DB����
			
			// select
			String sql = "select num, username, tel, email, birth, gender, writedate "
					+ "from member order by mun";
			pstmt = conn.prepareStatement(sql);
			
			
			// rs
			rs = pstmt.executeQuery();
			
			// dto, dto, dto, dto
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setTel(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setBirth(rs.getString(5));
				dto.setGender(rs.getString(6));
				dto.setWritedate(rs.getString(7));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("ȸ������ ���� �߻�");
			e.printStackTrace();
		} finally {
			
		}
		return list;
		
		
	}
	// ȸ�����
	// ȸ������
	// ȸ������
	// ȸ������
}
