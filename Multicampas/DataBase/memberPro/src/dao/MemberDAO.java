package dao;

import dbConn.MysqlConnection;
import java.util.ArrayList;
import java.util.List;


import dto.MemberDTO;

public class MemberDAO extends MysqlConnection{
	// 회원선택
	public List<MemberDTO> memberList() {
		// dto객체를 담을 ArrayList객체를 생성한다.
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			getConn(); // DB연결
			
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
			System.out.println("회원선택 예외 발생");
			e.printStackTrace();
		} finally {
			
		}
		return list;
		
		
	}
	// 회원등록
	// 회원수정
	// 회원삭제
	// 회원선택
}
