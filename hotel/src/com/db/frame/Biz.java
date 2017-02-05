package com.db.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz {
	
	public Biz(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection con = null;
		String user = "bigdata04";
		String password = "111111";
		String url = "jdbc:oracle:thin:@70.12.111.64:1521:XE";
		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);	//�̰ž����� insert delete update�ٷε� ������ Ŀ�԰� �ѹ��� �ѹ�������� �׾ȿ� ���α׷��ֵ�������
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void register(Object obj) throws Exception;
	public abstract void modify(Object obj) throws Exception;
	public abstract void remove(Object obj) throws Exception;
	public abstract Object get(Object obj) throws Exception;
	public abstract ArrayList<Object> get() throws Exception;
}
































