package basket;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class BasketDAO extends DBConnPool {
	public BasketDAO() {
		super();
	}
	
// 장바구니 제품넣기(insert), 뷰(select), (수정 : 수량 변경), 삭제(delete/선택,전체 삭제)
	// 회원코드 따오기
	public BasketDTO memberInfo(String m_id) {
		BasketDTO dto = new BasketDTO();
		
		String query = "SELECT m_code FROM member WHERE m_id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_id);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setM_code(rs.getString(1));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원코드를 불러오는 중 예외 발생");
		}
		return dto;
	}
	
	// 장바구니 제품 DB에 등록
	public void putProduct(BasketDTO dto) {
		
		String query = "INSERT INTO basket (b_code, p_code, m_code, p_name, b_count, b_price) VALUES(basket_b_code_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getP_code());
			psmt.setString(2, dto.getM_code());
			psmt.setString(3, dto.getP_name());
			psmt.setString(4, dto.getB_count());
			psmt.setString(5, dto.getB_price());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("basket db에 데이터 넣는 중 예외 발생");
		}
	}
	
	// 장바구니 조회
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
			System.out.println("장바구니 리스트 조회 중 예외 발생");
		}
		return list;
	} 
	
	// 제품 개수와 금액 변경
	public void updateCountPrice(BasketDTO dto) {
		String query = "UPDATE basket SET b_count=?, b_price=? WHERE m_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getB_count());
			psmt.setString(2, dto.getB_price());
			psmt.setString(3, dto.getM_code());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업데이트 중 예외 발생");
		}
	}
	
	// 총 상품금액
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
			System.out.println("총 상품 금액 계산 중 예외 발생");
		}
		return totalPrice;
	}
	
	// 제품 전체 삭제
	public void deleteProduct(String m_code) {
		String query = "DELETE FROM basket WHERE m_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("제품 전체 삭제 중 예외 발생");
		}
	}
	
	// 선택한 제품 삭제하기
	public void deleteSelectedProduct(String m_code, String p_code) {
		String query = "DELETE FROM basket WHERE m_code=? AND p_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			psmt.setString(2, p_code);
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제품 삭제 중 예외 발생");
		}
	}
}