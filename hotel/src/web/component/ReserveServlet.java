package web.component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.reserve.ReserveBiz;
import com.db.vo.ReserveVO;
import com.hotel.admin.db.room.RoomBiz;
import com.hotel.admin.db.vo.RoomVO;

@WebServlet({ "/ReserveServlet", "/reserve" })
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ReserveBiz biz;
	RoomBiz bbiz;
    public ReserveServlet() {
        super();
        biz = new ReserveBiz();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";

		if(cmd.equals("list")){
			ArrayList<Object> list = null;
			try {
				list = biz.get();
				request.setAttribute("reservelist", list);//-->������ ���� ȭ���� reservelist �̸����� �ѱ��.
				request.setAttribute("center", "reserve/reserve1");//center�� reserve ���� �Ʒ� reserve1.jsp�� �����ַ��� �Ѵ�.
				request.setAttribute("left", "left_reserve");//left�� left_reserve.jsp��...
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("add")){
			ArrayList<Object> list = null;
			System.out.println("entered");
			try {
				list = biz.getrooms();
				System.out.println("suc"+list);
				request.setAttribute("roomlist", list);
				request.setAttribute("center", "reserve/reserve2");
				request.setAttribute("left", "left_reserve");
			} catch (Exception e) {
				System.out.println("failed");
				e.printStackTrace();
			}

		}else if(cmd.equals("register")){
			//id, pwd, name�� ȭ�鿡�� �޴´�.
			//db�� ����Ÿ�� �ִ´�.
			//���������� �ԷµǸ�, list ȭ������ �̵��Ѵ�.
			
			String scid = request.getParameter("cid");
			int cid = Integer.parseInt(scid);
			String srrid = request.getParameter("rrid");//�ѱ۱���
			int rrid = Integer.parseInt(srrid);
			String sprice = request.getParameter("price");
			int price = Integer.parseInt(sprice);
			String srtype = request.getParameter("rtype");
			int rtype = Integer.parseInt(srtype);
			String sperson = request.getParameter("person");
			int person = Integer.parseInt(sperson);
			String saccomo = request.getParameter("accomo");
			System.out.println("string accomo = "+saccomo);
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date accomo=null;
			try {
				accomo = (Date) format.parse(saccomo);
				System.out.println(accomo);
			} catch (ParseException e1) {
				System.out.println("parse failed");
				e1.printStackTrace();
			}

			String spurpose = request.getParameter("purpose");
			int purpose = Integer.parseInt(spurpose);
			String sreason = request.getParameter("reason");
			int reason = Integer.parseInt(sreason);
			
			ReserveVO vo = new ReserveVO(cid, rrid, price, rtype, person, accomo, purpose, reason);
			try {
				biz.register(vo);//-->
				next = "reserve.bs?cmd=list";//-->
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(cmd.equals("modify")){//-->��ȸ
			//ID������ CustVO�� ��ȸ�Ͽ�
			//���� �������� �̵��Ѵ�.
			//--------------------------------
		}else if(cmd.equals("modifyimpl")){//-->db ����
			//ȭ���� ���� �����͸� �޴´�.
			//DB�� ���� ��û�Ѵ�.
			//���� �Ϸ� ��, �ش��ڵ� �� �������� �̵��Ѵ�.
		}else if(cmd.equals("remove")){

		}else if(cmd.equals("get")){
			//id�� ������ �ͼ�, Reserve��ü�� ��û�Ѵ�.

		}
		//Main ȭ�� �� �ش� ȭ������ �̵��Ѵ�.
		RequestDispatcher rd = 
				request.getRequestDispatcher(next);//-->jsp�̸�
		rd.forward(request, response);
	}

}
