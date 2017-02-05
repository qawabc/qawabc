package com.db.frame;

public class Sql {
	public static String insertReserve = 
			//"INSERT INTO RESERVE VALUES(RESERVE_SEQ,CID,RRID,PRICE,RTYPE,PERSON,ACCOMO,PURPOSE,REASON)";
			"INSERT INTO RESERVE VALUES(?,?,?,?,?,?,?,?,?)";
			//"INSERT INTO RESERVE VALUES(RESERVE_SEQ, ?, "
		public static String modifyReserve =
			"UPDATE RESERVE SET PWD=?, NAME=? WHERE ID=?";
		public static String deleteReserve =
			"DELETE FROM RESERVE WHERE ID=?";
		public static String selectReserve =
			"SELECT * FROM RESERVE WHERE ID=?";
		public static String selectAllReserve =
			"SELECT * FROM RESERVE";
		public static String selectRooms =
			"SELECT grade, avg(price) FROM room GROUP BY grade ORDER BY grade";	//예약추가페이지에서 방리스트좀...
}