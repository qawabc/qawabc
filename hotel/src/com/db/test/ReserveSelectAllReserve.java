package com.db.test;

import java.util.ArrayList;

import com.db.frame.Biz;
import com.db.reserve.ReserveBiz;

public class ReserveSelectAllReserve {

	public static void main(String[] args) {
		//Biz���� Cust ������ ��û�Ѵ�
		//Cust ������ ArrayList�� ��ܿ´�.
		//ArrayList ������ ����Ѵ�.
		Biz biz = new ReserveBiz();
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
