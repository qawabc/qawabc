package com.hotel.admin.db.test;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.vo.CustVO;

public class CustInsertTest {

	public static void main(String[] args) {
		CustVO vo = new CustVO("id01", "aaa@naver.com", "pwd01", "홍길동", "서울 강남구 테헤란로", "남자", 20, "우수",
				"010-1111-1111");
		Biz biz = new CustBiz();//-->>
		try {
			biz.register(vo);//-->
			System.out.println("Insert Ok");
		} catch (Exception e) {//-->
			System.out.println("Insert Fail");
			e.printStackTrace();
		}

	}

}
