package com.hotel.admin.db.test;

import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.room.RoomBiz;
import com.hotel.admin.db.vo.RoomVO;

public class RoomUpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoomVO vo = new RoomVO(21, 111, "111등급", 100000, "아주좋음", "b.jpg", 101);		
		Biz biz = new RoomBiz();
		try {
			biz.modify(vo);
			System.out.println("update OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("update Fail");
			e.printStackTrace();
		}
		
		
	}

}
