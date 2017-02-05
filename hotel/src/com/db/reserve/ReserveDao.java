package com.db.reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.db.frame.Dao;
import com.db.frame.Sql;
import com.db.vo.ReserveVO;
import com.hotel.admin.db.vo.RoomVO;

public class ReserveDao extends Dao {

	@Override
	public void insert(Connection con, Object obj) throws Exception {
		PreparedStatement pstmt = con.prepareStatement(Sql.insertReserve);
		ReserveVO p = (ReserveVO)obj;
		System.out.println("obj = "+obj);
		System.out.println("p = "+p);
		pstmt.setInt(1, p.getRid());
		pstmt.setInt(2, p.getCid());
		pstmt.setInt(3,  p.getRrid());
		pstmt.setInt(4,  p.getPrice());
		pstmt.setInt(5,  p.getRtype());
		pstmt.setInt(6, p.getPerson());
		pstmt.setDate(7, (java.sql.Date) p.getDate());
		pstmt.setInt(8, p.getPurpose());
		pstmt.setInt(9, p.getReason());
		pstmt.executeUpdate();
		close(pstmt);
	}

	@Override
	public void update(Connection con, Object obj) throws Exception {

	}

	@Override
	public void delete(Connection con, Object obj) throws Exception {

	}

	@Override
	public Object select(Connection con, Object obj) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Object> select(Connection con) throws Exception {
		ArrayList<Object> list = new ArrayList<>();
		PreparedStatement pstmt = con.prepareStatement(Sql.selectAllReserve);
		ResultSet rset = pstmt.executeQuery();

		while(rset.next()) {
			ReserveVO c = null;
			int rid = rset.getInt("rid");
			int cid = rset.getInt("cid");
			int rrid = rset.getInt("rrid");
			int price = rset.getInt("price");
			int rtype = rset.getInt("rtype");
			int person = rset.getInt("person");
			Date accomo = rset.getDate("accomo");
			int purpose = rset.getInt("purpose");
			int reason = rset.getInt("reason");
			c = new ReserveVO(rid, cid, rrid, price, rtype, person, accomo, purpose, reason);
			list.add(c);
		}
		close(pstmt);
		close(rset);
		return list;
	}
	
	@Override
	public ArrayList<Object> selectrooms(Connection con) throws Exception {
		//예약추가페이지에서 방리스트를 불러오기위함
		ArrayList<Object> list = new ArrayList<>();
		PreparedStatement pstmt = con.prepareStatement(Sql.selectRooms);
		ResultSet rset = pstmt.executeQuery();
		System.out.println(Sql.selectRooms);
		while(rset.next()) {
			RoomVO c = null;
			String grade = rset.getString("grade");
			int price = rset.getInt("avg(price)");
			c = new RoomVO(grade, price);
			list.add(c);
		}
		close(pstmt);
		close(rset);
		return list;
	}
	
	

}
