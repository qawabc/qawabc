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
			list = biz.get();//--> ���� ����Ÿ �������� �κ�.
			for(Object obj:list){//-->>>list�� 1 row�� �ӽ� obj�� �ű�� ó���Ѵ�.
				System.out.println(obj);//�ڵ����� ItemVO��ü�� toString()�Լ� ȣ��ȴ�. Override
			}
		} catch (Exception e) {
			System.out.println("all ��ȸ Fail");
			e.printStackTrace();
		}				

	}

}
