package com.hotel.admin.db.frame;

public class Sql {
	//ȸ������
	public static String insertCust 
		= "INSERT INTO CUST VALUES(CUST_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
	public static String modifyCust 
		= "UPDATE CUST SET MAIL=?, PWD=?, NAME=?, ADDR=?, GENDER=?, AGE=?, GRADE=?, MOBILE=?, JOINDATE=SYSDATE WHERE CID=? AND ID=? ";
	public static String deleteCust 
		= "DELETE FROM CUST WHERE CID=? AND ID=? ";
	public static String selectCust 
		= "SELECT * FROM CUST WHERE CID=? AND ID=?";
	public static String selectAllCust 
		= "SELECT * FROM CUST";

	//���ǰ���
	public static String insertRoom 
		= "INSERT INTO ROOM VALUES(ROOM_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	public static String modifyRoom 
		= "UPDATE ROOM SET GRADE=?, PRICE=?, DESCRIPTION=?, IMG=?, BRANCH=? WHERE RID=? AND RNUM=? ";
	public static String deleteRoom 
		= "DELETE FROM ROOM WHERE RID=? AND RNUM=?  ";
	public static String selectRoom 
		= "SELECT * FROM ROOM WHERE RID=? AND RNUM=? ";
	public static String selectAllRoom 
		= "SELECT * FROM ROOM";
	
	//�������
	public static String selectRooms =
			"SELECT grade, avg(price) FROM room GROUP BY grade";
	
}
