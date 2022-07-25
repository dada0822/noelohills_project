package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAO dao = new ProductDAO();
		
		List<ProductDTO> productList = dao.totalProduct();
		
		req.setAttribute("productList", productList);
		
		req.getRequestDispatcher("/pages/Products.jsp").forward(req, resp);
	}
}
