package com.llf.qqClient.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.llf.qqClient.Controller.QQUserController;
import com.llf.qqClient.Controller.ZoneAccessTokenController;
import com.llf.qqClient.client.ClientServerThread;
import com.llf.qqClient.client.ManageClientToServerThread;
import com.llf.qqClient.client.ManageQQChat;
import com.llf.qqClient.client.ManageSearchPanel;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;
/**
 * 
 * @author Administrator
 * 登陆成功后QQ面板
 */
public class QQPanel extends JFrame implements ActionListener{
	
	/**
	 * mp,绘图面板
	 * jl_top面板顶部背景图片,jl_title面板标题,jl_tx面板QQ头像,jl_webname网名,jl_sign个性签名
	 * jl_qqzoneQQ空间图标,jl_emailQQ邮箱图标,jl_friend_titleQQ好友标题
	 * jb_exit注销登录按钮,jb_redu窗口最小化按钮,jb_user_data用户个人资料按钮,jb_install设置按钮,jb_find查找按钮
	 * jtp页签组件,jp_friendQQ好友面板,jp_qqzone好友最新动态面板,jp_session聊天列表面板,jp_friend_listQQ好友列表信息面板,jp_bottom面板底部组件面板
	 * jsp负载QQ好友面板的滚动条
	 * jp右键弹出菜单
	 * jmi_check查看好友资料子菜单,jmi_visit访问QQ空间子菜单,jmi_delete删除好友子菜单
	 * jl_fl好友列表标签组
	 * index好友标签索引
	 * hm_jl_msg好友标签和其索引的集合
	 */
	private MyQQPanel mp;
	private JLabel jl_top,jl_title,jl_tx,jl_webname,jl_sign,jl_qqzone,jl_email,jl_friend_title;
	private JButton jb_exit,jb_redu,jb_user_data,jb_install,jb_find;
	private JTabbedPane jtp;
	private JPanel jp_friend,jp_qqzone,jp_session,jp_friend_list,jp_bottom;
	private JScrollPane jsp;
	public static JPopupMenu jp;
	private JMenuItem jmi_check,jmi_visit,jmi_delete;
	private static JLabel[] jl_fl=new JLabel[20];
	public static HashMap<QQUser,JLabel> hm_jl_msg=new HashMap<QQUser,JLabel>();
	public static QQUser qquser;
	public static List<QQUser> qqfs;
	private static QQPanel qp;
	public static QQUser qu_key;
	
	/**
	 * 更新好友列表(好友上线)
	 * @param m
	 */
	public void updateFriendlist_online(Message m)
	{
		for(int i=0;i<qqfs.size();i++)
		{
			if(qqfs.get(i).getQQ_No()==m.getSenderQQNo())
			{
				jl_fl[i].setEnabled(true);
				break;
			}
		}
		
	}
	
	/**
	 * 更新好友列表(好友下线)
	 * @param m
	 */
	public void updateFriendlist_dropline(Message m)
	{
		for(int i=0;i<qqfs.size();i++)
		{
			if(qqfs.get(i).getQQ_No()==m.getSenderQQNo())
			{
				jl_fl[i].setEnabled(false);
				break;
			}
		}
		
	}
	
	/**
	 * 添加好友，重构好友列表
	 * @param qu_r
	 * @param qqfriends_r
	 */
	public void recreateUI(QQUser qu_r,List<QQUser> qqfriends_r)
	{
		QQPanel.qp.dispose();
		QQPanel qp=new QQPanel(qu_r,qqfriends_r);
	}
	
