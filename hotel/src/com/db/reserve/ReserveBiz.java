package com.db.reserve;

import java.sql.Connection;
import java.util.ArrayList;

import com.db.frame.Biz;
import com.db.frame.Dao;

public class ReserveBiz extends Biz {
	Dao dao;
	public ReserveBiz() {
		dao = new ReserveDao();
	}
	
	@Override
	public void register(Object obj) throws Exception {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Object obj) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> get() throws Exception {
		// TODO Auto-generated method stub
		ArrayList <Object> list = null;
		Connection con = getConnection();
		try{
			list = dao.select(con);
		}catch(Exception e){
			throw e;
		}finally{
			close(con);
		}
		return list;
	}
	public ArrayList<Object> getrooms() throws Exception {
		// 예약추가테이블에서 방을 불러오기위함
		ArrayList <Object> list = null;
		Connection con = getConnection();
		System.out.println("getrooms entered");
		try{
			System.out.println("list");
			list = dao.selectrooms(con);
		}catch(Exception e){
			throw e;
		}finally{
			close(con);
		}
		return list;
	}

}
