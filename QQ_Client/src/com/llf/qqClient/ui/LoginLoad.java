package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author llf
 * ���ڵ�½�н���
 */
public class LoginLoad extends JDialog implements ActionListener{
	
	public static Thread t;
	private MyLoginLoadPanel mp;
	private JLabel jl_top,jl_tx;
	private JButton jb_cancel,jb_exit;
	
	public LoginLoad()
	{
		Font font=new Font("����",Font.PLAIN,13);
		
		mp=new MyLoginLoadPanel();
		mp.setLayout(null);
		jl_top=new JLabel(new ImageIcon("img/login_top.jpg"));
		jl_top.setBounds(0, 0, 430, 180);
		
		jl_tx=new JLabel(new ImageIcon("img/tx.png"));
		jl_tx.setBounds(165, 190, 80, 80);
		
		jb_cancel=new JButton("ȡ ��");
		jb_cancel.setFont(font);
		jb_cancel.setForeground(Color.white);
		jb_cancel.setBackground(Color.decode("#09A3DC"));
		jb_cancel.addActionListener(this);
		jb_cancel.setBounds(115, 280, 192, 30);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("�ر�");
		jb_exit.addActionListener(this);
		jb_exit.setBounds(415, 0, 15, 15);
		
		mp.setBounds(0, 0, 430, 180);
		
		mp.add(jl_top,-1);
		mp.add(jb_exit,0);
		mp.add(jl_tx);
		mp.add(jb_cancel);
		
		this.add(mp);
		this.setIconImage(new ImageIcon("img/qq.png").getImage());
		this.setSize(430,330);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//����JFrameװ��(ȥ���߿�)
		this.setUndecorated(true);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb_exit)
		{
			System.exit(0);
		}
		else if(e.getSource()==jb_cancel)
		{
			//�رյ�ǰ����,�ص���½����
			this.dispose();
			Login login=new  Login();
		}
		
	}
	
}

/**
 * 
 * @author llf
 * ���ڵ�½�л�ͼ���
 */
class MyLoginLoadPanel extends JPanel implements Runnable
{
	private static int temp=0;
	
	public MyLoginLoadPanel()
	{
		LoginLoad.t=new Thread(this);
		LoginLoad.t.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font("����",Font.BOLD,15));
		g.setColor(Color.gray);
		if(temp%5==0)
		{
			g.drawString("���ڵ�½��...", 160, 155);
		}
	}

	@Override
	public void run() {
	 
		while(true)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temp++;
			this.repaint();
		}
	}
}
