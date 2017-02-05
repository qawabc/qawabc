package com.hotel.admin.db.test;

import java.util.ArrayList;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;

public class CustSelectAllCust {

	public static void main(String[] args) {
		//Biz에게 Cust 정보를 요청한다
		//Cust 정보는 ArrayList에 담겨온다.
		//ArrayList 정보를 출력한다.
		Biz biz = new CustBiz();
		ArrayList <Object> list = null; //-->
		try {
			list = biz.get();//--> 실제 데이타 가져오는 부분.
			for(Object obj:list){//-->>>list의 1 row씩 임시 obj에 옮기며 처리한다.
				System.out.println(obj);//자동으로 CustVO객체의 toString()함수 호출된다. Override
			}
		} catch (Exception e) {
			System.out.println("조회 Fail");
			e.printStackTrace();
		}
	}

}
