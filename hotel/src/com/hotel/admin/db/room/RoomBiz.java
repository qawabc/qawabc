package com.hotel.admin.db.room;

import java.sql.Connection;
import java.util.ArrayList;

import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.frame.Dao;

public class RoomBiz extends Biz {

	Dao dao;
	public RoomBiz() {
		dao = new RoomDao();
		
	}

	@Override
	public void register(Object obj) throws Exception {
		//-->validation check 처리 필요하다..저장전에...!
		
		Connection con = getConnection();
		try{
			dao.insert(con, obj);
			con.commit();
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally{
			close(con);
		}

	}

	@Override
	public void modify(Object obj) throws Exception {
		
		Connection con = getConnection();
		try{
			dao.update(con, obj);
			con.commit();			
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally{
			close(con);
		}


	}

	@Override
	public void remove(Object obj) throws Exception {
		
		Connection con = getConnection();
		try{
			dao.delete(con, obj);		
			con.commit();
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally{
			close(con);
		}

	}

	@Override
	public Object get(Object obj) throws Exception {
		
		Object result = null;
		Connection con = getConnection();
		try{
			result = dao.select(con, obj);		
		}catch(Exception e){
			throw e;
		}finally{
			close(con);
		}
		return result;//-->obj			
		
	}

	@Override
	public ArrayList<Object> get() throws Exception {

		//DAO 에게 데이터를 요청한다.
		//RoomVO가 담긴 ArrayList를 리턴한다.
		ArrayList <Object> list = null;
		Connection con = getConnection();		
		try{
			list = dao.select(con);		
			con.commit();
		}catch(Exception e){
			con.rollback();
			throw e;			
		}finally{
			close(con);
		}
		return list;		
	}
	

}
