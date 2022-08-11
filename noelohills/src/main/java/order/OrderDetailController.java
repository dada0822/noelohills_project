package order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.BasketDAO;
import basket.BasketDTO;

public class OrderDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String o_code = req.getParameter("o_code");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		OrderDAO dao = new OrderDAO();
		
		String m_code = dao.m_codeGet(); // 회원코드 따오기
		
		List<OrderDTO> orderDetail = dao.orderListDetails(m_code, o_code);
		int ttprice = 0;
		for(int i=0; i<orderDetail.size(); i++) {
			ttprice += Integer.parseInt((orderDetail.get(i).getO_price().replace(",", "")).trim());
		}
		String tprice = Integer.toString(ttprice); // 구매내역 상세조회
		
		tprice = tprice.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		
		dao.close();
		
		map.put("tprice", tprice);
		req.setAttribute("map", map);
		req.setAttribute("orderDetail", orderDetail);
		req.getRequestDispatcher("/pages/OrderDetails.jsp").forward(req, resp);
	}
}
