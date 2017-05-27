package com.llf.qqServer.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.llf.qqServer.server.QQserver;
import com.llf.qqServer.util.GetDaoEntity;

/**
 * 服务器管理入口界面
 * @author llf
 *
 */
public class ServerFrame extends JFrame implements ActionListener{

	JPanel jp1;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
	
		ServerFrame sf=new ServerFrame();
	}
	
	public ServerFrame()
	{
		Font font=new Font("宋体",Font.PLAIN,13);
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.setFont(font);
		jb1.setForeground(Color.white);
		jb1.setBackground(Color.decode("#09A3DC"));
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jb2.setFont(font);
		jb2.setForeground(Color.white);
		jb2.setBackground(Color.decode("#09A3DC"));
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setIconImage(new ImageIcon("img/qq.png").getImage());
		this.setTitle("服务");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==jb1)
		{
			GetDaoEntity ge=new GetDaoEntity();
			new QQserver();
		}
	}
}
