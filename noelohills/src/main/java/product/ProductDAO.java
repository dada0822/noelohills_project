package product;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class ProductDAO extends DBConnPool {
	public ProductDAO() {
		super();
	}
	
//	상품 전체 페이지
	// 게시물 개수 세기
	public int selectCount() {

		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM product";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물의 개수를 계산하는 중에 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	// 목록 출력 시 페이징 기능 추가
	public List<ProductDTO> selectListPage(Map<String, Object> map){
		
		List<ProductDTO> bbs = new Vector<ProductDTO>();
		
		String query = "SELECT * FROM ( "
					+ " SELECT p.*, ROWNUM rNum FROM ( "
					+ "	SELECT p_code, p_categorycode, p_name, p_content, to_char(p_price, '999,999') p_price, "
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
				dto.setP_content(rs.getString("p_content"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
				
				bbs.add(dto);
			}
		} catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	// 상품 전체 조회
//	public List<ProductDTO> totalProduct() {
//		List<ProductDTO> list = new Vector<ProductDTO>();
//		
//		String query = "SELECT * FROM product";	
//		try {
//			
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(query);
//			
//			while(rs.next()) {
//				ProductDTO dto = new ProductDTO();
//				
//				dto.setP_code(rs.getString("p_code"));
//				dto.setP_categorycode(rs.getString("p_categorycode"));
//				dto.setP_name(rs.getString("P_name"));
//				dto.setP_content(rs.getString("p_content"));
//				dto.setP_price(rs.getString("p_price"));
//				dto.setP_totalprice(rs.getString("p_totalprice"));
//				dto.setP_count(rs.getString("p_count"));
//				
//				list.add(dto);
//			}
//		}catch(Exception e) {
//			System.out.println("상품 정렬 중 예외 발생");
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	// 카테고리별 상품 출력하기
	public List<ProductDTO> categoryProductList(String p_categorycode) {
		List<ProductDTO> list = new Vector<ProductDTO>();
		
		String query = "SELECT p_code, p_categorycode, p_name, TO_CHAR(p_price, '999,999') p_price, "
					+ " TO_CHAR(p_totalprice, '999,999,999') p_totalprice, p_count "
					+ " FROM product WHERE p_categorycode=? "
					+ " ORDER BY TO_NUMBER(p_code) DESC";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, p_categorycode);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setP_code(rs.getString("p_code"));
				dto.setP_categorycode(rs.getString("p_categorycode"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_content(rs.getString("p_content"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("카테고리 별로 상품 정렬 중 예외 발생");
		}
		return list;
	}
	
	// 카테고리 코드만 따오기 
	public List<ProductDTO> categoryCode() {
		List<ProductDTO> list = new Vector<ProductDTO>();
		
		String query = "select p_categorycode from product GROUP BY p_categorycode order by p_categorycode ASC";
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setP_categorycode(rs.getString("p_categorycode"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("카테고리코드를 불러오는 도중 예외 발생");
		}
		return list;
	}
	
//	상품 상세보기 페이지
	// 상품 상세보기
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
				dto.setP_content(rs.getString("p_content"));
				dto.setP_price(rs.getString("p_price"));
				dto.setP_totalprice(rs.getString("p_totalprice"));
				dto.setP_count(rs.getString("p_count"));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 상세보기 중 예외 발생");
		}
		return dto;
	}
}
