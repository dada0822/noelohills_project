package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JSFunction;

public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String m_id = req.getParameter("m_id");
		String m_pw = req.getParameter("m_pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberCheck(m_id, m_pw);
		dao.close();
		
		if(dto.getM_id() != null) {
			HttpSession session = req.getSession();
			session.setAttribute("m_id", dto.getM_id());
			
			JSFunction.alertLocation(resp, dto.getM_id() + "님 환영합니다.", "../pages/Index.jsp");
		} else {
			JSFunction.alertBack(resp, "아이디 혹은 비밀번호가 유효하지 않습니다.");
		}
		
	}
}
