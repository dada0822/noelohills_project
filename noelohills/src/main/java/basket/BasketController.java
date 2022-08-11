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

import common.JSFunction;

public class BasketController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
			
		String m_id = (String) session.getAttribute("m_id");
		BasketDAO dao = new BasketDAO();
		
		BasketDTO dto = dao.memberInfo(m_id); // ȸ�� �ڵ� �̾Ƴ���
		String m_code = dto.getM_code();
		
		List<BasketDTO> basketList2 = dao.basketList(m_code); // ��ٱ��� ��ȸ 
		
		String totalprice = dao.totalPrice(m_code); // ��ٱ��� �� �� ��ǰ �ݾ� ���
		map.put("totalprice", totalprice);
		
		dao.close();
		
		req.setAttribute("basketList2", basketList2);
		req.setAttribute("map", map);
		
		req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (!(session.getAttribute("m_id") == null)) {
			
			String m_id = (String) session.getAttribute("m_id");
			
			BasketDAO dao = new BasketDAO();
			
			BasketDTO dto = dao.memberInfo(m_id); // ȸ�� �ڵ� �̾Ƴ���
			String m_code = dto.getM_code();
			
			List<BasketDTO> basketList = dao.basketList(m_code); // ��ٱ��� ��� ��ȸ(����� ���� ��������)
			
			String default_p_totalprice = req.getParameter("default_p_totalprice");
			String p_totalprice1 = req.getParameter("p_totalprice");
			String p_code = req.getParameter("p_code");
			String b_count = req.getParameter("p_count");
			String p_name = req.getParameter("p_name");
			
			String p_totalprice = p_totalprice1.replaceAll(",", ""); 
			
			int pos = -1;
			// ��ǰ�� �ִٸ�
			
			for(int i = 0; i < basketList.size(); i++) {
				dto = basketList.get(i);
				if(dto.getP_name().equals(p_name)) {
					pos = 1;
					if((Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)) <= 5) { // ��ǰ ���� ����
						
						String b_price = Integer.toString(Integer.parseInt((default_p_totalprice.replaceAll(",", "")).trim())*(Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						
						dto.setB_count(Integer.toString(Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						dto.setB_price(b_price);
						
						dao.updateCountPrice(dto); // ������ ��ǰ�� �ִٸ� �ش� ��ǰ ������ �ݾ� ����
						break;
					} else {
						JSFunction.alertBack(resp, "��ǰ �ִ� �ֹ� ������ �ʰ��߽��ϴ�.");
						return;
					}
				}
			}
			
			// ������ ��ǰ�� ���ٸ�
			if(pos == -1) {
				dto.setM_code(m_code);
				dto.setB_price(p_totalprice);
				dto.setP_code(p_code);
				dto.setB_count(b_count);
				dto.setP_name(p_name);
			
				dao.putProduct(dto); // ��ǰ ���̺� insert
			}
			
			List<BasketDTO> basketList2 = dao.basketList(m_code); // ��ٱ��� ��� ��ȸ
			
			String totalprice = dao.totalPrice(m_code); // ��ٱ��� �� �� ��ǰ �հ� �ݾ�
			
			map.put("totalprice", totalprice);
			dao.close();
	
			req.setAttribute("basketList", basketList);
			req.setAttribute("basketList2", basketList2);
			req.setAttribute("map", map);

			req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);
		
		} else {
			JSFunction.alertLocation(resp, "�α����ϼž� ��ٱ��� �������� �� �� �ֽ��ϴ�.", "./login.do");
		}
	}
	
}
