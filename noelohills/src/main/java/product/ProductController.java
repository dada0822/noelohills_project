package product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.BoardPage;

public class ProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAO dao = new ProductDAO();
			
		Map<String, Object> map = new HashMap<String, Object>();
		
		int totalCount = dao.selectCount(); // �Խù� �� Ȯ��
		
		ServletContext application = getServletContext();
		
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE")); // 12
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK")); // 5
		
		int pageNum = 1;
		String pageTemp = req.getParameter("pageNum");
		if (pageTemp != null && !pageTemp.equals("")){
			pageNum = Integer.parseInt(pageTemp);
		}
		
		int start = (pageNum - 1) * pageSize + 1;
		int end = pageNum * pageSize;
		map.put("start", start);
		map.put("end", end);
		
		List<ProductDTO> productList = dao.selectListPage(map); // ��ǰ ��ü ��ȸ
		
		String p_categorycode = req.getParameter("p_categorycode");
		List<ProductDTO> cate_product = dao.categoryProductList(p_categorycode); // ī�װ� ���� ��ǰ ����
		
		List<ProductDTO> p_catecode = dao.categoryCode(); // ī�װ� �ڵ� ������

		String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "./product.do");
	
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		dao.close();
		
		req.setAttribute("productList", productList);
		req.setAttribute("cate_product", cate_product);
		req.setAttribute("map", map);
		req.setAttribute("p_catecode", p_catecode);
		
		req.getRequestDispatcher("/pages/Product.jsp").forward(req, resp);
	}
	
}