package web.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		path = path.substring(1, path.lastIndexOf("."));
		String next = null;
		//String next = "main.jsp";
		if(path.equals("main")){
			
			String view = request.getParameter("view");

			if(view != null){
				build(request, view);
			}
			next = "main.jsp";
		}else{
			next = path;
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher(next); // main.jsp, register,....

		rd.forward(request, response);
	}
	
	
	private void build(HttpServletRequest request,
			String view){
		if(view.equals("cust")){
			request.setAttribute("center", "cust/list");//-->top °í°´
			request.setAttribute("left", "left_cust");	
		}else if(view.equals("custadd")){//------->left °í°´ Ãß°¡
			request.setAttribute("center", "cust/register");//-->			
			request.setAttribute("left", "left_cust");
		}else if(view.equals("room")){
			request.setAttribute("center", "room/list");//-->top °´½Ç
			request.setAttribute("left", "left_room");		
		}else if(view.equals("roomadd")){//------->left °´½Ç Ãß°¡
			request.setAttribute("center", "room/register");
			request.setAttribute("left", "left_room");						
		}else if(view.equals("reserve")){
			request.setAttribute("center", "reserve/reserve1");//-->top ¿¹¾à
			request.setAttribute("left", "left_reserve");					
		}else if(view.equals("sales")){
			request.setAttribute("center", "sales/sales1");//-->top ¸ÅÃâ
			request.setAttribute("left", "left_sales");				
		}else if(view.equals("log")){
			request.setAttribute("center", "log/log1");//-->top ·Î±×
			request.setAttribute("left", "left_log");
		}else if(view.equals("resmenu1")){
			request.setAttribute("center", "reserve/reserve1");//-->top ¿¹¾à
			request.setAttribute("left", "left_reserve");
		}else if(view.equals("resmenu2")){
			request.setAttribute("center", "reserve/reserve2");//-->top ¿¹¾à
			request.setAttribute("left", "left_reserve");
		}else if(view.equals("custmenu1")){//------->left °í°´
			request.setAttribute("center", "cust/cust1");
			request.setAttribute("left", "left_cust");
		}else if(view.equals("custmenu2")){
			request.setAttribute("center", "cust/cust2");
			request.setAttribute("left", "left_cust");
		}else if(view.equals("roommenu1")){//------->left °´½Ç
			request.setAttribute("center", "room/room1");
			request.setAttribute("left", "left_room");
		}else if(view.equals("roommenu2")){
			request.setAttribute("center", "room/room2");
			request.setAttribute("left", "left_room");	
		}else if(view.equals("logmenu1")){//------->
			request.setAttribute("center", "log/log1");
			request.setAttribute("left", "left_log");
		}else if(view.equals("logmenu2")){//------->
			request.setAttribute("center", "log/log2");
			request.setAttribute("left", "left_log");
		}else if(view.equals("logmenu3")){//------->
			request.setAttribute("center", "log/log3");
			request.setAttribute("left", "left_log");
		}else if(view.equals("logmenu4")){//------->
			request.setAttribute("center", "log/log4");
			request.setAttribute("left", "left_log");
		}else if(view.equals("logmenu5")){//------->
			request.setAttribute("center", "log/log5");
			request.setAttribute("left", "left_log");
		}else if(view.equals("salesmenu1")){//------->
			request.setAttribute("center", "sales/sales1");
			request.setAttribute("left", "left_sales");
		}else if(view.equals("salesmenu2")){//------->
			request.setAttribute("center", "sales/sales2");
			request.setAttribute("left", "left_sales");
		}else if(view.equals("salesmenu3")){//------->
			request.setAttribute("center", "sales/sales3");
			request.setAttribute("left", "left_sales");
		}else if(view.equals("salesmenu4")){//------->
			request.setAttribute("center", "sales/sales4");
			request.setAttribute("left", "left_sales");
		}else if(view.equals("salesmenu5")){//------->
			request.setAttribute("center", "sales/sales5");
			request.setAttribute("left", "left_sales");
		}else if(view.equals("salesmenu6")){//------->
			request.setAttribute("center", "sales/sales6");
			request.setAttribute("left", "left_sales");
		}
	}
}