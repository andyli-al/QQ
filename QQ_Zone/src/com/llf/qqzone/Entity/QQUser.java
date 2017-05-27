package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class QQUser implements Serializable{
	
	//QQ�˺�
	private int QQ_No;
	//QQ�ǳ�
	private String QQ_webname;
	//QQ����
	private String QQ_pswd;
	//QQ����ǩ��
	private String QQ_sign;
	//�Ա�
	private String u_sex;
	//����
	private int u_age;
	//����
	private java.util.Date u_birthday;
	//����
	private String u_hometown;
	//���ڵ�
	private String u_staycity;
	//����
	private String u_education;
	//ְҵ
	private String u_profession;
	//�Ƿ�����
	private int isOnline;
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public String getQQ_webname() {
		return QQ_webname;
	}
	public void setQQ_webname(String qQWebname) {
		QQ_webname = qQWebname;
	}
	public String getQQ_pswd() {
		return QQ_pswd;
	}
	public void setQQ_pswd(String qQPswd) {
		QQ_pswd = qQPswd;
	}
	public String getQQ_sign() {
		return QQ_sign;
	}
	public void setQQ_sign(String qQSign) {
		QQ_sign = qQSign;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String uSex) {
		u_sex = uSex;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int uAge) {
		u_age = uAge;
	}
	public java.util.Date getU_birthday() {
		return u_birthday;
	}
	public void setU_birthday(java.util.Date uBirthday) {
		u_birthday = uBirthday;
	}
	public String getU_hometown() {
		return u_hometown;
	}
	public void setU_hometown(String uHometown) {
		u_hometown = uHometown;
	}
	public String getU_staycity() {
		return u_staycity;
	}
	public void setU_staycity(String uStaycity) {
		u_staycity = uStaycity;
	}
	public String getU_education() {
		return u_education;
	}
	public void setU_education(String uEducation) {
		u_education = uEducation;
	}
	public String getU_profession() {
		return u_profession;
	}
	public void setU_profession(String uProfession) {
		u_profession = uProfession;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public QQUser() {
		super();
	}
	public QQUser(int qQNo, String qQWebname, String qQPswd, String qQSign,
			String uSex, int uAge, Date uBirthday, String uHometown,
			String uStaycity, String uEducation, String uProfession,
			int isOnline) {
		super();
		QQ_No = qQNo;
		QQ_webname = qQWebname;
		QQ_pswd = qQPswd;
		QQ_sign = qQSign;
		u_sex = uSex;
		u_age = uAge;
		u_birthday = uBirthday;
		u_hometown = uHometown;
		u_staycity = uStaycity;
		u_education = uEducation;
		u_profession = uProfession;
		this.isOnline = isOnline;
	}
	

}
