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
 * �޸�ͷ�������
 */
public class UpdatePhoto extends JDialog implements ActionListener{
	
	private MyUpdatePhotoPanel mp;
	private JMenuBar jmb;
	private JMenu jm_open,jm_save;
	private JMenuItem jmi_open,jmi_save;
	private JButton jb_default;
	
	public UpdatePhoto()
	{
		Font font=new Font("����",Font.PLAIN,13);
		jmb=new JMenuBar();
		jm_open=new JMenu("��");
		jm_open.setFont(font);
		jm_save=new JMenu("����");
		jm_save.setFont(font);
		jmi_open=new JMenuItem("�����ļ�");
		jmi_open.setFont(font);
		jmi_open.addActionListener(this);
		jmi_save=new JMenuItem("�����޸�");
		jmi_save.setFont(font);
		jmi_save.addActionListener(this);
		jm_open.add(jmi_open);
		jm_save.add(jmi_save);
		jmb.add(jm_open);
		jmb.add(jm_save);
		
		//���������ñ���ɫ
        //this.getContentPane().setVisible(false);
        //this.setBackground(Color.decode("#E0E0E0"));
		this.setLayout(null);
		JButton jb=new JButton();
		
		this.setJMenuBar(jmb);
		this.setTitle("�޸�ͷ��");
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
			System.out.println("�򿪱����ļ�");
			//�ļ�ѡ�����
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�");
			//Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ�����·��
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			
			System.out.println(filename);
			
			/*
			 * ��ѡ���ͼƬճ���������ļ�����ʱ�洢
			 * ��ѡ���ͼƬ�Ŀ�Ⱥ͸߶Ȼ�ȡ������
			 */
			FileDeal.dealFile(filename);
			try {
				FormatDataSave.set_ts(FileDeal.getImageData(filename)[0], FileDeal.getImageData(filename)[1]);
				System.out.println("��:"+FileDeal.getImageData(filename)[0]+"  ��:"+ FileDeal.getImageData(filename)[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			this.dispose();
			
			Font font_msg=new Font("����",Font.PLAIN,14);
			//������Ϣ������
			UIManager.put("OptionPane.font",font_msg);
			UIManager.put("OptionPane.messageFont",font_msg);
			UIManager.put("OptionPane.buttonFont",font_msg);
			JOptionPane.showMessageDialog(null, "ͼƬ�ѽ��еȱ�������!");
			System.out.println("�ȱ������ź��:"+(int)ImageSizeDeal.getImageSizeAfterDeal()[0]+" �ȱ������ź��:"+(int)ImageSizeDeal.getImageSizeAfterDeal()[1]);
			
			//��ʼ����ͼ���
			mp=new MyUpdatePhotoPanel();
			mp.setLayout(null);
			mp.setBounds(0, 0, 400, 400);
			this.add(mp);
			this.getContentPane().setVisible(true);
			this.setVisible(true);
			
	
		}else if(e.getSource()==jmi_save)
		{
			System.out.println("����ͼƬ�޸�");
		}
	}
}

/**
 * 
 * @author llf
 * ͷ��༭��ͼ������
 */
class MyUpdatePhotoPanel extends JPanel
{
	//�û�ѡ��ĵȱ������ź��ͼƬ
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
		//����ȱ������ź��ͼƬ
		g.drawImage(tx,6, 3,(int)ImageSizeDeal.getImageSizeAfterDeal()[0], (int)ImageSizeDeal.getImageSizeAfterDeal()[1],this);
	}
}