	public QQPanel(QQUser qu,List<QQUser> qqfriends)
	{
		qp=this;
		qquser=qu;
		qqfs=qqfriends;
		mp=new MyQQPanel();
		mp.setLayout(null);
		
		Font font=new Font("宋体",Font.BOLD,15);
		Font font2=new Font("楷体",Font.BOLD,13);
		Font font3=new Font("楷体",Font.BOLD,15);
		
		jl_top=new JLabel(new ImageIcon("img/QQPanel_top.jpg"));
		jl_top.setBounds(0, 0, 280, 115);
		
		jl_title=new JLabel("QQ2017");
		jl_title.setFont(font);
		jl_title.setForeground(Color.black);
		jl_title.setBounds(3, -3, 70, 30);
		
		jl_tx=new JLabel(new ImageIcon("img/tx2.png"));
		jl_tx.setBounds(7, 48, 62, 62);
		
		jl_webname=new JLabel(qquser.getQQ_webname());
		jl_webname.setFont(font);
		jl_webname.setBounds(75, 45, 50, 25);
		
		jl_sign=new JLabel(qquser.getQQ_sign());
		jl_sign.setFont(font2);
		jl_sign.setBounds(75, 70, 100, 25);
		
		jb_redu=new JButton(new ImageIcon("img/login_redu.png"));
		jb_redu.setToolTipText("最小化");
		jb_redu.addActionListener(this);
		jb_redu.setBounds(245, 0, 13, 13);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("注销登录");
		jb_exit.addActionListener(this);
		jb_exit.setBounds(267, 0, 13, 13);
		
		jl_qqzone=new JLabel(new ImageIcon("img/QQZone.jpg"));
		jl_qqzone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl_qqzone.setToolTipText("QQ空间");
		jl_qqzone.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			try{
				ZoneAccessTokenController zt=new ZoneAccessTokenController();
				String tokenId=zt.produceToken(qquser.getQQ_No(), qquser.getQQ_No());
				String url = "http://localhost:8080/QQ_Zone/loginzone.do?tokenId="+tokenId+"";
				String command = "cmd /c start firefox ";
				Runtime.getRuntime().exec(command + url);
			}catch(Exception ex){
			ex.printStackTrace();
			}
			}
			});
		jl_qqzone.setBounds(76, 95, 13, 13);
		
		jl_email=new JLabel(new ImageIcon("img/QQEmail.jpg"));
		jl_email.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl_email.setToolTipText("QQ邮箱");
		jl_email.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			try{
				String url = "";
				Runtime.getRuntime().exec("explorer " + url);
			}catch(Exception ex){
			ex.printStackTrace();
			}
			}
			});
		jl_email.setBounds(98, 95, 13, 13);
		
		jb_user_data=new JButton(new ImageIcon("img/user_data.jpg"));
		jb_user_data.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb_user_data.setToolTipText("我的资料");
		jb_user_data.addActionListener(this);
		jb_user_data.setBounds(120, 95, 14, 14);
		
		jtp=new JTabbedPane(); 
		jtp.setFont(font2);
		jtp.setBackground(Color.decode("#A2DBCB"));
		
		jp_friend=new JPanel();
		jp_friend.setLayout(new BorderLayout());
		jp_friend.setBackground(Color.white);
		jp_friend_list=new JPanel();
		jp_friend_list.setLayout(new GridLayout(100,1,0,6));
		jl_friend_title=new JLabel("我的好友",new ImageIcon("img/QQ_friend_title.png"),JLabel.LEFT);
		jl_friend_title.setFont(font3);
		jl_friend_title.setForeground(Color.gray);
		jp_friend_list.add(jl_friend_title);
		

		//创建弹出菜单
			    jp=new JPopupMenu();
				jmi_check=new JMenuItem("查看好友资料");
				jmi_check.setFont(font2);
				jmi_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				jmi_check.addActionListener(this);
				jmi_visit=new JMenuItem("访问QQ空间");
				jmi_visit.setFont(font2);
				jmi_visit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				jmi_visit.addActionListener(this);
				jmi_delete=new JMenuItem("删除好友");
				jmi_delete.setFont(font2);
				jmi_delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				jmi_delete.addActionListener(this);
				jp.add(jmi_check);
				jp.add(jmi_visit);
				jp.add(jmi_delete);
	
			QQUser qqf=null;
			for(int index=0;index<qqfs.size();index++)	
			{
				qqf=qqfs.get(index);
				jl_fl[index]=new JLabel(qqf.getQQ_sign()!=null?qqf.getQQ_webname()+"("+qqf.getQQ_sign()+")":qqf.getQQ_webname()+"( )",new ImageIcon("img/QQ_friend_tx.png"),JLabel.LEFT);
				if(qqf.getIsOnline()==0)
				{
					//该好友不在线
					jl_fl[index].setEnabled(false);
				}
				jl_fl[index].setFont(font2);
				hm_jl_msg.put(qqf, jl_fl[index]);
				jl_fl[index].addMouseListener(mp);
				jp_friend_list.add(jl_fl[index]);
			}
			
		jsp=new JScrollPane(jp_friend_list);
		jp_friend.add(jsp,BorderLayout.CENTER);
		
        jp_bottom=new JPanel();
		jp_bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		jb_install=new JButton(new ImageIcon("img/install.png"));
		jb_install.setToolTipText("设置");
		//设置按钮大小(JPanel中组件)
		jb_install.setPreferredSize(new Dimension(35,25));
		jb_install.addActionListener(this);
		jp_bottom.add(jb_install);
		jb_find=new JButton(new ImageIcon("img/find.png"));
		jb_find.setToolTipText("查找");
		//设置按钮大小(JPanel中组件)
		jb_find.setPreferredSize(new Dimension(60,25));
		jb_find.addActionListener(this);
		jp_bottom.add(jb_find);
		jp_friend.add(jp_bottom,BorderLayout.SOUTH);
		
		jp_qqzone=new JPanel();
		jp_qqzone.setBackground(Color.white);
		jp_session=new JPanel();
		jp_session.setBackground(Color.white);
		
		jtp.add("QQ好友",jp_friend);
		jtp.add("好友最新动态",jp_qqzone);
		jtp.add("消息列表",jp_session);
		jtp.setBounds(1, 115, 279, 535);
		
		//分层添加组件到画板上
		mp.add(jl_top,-1);
		mp.add(jl_title,0);
		mp.add(jl_tx,0);
		mp.add(jl_webname,0);
		mp.add(jl_sign,0);
		mp.add(jb_redu,0);
		mp.add(jb_exit,0);
		mp.add(jl_qqzone,0);
		mp.add(jl_email,0);
		mp.add(jb_user_data,0);
		mp.add(jtp);
		this.add(mp);
	    this.addMouseListener(mp);  
	    this.addMouseMotionListener(mp);
		
		this.setIconImage(new ImageIcon("img/qq.png").getImage());
		this.setSize(280, 650);
		this.setLocation(850, 50);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		
		MyQQPanel.setqqp(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb_redu)
		{
			//最小化窗口
			this.setExtendedState(JFrame.ICONIFIED);
		}
		else if(e.getSource()==jb_exit)
		{
			int i=JOptionPane.showConfirmDialog(null, "是否注销登录？","提示:", JOptionPane.YES_NO_OPTION);
			if(i==JOptionPane.OK_OPTION)
			{
			//退出登录(关闭资源并改变QQUser.isOnline为0)
			QQUserController qc=new QQUserController();
			qc.logout(qquser.getQQ_No());
			//关闭资源
			ClientServerThread cst=ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No());
			try {
				cst.getS().close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			cst.stop();
			
			System.exit(0);
			}
		}
		else if(e.getSource()==jb_user_data)
		{
			//打开个人资料框
			PersonalInfomation pi=new PersonalInfomation(0,qquser);
		}
		else if(e.getSource()==jb_install)
		{
			System.out.println("设置");
		}
		else if(e.getSource()==jb_find)
		{
			SearchQQAdd sqa=new SearchQQAdd(qquser);
			ManageSearchPanel.addSearchQQPanel(qquser.getQQ_No(), sqa);
		}
		else if(e.getSource()==jmi_check)
		{
			PersonalInfomation pi=new PersonalInfomation(1,QQPanel.qu_key);
		}
		else if(e.getSource()==jmi_visit)
		{
			ZoneAccessTokenController zt=new ZoneAccessTokenController();
			String tokenId=zt.produceToken(qquser.getQQ_No(),  QQPanel.qu_key.getQQ_No());
			String url = "http://localhost:8080/QQ_Zone/loginzone.do?tokenId="+tokenId+"";
			String command = "cmd /c start firefox ";
			try {
				Runtime.getRuntime().exec(command + url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==jmi_delete)
		{ 
			int i=JOptionPane.showConfirmDialog(null, "是否删除该好友？","提示:", JOptionPane.YES_NO_OPTION);
			if(i==JOptionPane.OK_OPTION)
			{
			QQUserController qc=new QQUserController();
			qc.deletefriend(qquser, QQPanel.qu_key);	
			}
		}
	}

}

