package com.llf.qqClient.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���ݿ�jdbc����
 * @author llf
 *
 */
public class DBUtil {
	
	private static Properties p = new Properties();
	
	private static DBUtil d = new DBUtil();
	static {
		try{
			p.load(d.getClass().getResourceAsStream("/db.properties"));
		}catch(IOException e){
			System.out.println("�����ļ����Ʋ���ȷ");
		}
	}
	
	//�õ�����
	public static Connection getConnection(){
        String driverClass=p.getProperty("jdbc.driverClass").trim();
        String url=p.getProperty("jdbc.jdbcUrl").trim();
		String username = p.getProperty("jdbc.user").trim();
		String password = p.getProperty("jdbc.password").trim();
		Connection con = null;
		try{
			Class.forName(driverClass);
		}catch(ClassNotFoundException e){
			System.out.println("�����ļ�δ���뵽����");
		}
		
		try {
			con = DriverManager.getConnection(url,username,password);

		} catch (SQLException e) {
			System.out.println("���ݿ���������ȷ����������ʧ��");
		} 
		return con;
	}
	
	//�ر���Դ
	public static void close(PreparedStatement pstm,Connection con)
	{
		try {
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
