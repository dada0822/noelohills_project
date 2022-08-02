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
		
		if (!(session.getAttribute("m_id") == null)) { // �α��εǾ��ִٸ�!
			
			String m_id = (String) session.getAttribute("m_id");
			System.out.println(m_id + "���̵�");
			BasketDAO dao = new BasketDAO();
			
			BasketDTO dto = dao.memberInfo(m_id);
			// String m_code = dao.memberInfo(m_id); // ȸ�� �ڵ� �̾Ƴ���
			String m_code = dto.getM_code();
			System.out.println("ȸ���ڵ尡��" + m_code);
			List<BasketDTO> basketList2 = dao.basketList(m_code); // ��ٱ��� ��ȸ 
			
			String totalprice = dao.totalPrice(m_code);
			map.put("totalprice", totalprice);
			
			dao.close();
			
			req.setAttribute("basketList2", basketList2);
			req.setAttribute("map", map);
			
			req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);

		} else {
			JSFunction.alertLocation(resp, "�α����ϼž� ��ٱ��� �������� �� �� �ֽ��ϴ�.", "./login.do");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("������");
		HttpSession session = req.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (!(session.getAttribute("m_id") == null)) {
			String m_id = (String) session.getAttribute("m_id");
			System.out.println(m_id + "= m_id");
			BasketDAO dao = new BasketDAO();
			
			BasketDTO dto = dao.memberInfo(m_id);
			// String m_code = dao.memberInfo(m_id); // ȸ�� �ڵ� �̾Ƴ���
			String m_code = dto.getM_code();
			
			
			System.out.println(dto.getB_count());
			System.out.println(dto.getM_code()); // d�길 ����
			System.out.println(dto.getB_price());
			List<BasketDTO> basketList = dao.basketList(m_code); // ��ٱ��� ��� ��ȸ(����� ���� ��������)
			
			String default_p_totalprice = req.getParameter("default_p_totalprice");
			String p_totalprice1 = req.getParameter("p_totalprice");
			String p_code = req.getParameter("p_code");
			String b_count = req.getParameter("p_count");
			String p_name1 = req.getParameter("p_name");
			
			String p_totalprice = p_totalprice1.replaceAll(",", ""); 
			
			int pos = -1;
			// ��ǰ�� �ִٸ�
			
			for(int i = 0; i < basketList.size(); i++) {
				dto = basketList.get(i);
				if(dto.getP_name().equals(p_name1)) {
					pos = 1;
					System.out.println("������� ���°�?");
					if((Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)) < 5) {
						System.out.println((Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						System.out.println(Integer.parseInt((basketList.get(i).getB_price().replaceAll(",", "")).trim()));
						System.out.println(Integer.parseInt((default_p_totalprice.replaceAll(",", "")).trim()));
						System.out.println(Integer.parseInt(b_count));
						System.out.println("*******#");
						
						String b_price = Integer.toString(Integer.parseInt((default_p_totalprice.replaceAll(",", "")).trim())*(Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						
						
						dto.setB_count(Integer.toString(Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						dto.setB_price(b_price);

						System.out.println("dto.get_b_count() ==> " + dto.getB_count());
						System.out.println("dto.getB_price() ==> " + dto.getB_price());
						
						int result = dao.updateCountPrice(dto);
						System.out.println("result >>>" + result);
						break;
					} else {
						System.out.println("��������");
						JSFunction.alertBack(resp, "��ǰ �ִ� �ֹ� ������ �ʰ��߽��ϴ�.");
						return;
					}
					
				}
			}
			
			// ������ ��ǰ�� ���ٸ�
			if(pos == -1) {
				dto.setM_code(m_code);
				dto.setB_price(p_totalprice);
				dto.setP_code(req.getParameter("p_code"));
				dto.setB_count(req.getParameter("p_count"));
				dto.setP_name(req.getParameter("p_name"));
				
				System.out.println("m_code" + m_code);
				System.out.println("p_name = " + p_name1);
				System.out.println("������������������p_code" + p_code);
				System.out.println("���⿩��p_totalprice" + p_totalprice);
				System.out.println("���� " + b_count);
				
				
				
				int result = dao.putProduct(dto); // ��ǰ ���̺� insert
				if(result == 1) {
					
				}
			}
			
			List<BasketDTO> basketList2 = dao.basketList(m_code); // ��ٱ��� ��� ��ȸ
			
			String totalprice = dao.totalPrice(m_code);
			
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
