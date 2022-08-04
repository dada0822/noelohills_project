package basket;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class BasketDAO extends DBConnPool {
	public BasketDAO() {
		super();
	}
	
// ��ٱ��� ��ǰ�ֱ�(insert), ��(select), (���� : ���� ����), ����(delete/����,��ü ����)
	// ȸ���ڵ� ������
	public BasketDTO memberInfo(String m_id) {
		BasketDTO dto = new BasketDTO();
		
		String query = "select m_code From member where m_id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_id);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setM_code(rs.getString(1));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ���ڵ带 �ҷ����� �� ���� �߻�");
		}
		return dto;
	}
	
	// ��ٱ��� ��ǰ DB�� ���
	public int putProduct(BasketDTO dto) {
		int result = 0;
		
		String query = "INSERT INTO basket (b_code, p_code, m_code, p_name, b_count, b_price) VALUES(basket_b_code_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getP_code());
			psmt.setString(2, dto.getM_code());
			psmt.setString(3, dto.getP_name());
			psmt.setString(4, dto.getB_count());
			psmt.setString(5, dto.getB_price());
			
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("basket db�� ������ �ִ� �� ���� �߻�");
		}
		return result;
	}
	
	
//	// ��ٱ��� ��ȸ(��ǰ ��ĥ ���)
//	public List<BasketDTO> basketList(BasketDTO dto) {
//		List<BasketDTO> list = new Vector<BasketDTO>();
//		
//		String query = "SELECT b_code, p_code, m_code,"
//				+ " p_name, b_count, to_char(b_price, '999,999,999') b_price "
//				+ " FROM basket WHERE m_code=? ORDER BY TO_NUMBER(p_code) DESC";
//		
//		try {
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, dto.getM_code());
//			rs = psmt.executeQuery();
//			while(rs.next()) {
//				//BasketDTO dto = new BasketDTO();
//				
//				dto.setB_code(rs.getString("b_code"));
//				dto.setP_code(rs.getString("p_code"));
//				dto.setM_code(rs.getString("m_code"));
//				dto.setP_name(rs.getString("p_name"));
//				//dto.setB_count(rs.getString("b_count"));
//				dto.setB_price(rs.getString("b_price"));
//				
//				list.add(dto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("��ٱ��� ����Ʈ ��ȸ �� ���� �߻�");
//		}
//		return list;
//	} 
	
	// ��ٱ��� ��ȸ
	public List<BasketDTO> basketList(String m_code) {
		List<BasketDTO> list = new Vector<BasketDTO>();
		
		String query = "SELECT b_code, p_code, m_code, "
					+ " p_name, b_count, to_char(b_price, '999,999,999') b_price "
					+ " FROM basket WHERE m_code=? ORDER BY TO_NUMBER(b_code) DESC";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BasketDTO dto = new BasketDTO();
				
				dto.setB_code(rs.getString("b_code"));
				dto.setP_code(rs.getString("p_code"));
				dto.setM_code(rs.getString("m_code"));
				dto.setP_name(rs.getString("p_name"));
				dto.setB_count(rs.getString("b_count"));
				dto.setB_price(rs.getString("b_price"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ٱ��� ����Ʈ ��ȸ �� ���� �߻�");
		}
		return list;
	} 
	
	// ��ǰ ������ �ݾ� ����
	public int updateCountPrice(BasketDTO dto) {
		int result = 0;
		String query = "UPDATE basket SET b_count=?, b_price=? WHERE m_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getB_count());
			psmt.setString(2, dto.getB_price());
			psmt.setString(3, dto.getM_code());
			
			result = psmt.executeUpdate();
			System.out.println(result + "result��!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("������Ʈ �� ���� �߻�");
		}
		return result;
	}
	
	// �� ��ǰ�ݾ�
	public String totalPrice(String m_code) {
		String totalPrice = "";
		
		String query = "SELECT TO_CHAR(SUM(b_price), '999,999,999') b_price FROM basket WHERE m_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			rs = psmt.executeQuery();
			rs.next();
			totalPrice = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�� ��ǰ �ݾ� ��� �� ���� �߻�");
		}
		return totalPrice;
	}
	
	// ��ǰ ����
	public void deleteProduct(String m_code) {
		String query = "DELETE FROM basket WHERE m_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("��ǰ ��ü ���� �� ���� �߻�");
		}
	}
	
	public void deleteSelectedProduct(String m_code, String p_code) {
		String query = "DELETE FROM basket WHERE m_code=? AND p_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			psmt.setString(2, p_code);
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ǰ ���� �� ���� �߻�");
		}
	}
	
}
