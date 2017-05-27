package com.llf.qqClient.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.llf.qqClient.util.FileDeal;
import com.llf.qqClient.util.FormatDataSave;
import com.llf.qqClient.util.ImageSizeDeal;

/**
 * @author llf
 * 修改头像界面类
 */
public class UpdatePhoto extends JDialog implements ActionListener{
	
	private MyUpdatePhotoPanel mp;
	private JMenuBar jmb;
	private JMenu jm_open,jm_save;
	private JMenuItem jmi_open,jmi_save;
	private JButton jb_default;
	
	public UpdatePhoto()
	{
		Font font=new Font("楷体",Font.PLAIN,13);
		jmb=new JMenuBar();
		jm_open=new JMenu("打开");
		jm_open.setFont(font);
		jm_save=new JMenu("保存");
		jm_save.setFont(font);
		jmi_open=new JMenuItem("本地文件");
		jmi_open.setFont(font);
		jmi_open.addActionListener(this);
		jmi_save=new JMenuItem("保存修改");
		jmi_save.setFont(font);
		jmi_save.addActionListener(this);
		jm_open.add(jmi_open);
		jm_save.add(jmi_save);
		jmb.add(jm_open);
		jmb.add(jm_save);
		
		//给窗体设置背景色
        //this.getContentPane().setVisible(false);
        //this.setBackground(Color.decode("#E0E0E0"));
		this.setLayout(null);
		JButton jb=new JButton();
		
		this.setJMenuBar(jmb);
		this.setTitle("修改头像");
		this.setSize(400, 400);
		this.setLocation(200,100);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		UpdatePhoto up=new UpdatePhoto();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jmi_open)
		{
			System.out.println("打开本地文件");
			//文件选择组件
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件");
			//默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//得到用户选择的文件绝对路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			
			System.out.println(filename);
			
			/*
			 * 把选择的图片粘贴到本地文件夹临时存储
			 * 将选择的图片的宽度和高度获取并保存
			 */
			FileDeal.dealFile(filename);
			try {
				FormatDataSave.set_ts(FileDeal.getImageData(filename)[0], FileDeal.getImageData(filename)[1]);
				System.out.println("宽:"+FileDeal.getImageData(filename)[0]+"  高:"+ FileDeal.getImageData(filename)[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			this.dispose();
			
			Font font_msg=new Font("楷体",Font.PLAIN,14);
			//设置消息框字体
			UIManager.put("OptionPane.font",font_msg);
			UIManager.put("OptionPane.messageFont",font_msg);
			UIManager.put("OptionPane.buttonFont",font_msg);
			JOptionPane.showMessageDialog(null, "图片已进行等比例缩放!");
			System.out.println("等比例缩放后宽:"+(int)ImageSizeDeal.getImageSizeAfterDeal()[0]+" 等比例缩放后高:"+(int)ImageSizeDeal.getImageSizeAfterDeal()[1]);
			
			//初始化绘图面板
			mp=new MyUpdatePhotoPanel();
			mp.setLayout(null);
			mp.setBounds(0, 0, 400, 400);
			this.add(mp);
			this.getContentPane().setVisible(true);
			this.setVisible(true);
			
	
		}else if(e.getSource()==jmi_save)
		{
			System.out.println("保存图片修改");
		}
	}
}

/**
 * 
 * @author llf
 * 头像编辑绘图画板类
 */
class MyUpdatePhotoPanel extends JPanel
{
	//用户选择的等比例缩放后的图片
	private Image tx=null;
	public MyUpdatePhotoPanel()
	{
		try {
			tx=ImageIO.read(new File("img_tx/tx_selected"+FormatDataSave.tx_format));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		g.drawRect(6, 3, 380, 340);
		//绘出等比例缩放后的图片
		g.drawImage(tx,6, 3,(int)ImageSizeDeal.getImageSizeAfterDeal()[0], (int)ImageSizeDeal.getImageSizeAfterDeal()[1],this);
	}
}
