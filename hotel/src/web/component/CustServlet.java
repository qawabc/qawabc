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
    	//��ӹ��� HttpServlet()�� ���� ó���� ��, ȭ�鰪��(request.getParameter) ������ �� �����Ƿ� super() ����~!
        super();//-->�켱������ ȣ��Ǿ�� �Ѵ�...�߿�~!
        biz = new CustBiz();//�ʱ�ȭ- ���⼭�� �̰� ����ϰڴٰ� ����
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		
		if(cmd.equals("list")){
			ArrayList<Object> list = null;
			try {
				list = biz.get();
				request.setAttribute("custlist", list);//-->������ ���� ȭ���� custlist �̸����� �ѱ��. 
				request.setAttribute("center", "cust/list");//center�� cust ���� �Ʒ� list.jsp�� �����ַ��� �Ѵ�.
				request.setAttribute("left", "left_cust");							
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else if(cmd.equals("register")){
			//������ ȭ�鿡�� �޴´�.
			//db�� ����Ÿ�� �ִ´�.
			//���������� �ԷµǸ�, list ȭ������ �̵��Ѵ�.
			String id = request.getParameter("id");
			String mail = request.getParameter("mail");		
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");//�ѱ۱���
			name = Util.convertKr(name);//-->KSC5601�� ��ȯ
			String addr = request.getParameter("addr");//�ѱ۱���
			addr = Util.convertKr(addr);//-->KSC5601�� ��ȯ			
			String gender = request.getParameter("gender");
			gender = Util.convertKr(gender);//-->KSC5601�� ��ȯ				
			int age = Integer.parseInt(request.getParameter("age"));//-->
			String grade = request.getParameter("grade");
			grade = Util.convertKr(grade);//-->KSC5601�� ��ȯ				
			String mobile = request.getParameter("mobile");			
			
			CustVO vo = new CustVO(id, mail, pwd, name, addr, gender, age, grade, mobile);
			try {
				biz.register(vo);//-->
				next = "cust.bs?cmd=list";//-->
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("modify")){//-->��ȸ
			//ID������ CustVO�� ��ȸ�Ͽ�
			//���� �������� �̵��Ѵ�.
			//--------------------------------
			//cid, id�� ������ �ͼ�, Cust��ü�� ��û�Ѵ�.
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
		}else if(cmd.equals("modifyimpl")){//-->db ����
			//ȭ���� ���� �����͸� �޴´�.
			//DB�� ���� ��û�Ѵ�.
			//���� �Ϸ� ��, �ش��ڵ� �� �������� �̵��Ѵ�.
			String cidstr = request.getParameter("cid");			
			int cid = Integer.parseInt(cidstr);			
			String id = request.getParameter("id");
			String mail = request.getParameter("mail");		
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");//�ѱ۱���
			name = Util.convertKr(name);//-->KSC5601�� ��ȯ
			String addr = request.getParameter("addr");//�ѱ۱���
			addr = Util.convertKr(addr);//-->KSC5601�� ��ȯ			
			String gender = request.getParameter("gender");
			gender = Util.convertKr(gender);//-->KSC5601�� ��ȯ				
			int age = Integer.parseInt(request.getParameter("age"));//-->
			String grade = request.getParameter("grade");
			grade = Util.convertKr(grade);//-->KSC5601�� ��ȯ				
			String mobile = request.getParameter("mobile");			
			CustVO vo = new CustVO(cid, id, mail, pwd, name, addr, gender, age, grade, mobile);			
			
			try {
				biz.modify(vo);//-->
				next = "cust.bs?cmd=get&cid="+cid+"&id="+id;//-->�ش��ڵ� �� �������� �̵��Ѵ�.
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
			
		}else if(cmd.equals("remove")){
			String cidstr = request.getParameter("cid");			
			int cid = Integer.parseInt(cidstr);				
			String id = request.getParameter("id");
			CustVO vo = new CustVO(cid, id);	
			try {
				biz.remove(vo);//-->���� ��
				next = "cust.bs?cmd=list";//-->list.jsp ȭ������ �̵��϶�
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("get")){
			//cid, id�� ������ �ͼ�, Cust��ü�� ��û�Ѵ�.
			String cidstr = request.getParameter("cid");
			int cid = Integer.parseInt(cidstr);;			
			String id = request.getParameter("id");			
			CustVO vo = new CustVO(cid, id);			
			CustVO c = null;
			try {
				c = (CustVO)biz.get(vo);
				request.setAttribute("getcust", c);//-->
				request.setAttribute("center", "cust/get");//center�� cust ���� �Ʒ� get.jsp�� �����ַ��� �Ѵ�.
				request.setAttribute("left", "left_cust");						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		//Main ȭ�� �� �ش� ȭ������ �̵��Ѵ�.
		RequestDispatcher rd = 
				request.getRequestDispatcher(next);//-->jsp�̸�
		rd.forward(request, response);		
		
	}//end-service

}
















