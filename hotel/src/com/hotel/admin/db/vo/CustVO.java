package com.hotel.admin.db.vo;

public class CustVO {

	// TODO Auto-generated constructor stub
	private int cid;
	private String id;
	private String mail;
	private String pwd;
	private String name;
	private String addr;
	private String gender;
	private int age;				
	private String grade;
	private String mobile;	
	
	//-->
	public CustVO() {
	}
	
	public CustVO(int cid, String id) {
		this.cid = cid;
		this.id = id;
	}

	//-->	
	public CustVO(String id, String mail, String pwd, String name, String addr, String gender, int age, String grade,
			String mobile) {
		this.id = id;
		this.mail = mail;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
		this.mobile = mobile;
	}

	public CustVO(int cid, String id, String mail, String pwd, String name, String addr, String gender, int age,
			String grade, String mobile) {
		this.cid = cid;
		this.id = id;
		this.mail = mail;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
		this.mobile = mobile;
	}
	
	//-->
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	//-->
	@Override
	public String toString() {
		return "CustVO [cid=" + cid + ", id=" + id + ", mail=" + mail + ", pwd=" + pwd + ", name=" + name
				+ ", addr=" + addr + ", gender=" + gender + ", age=" + age + ", grade=" + grade + ", mobile="
				+ mobile + "]";
	}		

	
		
}
