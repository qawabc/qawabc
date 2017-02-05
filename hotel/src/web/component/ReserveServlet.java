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
				request.setAttribute("reservelist", list);//-->가져온 값을 화면의 reservelist 이름으로 넘긴다.
				request.setAttribute("center", "reserve/reserve1");//center를 reserve 폴더 아래 reserve1.jsp로 보여주려고 한다.
				request.setAttribute("left", "left_reserve");//left를 left_reserve.jsp로...
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
			//id, pwd, name을 화면에서 받는다.
			//db에 데이타를 넣는다.
			//정상적으로 입력되면, list 화면으로 이동한다.
			
			String scid = request.getParameter("cid");
			int cid = Integer.parseInt(scid);
			String srrid = request.getParameter("rrid");//한글깨짐
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
			
		}else if(cmd.equals("modify")){//-->조회
			//ID정보의 CustVO를 조회하여
			//수정 페이지로 이동한다.
			//--------------------------------
		}else if(cmd.equals("modifyimpl")){//-->db 저장
			//화면의 수정 데이터를 받는다.
			//DB에 수정 요청한다.
			//수정 완료 후, 해당코드 상세 페이지로 이동한다.
		}else if(cmd.equals("remove")){

		}else if(cmd.equals("get")){
			//id를 가지고 와서, Reserve객체를 요청한다.

		}
		//Main 화면 및 해당 화면으로 이동한다.
		RequestDispatcher rd = 
				request.getRequestDispatcher(next);//-->jsp이름
		rd.forward(request, response);
	}

}
