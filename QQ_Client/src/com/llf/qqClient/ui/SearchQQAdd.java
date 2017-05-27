package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.llf.qqClient.Controller.QQUserController;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * ����QQ�Ų����
 * @author llf
 *
 */
public class SearchQQAdd extends JDialog implements ActionListener{
	
	private JLabel jl_searchQQ,jl_searchWebname;
	private JTextField jtf_QQ,jtf_Webname;
	private JButton jb_search,jb_add;
	private JScrollPane jsp;
	private JTable jt;
	private static Vector rowData,columNames;
	private static QQUser qquser;
	private static List<QQUser> qquser_result;
	
	public void setValueToJtable(Message m)
	{
		List<QQUser> qquser_res=m.getQqfriends();
		if(qquser_res.size()>0)
		{
		qquser_result=qquser_res;
		}
		else
		{
			qquser_result=null;
		}
		SearchQQAdd sqa=new SearchQQAdd(qquser);
	   
	}
	
	public SearchQQAdd(QQUser qu)
	{
		qquser=qu;
		this.setLayout(null);
		Font font=new Font("����",Font.PLAIN,13);
		
		jl_searchQQ=new JLabel("ͨ��QQ�������");
		jl_searchQQ.setFont(font);
		jl_searchQQ.setBounds(30,10, 130, 25);
		this.add(jl_searchQQ);
		
		jl_searchWebname=new JLabel("ͨ���ǳƹؼ��ֲ���");
		jl_searchWebname.setFont(font);
		jl_searchWebname.setBounds(30, 45, 130, 25);
		this.add(jl_searchWebname);
		
		jtf_QQ=new JTextField();
		jtf_QQ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127,157,185)));
		jtf_QQ.setBounds(190, 10, 140, 25);
		this.add(jtf_QQ);
		
		jtf_Webname=new JTextField();
		jtf_Webname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127,157,185)));
		jtf_Webname.setBounds(190, 45, 140, 25);
		this.add(jtf_Webname);
		
		jb_search=new JButton("�����˺�");
		jb_search.setFont(font);
		jb_search.setForeground(Color.white);
		jb_search.setBackground(Color.decode("#09A3DC"));
		jb_search.setBounds(90, 90, 90, 30);
		jb_search.addActionListener(this);
		this.add(jb_search);
		
		jb_add=new JButton("��Ӻ���");
		jb_add.setFont(font);
		jb_add.setForeground(Color.white);
		jb_add.setBackground(Color.decode("#09A3DC"));
		jb_add.setBounds(210, 90, 90, 30);
		jb_add.addActionListener(this);
		this.add(jb_add);
		
		
		columNames=new Vector();
		columNames.add("QQ����");
		columNames.add("�ǳ�");
		columNames.add("�Ա�");
		columNames.add("����");
		columNames.add("�־ӵ�");
		
		rowData=new Vector();
		if(qquser_result!=null)
		{
		for(QQUser qquser_item:qquser_result)
		{
			Vector rowItem=new Vector();
			rowItem.add(qquser_item.getQQ_No());
			rowItem.add(qquser_item.getQQ_webname());
			rowItem.add(qquser_item.getU_sex());
			rowItem.add(qquser_item.getU_age());
			rowItem.add(qquser_item.getU_staycity());
			rowData.add(rowItem);
		}
		}
		
		jt=new JTable(rowData,columNames);
		jsp=new JScrollPane(jt);
		jsp.setBounds(50, 135, 300, 100);
		
		this.add(jsp);
		
		this.setIconImage(new ImageIcon("img/qq.png").getImage());
		this.setTitle("����");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
    public static void main(String[] args) {
		
    	QQUser qu=new QQUser();
    	SearchQQAdd sa=new SearchQQAdd(qu);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		Font font_msg=new Font("����",Font.PLAIN,14);
		//������Ϣ������
		UIManager.put("OptionPane.font",font_msg);
		UIManager.put("OptionPane.messageFont",font_msg);
		UIManager.put("OptionPane.buttonFont",font_msg);
		
		if(e.getSource()==jb_search)
		{
			if(jtf_QQ.getText().equals("")&&jtf_Webname.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��!");
			}else if(!jtf_QQ.getText().equals("")&&!jtf_Webname.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "ͬʱ��֧�ֵ�һ������ѯ");
			}else
			{
				this.dispose();
				QQUserController qc=new QQUserController();
				if(!jtf_QQ.getText().equals(""))
				{
					qc.sendSearchDataInt(qquser.getQQ_No(),Integer.parseInt(jtf_QQ.getText()));
				}else
				{
					qc.sendSearchDataString(qquser.getQQ_No(),jtf_Webname.getText());
				}
							
			}
		}else if(e.getSource()==jb_add)
		{
			if(jt.getSelectedRow()!=-1)
			{
				QQUser qquser_item=qquser_result.get(jt.getSelectedRow());
				if(qquser_item.getQQ_No()!=qquser.getQQ_No())
				{
					int flag=0;
					for(QQUser qquser_temp:QQPanel.qqfs)
					{
						if(qquser_temp.getQQ_No()==qquser_item.getQQ_No())
						{
							JOptionPane.showMessageDialog(null, qquser_temp.getQQ_webname()+"�Ѿ�����ĺ�����,�����ظ����");
							flag++;
							break;
						}
					}
				if(flag==0)
				{
				int i=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ���"+qquser_item.getQQ_webname()+"Ϊ������?","��ʾ:", JOptionPane.YES_NO_OPTION);
				if(i==JOptionPane.OK_OPTION)
				{
				QQUserController qc=new QQUserController();
				qc.addfriend(qquser, qquser_item);
				}
				}
 				}else
				{
					JOptionPane.showMessageDialog(null, "�㲻������Լ�Ϊ����!");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "�㻹û��ѡ���κ�һ��!");
			}
		}
	}

}
