package member;

import common.DBConnPool;

public class MemberDAO extends DBConnPool {
	public MemberDAO() {
		super();
	}
	
//	ȸ�� ����(insert), �α���(SELECT)
	// ȸ�� ���� DB�� ����
	public int insertMember(MemberDTO dto) {
		int result = 0;
		
		try {
			
			String query = "INSERT INTO member VALUES (?,?,?,?,?,?,?)";
		
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getM_code());
			psmt.setString(2, dto.getM_name());
			psmt.setString(3, dto.getM_address());
			psmt.setString(4, dto.getM_id());
			psmt.setString(5, dto.getM_pw());
			psmt.setString(6, dto.getM_email());
			psmt.setString(7, dto.getM_tel());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ�� ���� insert �� ���� �߻�");
		}
		return result;
	}
	
	// �α��� Ȯ��
	public MemberDTO memberCheck(String m_id, String m_pw) {
		MemberDTO dto = new MemberDTO();
		
		try {
			String query = "SELECT * FROM member m_id=? AND m_pw=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getM_id());
			psmt.setString(2, dto.getM_pw());
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setM_code(rs.getString("m_code"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_address(rs.getString("m_address"));
				dto.setM_id(m_id);
				dto.setM_pw(m_pw);
				dto.setM_email(rs.getString("m_email"));
				dto.setM_tel(rs.getString("m_tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�α��� �� ���� �߻�");
		}
		return dto;
	}
}