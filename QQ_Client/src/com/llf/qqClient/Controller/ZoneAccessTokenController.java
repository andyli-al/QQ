package com.llf.qqClient.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.llf.qqClient.util.DBUtil;

/**
 * 空间访问凭证申请表
 * @author llf
 *
 */
public class ZoneAccessTokenController {

	/**
	 * 生成并返回访问空间的凭证
	 * @return
	 */
	public String produceToken(int QQ_No,int QQ_No_Access)
	{
		    String tokenId=getTokenId();
			Connection con=DBUtil.getConnection();
			PreparedStatement pstmt = null;
			String sql="insert into zoneaccesstoken (zonetokenid,QQ_No,QQ_No_Access) values(?,?,?)";
			
			 try{
				 pstmt = con.prepareStatement(sql);
				 pstmt.setString(1, tokenId);
				 pstmt.setInt(2, QQ_No);
				 pstmt.setInt(3, QQ_No_Access);
				
				 pstmt.executeUpdate();
				 
			    } catch (SQLException e) {
			    	e.printStackTrace();
				} finally {
					DBUtil.close(pstmt,con);
				}

		return tokenId;	
	}
	
	public static String getTokenId()
	{
		String data="abcdefg123456789";
		StringBuffer buff = new StringBuffer();
		Random random = new Random();
		//随机抽取字符,组成一个8位字符串
	    for (int i = 0; i<8; i++) {
	    //从16个字符中随机取字符
	    int index = random.nextInt(16);
	    //截取一个字符
		String str = data.substring(index, index+1);
				    
		buff.append(str);
	  }
		
	    return buff.toString();
	}
}
