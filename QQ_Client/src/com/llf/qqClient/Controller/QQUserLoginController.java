package com.llf.qqClient.Controller;

import com.llf.qqClient.client.QQClientUser;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * QQ用户登录验证
 * @author llf
 *
 */
public class QQUserLoginController {
	
	   /**
	   * 用户登录验证
	   */
		public Message login(QQUser qquser)
		{
			return new QQClientUser().sendLoginInfoToServer(qquser);
		}
		

}
