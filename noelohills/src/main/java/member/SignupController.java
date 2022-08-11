package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.JSFunction;

public class SignupController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/pages/Signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		String m_name = req.getParameter("m_name");
		String m_address = req.getParameter("m_address");
		String m_id = req.getParameter("m_id");
		String m_pw = req.getParameter("m_pw");
		String m_email = req.getParameter("m_email");
		String m_tel = req.getParameter("m_tel");
		
		dto.setM_name(m_name);
		dto.setM_address(m_address);
		dto.setM_id(m_id);
		dto.setM_pw(m_pw);
		dto.setM_email(m_email);
		dto.setM_tel(m_tel);
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.insertMember(dto); // 회원 정보 DB에 저장
		
		dao.close();
		
		if (result == 1) {
			JSFunction.alertLocation(resp, "가입이 완료되었습니다.", "../pages/Index.jsp");
		}else {
			JSFunction.alertBack(resp, "중복된 아이디입니다.");
		}
		
	}
}
