/**
 * 定义包的种类
 */
package com.llf.qqcommon.pojo;

public interface MessageType {

	String message_login_succeed="1";//表明是登陆成功
	String message_login_fail="2";//表明登录失败
	String message_comm_mes="3";//普通信息包
	String message_logout="4";//退出登录请求
	String message_show_friendMsg="5";//获取好友资料的请求
	String qquseredit_send="6";//发送更改QQ资料请求
	String qquseredit_succeed="7";//更改QQ资料成功
	String qqfriendonlineMsg="8";//好友上线提示
	String qqfrienddroplineMsg="9";//好友下线提示
	String message_addfriend="10";//添加好友请求
	String message_deletefriend="11";//删除好友请求
	String message_searchByQQ="12";//根据QQ号查询
	String message_searchBywebname="13";//根据昵称关键字查询
	String message_searchResult="14";//QQ查询结果返回
	String message_addfriend_succeed="15";//添加好友成功
	String message_deletefriend_succeed="16";//删除好友成功
	
}
