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
		
		if (!(session.getAttribute("m_id") == null)) { // 로그인되어있다면!
			
			String m_id = (String) session.getAttribute("m_id");
			System.out.println(m_id + "아이디값");
			BasketDAO dao = new BasketDAO();
			
			BasketDTO dto = dao.memberInfo(m_id);
			// String m_code = dao.memberInfo(m_id); // 회원 코드 뽑아내기
			String m_code = dto.getM_code();
			System.out.println("회원코드가뵤" + m_code);
			List<BasketDTO> basketList2 = dao.basketList(m_code); // 장바구니 조회 
			
			String totalprice = dao.totalPrice(m_code);
			map.put("totalprice", totalprice);
			
			dao.close();
			
			req.setAttribute("basketList2", basketList2);
			req.setAttribute("map", map);
			
			req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);

		} else {
			JSFunction.alertLocation(resp, "로그인하셔야 장바구니 페이지로 갈 수 있습니다.", "./login.do");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("갹갹갹");
		HttpSession session = req.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (!(session.getAttribute("m_id") == null)) {
			String m_id = (String) session.getAttribute("m_id");
			System.out.println(m_id + "= m_id");
			BasketDAO dao = new BasketDAO();
			
			BasketDTO dto = dao.memberInfo(m_id);
			// String m_code = dao.memberInfo(m_id); // 회원 코드 뽑아내기
			String m_code = dto.getM_code();
			
			
			System.out.println(dto.getB_count());
			System.out.println(dto.getM_code()); // d얘만 나옴
			System.out.println(dto.getB_price());
			List<BasketDTO> basketList = dao.basketList(m_code); // 장바구니 목록 조회(저장된 값들 가져오기)
			
			String default_p_totalprice = req.getParameter("default_p_totalprice");
			String p_totalprice1 = req.getParameter("p_totalprice");
			String p_code = req.getParameter("p_code");
			String b_count = req.getParameter("p_count");
			String p_name1 = req.getParameter("p_name");
			
			String p_totalprice = p_totalprice1.replaceAll(",", ""); 
			
			int pos = -1;
			// 제품이 있다면
			
			for(int i = 0; i < basketList.size(); i++) {
				dto = basketList.get(i);
				if(dto.getP_name().equals(p_name1)) {
					pos = 1;
					System.out.println("여기까지 오는가?");
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
						System.out.println("으갸갸갸");
						JSFunction.alertBack(resp, "제품 최대 주문 수량을 초과했습니다.");
						return;
					}
					
				}
			}
			
			// 동일한 제품이 없다면
			if(pos == -1) {
				dto.setM_code(m_code);
				dto.setB_price(p_totalprice);
				dto.setP_code(req.getParameter("p_code"));
				dto.setB_count(req.getParameter("p_count"));
				dto.setP_name(req.getParameter("p_name"));
				
				System.out.println("m_code" + m_code);
				System.out.println("p_name = " + p_name1);
				System.out.println("여기이이이이이이이p_code" + p_code);
				System.out.println("여기여깅p_totalprice" + p_totalprice);
				System.out.println("여기 " + b_count);
				
				
				
				int result = dao.putProduct(dto); // 제품 테이블에 insert
				if(result == 1) {
					
				}
			}
			
			List<BasketDTO> basketList2 = dao.basketList(m_code); // 장바구니 목록 조회
			
			String totalprice = dao.totalPrice(m_code);
			
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
