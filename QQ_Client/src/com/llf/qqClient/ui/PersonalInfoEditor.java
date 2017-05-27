package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.llf.qqClient.Controller.QQUserController;
import com.llf.qqClient.util.ConstellationUtil;
import com.llf.qqClient.util.ProvinceCityContact;
import com.llf.qqcommon.pojo.QQUser;

/**
 * 
 * @author llf
 * 个人资料编辑对话框
 */
public class PersonalInfoEditor extends JDialog implements ActionListener,ItemListener{
	/**
	 * 个人资料包括:网名,个性签名,性别,年龄,生日,星座,故乡,所在地,学历,职业
	 */
	private MyPersonalInfoEditorPanel mp;
	private JButton jb_exit,jb_save;
	private JLabel jl_title,jl_webname,jl_sign,jl_sex,jl_age,jl_birthday,jl_month,jl_day,jl_hometown,jl_staycity,jl_education,jl_profession;
	private JTextField jta_webname;
	private JTextArea jta_sign;
	private JComboBox jcb_sex,jcb_age,jcb_birthday_month,jcb_birthday_day,jcb_constellation,jcb_hometown_province,jcb_hometown_city,jcb_staycity_province,jcb_staycity_city,jcb_education,jcb_profession;
	private static QQUser qquser;
	
	
	public PersonalInfoEditor(QQUser qu)
	{
		qquser=qu;
		mp=new MyPersonalInfoEditorPanel();
		mp.setLayout(null);
		
		Font font=new Font("楷体",Font.PLAIN,15);
		Font font2=new Font("宋体",Font.PLAIN,13);
		
		jb_exit=new JButton(new ImageIcon("img/login_exit.png"));
		jb_exit.setToolTipText("关闭");
		jb_exit.addActionListener(this);
		jb_exit.setBounds(287, 0, 13, 13);
		
		jl_title=new JLabel("编辑资料");
		jl_title.setFont(font);
		jl_title.setForeground(Color.decode("#1C1C1C"));
		jl_title.setBounds(1, 0, 60, 27);
		
		jl_sign=new JLabel("个人说明");
		jl_sign.setFont(font2);
		jl_sign.setForeground(Color.decode("#1C1C1C"));
		jl_sign.setBounds(12, 30, 60, 27);
		
		jta_sign=new JTextArea(15,3);
		//设置边框
		jta_sign.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		//输入到边框边界时自动换行
		jta_sign.setLineWrap(true);
		jta_sign.setFont(font2);
		jta_sign.setForeground(Color.decode("#1C1C1C"));
		jta_sign.setText(qquser.getQQ_sign());
		jta_sign.setBounds(75, 30, 200, 50);
		
		jl_webname=new JLabel("昵   称");
		jl_webname.setFont(font2);
		jl_webname.setForeground(Color.decode("#1C1C1C"));
		jl_webname.setBounds(12, 85, 60, 27);
		
		jta_webname=new JTextField(15);
		//设置边框
		jta_webname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127,157,185)));
		jta_webname.setFont(font2);
		jta_webname.setForeground(Color.decode("#1C1C1C"));
		jta_webname.setText(qquser.getQQ_webname());
		jta_webname.setBounds(75, 85, 120, 25);
		
		
		jl_sex=new JLabel("性   别");
		jl_sex.setFont(font2);
		jl_sex.setForeground(Color.decode("#1C1C1C"));
		jl_sex.setBounds(12, 120, 60, 27);
		
		String s_sex[]={"男","女"};
		jcb_sex=new JComboBox(s_sex);
		jcb_sex.setFont(font2);
		jcb_sex.setBounds(75, 120, 40, 25);
		
		jl_age=new JLabel("年   龄");
		jl_age.setFont(font2);
		jl_age.setForeground(Color.decode("#1C1C1C"));
		jl_age.setBounds(150, 120, 60, 27);
		
		String s_age[]=new String[100];
		for(int i=0;i<100;i++)
		{
			s_age[i]=(i+1)+"";
		}
		
		jcb_age=new JComboBox(s_age);
		jcb_age.setFont(font2);
		jcb_age.setBounds(213, 120, 40, 25);
		
		jl_birthday=new JLabel("生   日");
		jl_birthday.setFont(font2);
		jl_birthday.setForeground(Color.decode("#1C1C1C"));
		jl_birthday.setBounds(12, 155, 60, 27);
		
		String s_birthday_month[]=new String[12];
		for(int i=0;i<12;i++)
		{
			s_birthday_month[i]=(i+1)+"";
		}
		jcb_birthday_month=new JComboBox(s_birthday_month);
		jcb_birthday_month.setFont(font2);
		//设置最大可见行数
		jcb_birthday_month.setMaximumRowCount(10);
		jcb_birthday_month.addItemListener(this);
		jcb_birthday_month.setBounds(75, 155, 40, 25);
		
		jl_month=new JLabel("月");
		jl_month.setFont(font2);
		jl_month.setBounds(120, 155, 20, 25);
		
		String s_birthday_day[]=new String[31];
		for(int i=0;i<31;i++)
		{
			s_birthday_day[i]=(i+1)+"";
		}
		jcb_birthday_day=new JComboBox(s_birthday_day);
		jcb_birthday_day.setFont(font2);
		jcb_birthday_day.setMaximumRowCount(10);
		jcb_birthday_day.addItemListener(this);
		jcb_birthday_day.setBounds(145, 155, 40, 25);
		
		jl_day=new JLabel("日");
		jl_day.setFont(font2);
		jl_day.setBounds(190, 155, 20, 25);
		
		//12星座，按月份排序，默认摩羯座
		String s_constellation[]=new String[12];
		s_constellation[0]="摩羯座";
		s_constellation[1]="水瓶座";
		s_constellation[2]="双鱼座";
		s_constellation[3]="白羊座";
		s_constellation[4]="金牛座";
		s_constellation[5]="双子座";
		s_constellation[6]="巨蟹座";
		s_constellation[7]="狮子座";
		s_constellation[8]="处女座";
		s_constellation[9]="天秤座";
		s_constellation[10]="天蝎座";
		s_constellation[11]="射手座";
		
		jcb_constellation=new JComboBox(s_constellation);
		jcb_constellation.setFont(font2);
		//设置为不可编辑,不可选择
		//jcb_constellation.setEnabled(false);
		jcb_constellation.setMaximumRowCount(5);
		jcb_constellation.setBounds(215, 155, 65, 25);
		
		jl_hometown=new JLabel("故   乡");
		jl_hometown.setFont(font2);
		jl_hometown.setForeground(Color.decode("#1C1C1C"));
		jl_hometown.setBounds(12, 190, 60, 27);
		
		//31省、直辖市、自治区，模拟11个，默认北京
		String s_hometown_province[]=new String[11];
		s_hometown_province[0]="北京";
		s_hometown_province[1]="上海";
		s_hometown_province[2]="天津";
		s_hometown_province[3]="重庆";
		s_hometown_province[4]="江苏";
		s_hometown_province[5]="浙江";
		s_hometown_province[6]="广东";
		s_hometown_province[7]="福建";
		s_hometown_province[8]="山东";
		s_hometown_province[9]="辽宁";
		s_hometown_province[10]="内蒙古";
		
		jcb_hometown_province=new JComboBox(s_hometown_province);
		jcb_hometown_province.setFont(font2);
		jcb_hometown_province.setMaximumRowCount(5);
		jcb_hometown_province.addItemListener(this);
		jcb_hometown_province.setBounds(75, 190, 65, 25);
		
		//模拟部分省市区县,默认北京东城
		String s_hometown_city[]=new String[5];
		s_hometown_city[0]="东城";
		s_hometown_city[1]="西城";
		s_hometown_city[2]="朝阳";
		s_hometown_city[3]="海淀";
		s_hometown_city[4]="昌平";
		
		jcb_hometown_city=new JComboBox(s_hometown_city);
		jcb_hometown_city.setFont(font2);
		jcb_hometown_city.setMaximumRowCount(5);
		jcb_hometown_city.setBounds(150, 190, 85, 25);
		
		
		jl_staycity=new JLabel("所 在 地");
		jl_staycity.setFont(font2);
		jl_staycity.setForeground(Color.decode("#1C1C1C"));
		jl_staycity.setBounds(12, 225, 60, 27);
		
		//31省、直辖市、自治区，模拟11个，默认北京
		String s_staycity_province[]=new String[11];
		s_staycity_province[0]="北京";
		s_staycity_province[1]="上海";
		s_staycity_province[2]="天津";
		s_staycity_province[3]="重庆";
		s_staycity_province[4]="江苏";
		s_staycity_province[5]="浙江";
		s_staycity_province[6]="广东";
		s_staycity_province[7]="福建";
		s_staycity_province[8]="山东";
		s_staycity_province[9]="辽宁";
		s_staycity_province[10]="内蒙古";
		
		jcb_staycity_province=new JComboBox(s_staycity_province);
		jcb_staycity_province.setFont(font2);
		jcb_staycity_province.setMaximumRowCount(5);
		jcb_staycity_province.addItemListener(this);
		jcb_staycity_province.setBounds(75, 225, 65, 25);
		
		//模拟部分省市区县,默认北京东城
		String s_staycity_city[]=new String[5];
		s_staycity_city[0]="东城";
		s_staycity_city[1]="西城";
		s_staycity_city[2]="朝阳";
		s_staycity_city[3]="海淀";
		s_staycity_city[4]="昌平";
		
		jcb_staycity_city=new JComboBox(s_staycity_city);
		jcb_staycity_city.setFont(font2);
		jcb_staycity_city.setMaximumRowCount(5);
		jcb_staycity_city.setBounds(150, 225, 85, 25);
		
		jl_education=new JLabel("学   历");
		jl_education.setFont(font2);
		jl_education.setForeground(Color.decode("#1C1C1C"));
		jl_education.setBounds(12, 260, 60, 27);
		
		String s_education[]=new String[7];
		s_education[0]="小学";
		s_education[1]="初中";
		s_education[2]="高中";
		s_education[3]="大专";
		s_education[4]="本科";
		s_education[5]="硕士";
		s_education[6]="博士";
		
		jcb_education=new JComboBox(s_education);
		jcb_education.setFont(font2);
		jcb_education.setMaximumRowCount(5);
		jcb_education.setBounds(75, 260, 65, 25);
		
		jl_profession=new JLabel("职   业");
		jl_profession.setFont(font2);
		jl_profession.setForeground(Color.decode("#1C1C1C"));
		jl_profession.setBounds(12, 295, 60, 27);
		
		String s_profession[]=new String[13];
		s_profession[0]="计算机/互联网/通信";
		s_profession[1]="生产/工艺/制造";
		s_profession[2]="医疗/护理/制药";
		s_profession[3]="金融/银行/投资/保险";
		s_profession[4]="商业/服务业/个体经营";
		s_profession[5]="文化/广播/传媒";
		s_profession[6]="娱乐/艺术/表演";
		s_profession[7]="律师/法务";
		s_profession[8]="教育/培训";
		s_profession[9]="公务员/行政/事业单位";
		s_profession[10]="模特/空姐";
		s_profession[11]="学生";
		s_profession[12]="其他";
		
		jcb_profession=new JComboBox(s_profession);
		jcb_profession.setFont(font2);
		jcb_profession.setMaximumRowCount(5);
		jcb_profession.setBounds(75, 295, 150, 25);
		
		jb_save=new JButton("保存修改");
		jb_save.setFont(font);
		jb_save.setBackground(Color.decode("#F4F4F4"));
		jb_save.addActionListener(this);
		jb_save.setBounds(180, 350, 100, 27);
		
		mp.add(jb_exit);
		mp.add(jl_title);
		mp.add(jl_webname);
		mp.add(jta_webname);
		mp.add(jl_sign);
		mp.add(jta_sign);
		mp.add(jl_sex);
		mp.add(jcb_sex);
		mp.add(jl_age);
		mp.add(jcb_age);
		mp.add(jl_birthday);
		mp.add(jcb_birthday_month);
		mp.add(jl_month);
		mp.add(jcb_birthday_day);
		mp.add(jl_day);
		mp.add(jcb_constellation);
		mp.add(jl_hometown);
		mp.add(jcb_hometown_province);
		mp.add(jcb_hometown_city);
		mp.add(jl_staycity);
		mp.add(jcb_staycity_province);
		mp.add(jcb_staycity_city);
		mp.add(jl_education);
		mp.add(jcb_education);
		mp.add(jl_profession);
		mp.add(jcb_profession);
		mp.add(jb_save);
		
		this.add(mp);
		this.addMouseListener(mp);
		this.addMouseMotionListener(mp);
		this.setSize(300,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		
		MyPersonalInfoEditorPanel.setpie(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb_exit)
		{
			//关闭窗口
			this.dispose();
		}
		else if(e.getSource()==jb_save)
		{
		
			QQUser qquser2=new QQUser();
			qquser2.setQQ_No(this.qquser.getQQ_No());
			qquser2.setQQ_webname(jta_webname.getText());
			qquser2.setQQ_sign(jta_sign.getText());
			qquser2.setU_sex(jcb_sex.getSelectedItem().toString());
			qquser2.setU_age(Integer.parseInt(jcb_age.getSelectedItem().toString()));
			String s_birthday_month=jcb_birthday_month.getSelectedItem().toString();
			String s_birthday_day=jcb_birthday_day.getSelectedItem().toString();
			Calendar c=Calendar.getInstance();
			int i_birthday_year=(c.get(Calendar.YEAR))-(Integer.parseInt(jcb_age.getSelectedItem().toString()));
			if(s_birthday_month.length()==1)
			{
				s_birthday_month="0"+s_birthday_month;
			}
			if(s_birthday_day.length()==1)
			{
				s_birthday_day="0"+s_birthday_day;
			}
			String s_birthday=i_birthday_year+"-"+s_birthday_month+"-"+s_birthday_day;
			
			Date d_birthday=null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				d_birthday = sdf.parse(s_birthday);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
			qquser2.setU_birthday(d_birthday);
			qquser2.setU_hometown(jcb_hometown_province.getSelectedItem().toString()+jcb_hometown_city.getSelectedItem().toString());
			qquser2.setU_staycity(jcb_staycity_province.getSelectedItem().toString()+jcb_staycity_city.getSelectedItem().toString());
			qquser2.setU_education(jcb_education.getSelectedItem().toString());
			qquser2.setU_profession(jcb_profession.getSelectedItem().toString());
			
			QQUserController qc=new QQUserController();
			qc.editPersonalMsg(qquser2);
	        
		}
	}
	
	public static void showResult(QQUser qquser)
	{
		Font font_msg=new Font("楷体",Font.PLAIN,14);
		//设置消息框字体
		UIManager.put("OptionPane.font",font_msg);
		UIManager.put("OptionPane.messageFont",font_msg);
		UIManager.put("OptionPane.buttonFont",font_msg);
		
		if(qquser!=null)
		{	
			//刷新面板
			PersonalInfomation.qquser=qquser;
			QQPanel.qquser=qquser;
			
			JOptionPane.showMessageDialog(null, "编辑成功!");
		}else
		{
			JOptionPane.showMessageDialog(null, "编辑失败!");
		}
			
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if(e.getStateChange()==ItemEvent.SELECTED)
		{
			//获取选中的生日月份和日期
			String month=(String)jcb_birthday_month.getSelectedItem();
			String day=(String)jcb_birthday_day.getSelectedItem();
			//根据生日匹配星座
			jcb_constellation.setSelectedIndex(ConstellationUtil.getConstellationByDate(month, day));
			
			//获取选中的故乡省份
			String hometown_province=(String)jcb_hometown_province.getSelectedItem();
			//根据故乡省份获取下辖市区信息，并重新为故乡城市下拉框赋值
			jcb_hometown_city.removeAllItems();
			String s_hometown_cities[]=ProvinceCityContact.getCitiesByProvince(hometown_province);
		    for(int i=0;i<s_hometown_cities.length;i++)
		    {
		    	jcb_hometown_city.addItem(s_hometown_cities[i]);
		    }
		    
		    //获取选中的所在地省份
			String staycity_province=(String)jcb_staycity_province.getSelectedItem();
			//根据所在地省份获取下辖市区信息，并重新为所在地城市下拉框赋值
			jcb_staycity_city.removeAllItems();
			String s_staycity_cities[]=ProvinceCityContact.getCitiesByProvince(staycity_province);
		    for(int i=0;i<s_staycity_cities.length;i++)
		    {
		    	jcb_staycity_city.addItem(s_staycity_cities[i]);
		    }
		}
	}

}

/**
 * 
 * @author llf
 * 个人资料编辑对话框绘图面板
 */
class MyPersonalInfoEditorPanel extends JPanel implements MouseListener,MouseMotionListener
{
	   //当前个人资料编辑窗体对象
		private static PersonalInfoEditor pie=null;
		//初始选中面板点横坐标
		private static int x;
		//初始选中面板点纵坐标
		private static int y;
		
		public static void setpie(PersonalInfoEditor personalinfoeditor)
		{
			pie=personalinfoeditor;
		}
		
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		g.drawRect(0, 0, 299, 399);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		//随着鼠标的拖拽改变窗体位置（每次的改变量为鼠标每次拖拽移动的坐标差量）
		 pie.setLocation(pie.getLocation().x+(e.getX()-x) , pie.getLocation().y+(e.getY()-y));
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