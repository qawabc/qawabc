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
		RoomVO c = (RoomVO)obj;//-->>>객체의 형변환(cast cade)
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
		RoomVO c = (RoomVO)obj;//에러남...why ==>> 넘어온 값이 VO객체가 아니고 그냥 한개 obj -> string 
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
		RoomVO c = (RoomVO)obj;//에러남...why ==>> 넘어온 값이 VO객체가 아니고 그냥 한개 obj -> string 
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
		result = new RoomVO(rid, rnum, grade, price, description, img, branch);//-->>>VO객체만들어 넘기기--출력폼(toString()) 참고
		close(rset);
		close(pstmt);
		return result;		
		
	}

	@Override
	public ArrayList<Object> select(Connection con) throws Exception {
		
		//모든 데이타를 ArrayList RoomVO 객체에 담아서 리턴한다.
		ArrayList<Object> list = new ArrayList();
		PreparedStatement pstmt = con.prepareStatement(Sql.selectAllRoom);
		ResultSet rset = null;
		rset = pstmt.executeQuery();
		while(rset.next()){//-->>>데이타 끝날때까지 반복한다.
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
