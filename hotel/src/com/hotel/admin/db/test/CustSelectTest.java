package com.hotel.admin.db.test;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.vo.CustVO;
import com.hotel.admin.db.vo.RoomVO;

public class CustSelectTest {

	public static void main(String[] args) {
		Biz biz = new CustBiz();
		CustVO vo = new CustVO(24, "id01");				
		CustVO c = null;//받을 준비.
		
		try {
			c = (CustVO) biz.get(vo);//VO 객체로 받는다.
			System.out.println(c);//JVM이 알아서 toSting()함수 호출해서 보여준다.
		} catch (Exception e) {
			System.out.println("존재하지 않는다.");
			e.printStackTrace();
		}

	}

}
