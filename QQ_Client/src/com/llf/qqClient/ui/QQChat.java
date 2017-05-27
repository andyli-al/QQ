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
 * QQ����Ի���
 */
public class QQChat extends JFrame implements ActionListener{
	
	/**
	 * index��ѡ�е������������
	 * mp��ͼ���
	 * jl_top����ͼƬ������ǩ,jl_friend_tx����ͷ��,jl_friend_msg���������͸���ǩ��
	 * jb_exit�رմ��ڰ�ť,jb_redu��С�����ڰ�ť,jb_faceQQ���鰴ť,jb_shakeQQ������ť,jb_voiceQQ������ť,jb_fileQQ�ļ���ť
	 * jb_check_note�鿴�����¼��ť,jb_reset���������ť,jb_send����������Ϣ��ť
	 * jta_msg������Ϣ��ʾ��,jta_send�༭��Ϣ��
	 * jsp_msg����������Ϣ��ʾ��Ĺ�����,jsp_send���ر༭��Ĺ�����
	 * jp_tool�༭���������
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
		
		Font font=new Font("����",Font.BOLD,16);
		Font font2=new Font("����",Font.PLAIN,13);
		
		mp=new MyQQChatPanel();
		mp.setLayout(null);
		
		jl_top=new JLabel(new ImageIcon("img/QQ_chat_top.png"));
		jl_top.setBounds(0, 0, 500, 100);
		
		jb_redu=new JButton(new ImageIcon("img/login_redu.png"));
		jb_redu.setToolTipText("��С��");
		jb_redu.addActionListener(this);
		jb_redu.setBounds(465, 0, 13, 13);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("�ر�");
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
		jb_face.setToolTipText("ѡ�����");
		//���ð�ť��С(JPanel�����)
		jb_face.setPreferredSize(new Dimension(30,30));
		jb_face.addActionListener(this);
		jp_tool.add(jb_face);
		
		jb_shake=new JButton(new ImageIcon("img/QQ_shake.png"));
		jb_shake.setToolTipText("���Ͷ���");
		//���ð�ť��С(JPanel�����)
		jb_shake.setPreferredSize(new Dimension(30,30));
		jb_shake.addActionListener(this);
		jp_tool.add(jb_shake);
		
		jb_voice=new JButton(new ImageIcon("img/QQ_voice.png"));
		jb_voice.setToolTipText("��������");
		//���ð�ť��С(JPanel�����)
		jb_voice.setPreferredSize(new Dimension(30,30));
		jb_voice.addActionListener(this);
		jp_tool.add(jb_voice);
		
		jb_file=new JButton(new ImageIcon("img/QQ_file.png"));
		jb_file.setToolTipText("�����ļ�");
		//���ð�ť��С(JPanel�����)
		jb_file.setPreferredSize(new Dimension(30,30));
		jb_file.addActionListener(this);
		jp_tool.add(jb_file);
		
		jb_check_note=new JButton(new ImageIcon("img/QQ_note.png"));
		jb_check_note.setToolTipText("�鿴��Ϣ��¼");
		jb_check_note.setBounds(400, 385, 76, 30);
		jb_check_note.addActionListener(this);
	
		jp_tool.setBounds(1, 381, 498, 35);
		
		jta_send=new JTextArea(30,30);
		jta_send.setFont(font);
		jta_send.setLineWrap(true);
		jta_send.setBackground(Color.decode("#E6F2F9"));
		jsp_send=new JScrollPane(jta_send);
		jsp_send.setBounds(1, 422, 498, 110);
		
		jb_reset=new JButton("�� ��");
		jb_reset.setFont(font2);
		jb_reset.addActionListener(this);
		jb_reset.setBackground(Color.decode("#C3E8F6"));
		jb_reset.setBounds(332, 540, 70, 28);
		
		jb_send=new JButton("�� ��");
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
				//��С������
				this.setExtendedState(JFrame.ICONIFIED);
			}
			else if(e.getSource()==jb_exit)
			{
				//�رմ���
				this.dispose();
			}
			else if(e.getSource()==jb_face)
			{
				System.out.println("QQ����");
			}
			else if(e.getSource()==jb_shake)
			{
				System.out.println("���Ͷ���");
			}
			else if(e.getSource()==jb_voice)
			{
				System.out.println("QQ����");
			}
			else if(e.getSource()==jb_file)
			{
				System.out.println("�����ļ�");
			}
			else if(e.getSource()==jb_check_note)
			{
				System.out.println("��Ϣ��¼");
			}
			else if(e.getSource()==jb_reset)
			{
				System.out.println("����");
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
				m.setSendTime(new SimpleDateFormat("yyyy-MM-dd HH��mm��ss").format(new Date()));
				
				try{
					ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
					oos.writeObject(m);
		
				}catch(Exception e2){
					e2.printStackTrace();
				}
				
			}
		
	}

	//��ʾ��Ϣ
	public void showMsg(Message m)
	{
		String info=m.getSendTime()+"\r\n"+m.getSender()+" ��  "+m.getGetter()+" ˵: "+m.getContent()+"\r\n";
		jta_msg.append(info);
	}

}

class MyQQChatPanel extends JPanel implements MouseListener,MouseMotionListener
{

	//��ǰQQ������崰�����
	private static QQChat qqc=null;
	//��ʼѡ�����������
	private static int x;
	//��ʼѡ������������
	private static int y;
	
	public static void setqqc(QQChat qqchat)
	{
		qqc=qqchat;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		//�������߿���
		g.drawRect(0, 0, 499, 579);
		//����QQͷ��߿���
		g.drawRect(9, 19, 63, 63);
		g.setColor(Color.black);
		g.drawLine(0, 100, 500, 100);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		//����������ק�ı䴰��λ�ã�ÿ�εĸı���Ϊ���ÿ����ק�ƶ������������
		 qqc.setLocation(qqc.getLocation().x+(e.getX()-x) , qqc.getLocation().y+(e.getY()-y));
		 //���¸ı�����ʼ����
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
		
		//��ȡ�������������µĳ�ʼ����
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
}
