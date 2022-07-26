package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetatilController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAO dao1 = new ProductDAO();

		String p_code = req.getParameter("p_code");
		
		ProductDTO dto = dao1.productView(p_code);
		
		dao1.close();
		
		Product_imgDAO dao2 = new Product_imgDAO();
		
		List<Product_imgDTO> imgList = dao2.product_imgView(p_code); 
		
		req.setAttribute("dto", dto);
		req.setAttribute("imgList", imgList);
		
		req.getRequestDispatcher("/pages/ProductDetail.jsp").forward(req, resp);
	}
}
