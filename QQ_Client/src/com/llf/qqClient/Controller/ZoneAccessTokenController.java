package com.llf.qqClient.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.llf.qqClient.util.DBUtil;

/**
 * �ռ����ƾ֤�����
 * @author llf
 *
 */
public class ZoneAccessTokenController {

	/**
	 * ���ɲ����ط��ʿռ��ƾ֤
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
		//�����ȡ�ַ�,���һ��8λ�ַ���
	    for (int i = 0; i<8; i++) {
	    //��16���ַ������ȡ�ַ�
	    int index = random.nextInt(16);
	    //��ȡһ���ַ�
		String str = data.substring(index, index+1);
				    
		buff.append(str);
	  }
		
	    return buff.toString();
	}
}
