package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.llf.qqClient.client.ManageClientToServerThread;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * 
 * @author llf
 * QQ聊天对话框
 */
public class QQChat extends JFrame implements ActionListener{
	
	/**
	 * index被选中的聊天好友索引
	 * mp绘图面板
	 * jl_top顶部图片背景标签,jl_friend_tx好友头像,jl_friend_msg好友网名和个性签名
	 * jb_exit关闭窗口按钮,jb_redu最小化窗口按钮,jb_faceQQ表情按钮,jb_shakeQQ抖动按钮,jb_voiceQQ语音按钮,jb_fileQQ文件按钮
	 * jb_check_note查看聊天记录按钮,jb_reset重置输入框按钮,jb_send发送聊天信息按钮
	 * jta_msg聊天信息显示框,jta_send编辑信息框
	 * jsp_msg负载聊天信息显示框的滚动条,jsp_send负载编辑框的滚动条
	 * jp_tool编辑工具栏面板
	 */
	private MyQQChatPanel mp;
	private JLabel jl_top,jl_friend_tx,jl_friend_msg;
	private JButton jb_exit,jb_redu,jb_face,jb_shake,jb_voice,jb_file,jb_check_note,jb_reset,jb_send;
	private JTextArea jta_msg,jta_send;
	private JScrollPane jsp_msg,jsp_send;
	private JPanel jp_tool;
	private static QQUser qquser;
	private static QQUser qqfriend;
	
