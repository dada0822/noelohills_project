package basket;

import java.io.IOException;
import java.util.List;

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
		
		if (!(session.getAttribute("m_id") == null)) { // 로그인되어있다면!
			
			String m_id = (String) session.getAttribute("m_id");
			
			BasketDAO dao = new BasketDAO();
			
			BasketDTO dto = dao.memberInfo(m_id);
			// String m_code = dao.memberInfo(m_id); // 회원 코드 뽑아내기
			String m_code = dto.getM_code();
			
			String p_totalprice = req.getParameter("p_totalprice");
			String p_count = req.getParameter("p_count1");
			String p_code = req.getParameter("p_co");
			System.out.println("여기이이이이이이이p_code" + p_code);
			System.out.println("여기여깅p_totalprice" + p_totalprice);
			System.out.println("여기 " + p_count);
			
			List<BasketDTO> basketList = dao.basketList(m_code); // 장바구니 조회 
		
			
			req.setAttribute("basketList", basketList);
			
			req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);

		} else {
			JSFunction.alertLocation(resp, "로그인하셔야 장바구니 페이지로 갈 수 있습니다.", "./login.do");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String m_id = (String) session.getAttribute("m_id");
		
		BasketDAO dao = new BasketDAO();
		
		BasketDTO dto = dao.memberInfo(m_id);
		// String m_code = dao.memberInfo(m_id); // 회원 코드 뽑아내기
		String m_code = dto.getM_code();
		
		String p_totalprice = req.getParameter("p_totalprice");
		String p_code = req.getParameter("p_code");
		String p_count = req.getParameter("p_count1");
		System.out.println("여기이이이이이이이p_code" + p_code);
		System.out.println("여기여깅p_totalprice" + p_totalprice);
		System.out.println("여기 " + p_count);
			
		int result = dao.putProduct(dto);
		
		List<BasketDTO> basketList = dao.basketList(m_code);
		
		

//		dao.close();
//		
//		
//		if (result == 1) { // 성공
//			resp.sendRedirect("./list.do");
//		} else { // 실패
//			resp.sendRedirect("./write.do");
//		}
		
		req.setAttribute("basketList", basketList);
		
		
		req.getRequestDispatcher("/pages/Basket.jsp").forward(req, resp);
	
	}
	

}
