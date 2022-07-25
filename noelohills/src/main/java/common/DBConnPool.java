package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnPool {
	public Connection con; // �����ͺ��̽��� ������ ���
	public Statement stmt; // ���Ķ���Ͱ� ���� ���� �������� ���
	public PreparedStatement psmt; // ���Ķ���Ͱ� �ִ� ���� �������� ���
	public ResultSet rs; // SELECT �������� ����� ����
	
	public DBConnPool() {
		
		try {
			// �ڹ��� ���̹� ����(JNDI)���� �̸��� ���� ��ü�� �������ִ� ���� Context
			// Context�� �ٷ�� ���� ������ InitialContext()
			Context initCtx = new InitialContext();
			
			// "java:comp/env"��� �̸��� �μ��� Context ��ü�� ����
			// "java:comp/env" : ���� �� ���ø����̼��� ��Ʈ ���͸�
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			
			// "java:comp/env" �Ʒ��� ��ġ�� dbcp_myoracle �ڿ��� ������
			DataSource source = (DataSource)ctx.lookup("dbcp_myoracle");
			
			// ������ �ҽ��� ���� Ǯ�� �����Ǿ� �ִ� ���� ��ü�� ���ͼ�
			// ��������� �����ϸ� ��.
			con = source.getConnection();
			
			System.out.println("DB Ŀ�ؼ� Ǯ ���� ����");
		} catch(Exception e) {
			System.out.println("DB Ŀ�ؼ� Ǯ ���� ����");
			e.printStackTrace();
		}
		
	}
	
	// ���� ����
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("JDBC �ڿ� ��ü");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}