package com.hotel.admin.db.test;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;
import com.hotel.admin.db.vo.CustVO;

public class CustUpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz biz = new CustBiz();
		CustVO c = new CustVO(28, "id01", "ccc@naver.com", "pwd33", "ȫ���", "���� ������ ������� 11��", "����", 30, "�߰�",
				"010-3333-3333");
		
		try {
			biz.modify(c);//-->
			System.out.println("Update Ok");
		} catch (Exception e) {
			System.out.println("Update Fail");
			e.printStackTrace();
		}
	}

}
