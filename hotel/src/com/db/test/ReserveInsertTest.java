package com.db.test;

import java.sql.Date;

import com.db.frame.Biz;
import com.db.reserve.ReserveBiz;
import com.db.vo.ReserveVO;



public class ReserveInsertTest {

	public static void main(String[] args) {
		//"INSERT INTO RESERVE VALUES(RESERVE_SEQ,CID,RRID,PRICE,RTYPE,PERSON,ACCOMO,PURPOSE,REASON)";
		Date date = new Date(0);
		ReserveVO vo = new ReserveVO(3,1, 1, 10000,1,1,date,1,1);
		Biz biz = new ReserveBiz();
		try {
			biz.register(vo);
			System.out.println("insert OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("insert Fail");
			e.printStackTrace();
		}
		
	
	}

	
}
