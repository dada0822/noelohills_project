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
		
		String m_code = req.getParameter("m_code");
		String m_name = req.getParameter("m_name");
		String m_address = req.getParameter("m_address");
		String m_id = req.getParameter("m_id");
		String m_pw = req.getParameter("m_email");
		String m_tel = req.getParameter("m_tel");
		
		dto.setM_code(m_code);
		dto.setM_name(m_name);
		dto.setM_address(m_address);
		dto.setM_id(m_id);
		dto.setM_pw(m_pw);
		dto.setM_tel(m_tel);
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.insertMember(dto);
		
		dao.close();
		
		if (result == 1) {
			JSFunction.alertLocation(resp, "������ �Ϸ�Ǿ����ϴ�.", "../pages/Index.jsp");
		}else {
			JSFunction.alertBack(resp, "�ߺ��� ���̵��Դϴ�.");
		}
		
	}
}
