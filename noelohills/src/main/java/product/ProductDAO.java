package product;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class ProductDAO extends DBConnPool {
	public ProductDAO() {
		super();
	}
	
	// ��ü ����, ī���ڸ� ���� ����, �� ����! ����¡
	
	// �Խù� ���� ����
	public int selectCount() {

		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM product";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("�Խù��� ������ ����ϴ� �߿� ���� �߻�");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	// ��� ��� �� ����¡ ��� �߰�
	public List<ProductDTO> selectListPage(Map<String, Object> map){
		
		List<ProductDTO> bbs = new Vector<ProductDTO>();
		
		String query = "SELECT * FROM ( "
					+ " SELECT p.*, ROWNUM rNum FROM ( "
					+ "	SELECT p_code, p_categorycode, p_name, to_char(p_price, '999,999') p_price, "
					+ "	 to_char(p_totalprice, '999,999,999') p_totalprice, p_count FROM product "
					+ "	ORDER BY TO_NUMBER(p_code) DESC "
					+ "	) p "
					+ "	) "
					+ " WHERE rNum BETWEEN ? AND ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setP_code(rs.getString("p_code"));
				dto.setP_categorycode(rs.getString("p_categorycode"));
				dto.setP_name(rs.getString("P_name"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
				
				bbs.add(dto);
			}
		} catch(Exception e) {
			System.out.println("�Խù� ��ȸ �� ���� �߻�");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	// ��ǰ ��ü ��ȸ
	public List<ProductDTO> totalProduct() {
		List<ProductDTO> list = new Vector<ProductDTO>();
		
		String query = "SELECT * FROM product";	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setP_code(rs.getString("p_code"));
				dto.setP_categorycode(rs.getString("p_categorycode"));
				dto.setP_name(rs.getString("P_name"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println("��ǰ ���� �� ���� �߻�");
			e.printStackTrace();
		}
		return list;

	}
	
	// ī�װ��� ��ǰ ����ϱ�
	public List<ProductDTO> categoryProductList(String p_categorycode) {
		List<ProductDTO> list = new Vector<ProductDTO>();
		
		String query = "SELECT * FROM product WHERE p_categorycode=?"
					+ " ORDER BY TO_NUMBER(p_code) DESC";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, p_categorycode);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setP_code(rs.getString("p_code"));
				dto.setP_categorycode(rs.getString("p_categorycode"));
				dto.setP_name(rs.getString("P_name"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ī�װ� ���� ��ǰ ���� �� ���� �߻�");
		}
		return list;
	}
	
	// ��ǰ �󼼺���
	public ProductDTO productView(String p_code) {
		ProductDTO dto = new ProductDTO();
		
		String query = "SELECT p_code, p_categorycode, p_name, to_char(p_price, '999,999') p_price, "
					+ "	 to_char(p_totalprice, '999,999,999') p_totalprice, p_count " 
					+ " FROM product WHERE p_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, p_code);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto.setP_code(rs.getString("p_code"));
				dto.setP_categorycode(rs.getString("p_categorycode"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ǰ �󼼺��� �� ���� �߻�");
		}
		return dto;
	}
}
