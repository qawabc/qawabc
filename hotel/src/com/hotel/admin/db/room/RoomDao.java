package com.hotel.admin.db.room;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.db.vo.ReserveVO;
import com.hotel.admin.db.frame.Dao;
import com.hotel.admin.db.frame.Sql;
import com.hotel.admin.db.vo.RoomVO;

public class RoomDao extends Dao {

	@Override
	public void insert(Connection con, Object obj) throws Exception {
		RoomVO c = (RoomVO)obj;//-->>>��ü�� ����ȯ(cast cade)
		PreparedStatement pstmt = con.prepareStatement(Sql.insertRoom);
		pstmt.setInt(1, c.getRnum());//-->RoomVO
		pstmt.setString(2, c.getGrade());			
		pstmt.setInt(3, c.getPrice());//-->	
		pstmt.setString(4, c.getDescription());
		pstmt.setString(5, c.getImg());		
		pstmt.setInt(6, c.getBranch());//-->
		pstmt.executeUpdate();
		close(pstmt);		
		
	}

	@Override
	public void update(Connection con, Object obj) throws Exception {
		RoomVO c = (RoomVO)obj;
		PreparedStatement pstmt = con.prepareStatement(Sql.modifyRoom);
		pstmt.setString(1, c.getGrade());	
		pstmt.setInt(2, c.getPrice());//-->		
		pstmt.setString(3, c.getDescription());
		pstmt.setString(4, c.getImg());		
		pstmt.setInt(5, c.getBranch());//-->	
		pstmt.setInt(6, c.getRid());//-->RoomVO
		pstmt.setInt(7, c.getRnum());		
		pstmt.executeUpdate();
		close(pstmt);		
		
	}

	@Override
	public void delete(Connection con, Object obj) throws Exception {
		RoomVO c = (RoomVO)obj;//������...why ==>> �Ѿ�� ���� VO��ü�� �ƴϰ� �׳� �Ѱ� obj -> string 
		PreparedStatement pstmt = con.prepareStatement(Sql.deleteRoom);
		////pstmt.setString(1, obj.toString());//OK  //obj -->string
		pstmt.setInt(1, c.getRid());//-->RoomVO		
		pstmt.setInt(2, c.getRnum());		
		pstmt.executeUpdate();//-->
		close(pstmt);
		
	}

	@Override
	public Object select(Connection con, Object obj) throws Exception {
		
		Object result = null;
		RoomVO c = (RoomVO)obj;//������...why ==>> �Ѿ�� ���� VO��ü�� �ƴϰ� �׳� �Ѱ� obj -> string 
		PreparedStatement pstmt = con.prepareStatement(Sql.selectRoom);
		pstmt.setInt(1, c.getRid());//-->RoomVO			
		pstmt.setInt(2, c.getRnum());		
		
		ResultSet rset = null;
		rset = pstmt.executeQuery(); 
		rset.next();
		int rid = rset.getInt("RID");//-->	
		int rnum = rset.getInt("RNUM");//-->
		String grade = rset.getString("GRADE");		
		int price = rset.getInt("PRICE");		
		String description = rset.getString("DESCRIPTION");
		String img = rset.getString("IMG");
		int branch = rset.getInt("BRANCH");//-->
		result = new RoomVO(rid, rnum, grade, price, description, img, branch);//-->>>VO��ü����� �ѱ��--�����(toString()) ����
		close(rset);
		close(pstmt);
		return result;		
		
	}

	@Override
	public ArrayList<Object> select(Connection con) throws Exception {
		
		//��� ����Ÿ�� ArrayList RoomVO ��ü�� ��Ƽ� �����Ѵ�.
		ArrayList<Object> list = new ArrayList();
		PreparedStatement pstmt = con.prepareStatement(Sql.selectAllRoom);
		ResultSet rset = null;
		rset = pstmt.executeQuery();
		while(rset.next()){//-->>>����Ÿ ���������� �ݺ��Ѵ�.
			RoomVO c = null;
			int rid = rset.getInt("RID");//-->	
			int rnum = rset.getInt("RNUM");//-->
			String grade = rset.getString("GRADE");		
			int price = rset.getInt("PRICE");		
			String description = rset.getString("DESCRIPTION");
			String img = rset.getString("IMG");
			int branch = rset.getInt("BRANCH");//-->
			c = new RoomVO(rid, rnum, grade, price, description, img, branch);//-->>>
			list.add(c);
		}
		close(rset);
		close(pstmt);		
		return list;		
		
	}

}
