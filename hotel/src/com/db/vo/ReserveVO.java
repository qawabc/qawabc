package com.db.vo;

import java.sql.Date;

public class ReserveVO {
	private int rid;
	private int cid;
	private int rrid;
	private int price;
	private int rtype;
	private int person;
	private Date date;
	private int purpose;
	private int reason;
	public ReserveVO(int rid, int cid, int rrid, int price, int rtype, int person, Date date, int purpose, int reason) {
		this.rid = rid;
		this.cid = cid;
		this.rrid = rrid;
		this.price = price;
		this.rtype = rtype;
		this.person = person;
		this.date = date;
		this.purpose = purpose;
		this.reason = reason;
	}
	
	public ReserveVO() {
		
	}

	public ReserveVO(int cid, int rrid, int price, int rtype, int person, Date date, int purpose, int reason) {
		this.cid = cid;
		this.rrid = rrid;
		this.price = price;
		this.rtype = rtype;
		this.person = person;
		this.date = date;
		this.purpose = purpose;
		this.reason = reason;
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getRrid() {
		return rrid;
	}
	public void setRrid(int rrid) {
		this.rrid = rrid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRtype() {
		return rtype;
	}
	public void setRtype(int rtype) {
		this.rtype = rtype;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ReserveVO [rid=" + rid + ", cid=" + cid + ", rrid=" + rrid + ", price=" + price + ", rtype=" + rtype
				+ ", person=" + person + ", date=" + date + ", purpose=" + purpose + ", reason=" + reason + "]";
	}
}
