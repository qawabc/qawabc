package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.admin.db.cust.CustBiz;
import com.hotel.admin.db.vo.CustVO;

import web.dispatcher.Util;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({ "/CustServlet", "/cust" })
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustBiz biz;
    public CustServlet() {
    	//상속받은 HttpServlet()가 먼저 처리된 후, 화면값을(request.getParameter) 가져올 수 있으므로 super() 먼저~!
        super();//-->우선적으로 호출되어야 한다...중요~!
        biz = new CustBiz();//초기화- 여기서는 이것 사용하겠다고 선언
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		
		if(cmd.equals("list")){
			ArrayList<Object> list = null;
			try {
				list = biz.get();
				request.setAttribute("custlist", list);//-->가져온 값을 화면의 custlist 이름으로 넘긴다. 
				request.setAttribute("center", "cust/list");//center를 cust 폴더 아래 list.jsp로 보여주려고 한다.
				request.setAttribute("left", "left_cust");							
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else if(cmd.equals("register")){
			//브라우저 화면에서 받는다.
			//db에 데이타를 넣는다.
			//정상적으로 입력되면, list 화면으로 이동한다.
			String id = request.getParameter("id");
			String mail = request.getParameter("mail");		
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");//한글깨짐
			name = Util.convertKr(name);//-->KSC5601로 변환
			String addr = request.getParameter("addr");//한글깨짐
			addr = Util.convertKr(addr);//-->KSC5601로 변환			
			String gender = request.getParameter("gender");
			gender = Util.convertKr(gender);//-->KSC5601로 변환				
			int age = Integer.parseInt(request.getParameter("age"));//-->
			String grade = request.getParameter("grade");
			grade = Util.convertKr(grade);//-->KSC5601로 변환				
			String mobile = request.getParameter("mobile");			
			
			CustVO vo = new CustVO(id, mail, pwd, name, addr, gender, age, grade, mobile);
			try {
				biz.register(vo);//-->
				next = "cust.bs?cmd=list";//-->
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("modify")){//-->조회
			//ID정보의 CustVO를 조회하여
			//수정 페이지로 이동한다.
			//--------------------------------
			//cid, id를 가지고 와서, Cust객체를 요청한다.
			String cidstr = request.getParameter("cid");
			int cid = Integer.parseInt(cidstr);;			
			String id = request.getParameter("id");			
			CustVO vo = new CustVO(cid, id);				
			CustVO c = null;
			try {
				c = (CustVO)biz.get(vo);
				request.setAttribute("modifycust", c);//-->
				request.setAttribute("center", "cust/modify");//-->
				request.setAttribute("left", "left_cust");					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//--------------------------------			
		}else if(cmd.equals("modifyimpl")){//-->db 저장
			//화면의 수정 데이터를 받는다.
			//DB에 수정 요청한다.
			//수정 완료 후, 해당코드 상세 페이지로 이동한다.
			String cidstr = request.getParameter("cid");			
			int cid = Integer.parseInt(cidstr);			
			String id = request.getParameter("id");
			String mail = request.getParameter("mail");		
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");//한글깨짐
			name = Util.convertKr(name);//-->KSC5601로 변환
			String addr = request.getParameter("addr");//한글깨짐
			addr = Util.convertKr(addr);//-->KSC5601로 변환			
			String gender = request.getParameter("gender");
			gender = Util.convertKr(gender);//-->KSC5601로 변환				
			int age = Integer.parseInt(request.getParameter("age"));//-->
			String grade = request.getParameter("grade");
			grade = Util.convertKr(grade);//-->KSC5601로 변환				
			String mobile = request.getParameter("mobile");			
			CustVO vo = new CustVO(cid, id, mail, pwd, name, addr, gender, age, grade, mobile);			
			
			try {
				biz.modify(vo);//-->
				next = "cust.bs?cmd=get&cid="+cid+"&id="+id;//-->해당코드 상세 페이지로 이동한다.
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
			
		}else if(cmd.equals("remove")){
			String cidstr = request.getParameter("cid");			
			int cid = Integer.parseInt(cidstr);				
			String id = request.getParameter("id");
			CustVO vo = new CustVO(cid, id);	
			try {
				biz.remove(vo);//-->삭제 후
				next = "cust.bs?cmd=list";//-->list.jsp 화면으로 이동하라
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("get")){
			//cid, id를 가지고 와서, Cust객체를 요청한다.
			String cidstr = request.getParameter("cid");
			int cid = Integer.parseInt(cidstr);;			
			String id = request.getParameter("id");			
			CustVO vo = new CustVO(cid, id);			
			CustVO c = null;
			try {
				c = (CustVO)biz.get(vo);
				request.setAttribute("getcust", c);//-->
				request.setAttribute("center", "cust/get");//center를 cust 폴더 아래 get.jsp로 보여주려고 한다.
				request.setAttribute("left", "left_cust");						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		//Main 화면 및 해당 화면으로 이동한다.
		RequestDispatcher rd = 
				request.getRequestDispatcher(next);//-->jsp이름
		rd.forward(request, response);		
		
	}//end-service

}
















