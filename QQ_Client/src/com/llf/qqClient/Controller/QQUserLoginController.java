package com.llf.qqClient.Controller;

import com.llf.qqClient.client.QQClientUser;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * QQ�û���¼��֤
 * @author llf
 *
 */
public class QQUserLoginController {
	
	   /**
	   * �û���¼��֤
	   */
		public Message login(QQUser qquser)
		{
			return new QQClientUser().sendLoginInfoToServer(qquser);
		}
		

}