	public QQChat(QQUser qu,QQUser qqf)
	{
		qquser=qu;
		qqfriend=qqf;
		
		Font font=new Font("楷体",Font.BOLD,16);
		Font font2=new Font("宋体",Font.PLAIN,13);
		
		mp=new MyQQChatPanel();
		mp.setLayout(null);
		
		jl_top=new JLabel(new ImageIcon("img/QQ_chat_top.png"));
		jl_top.setBounds(0, 0, 500, 100);
		
		jb_redu=new JButton(new ImageIcon("img/login_redu.png"));
		jb_redu.setToolTipText("最小化");
		jb_redu.addActionListener(this);
		jb_redu.setBounds(465, 0, 13, 13);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("关闭");
		jb_exit.addActionListener(this);
		jb_exit.setBounds(487, 0, 13, 13);
		
		jl_friend_tx=new JLabel(new ImageIcon("img/QQ_friend_tx2.jpg"));
		jl_friend_tx.setBounds(10, 20, 62, 62);
		
		jl_friend_msg=new JLabel(qqfriend.getQQ_sign()!=null?qqfriend.getQQ_webname()+"("+qqfriend.getQQ_sign()+")":qqfriend.getQQ_webname()+"( )");
		jl_friend_msg.setForeground(Color.lightGray);
		jl_friend_msg.setFont(font);
		jl_friend_msg.setBounds(80, 40, 200, 25);
		
		jta_msg=new JTextArea(30,50);
		jta_msg.setFont(font);
		jta_msg.setLineWrap(true);
		jta_msg.setBackground(Color.decode("#E6F2F9"));
		jsp_msg=new JScrollPane(jta_msg);
		jsp_msg.setBounds(1, 101, 498, 280);
		
		jp_tool=new JPanel();
		jp_tool.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jb_face=new JButton(new ImageIcon("img/QQ_face.png"));
		jb_face.setToolTipText("选择表情");
		//设置按钮大小(JPanel中组件)
		jb_face.setPreferredSize(new Dimension(30,30));
		jb_face.addActionListener(this);
		jp_tool.add(jb_face);
		
		jb_shake=new JButton(new ImageIcon("img/QQ_shake.png"));
		jb_shake.setToolTipText("发送抖动");
		//设置按钮大小(JPanel中组件)
		jb_shake.setPreferredSize(new Dimension(30,30));
		jb_shake.addActionListener(this);
		jp_tool.add(jb_shake);
		
		jb_voice=new JButton(new ImageIcon("img/QQ_voice.png"));
		jb_voice.setToolTipText("发送语音");
		//设置按钮大小(JPanel中组件)
		jb_voice.setPreferredSize(new Dimension(30,30));
		jb_voice.addActionListener(this);
		jp_tool.add(jb_voice);
		
		jb_file=new JButton(new ImageIcon("img/QQ_file.png"));
		jb_file.setToolTipText("发送文件");
		//设置按钮大小(JPanel中组件)
		jb_file.setPreferredSize(new Dimension(30,30));
		jb_file.addActionListener(this);
		jp_tool.add(jb_file);
		
		jb_check_note=new JButton(new ImageIcon("img/QQ_note.png"));
		jb_check_note.setToolTipText("查看消息记录");
		jb_check_note.setBounds(400, 385, 76, 30);
		jb_check_note.addActionListener(this);
	
		jp_tool.setBounds(1, 381, 498, 35);
		
		jta_send=new JTextArea(30,30);
		jta_send.setFont(font);
		jta_send.setLineWrap(true);
		jta_send.setBackground(Color.decode("#E6F2F9"));
		jsp_send=new JScrollPane(jta_send);
		jsp_send.setBounds(1, 422, 498, 110);
		
		jb_reset=new JButton("重 置");
		jb_reset.setFont(font2);
		jb_reset.addActionListener(this);
		jb_reset.setBackground(Color.decode("#C3E8F6"));
		jb_reset.setBounds(332, 540, 70, 28);
		
		jb_send=new JButton("发 送");
		jb_send.setFont(font2);
		jb_send.addActionListener(this);
		jb_send.setBackground(Color.decode("#C3E8F6"));
		jb_send.setBounds(412, 540, 70, 28);
		
		mp.add(jl_top,-1);
		mp.add(jb_redu,0);
		mp.add(jb_exit,0);
		mp.add(jl_friend_tx,0);
		mp.add(jl_friend_msg,0);
		mp.add(jsp_msg,0);
		mp.add(jp_tool,-1);
		mp.add(jb_check_note,0);
		mp.add(jsp_send,0);
		mp.add(jb_reset,0);
		mp.add(jb_send,0);
		
		this.add(mp);
		this.addMouseListener(mp);
		this.addMouseMotionListener(mp);
		
		this.setIconImage(new ImageIcon("img/QQ_friend_tx2.jpg").getImage());
		this.setSize(500,580);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		
		MyQQChatPanel.setqqc(this);
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
				//关闭窗口
				this.dispose();
			}
			else if(e.getSource()==jb_face)
			{
				System.out.println("QQ表情");
			}
			else if(e.getSource()==jb_shake)
			{
				System.out.println("发送抖动");
			}
			else if(e.getSource()==jb_voice)
			{
				System.out.println("QQ语音");
			}
			else if(e.getSource()==jb_file)
			{
				System.out.println("发送文件");
			}
			else if(e.getSource()==jb_check_note)
			{
				System.out.println("消息记录");
			}
			else if(e.getSource()==jb_reset)
			{
				System.out.println("重置");
			}
			else if(e.getSource()==jb_send)
			{
				Message m=new Message();
				m.setMesType("3");
				m.setSenderQQNo(qquser.getQQ_No());
				m.setSender(qquser.getQQ_webname());
				m.setGetterQQNo(qqfriend.getQQ_No());
				m.setGetter(qqfriend.getQQ_webname());
				m.setContent(jta_send.getText());
				m.setSendTime(new SimpleDateFormat("yyyy-MM-dd HH：mm：ss").format(new Date()));
				
				try{
					ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
					oos.writeObject(m);
		
				}catch(Exception e2){
					e2.printStackTrace();
				}
				
			}
		
	}

	//显示消息
	public void showMsg(Message m)
	{
		String info=m.getSendTime()+"\r\n"+m.getSender()+" 对  "+m.getGetter()+" 说: "+m.getContent()+"\r\n";
		jta_msg.append(info);
	}

}

class MyQQChatPanel extends JPanel implements MouseListener,MouseMotionListener
{

	//当前QQ聊天面板窗体对象
	private static QQChat qqc=null;
	//初始选中面板点横坐标
	private static int x;
	//初始选中面板点纵坐标
	private static int y;
	
	public static void setqqc(QQChat qqchat)
	{
		qqc=qqchat;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		//绘制面板边框线
		g.drawRect(0, 0, 499, 579);
		//绘制QQ头像边框线
		g.drawRect(9, 19, 63, 63);
		g.setColor(Color.black);
		g.drawLine(0, 100, 500, 100);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		//随着鼠标的拖拽改变窗体位置（每次的改变量为鼠标每次拖拽移动的坐标差量）
		 qqc.setLocation(qqc.getLocation().x+(e.getX()-x) , qqc.getLocation().y+(e.getY()-y));
		 //重新改变鼠标初始坐标
		 x=e.getY();
		 y=e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		
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
}
