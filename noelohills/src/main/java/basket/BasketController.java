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
		
		BasketDTO dto = dao.memberInfo(m_id); // 회원 코드 뽑아내기
		String m_code = dto.getM_code();
		
		List<BasketDTO> basketList2 = dao.basketList(m_code); // 장바구니 조회 
		
		String totalprice = dao.totalPrice(m_code); // 장바구니 내 총 상품 금액 계산
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
			
			BasketDTO dto = dao.memberInfo(m_id); // 회원 코드 뽑아내기
			String m_code = dto.getM_code();
			
			List<BasketDTO> basketList = dao.basketList(m_code); // 장바구니 목록 조회(저장된 값들 가져오기)
			
			String default_p_totalprice = req.getParameter("default_p_totalprice");
			String p_totalprice1 = req.getParameter("p_totalprice");
			String p_code = req.getParameter("p_code");
			String b_count = req.getParameter("p_count");
			String p_name = req.getParameter("p_name");
			
			String p_totalprice = p_totalprice1.replaceAll(",", ""); 
			
			int pos = -1;
			// 제품이 있다면
			
			for(int i = 0; i < basketList.size(); i++) {
				dto = basketList.get(i);
				if(dto.getP_name().equals(p_name)) {
					pos = 1;
					if((Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)) <= 5) { // 제품 개수 제한
						
						String b_price = Integer.toString(Integer.parseInt((default_p_totalprice.replaceAll(",", "")).trim())*(Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						
						dto.setB_count(Integer.toString(Integer.parseInt(basketList.get(i).getB_count()) + Integer.parseInt(b_count)));
						dto.setB_price(b_price);
						
						dao.updateCountPrice(dto); // 동일한 제품이 있다면 해당 제품 개수와 금액 변경
						break;
					} else {
						JSFunction.alertBack(resp, "제품 최대 주문 수량을 초과했습니다.");
						return;
					}
				}
			}
			
			// 동일한 제품이 없다면
			if(pos == -1) {
				dto.setM_code(m_code);
				dto.setB_price(p_totalprice);
				dto.setP_code(p_code);
				dto.setB_count(b_count);
				dto.setP_name(p_name);
			
				dao.putProduct(dto); // 제품 테이블에 insert
			}
			
			List<BasketDTO> basketList2 = dao.basketList(m_code); // 장바구니 목록 조회
			
			String totalprice = dao.totalPrice(m_code); // 장바구니 내 총 상품 합계 금액
			
			map.put("totalprice", totalprice);
			dao.close();
	
			req.setAttribute("basketList", basketList);
			req.setAttribute("basketList2", basketList2);
			req.setAttribute("map", map);

			req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);
		
		} else {
			JSFunction.alertLocation(resp, "로그인하셔야 장바구니 페이지로 갈 수 있습니다.", "./login.do");
		}
	}
	
}
