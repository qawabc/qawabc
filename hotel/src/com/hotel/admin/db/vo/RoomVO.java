package com.hotel.admin.db.vo;

public class RoomVO {

	private int rid;
	private int rnum;
	private String grade;
	private int price;	
	private String description;
	private String img;	
	private int branch;
	
	//-->
	public RoomVO() {
	}

	public RoomVO(int rid, int rnum) {
		this.rid = rid;
		this.rnum = rnum;
	}
	
	public RoomVO(String grade, int price) {
		this.grade = grade;
		this.price = price;
	}

	//-->
	public RoomVO(int rid, int rnum, String grade, int price, String description, String img, int branch) {
		this.rid = rid;
		this.rnum = rnum;
		this.grade = grade;
		this.price = price;
		this.description = description;
		this.img = img;
		this.branch = branch;
	}

	public RoomVO(int rnum, String grade, int price, String description, String img, int branch) {
		this.rnum = rnum;
		this.grade = grade;
		this.price = price;
		this.description = description;
		this.img = img;
		this.branch = branch;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	//-->
	@Override
	public String toString() {
		return "RoomVO [rid=" + rid + ", rnum=" + rnum + ", grade=" + grade + ", price=" + price + ", description="
				+ description + ", img=" + img + ", branch=" + branch + "]";
	}	
	

	
}
