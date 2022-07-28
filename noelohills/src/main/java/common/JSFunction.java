package common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JSFunction {
	
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		
		try {
			// 글쓰기 12. 서블릿에서 내용을 출력하기 위해 콘텐츠 타입 지정
			resp.setContentType("text/html;charset=UTF-8");
			 
			// 글쓰기 13. getWriter() 메서드를 통해 PrintWriter 객체 얻어옴
			PrintWriter writer = resp.getWriter();
			
			// 글쓰기 14. 표현하고자 하는 스크립트 코드를 하나의 문자열로 만들어 서블릿에서 즉시 출력함
			String script = "<script>alert('" + msg + "'); location.href='" + url + "';</script>";
			writer.print(script);
		} catch (Exception e) { }
	}
	
	// 수정 38. 서블릿에서 알림창 표시하고 이전 페이지로 돌아감
	public static void alertBack(HttpServletResponse resp, String msg) {
		
		try {
			// 수정 39. 서블릿에 내용을 출력하기 위해 콘텐츠 타입 지정
			resp.setContentType("text/html;charset=UTF-8");
			
			// 수정 40. getWriter() 메서드를 통해 PrintWriter 객체 얻어옴
			PrintWriter writer = resp.getWriter();
			
			// 수정 41. 표현하고자 하는 스크립트 코드를 하나의 문자열로 만들어 서블릿에서 즉시 출력함
			// history.back() 직전 페이지로 이동
			String script = "<script>"
							+ "alert('" + msg + "');"
							+ "history.back();"
							+ "</script>";
			writer.print(script);
		} catch (Exception e) { }
	}
}