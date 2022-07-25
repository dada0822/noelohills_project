package product;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class ProductDAO extends DBConnPool {
	public ProductDAO() {
		super();
	}
	
	// ��ü ����, ī���ڸ� ���� ����, �� ����!
	
	public List<ProductDTO> totalProduct() {
		List<ProductDTO> list = new Vector<ProductDTO>();
		
		String query = "SELECT * FROM product";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
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
			System.out.println("��ü ��ǰ ���� �� ���� �߻�!");
		}
		return list;
	}
}
