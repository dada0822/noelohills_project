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


public class OrderpageController extends HttpServlet {
	
	// ������� ���� ���!!
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
	
		String m_id = (String) session.getAttribute("m_id");
		BasketDAO b_dao = new BasketDAO();
		
		BasketDTO b_dto = b_dao.memberInfo(m_id);
		String m_code = b_dto.getM_code();
		
		OrderDTO dto = new OrderDTO();
		OrderDAO dao = new OrderDAO();
		
		List<OrderDTO> orderList = dao.orderList(m_code);
		
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("/pages/OrderList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String m_code = req.getParameter("m_code"); // �������������� null, ȸ���ڵ� ��ٱ��Ͽ��� �����ϱ⸦ ���� ��쿡�� ���� ��������
		
		String[] o_name = req.getParameterValues("p_name"); // ��ǰ��
		String[] o_count = req.getParameterValues("p_count"); // ������ ����
		String[] o_price = req.getParameterValues("p_totalprice"); // ������ ���� �ݾ�
		//String totalprice = req.getParameter("totalprice"); // ��ٱ��� �ջ�ݾ�
		
		

		OrderDTO dto = new OrderDTO();
		OrderDAO dao = new OrderDAO();
		
		dao.deleteProduct(m_code); // ��ٱ��� ���ļ� �������� ��츸 ��ٱ��� ���̺� ������ �����ϱ�
		
		if (m_code == null) {
			m_code = dao.m_codeGet1();
		}
		
		dto.setM_code(m_code);
		
//		if(totalprice == null) {
//			totalprice = o_price[0];
//		}
		
		List list = new Vector();
		Map map = null;
		for(int i=0; i<o_name.length; i++) {
			map = new HashMap();
			map.put("o_name" + i, o_name[i]);
			map.put("o_count" + i, o_count[i]);
			map.put("o_price" + i, o_price[i].replace(",", ""));
		
			list.add(map);
		}
		
		dao.orderInsert(list, dto); // �����ϱ� ���̺� insert ��
		
		List<OrderDTO> orderList = dao.orderList(m_code);
		//String o_code = orderList.get().getO_code();
		
		dao.close();
		
		req.setAttribute("orderList", orderList);
		
		req.getRequestDispatcher("/pages/OrderList.jsp").forward(req, resp);
	}
}
