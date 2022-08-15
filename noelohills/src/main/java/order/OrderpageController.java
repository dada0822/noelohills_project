package order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basket.BasketDAO;
import basket.BasketDTO;
import common.JSFunction;


public class OrderpageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		OrderDAO dao = new OrderDAO();
		HttpSession session = req.getSession();
		String m_code = dao.m_codeGet((String) session.getAttribute("m_id")); // 회원코드 따오기
		
		List<OrderDTO> orderList = dao.orderList(m_code); // 주문 내역 조회
		
		dao.close();
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("/pages/OrderList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if (!(session.getAttribute("m_id") == null)) {
			String m_code = req.getParameter("m_code"); // 상세페이지에서는 null, 회원코드 장바구니에서 구매하기를 누를 경우에만 값이 가져와짐
			
			String[] o_name = req.getParameterValues("p_name"); // 제품명
			String[] o_count = req.getParameterValues("p_count"); // 선택한 개수
			String[] o_price = req.getParameterValues("p_totalprice"); // 개수에 따른 금액
			String[] p_code = req.getParameterValues("p_code"); // 제품 코드
			
			OrderDTO dto = new OrderDTO();
			OrderDAO dao = new OrderDAO();
			
			dao.deleteProduct(m_code); // 장바구니 거쳐서 구매했을 경우만 장바구니 테이블에 데이터 삭제하기
			
			if (m_code == null) {
				m_code = dao.m_codeGet((String) session.getAttribute("m_id")); // 회원코드 따오기
			}
			
			dto.setM_code(m_code);
			
			List list = new Vector();
			Map map = null;
			for(int i=0; i<o_name.length; i++) {
				map = new HashMap();
				map.put("o_name" + i, o_name[i]);
				map.put("o_count" + i, o_count[i]);
				map.put("o_price" + i, o_price[i].replace(",", ""));
				map.put("p_code" + i, p_code[i]);
				list.add(map);
			}
			
			dao.orderInsert(list, dto); // 구매하기 테이블에 insert 후
			
			List<OrderDTO> orderList = dao.orderList(m_code); // 구매내역 조회
			dao.close();
			
			req.setAttribute("orderList", orderList);
			
			req.getRequestDispatcher("/pages/OrderList.jsp").forward(req, resp);
		} else {
			JSFunction.alertLocation(resp, "로그인하셔야 구매할 수 있습니다.", "./login.do");
		}
	}
}
