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
		
		String p_code = req.getParameter("p_code");
		System.out.println("어떻게 나올지 " + p_code);
		String m_id = (String) session.getAttribute("m_id");
		System.out.println(m_id + "아이디값");
		BasketDAO dao = new BasketDAO();
		
		BasketDTO dto = dao.memberInfo(m_id);
		// String m_code = dao.memberInfo(m_id); // 회원 코드 뽑아내기
		String m_code = dto.getM_code();
		
		List<BasketDTO> basketList2 = null;
		
		if(p_code == null) { // 전체 삭제
			dao.deleteProduct(m_code); // 전체 삭제
		} else {
			dao.deleteSelectedProduct(m_code, p_code); // 선택 제품 삭제
			
			basketList2 = dao.basketList(m_code); // 장바구니 목록 조회
		}
		
		dao.close();
		
		req.setAttribute("basketList2", basketList2);
		
		req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);
	}

}
