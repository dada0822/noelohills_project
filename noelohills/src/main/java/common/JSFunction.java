package common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JSFunction {
	
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		
		try {
			// �۾��� 12. �������� ������ ����ϱ� ���� ������ Ÿ�� ����
			resp.setContentType("text/html;charset=UTF-8");
			 
			// �۾��� 13. getWriter() �޼��带 ���� PrintWriter ��ü ����
			PrintWriter writer = resp.getWriter();
			
			// �۾��� 14. ǥ���ϰ��� �ϴ� ��ũ��Ʈ �ڵ带 �ϳ��� ���ڿ��� ����� �������� ��� �����
			String script = "<script>alert('" + msg + "'); location.href='" + url + "';</script>";
			writer.print(script);
		} catch (Exception e) { }
	}
	
	// ���� 38. �������� �˸�â ǥ���ϰ� ���� �������� ���ư�
	public static void alertBack(HttpServletResponse resp, String msg) {
		
		try {
			// ���� 39. ������ ������ ����ϱ� ���� ������ Ÿ�� ����
			resp.setContentType("text/html;charset=UTF-8");
			
			// ���� 40. getWriter() �޼��带 ���� PrintWriter ��ü ����
			PrintWriter writer = resp.getWriter();
			
			// ���� 41. ǥ���ϰ��� �ϴ� ��ũ��Ʈ �ڵ带 �ϳ��� ���ڿ��� ����� �������� ��� �����
			// history.back() ���� �������� �̵�
			String script = "<script>"
							+ "alert('" + msg + "');"
							+ "history.back();"
							+ "</script>";
			writer.print(script);
		} catch (Exception e) { }
	}
}