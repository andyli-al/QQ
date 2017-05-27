package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.llf.qqClient.Controller.QQUserLoginController;
import com.llf.qqClient.util.LoginTimerTask;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;
/**
 * 
 * @author llf
 * QQ��¼����
 *
 */
public class Login extends JFrame implements ActionListener,MouseListener{
	
	private LoginPanel lp;
	private JLabel jl_top,jl_tx,jl_reg,jl_find;
	private static JTextField jl_qqno;
	private static JPasswordField j_pswd;
	private JCheckBox jc_rem,jc_auto;
	private JButton jb_login,jb_exit,jb_redu; 
	
	public Login()
	{
		lp=new LoginPanel();
		lp.setLayout(null);
	    
	    Font font=new Font("����",Font.PLAIN,13);
	    
		jl_top=new JLabel(new ImageIcon("img/login_top.jpg"));
		jl_top.setBounds(0, 0, 430, 180);
		
		jl_tx=new JLabel(new ImageIcon("img/tx.png"));
		jl_tx.setBounds(40, 190, 80, 80);
		
		jl_qqno=new JTextField();
		jl_qqno.setFont(font);
		//���ñ߿���ɫ
		jl_qqno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127,157,185)));
		jl_qqno.setForeground(Color.gray);
	    jl_qqno.setText("��¼�˺�"); 
		jl_qqno.addMouseListener(this);
		jl_qqno.setBounds(135, 190, 192, 30);
		j_pswd=new JPasswordField();
		j_pswd.setFont(font);
		//���ñ߿���ɫ
		j_pswd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127,157,185)));
		j_pswd.setForeground(Color.gray);
		j_pswd.setText("����");
		//��ʾ��Ϣ����������ʾ
		j_pswd.setEchoChar('\0');
		j_pswd.addMouseListener(this);
	    j_pswd.setBounds(135, 221, 192, 30); 
		
		jc_rem=new JCheckBox("��ס����");
		jc_rem.setFont(font);
		jc_rem.setForeground(Color.gray);
		jc_rem.setBounds(130, 251, 90, 20);
		jc_auto=new JCheckBox("�Զ���¼");
		jc_auto.setFont(font);
		jc_auto.setForeground(Color.gray);
		jc_auto.setBounds(255, 251, 90, 20);
		
		jb_login=new JButton("�� ȫ �� ¼");
		jb_login.setFont(font);
		jb_login.setForeground(Color.white);
		jb_login.setBackground(Color.decode("#09A3DC"));
		jb_login.addActionListener(this);
		jb_login.setBounds(130, 280, 192, 30);
		
		jl_reg=new JLabel("<html><a style='color:#2786E4;text-decoration:none' href='http://www.baidu.com'>ע���˺�</a></html>");
		jl_reg.setFont(font);
		jl_reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl_reg.setToolTipText("���ע���˺�");
		jl_reg.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			try{
				String url = "http://localhost:8080/QQ_Zone/to_register.do";
				Runtime.getRuntime().exec("explorer " + url);
			}catch(Exception ex){
			ex.printStackTrace();
			}
			}
			});
		jl_reg.setBounds(330, 190, 70, 25);
		
		jl_find=new JLabel("<html><a style='color:#2786E4;text-decoration:none' href='http://www.baidu.com'>�һ�����</a></html>");
		jl_find.setFont(font);
		jl_find.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl_find.setToolTipText("����һ�����");
		jl_find.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			try{
				String url = "http://www.baidu.com";
				Runtime.getRuntime().exec("explorer " + url);
			}catch(Exception ex){
			ex.printStackTrace();
			}
			}
			});
		jl_find.setBounds(330, 220, 70, 25);
		
		jb_redu=new JButton(new ImageIcon("img/login_redu.png"));
		jb_redu.setToolTipText("��С��");
		jb_redu.addActionListener(this);
		jb_redu.setBounds(390, 0, 15, 15);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("�ر�");
		jb_exit.addActionListener(this);
		jb_exit.setBounds(415, 0, 15, 15);
		
		lp.addMouseListener(this);
		
		lp.add(jl_top,-1);
		lp.add(jl_tx);
		lp.add(jl_qqno);
		lp.add(j_pswd);
		lp.add(jc_rem);
		lp.add(jc_auto);
		lp.add(jb_login);
		lp.add(jl_reg);
		lp.add(jl_find);
		lp.add(jb_redu,0);
		lp.add(jb_exit,0);
		
		this.add(lp); 
		
		this.setIconImage(new ImageIcon("img/qq.png").getImage());
		this.setSize(430,330);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//����JFrameװ��(ȥ���߿�)
		this.setUndecorated(true);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		Login login=new Login();
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==jb_redu)
		{
			//��С������
			this.setExtendedState(JFrame.ICONIFIED);
		}
		else if(e.getSource()==jb_exit)
		{
			System.exit(0);
		}
		else if(e.getSource()==jb_login)
		{ 
			Font font_msg=new Font("����",Font.PLAIN,14);
			//������Ϣ������
			UIManager.put("OptionPane.font",font_msg);
			UIManager.put("OptionPane.messageFont",font_msg);
			UIManager.put("OptionPane.buttonFont",font_msg);
			if(jl_qqno.getText().equals("")||jl_qqno.getText().equals("��¼�˺�"))
			{
			    JOptionPane.showMessageDialog(null, "�������¼�˺�!");
			}else if(j_pswd.getText().equals("")||j_pswd.getText().equals("����"))
			{
				JOptionPane.showMessageDialog(null, "�������¼����!");
			}else
			{
			QQUserLoginController qc=new QQUserLoginController();
			QQUser qquser=new QQUser();
			qquser.setQQ_No(Integer.parseInt(jl_qqno.getText()));
			qquser.setQQ_pswd(j_pswd.getText());
			Message m=qc.login(qquser);
			
			if(m==null)
			{
				JOptionPane.showMessageDialog(null, "��¼�˺Ż��������!");
			}else
			{
			if(m.getMesType().equals("1"))
			{
			 QQUser qu=m.getQquser();
			 List<QQUser> qqfriends=m.getQqfriends();
			
			 //ͨ����֤��5���رմ���,��½�ɹ�
			    this.dispose();
	            //�������ڵ�½������
				LoginLoad lolod=new LoginLoad();
				LoginTimerTask.setdata(lolod, qu,qqfriends);
				 TimerTask task = new LoginTimerTask();       
				 Timer timer = new Timer();
			    timer.schedule(task, 5000); 
			}
			}
			
		   }
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	   if(e.getComponent()==jl_qqno)
	   {
	        jl_qqno.setText("");
	        jl_qqno.setForeground(Color.black);
	   }else if(e.getComponent()==j_pswd)
	   {
		  j_pswd.setText("");
		  //��������������ʾ*
		  j_pswd.setEchoChar('*');
		  j_pswd.setForeground(Color.black);
	   }else
	   {
		  if(jl_qqno.getText().equals(""))
		  {
			  jl_qqno.setForeground(Color.gray);
			  jl_qqno.setText("��¼�˺�");
		  }
		  if(j_pswd.getText().equals(""))
		  {
			  j_pswd.setForeground(Color.gray);
			  j_pswd.setEchoChar('\0');
			  j_pswd.setText("����");
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
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

}

/**
 * 
 * @author llf
 * ��½���滭����
 */
class LoginPanel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		g.drawRect(0, 0, 429, 329);
	}
}


