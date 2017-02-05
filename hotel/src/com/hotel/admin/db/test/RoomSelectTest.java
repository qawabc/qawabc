package com.hotel.admin.db.test;

import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.room.RoomBiz;
import com.hotel.admin.db.vo.RoomVO;

public class RoomSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz biz = new RoomBiz();
		RoomVO vo = new RoomVO(21, 111);			
		RoomVO p = null;	
		try {
			p = (RoomVO)biz.get(vo);
			System.out.println(p);			
		} catch (Exception e) {
			System.out.println("자료가 없습니다.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
