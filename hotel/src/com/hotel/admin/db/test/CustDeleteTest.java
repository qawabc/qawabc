package com.hotel.admin.db.test;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.vo.CustVO;

public class CustDeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz biz = new CustBiz();
		CustVO vo = new CustVO(28, "id01");
		
		try {
			biz.remove(vo);
			System.out.println("Delete Ok");
		} catch (Exception e) {
			System.out.println("Delete Fail");
			e.printStackTrace();
		}
		
		
	}

}
