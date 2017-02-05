package com.hotel.admin.db.test;

import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.room.RoomBiz;
import com.hotel.admin.db.vo.RoomVO;

public class RoomInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//RoomVO vo = new RoomVO(111, "1���", 90000, "��������", "a.jpg", 100);
		//RoomVO vo = new RoomVO(222, "2���", 70000, "�߰�����", "b.jpg", 100);
		RoomVO vo = new RoomVO(333, "3���", 50000, "����", "c.jpg", 200);			
		Biz biz = new RoomBiz();
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
