package com.llf.qqClient.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库jdbc工具
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
			System.out.println("配置文件名称不正确");
		}
	}
	
	//得到连接
	public static Connection getConnection(){
        String driverClass=p.getProperty("jdbc.driverClass").trim();
        String url=p.getProperty("jdbc.jdbcUrl").trim();
		String username = p.getProperty("jdbc.user").trim();
		String password = p.getProperty("jdbc.password").trim();
		Connection con = null;
		try{
			Class.forName(driverClass);
		}catch(ClassNotFoundException e){
			System.out.println("驱动文件未导入到工程");
		}
		
		try {
			con = DriverManager.getConnection(url,username,password);

		} catch (SQLException e) {
			System.out.println("数据库的链接项不正确，创建链接失败");
		} 
		return con;
	}
	
	//关闭资源
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
