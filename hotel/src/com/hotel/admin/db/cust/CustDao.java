package com.hotel.admin.db.cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hotel.admin.db.frame.Dao;
import com.hotel.admin.db.frame.Sql;
import com.hotel.admin.db.vo.CustVO;
import com.hotel.admin.db.vo.RoomVO;

public class CustDao extends Dao {

	@Override
	public void insert(Connection con, Object obj) throws Exception {
		CustVO c = (CustVO)obj;//-->>>객체의 형변환(cast cade)
		PreparedStatement pstmt = con.prepareStatement(Sql.insertCust);
		pstmt.setString(1, c.getId());//CustVO
		pstmt.setString(2, c.getMail());
		pstmt.setString(3, c.getPwd());	
		pstmt.setString(4, c.getName());
		pstmt.setString(5, c.getAddr());		
		pstmt.setString(6, c.getGender());
		pstmt.setInt(7, c.getAge());//-->	
		pstmt.setString(8, c.getGrade());	
		pstmt.setString(9, c.getMobile());			
		pstmt.executeUpdate();
		close(pstmt);		
		
	}

	@Override
	public void update(Connection con, Object obj) throws Exception {
		CustVO c = (CustVO)obj;
		PreparedStatement pstmt = con.prepareStatement(Sql.modifyCust);
		pstmt.setString(1, c.getMail());
		pstmt.setString(2, c.getPwd());	
		pstmt.setString(3, c.getName());
		pstmt.setString(4, c.getAddr());		
		pstmt.setString(5, c.getGender());
		pstmt.setInt(6, c.getAge());//-->	
		pstmt.setString(7, c.getGrade());	
		pstmt.setString(8, c.getMobile());
		pstmt.setInt(9, c.getCid());//-->
		pstmt.setString(10, c.getId());		
		pstmt.executeUpdate();
		close(pstmt);		
	}

	@Override
	public void delete(Connection con, Object obj) throws Exception {
		CustVO c = (CustVO)obj;//에러남...why ==>> 넘어온 값이 VO객체가 아니고 그냥 한개 obj -> string 
		PreparedStatement pstmt = con.prepareStatement(Sql.deleteCust);
		pstmt.setInt(1, c.getCid());//-->
		pstmt.setString(2, c.getId());		
		System.out.println("id--->"+c.getId());
		System.out.println("cid--->"+c.getCid());		
		pstmt.executeUpdate();//-->
		close(pstmt);
	
	}

	@Override
	public Object select(Connection con, Object obj) throws Exception {
		
		Object result = null;
		CustVO c = (CustVO)obj;//에러남...why ==>> 넘어온 값이 VO객체가 아니고 그냥 한개 obj -> string 
		PreparedStatement pstmt = con.prepareStatement(Sql.selectCust);
		pstmt.setInt(1, c.getCid());//-->		
		pstmt.setString(2, c.getId());	
		
		ResultSet rset = null;
		rset = pstmt.executeQuery(); 
		rset.next();
		int cid = rset.getInt("CID");//-->	
		String id = rset.getString("ID");
		String mail = rset.getString("MAIL");		
		String pwd = rset.getString("PWD");
		String name = rset.getString("NAME");
		String addr = rset.getString("ADDR");
		String gender = rset.getString("GENDER");
		int age = rset.getInt("AGE");//-->
		String grade = rset.getString("GRADE");
		String mobile = rset.getString("MOBILE");
		result = new CustVO(cid, id, mail, pwd, name, addr, gender, age, grade, mobile);//-->>>VO객체만들어 넘기기--출력폼(toString()) 참고
		close(rset);
		close(pstmt);
		return result;		
		
	}

	@Override
	public ArrayList<Object> select(Connection con) throws Exception {
		
		//모든 데이타를 ArrayList CustVO 객체에 담아서 리턴한다.
		ArrayList<Object> list = new ArrayList();
		PreparedStatement pstmt = con.prepareStatement(Sql.selectAllCust);
		ResultSet rset = null;
		rset = pstmt.executeQuery();
		while(rset.next()){//-->>>데이타 끝날때까지 반복한다.
			CustVO c = null;
			int cid = rset.getInt("CID");//-->	
			String id = rset.getString("ID");
			String mail = rset.getString("MAIL");		
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			String addr = rset.getString("ADDR");
			String gender = rset.getString("GENDER");
			int age = rset.getInt("AGE");//-->
			String grade = rset.getString("GRADE");
			String mobile = rset.getString("MOBILE");			
			c = new CustVO(cid, id, mail, pwd, name, addr, gender, age, grade, mobile);//-->>>
			list.add(c);
		}
		close(rset);
		close(pstmt);		
		return list;		
		
	}

}