class MyQQPanel extends JPanel implements MouseListener,MouseMotionListener
{
	//当前QQ面板窗体对象
	private static QQPanel qqp=null;
	//初始选中面板点横坐标
	private static int x;
	//初始选中面板点纵坐标
	private static int y;
	
	public static void setqqp(QQPanel qqpanel)
	{
		qqp=qqpanel;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		//绘制面板边框线
		g.drawRect(0, 0, 278, 648);
		//绘制QQ头像边框线
		g.drawRect(6, 47, 63, 63);
		//绘制面板顶部下划线
		g.drawLine(0, 115, 280, 115);
	}
	 
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//左键点击了好友标签
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			//判断选中了哪一个好友标签
			Iterator it=QQPanel.hm_jl_msg.keySet().iterator();
			while(it.hasNext())
			{
				QQUser key=(QQUser) it.next();
				if(e.getComponent()==(JLabel)QQPanel.hm_jl_msg.get(key))
				{
					//被选中的好友标签背景改变颜色
					//先取消标签透明,再设置背景色
					QQPanel.hm_jl_msg.get(key).setOpaque(true);
					QQPanel.hm_jl_msg.get(key).setBackground(Color.decode("#B7EADE"));
					
				}else
				{
				//其他好友标签颜色恢复与好友列表面板同背景色
					QQPanel.hm_jl_msg.get(key).setOpaque(false);
					QQPanel.hm_jl_msg.get(key).setBackground(Color.white);
				}
			}
		}
	
		//右键点击了好友标签,弹出右键菜单
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			//判断选中了哪一个好友标签
			Iterator it=QQPanel.hm_jl_msg.keySet().iterator();
			while(it.hasNext())
			{
				QQUser key=(QQUser) it.next();
				if(e.getComponent()==(JLabel)QQPanel.hm_jl_msg.get(key))
				{
					//弹出右键菜单
					QQPanel.jp.show((JLabel)QQPanel.hm_jl_msg.get(key),e.getX(),e.getY());
					QQPanel.qu_key=key;
					//被选中的好友标签背景改变颜色
					//先取消标签透明,再设置背景色
					QQPanel.hm_jl_msg.get(key).setOpaque(true);
					QQPanel.hm_jl_msg.get(key).setBackground(Color.decode("#B7EADE"));
					
				}else
				{
				   //其他好友标签颜色恢复与好友列表面板同背景色
					QQPanel.hm_jl_msg.get(key).setOpaque(false);
					QQPanel.hm_jl_msg.get(key).setBackground(Color.white);
				}
			}
		}
		
		//鼠标双击了,打开与好友的聊天对话框
		if(e.getClickCount()==2)
		{
			//判断选中了哪一个好友标签
			Iterator it=QQPanel.hm_jl_msg.keySet().iterator();
			while(it.hasNext())
			{
				QQUser key=(QQUser) it.next();
				if(e.getComponent()==(JLabel)QQPanel.hm_jl_msg.get(key))
				{
					//打开聊天对话框
					QQChat qqchat=new QQChat(QQPanel.qquser,key);
					//把聊天界面加入到管理类
					ManageQQChat.addQQChat(QQPanel.qquser.getQQ_No()+","+key.getQQ_No(), qqchat);
					
					//被选中的好友标签背景改变颜色
					//先取消标签透明,再设置背景色
					QQPanel.hm_jl_msg.get(key).setOpaque(true);
					QQPanel.hm_jl_msg.get(key).setBackground(Color.decode("#B7EADE"));
				
				}else
				{
					 //其他好友标签颜色恢复与好友列表面板同背景色
					QQPanel.hm_jl_msg.get(key).setOpaque(false);
					QQPanel.hm_jl_msg.get(key).setBackground(Color.white);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
      
		//获取鼠标在面板区域按下的初始坐标
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		//随着鼠标的拖拽改变窗体位置（每次的改变量为鼠标每次拖拽移动的坐标差量）
		 qqp.setLocation(qqp.getLocation().x+(e.getX()-x) , qqp.getLocation().y+(e.getY()-y));
		 //重新改变鼠标初始坐标
		 x=e.getY();
		 y=e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
		
	}
}
