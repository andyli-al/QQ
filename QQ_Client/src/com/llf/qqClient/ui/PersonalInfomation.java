package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.llf.qqClient.util.BirthdayHandler;
import com.llf.qqcommon.pojo.QQUser;
import com.sun.awt.AWTUtilities;

/**
 * 
 * @author llf
 * ����������Ϣ���
 */
public class PersonalInfomation extends JFrame implements ActionListener{
	/**
	 * �������ϰ���:����,QQ����,����ǩ��,�Ա�,����,����,����,����,���ڵ�,ѧ��,ְҵ
	 * obj_index,ֵΪ0��ʾ���Լ����������,ֵΪ1��ʾ�Ǻ��ѵ��������
	 */
	private MyPersonalInfomationPanel mp;
	public static JLabel jl_tx;
	private JLabel jl_qqno,jl_webname,jl_sign;
	private JLabel jl_top,jl_qqno2,jl_webname2,jl_sign2,jl_personal,jl_hometown,jl_staycity,jl_education,jl_profession;
	private JLabel webname,qqno,sign,sex,age,birthday,constellation,hometown,staycity,education,profession;
	private JButton jb_exit,jb_redu,jb_editor;
	public static QQUser qquser;
	
	public PersonalInfomation(int obj_index,QQUser qu)
	{
		qquser=qu;
		mp=new MyPersonalInfomationPanel();
		mp.setLayout(null);
		
		Font font=new Font("����",Font.BOLD,18);
		Font font2=new Font("����",Font.PLAIN,14);
		Font font3=new Font("����",Font.PLAIN,14);
		
		jl_top=new JLabel(new ImageIcon("img/QQ_personal_msg_top.jpg"));
		jl_top.setBounds(1, 0, 450, 100);
		
		jb_redu=new JButton(new ImageIcon("img/login_redu.png"));
		jb_redu.setToolTipText("��С��");
		jb_redu.addActionListener(this);
		jb_redu.setBounds(415, 0, 13, 13);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("�ر�");
		jb_exit.addActionListener(this);
		jb_exit.setBounds(437, 0, 13, 13);
		
		jl_tx=new JLabel(new ImageIcon("img/tx2.png"));
		jl_tx.setToolTipText("�޸�ͷ��");
		jl_tx.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jl_tx.addMouseListener(mp);
		jl_tx.setBounds(10, 25, 62, 62);
		
		jl_webname=new JLabel(qquser.getQQ_webname());
		jl_webname.setFont(font);
		jl_webname.setForeground(Color.white);
		jl_webname.setBounds(78, 25, 75, 25);
		
		jl_qqno=new JLabel("("+qquser.getQQ_No()+")");
		jl_qqno.setFont(font2);
		jl_qqno.setForeground(Color.white);
		jl_qqno.setBounds(154, 26, 100, 25);
		
		jl_sign=new JLabel(qquser.getQQ_sign());
		jl_sign.setFont(font3);
		jl_sign.setForeground(Color.white);
		jl_sign.setBounds(78, 65, 100, 25);
		 
		jl_qqno2=new JLabel("��  ��:");
		jl_qqno2.setFont(font2);
		jl_qqno2.setForeground(Color.decode("#282828"));
		jl_qqno2.setBounds(12, 110, 60, 27);
		
		qqno=new JLabel(qquser.getQQ_No()+"");
		qqno.setFont(font3);
		qqno.setForeground(Color.decode("#1C1C1C"));
		qqno.setBounds(75, 110, 100, 27);
		
		jl_webname2=new JLabel("��  ��:");
		jl_webname2.setFont(font2);
		jl_webname2.setForeground(Color.decode("#282828"));
		jl_webname2.setBounds(12, 135, 60, 27);
		
		webname=new JLabel(qquser.getQQ_webname());
		webname.setFont(font3);
		webname.setForeground(Color.decode("#1C1C1C"));
		webname.setBounds(75, 135, 120, 27);
		
		jl_sign2=new JLabel("����˵��:");
		jl_sign2.setFont(font2);
		jl_sign2.setForeground(Color.decode("#282828"));
		jl_sign2.setBounds(12, 160, 80, 27);
		
		sign=new JLabel(qquser.getQQ_sign());
		sign.setFont(font3);
		sign.setForeground(Color.decode("#1C1C1C"));
		sign.setBounds(80, 160, 350, 27);
		
		jl_personal=new JLabel("��  ��:");
		jl_personal.setFont(font2);
		jl_personal.setForeground(Color.decode("#282828"));
		jl_personal.setBounds(12, 195, 60, 27);
		
		sex=new JLabel(qquser.getU_sex());
		sex.setFont(font3);
		sex.setForeground(Color.decode("#1C1C1C"));
		sex.setBounds(75, 195, 25, 27);
		
		String[] temp=BirthdayHandler.handle(qquser.getU_age(),qquser.getU_birthday());
		
		age=new JLabel(temp[2]+"");
		age.setFont(font3);
		age.setForeground(Color.decode("#1C1C1C"));
		age.setBounds(103, 195, 35, 27);
		
		birthday=new JLabel(""+temp[0]+"(��������)");
		birthday.setFont(font3);
		birthday.setForeground(Color.decode("#1C1C1C"));
		birthday.setBounds(140, 195, 130, 27);
		
		constellation=new JLabel(temp[1]);
		constellation.setFont(font3);
		constellation.setForeground(Color.decode("#1C1C1C"));
		constellation.setBounds(275, 195, 45, 27);
		
		 
		jl_hometown=new JLabel("��  ��:");
		jl_hometown.setFont(font2);
		jl_hometown.setForeground(Color.decode("#282828"));
		jl_hometown.setBounds(12, 230, 60, 27);
		
		hometown=new JLabel(qquser.getU_hometown());
		hometown.setFont(font3);
		hometown.setForeground(Color.decode("#1C1C1C"));
		hometown.setBounds(75, 230, 120, 27);
		
		jl_staycity=new JLabel("���ڵ�:");
		jl_staycity.setFont(font2);
		jl_staycity.setForeground(Color.decode("#282828"));
		jl_staycity.setBounds(12, 260, 60, 27);
		
		staycity=new JLabel(qquser.getU_staycity());
		staycity.setFont(font3);
		staycity.setForeground(Color.decode("#1C1C1C"));
		staycity.setBounds(75, 260, 120, 27);
		
		jl_education=new JLabel("ѧ  ��:");
		jl_education.setFont(font2);
		jl_education.setForeground(Color.decode("#282828"));
		jl_education.setBounds(12, 290, 60, 27);
		
		education=new JLabel(qquser.getU_education());
		education.setFont(font3);
		education.setForeground(Color.decode("#1C1C1C"));
		education.setBounds(75, 290, 45, 27);
		
		jl_profession=new JLabel("ְ  ҵ:");
		jl_profession.setFont(font2);
		jl_profession.setForeground(Color.decode("#282828"));
		jl_profession.setBounds(200, 290, 60, 27);
		
		profession=new JLabel(qquser.getU_profession());
		profession.setFont(font3);
		profession.setForeground(Color.decode("#1C1C1C"));
		profession.setBounds(263, 290, 100, 27);
	
		mp.add(jl_top,-1);
		mp.add(jl_tx,0);
		mp.add(jl_webname,0);
		mp.add(jl_qqno,0);
		mp.add(jl_sign,0);
		mp.add(jb_redu,0);
		mp.add(jb_exit,0);
		mp.add(jl_qqno2);
		mp.add(qqno);
		mp.add(jl_webname2);
		mp.add(webname);
		mp.add(jl_sign2);
		mp.add(sign);
		mp.add(jl_personal);
		mp.add(sex);
		mp.add(age);
		mp.add(birthday);
		mp.add(constellation);
		mp.add(jl_hometown);
		mp.add(hometown);
		mp.add(jl_staycity);
		mp.add(staycity);
		mp.add(jl_education);
		mp.add(education);
		mp.add(jl_profession);
		mp.add(profession);
		if(obj_index==0)
		{
			jb_editor=new JButton("�༭����");
			jb_editor.setFont(font3);
			jb_editor.setBackground(Color.decode("#F4F4F4"));
			jb_editor.addActionListener(this);
			jb_editor.setBounds(330, 345, 90, 25);
			mp.add(jb_editor);
		}
		
		this.add(mp);
		this.addMouseListener(mp);
		this.addMouseMotionListener(mp);
		this.setIconImage(new ImageIcon("img/qq.png").getImage());
		this.setSize(450, 420);
		this.setLocation(400, 150);
		this.setResizable(false);
		this.setUndecorated(true);
	    //Opacity���ֵΪ1.0f��Ҳ����ʲôҲ��͸����ȡֵ���ܴ���1.0f  
		//�������͸����Ϊ0.9
		AWTUtilities.setWindowOpacity(this,0.9f); 
		this.setVisible(true);
		
		MyPersonalInfomationPanel.setpi(this);
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
			//�رմ���
			this.dispose();
		}
		else if(e.getSource()==jb_editor)
		{
			//�������ϱ༭�Ի���
			PersonalInfoEditor pie=new PersonalInfoEditor(qquser);
			this.dispose();
		}
		
	}
}

class MyPersonalInfomationPanel extends JPanel implements MouseListener,MouseMotionListener
{
	
	   //��ǰ�������ϴ������
		private static PersonalInfomation pi=null;
		//��ʼѡ�����������
		private static int x;
		//��ʼѡ������������
		private static int y;
		
		public static void setpi(PersonalInfomation personalinfo)
		{
			pi=personalinfo;
		}
		
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		//�������߿���
		g.drawRect(0, 0, 449, 419);
		//����QQͷ��߿���
		g.drawRect(9, 24, 63, 63);
		g.drawLine(0, 100, 450, 100);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		//����������ק�ı䴰��λ�ã�ÿ�εĸı���Ϊ���ÿ����ק�ƶ������������
		 pi.setLocation(pi.getLocation().x+(e.getX()-x) , pi.getLocation().y+(e.getY()-y));
		 //���¸ı�����ʼ����
		 x=e.getY();
		 y=e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	    if(e.getComponent()==PersonalInfomation.jl_tx)
	    {
	    	System.out.println("�޸�ͷ��");
	    	UpdatePhoto up=new UpdatePhoto();
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
		
		//��ȡ�������������µĳ�ʼ����
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
}