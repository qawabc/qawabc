package com.hotel.admin.db.test;

import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.room.RoomBiz;
import com.hotel.admin.db.vo.RoomVO;

public class RoomDeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz biz = new RoomBiz();
		RoomVO vo = new RoomVO(21, 111);	
		
		try {
			biz.remove(vo);
			System.out.println("delete OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("delete Fail");
			e.printStackTrace();
		}		
		
	}

}
