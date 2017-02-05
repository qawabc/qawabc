package com.hotel.admin.db.test;

import java.util.ArrayList;

import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.room.RoomBiz;

public class RoomSelectAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz biz = new RoomBiz();
		ArrayList <Object> list = null; //-->
		try {
			list = biz.get();//--> 실제 데이타 가져오는 부분.
			for(Object obj:list){//-->>>list의 1 row씩 임시 obj에 옮기며 처리한다.
				System.out.println(obj);//자동으로 ItemVO객체의 toString()함수 호출된다. Override
			}
		} catch (Exception e) {
			System.out.println("all 조회 Fail");
			e.printStackTrace();
		}				

	}

}
