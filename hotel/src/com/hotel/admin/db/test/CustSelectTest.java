package com.hotel.admin.db.test;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.vo.CustVO;
import com.hotel.admin.db.vo.RoomVO;

public class CustSelectTest {

	public static void main(String[] args) {
		Biz biz = new CustBiz();
		CustVO vo = new CustVO(24, "id01");				
		CustVO c = null;//���� �غ�.
		
		try {
			c = (CustVO) biz.get(vo);//VO ��ü�� �޴´�.
			System.out.println(c);//JVM�� �˾Ƽ� toSting()�Լ� ȣ���ؼ� �����ش�.
		} catch (Exception e) {
			System.out.println("�������� �ʴ´�.");
			e.printStackTrace();
		}

	}

}
