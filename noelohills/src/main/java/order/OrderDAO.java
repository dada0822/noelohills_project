package order;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import basket.BasketDTO;
import common.DBConnPool;

public class OrderDAO extends DBConnPool {
	public OrderDAO(){
		super();
	}
	
	// 구매 테이블에 insert
	// 구매내역 조회 select (회원 코드)
	
	public OrderDTO m_codeGet(OrderDTO dto) {
		String query = "SELECT m.m_code "
					+ " FROM member m, order_ o "
					+ " WHERE m.m_code = o.m_code(+)";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				dto.setM_code(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 코드 조회 중 예외 발생");
		}
		return dto;
	}
	
	public String m_codeGet1() {
		String m_code = "";
		
		String query = "SELECT m.m_code "
					+ " FROM member m, order_ o "
					+ " WHERE m.m_code = o.m_code(+)";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				m_code = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 코드 조회 중 예외 발생");
		}
		return m_code;
	}
	
	public int orderInsert(List list, OrderDTO dto) {
		int result = 0;
		
		String query = "INSERT INTO order_ VALUES(TO_CHAR(SYSDATE, 'YYYYMMDD-HH24MISS'), ?, TO_CHAR(SYSDATE, 'YY.MM.DD'), ?, ?, ?)";
		try {
			Map map = null;
			psmt = con.prepareStatement(query);
			
			for(int i=0; i<list.size(); i++) {
				map = (Map) list.get(i);
				psmt.setString(1, dto.getM_code());
				psmt.setString(2, (String) map.get("o_count" + i));
				psmt.setString(3, (String) map.get("o_name" + i));
				psmt.setString(4, (String) map.get("o_price" + i));
				
				result = psmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("order_ table insert 중 예외 발생");
		}
		
		return result;
	}
	
	// order_ table에 insert 후 basket table에 있는 데이터 제거
	public void deleteProduct(String m_code) {
		int result = 0;
		String query = "DELETE FROM basket WHERE m_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("basket table 데이터 delete 중 예외 발생");
		}
	}
	
	// 구매내역 조회
	public List<OrderDTO> orderList(String m_code) {
		List<OrderDTO> list = new Vector<OrderDTO>();
		
		String query = "SELECT o_code, MAX(o_day) o_day, MAX(o_name) o_name, "
					+ " SUM(o_count) o_count, TO_CHAR(SUM(o_price), '999,999,999,999') o_price "
					+ " FROM order_ WHERE m_code=? GROUP BY o_code ORDER BY o_code DESC";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				OrderDTO dto = new OrderDTO();
				
				dto.setO_code(rs.getString("o_code"));
				dto.setO_day(rs.getString("o_day"));
				dto.setO_count(rs.getString("o_count"));
				dto.setO_name(rs.getString("o_name"));
				dto.setO_price(rs.getString("o_price"));
				list.add(dto);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("구매내역 조회 중 예외 발생");
		}
		return list;
	}
	
	// 구매내역 상세조회
	public List<OrderDTO> orderListDetails(String m_code, String o_code) {
		List<OrderDTO> list = new Vector<OrderDTO>();
		
		String query = "SELECT o_code, o_day, o_count, o_name, "
				+ " TO_CHAR(o_price, '999,999,999,999') o_price "
				+ " FROM order_ WHERE m_code=? AND o_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_code);
			psmt.setString(2, o_code);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				OrderDTO dto = new OrderDTO();
				
				dto.setO_code(rs.getString("o_code"));
				dto.setO_day(rs.getString("o_day"));
				dto.setO_count(rs.getString("o_count"));
				dto.setO_name(rs.getString("o_name"));
				dto.setO_price(rs.getString("o_price"));
				list.add(dto);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("구매내역 조회 중 예외 발생");
		}
		return list;
	}
	
	

}