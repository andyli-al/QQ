package com.llf.qqServer.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.llf.qqServer.util.DBUtil;
import com.llf.qqcommon.pojo.QQUser;

/**
 * QQ用户登录验证
 * @author llf
 *
 */
public class QQUserLoginController {
	
     
	/**
	 * 用户登录验证(使用纯jdbc,以避免每次启动spring容器加载的费时)
	 * @param QQ_No
	 * @param QQ_pswd
	 * @return QQUser
	 */
		public QQUser login(int QQ_No,String QQ_pswd)
		{
			QQUser qquser=null;
			Connection con=DBUtil.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			String sql="select * from QQUser where QQ_No=? and QQ_pswd=?";
			
			 try{
				 pstmt = con.prepareStatement(sql);
				 pstmt.setInt(1, QQ_No);
				 pstmt.setString(2, QQ_pswd);
				 rs = pstmt.executeQuery();
				 if(rs.next()){
				    qquser=new QQUser();
				    qquser.setQQ_No(rs.getInt("QQ_No"));
				    qquser.setQQ_pswd(rs.getString("QQ_pswd"));
				    qquser.setQQ_webname(rs.getString("QQ_webname"));
				    qquser.setQQ_sign(rs.getString("QQ_sign"));
				    qquser.setU_sex(rs.getString("u_sex"));
				    qquser.setU_age(rs.getInt("u_age"));
				    qquser.setU_education(rs.getString("u_education"));
				    qquser.setU_hometown(rs.getString("u_hometown"));
				    qquser.setU_staycity(rs.getString("u_staycity"));
				    qquser.setU_profession(rs.getString("u_profession"));
				    qquser.setU_birthday(rs.getDate("u_birthday"));
					
				    //更改QQ号状态为在线
				    pstmt.execute("update QQUser set isOnline=1 where QQ_No="+QQ_No+"");
				    
				 }
			    } catch (SQLException e) {
			    	e.printStackTrace();
				} finally {
					DBUtil.close(rs, pstmt,con);
				}

			return qquser;
			
		}

}
