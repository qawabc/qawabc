package com.hotel.admin.db.test;

import java.util.ArrayList;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.frame.Biz;

public class CustSelectAllCust {

	public static void main(String[] args) {
		//Biz���� Cust ������ ��û�Ѵ�
		//Cust ������ ArrayList�� ��ܿ´�.
		//ArrayList ������ ����Ѵ�.
		Biz biz = new CustBiz();
		ArrayList <Object> list = null; //-->
		try {
			list = biz.get();//--> ���� ����Ÿ �������� �κ�.
			for(Object obj:list){//-->>>list�� 1 row�� �ӽ� obj�� �ű�� ó���Ѵ�.
				System.out.println(obj);//�ڵ����� CustVO��ü�� toString()�Լ� ȣ��ȴ�. Override
			}
		} catch (Exception e) {
			System.out.println("��ȸ Fail");
			e.printStackTrace();
		}
	}

}
