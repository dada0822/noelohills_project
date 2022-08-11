package product;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class Product_imgDAO extends DBConnPool {
	public Product_imgDAO() {
		super();
	}
	
	// 제품코드에 맞는 제품 이미지 코드 가져오기
	public List<Product_imgDTO> product_imgView(String p_code) {
		List<Product_imgDTO> list = new Vector<Product_imgDTO>();
		
		String query = "SELECT * FROM product_img"
					+ " WHERE p_code=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, p_code);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Product_imgDTO dto = new Product_imgDTO();
				
				dto.setP_code(rs.getString("p_code"));
				dto.setPr_imgnum(rs.getString("pr_imgnum"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제품 이미지 코드를 불러오는 중 예외 발생");
		}
		return list;
	}
}
