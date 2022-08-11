package basket;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BasketDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String p_code = req.getParameter("p_code");

		String m_id = (String) session.getAttribute("m_id");
		
		BasketDAO dao = new BasketDAO();
		
		BasketDTO dto = dao.memberInfo(m_id); // ȸ�� �ڵ� �̾Ƴ���
		String m_code = dto.getM_code();
		
		List<BasketDTO> basketList2 = null;
		
		if(p_code == null) { // ��ü ����
			dao.deleteProduct(m_code); // ��ü ����
		} else {
			dao.deleteSelectedProduct(m_code, p_code); // ������ ��ǰ ����
			
			basketList2 = dao.basketList(m_code); // ��ٱ��� ��� ��ȸ
			
			String totalprice = dao.totalPrice(m_code); // ��ٱ��� �� �� ��ǰ �ݾ� ���
			
			map.put("totalprice", totalprice);
		}
		
		dao.close();
		
		req.setAttribute("basketList2", basketList2);
		req.setAttribute("map", map);
		
		req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);
	}

}
