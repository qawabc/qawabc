package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;//-->
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.admin.db.room.RoomBiz;
import com.hotel.admin.db.vo.CustVO;
import com.hotel.admin.db.vo.RoomVO;
import com.oreilly.servlet.MultipartRequest;//-->

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet({ "/RoomServlet", "/room" })
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RoomBiz biz;
    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
        biz = new RoomBiz();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dir = "C:\\html5\\hotel\\WebContent\\img";//-->>>������ ���� ������ �� �̸�
		int size = 1024*1024*1024;//-->1073,741,824(1073mb) 1gb�̻�
		
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		if(cmd.equals("register")){
			//-->ȭ�� jsp���� formdml enctype="multipart/form-data �� ����, �Ʒ� MultipartRequest���� ������ ��, �����´�. 
			MultipartRequest mp = new MultipartRequest(request, dir, size, "EUC_KR");//-->�̹�������, ������, �ѱ�Ÿ��
			//--------------------------------------------
			String rnumStr = mp.getParameter("rnum");
			int rnum = Integer.parseInt(rnumStr);	
			String grade = mp.getParameter("grade");			
			String priceStr = mp.getParameter("price");
			int price = Integer.parseInt(priceStr);
			String description = mp.getParameter("description");			
			String img = mp.getOriginalFileName("img");//-->���� ������ ���ε� ����~!!!
			String branchStr = mp.getParameter("branch");
			int branch = Integer.parseInt(branchStr);		
			//--------------------------------------------
			RoomVO p = new RoomVO(rnum, grade, price, description, img, branch);//-->db ����
			
			try {
				biz.register(p);
				next = "room.bs?cmd=list";//-->				
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			//--------------------------------------------
		}else if(cmd.equals("remove")){
			String ridstr = request.getParameter("rid");
			int rid = Integer.parseInt(ridstr);
			String rnumstr = request.getParameter("rnum");
			int rnum = Integer.parseInt(rnumstr);			
			RoomVO vo = new RoomVO(rid, rnum);//-->						
			try {
				biz.remove(vo);
				next = "room.bs?cmd=list";//-->>>����Ÿ �����ͼ� ����Ʈ �����ֱ�
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(cmd.equals("modify")){//--��������Ÿ ��������
			String ridstr = request.getParameter("rid");
			int rid = Integer.parseInt(ridstr);
			String rnumstr = request.getParameter("rnum");
			int rnum = Integer.parseInt(rnumstr);			
			RoomVO vo = new RoomVO(rid, rnum);//-->				
			RoomVO p = null;
			try {
				p = (RoomVO)biz.get(vo);
				request.setAttribute("modifyroom", p);
				request.setAttribute("center","room/modify");//jsp name
				request.setAttribute("left", "left_room");							
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}else if(cmd.equals("modifyimpl")){//--DB�� �����ϱ�
			//-->ȭ�� jsp���� formdml enctype="multipart/form-data �� ����, �Ʒ� MultipartRequest���� ������ ��, �����´�. 
			MultipartRequest mp = new MultipartRequest(request, dir, size, "EUC_KR");//-->�̹�������, ������, �ѱ�Ÿ��
			//--------------------------------------------
			String ridstr = mp.getParameter("rid");
			int rid = Integer.parseInt(ridstr);	
			String rnumstr = mp.getParameter("rnum");
			int rnum = Integer.parseInt(rnumstr);	
			String grade = mp.getParameter("grade");			
			String priceStr = mp.getParameter("price");
			int price = Integer.parseInt(priceStr);
			String description = mp.getParameter("description");			
			String img = mp.getParameter("img");//-->>>
			String newimg = mp.getOriginalFileName("newimg");//-->>>���� ������ ���ε� ����~!!!
			String branchStr = mp.getParameter("branch");
			int branch = Integer.parseInt(branchStr);			
			
			RoomVO p = null;
			if(newimg == null || newimg.equals("")){//-->null�� �� �Ѵ� üũ�Ѵ�.~!!!
				p = new RoomVO(rid, rnum, grade, price, description, img, branch);//-->db ����(���� �̹���)				
			}else{
				p = new RoomVO(rid, rnum, grade, price, description, newimg, branch);//-->db ����(���ο� �̹���)	
				
			}
			//--------------------------------------------
			try {
				biz.modify(p);
				next = "room.bs?cmd=get&rid="+rid+"&rnum="+rnum;//-->�� �������� �̵��Ѵ�.
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(cmd.equals("list")){
			ArrayList<Object> list = null;
			try {
				list = biz.get();
				request.setAttribute("plist", list);
				request.setAttribute("center", "room/list");//jsp name
				request.setAttribute("left", "left_room");							
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(cmd.equals("get")){
			String ridstr = request.getParameter("rid");
			int rid = Integer.parseInt(ridstr);
			String rnumstr = request.getParameter("rnum");
			int rnum = Integer.parseInt(rnumstr);	
			RoomVO vo = new RoomVO(rid, rnum);//-->	
			RoomVO p = null;
			try {
				p = (RoomVO)biz.get(vo);
				request.setAttribute("getroom", p);
				request.setAttribute("center", "room/get");//jsp name
				request.setAttribute("left", "left_room");							
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
		
	}

}
